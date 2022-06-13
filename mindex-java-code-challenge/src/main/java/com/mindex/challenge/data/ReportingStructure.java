package com.mindex.challenge.data;

import com.mindex.challenge.data.Employee;
import java.util.List;

/**
 * Created by Michael on 6/11/2022.
 */
public class ReportingStructure {

    private Employee employee;
    private int numberOfReports;


    /*
     * Parameterless constructor, in case the intended use of this class is simply through usage of getter/setter
     * functions.
     * */
    public ReportingStructure() {

    }

    /*
     * Constructor function requiring an employee input. This would be the most logical quintessential parameter, since
     * the numberOfReports is directly derived from a particular employee.
     *
     * This went unused.
     * */
    /*public ReportingStructure(Employee employee) {
        this.employee = employee;
        this.numberOfReports = getTotalNumberOfReports(employee);
    }*/


    /*
     * What follows is a standard "setter" function for the Employee, with the added functionality of determining the
     * numberOfReports for the provided employee.
     * */
    public void setEmployee(Employee employee) {
        this.employee = employee;
        this.numberOfReports = getTotalNumberOfReports(employee);
    }


    /*
     * What follows are standard "getter" functions that mimic the structure of the provided Employee class.
     * */
    public Employee getEmployee() {
        return employee;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    private int getTotalNumberOfReports(Employee current) {
        List<Employee> list = current.getDirectReports();
        int total;

        if (list != null) {
            total = list.size();

            for (Employee e : list) {
                total += getTotalNumberOfReports(e);
            }
        } else {
            total = 0;
        }

        return total;

    }

}