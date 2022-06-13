package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;

/**
 * Created by Michael on 6/11/2022.
 */
public interface CompensationService {
    /*
    * Requirements call for a means to create a new Compensation which persists
    * */
    Compensation create(Compensation compensation);
    /*
    * Requirements call for a means to read an existing compensation from the persistence layer based on employee ID
    * */
    Compensation read(String id);
}
