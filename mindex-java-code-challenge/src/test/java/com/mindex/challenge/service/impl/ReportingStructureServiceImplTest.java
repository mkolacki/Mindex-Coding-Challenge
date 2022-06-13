package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Michael on 6/11/2022.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureServiceImplTest {

    private String employeeURL;

    private String reportingStructureIDURL;

    @Autowired
    private ReportingStructureService reportingStructureService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        employeeURL = "http://localhost:" + port + "/employee";
        reportingStructureIDURL = "http://localhost:" + port + "/reporting-structure/{id}";
    }

    @Test
    public void testRead() {
        Employee employee0 = new Employee();
        employee0.setFirstName("John");
        employee0.setLastName("Doe");
        employee0.setDepartment("Engineering");
        employee0.setPosition("Developer");

        Employee employee1 = new Employee();
        employee1.setFirstName("Michael");
        employee1.setLastName("Kolacki");
        employee1.setDepartment("Engineering");
        employee1.setPosition("Developer");

        Employee employee2 = new Employee();
        employee2.setFirstName("Kate");
        employee2.setLastName("Johanna");
        employee2.setDepartment("Engineering");
        employee2.setPosition("Developer");

        Employee employee3 = new Employee();
        employee3.setFirstName("Thomas");
        employee3.setLastName("Brown");
        employee3.setDepartment("Engineering");
        employee3.setPosition("Developer");

        Employee employee4 = new Employee();
        employee4.setFirstName("Kyle");
        employee4.setLastName("Vinton");
        employee4.setDepartment("Engineering");
        employee4.setPosition("Developer");

        List<Employee> johnsDirectReports = new ArrayList<>();
        johnsDirectReports.add(employee1);
        johnsDirectReports.add(employee2);
        employee0.setDirectReports(johnsDirectReports);

        List<Employee> michaelsDirectReports = new ArrayList<>();
        michaelsDirectReports.add(employee3);
        michaelsDirectReports.add(employee4);
        employee1.setDirectReports(michaelsDirectReports);

        Employee createdEmployee = restTemplate.postForEntity(employeeURL, employee0, Employee.class).getBody();

        ReportingStructure testReportingStructure = new ReportingStructure();
        testReportingStructure.setEmployee(createdEmployee);


        // Read test
        ReportingStructure readReportingStructure = restTemplate.getForEntity(reportingStructureIDURL, ReportingStructure.class, createdEmployee.getEmployeeId()).getBody();
        assertEquals(createdEmployee.getEmployeeId(), readReportingStructure.getEmployee().getEmployeeId());
        assertReportingStructureEquivalence(testReportingStructure, readReportingStructure);

    }

    private static void assertReportingStructureEquivalence(ReportingStructure expected, ReportingStructure actual) {
        assertEmployeeEquivalence(expected.getEmployee(), actual.getEmployee());
        assertEquals(expected.getNumberOfReports(), actual.getNumberOfReports());
    }

    private static void assertEmployeeEquivalence(Employee expected, Employee actual) {
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getDepartment(), actual.getDepartment());
        assertEquals(expected.getPosition(), actual.getPosition());
        assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
    }

}
