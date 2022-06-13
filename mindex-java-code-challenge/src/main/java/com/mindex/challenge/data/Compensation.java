package com.mindex.challenge.data;

import com.mindex.challenge.data.Employee;

import java.util.Date;

/**
 * Created by Michael on 6/11/2022.
 */
public class Compensation {

    private Employee employee;
    private double salary;
    private Date effectiveDate;


    /*
    * Parameterless constructor, in case the intended use of this class is simply through usage of getter/setter
    * functions.
    * */
    public Compensation() {

    }

    /*
    * Constructor function requiring an employee input. This would be the most logical quintessential parameter, since
    * neither a salary nor effectiveDate are relevant to a non-existent employee
    *
    * This went unused.
    * */
    /*public Compensation(Employee employee) {
        this.employee = employee;
    }*/


    /*
    * What follows are standard "setter" functions that mimic the structure of the provided Employee class.
    * */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /*
     * What follows are standard "getter" functions that mimic the structure of the provided Employee class.
     * */
    public Employee getEmployee() {
        return employee;
    }

    public double getSalary() {
        return salary;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

}
