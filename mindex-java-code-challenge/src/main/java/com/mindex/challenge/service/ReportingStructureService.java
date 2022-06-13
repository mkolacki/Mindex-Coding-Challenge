package com.mindex.challenge.service;

import com.mindex.challenge.data.ReportingStructure;

/**
 * Created by Michael on 6/11/2022.
 */
public interface ReportingStructureService{
    /*
    * Requirements specified that a ReportingStructure should be supplied on the fly for a given employee ID, with the
    * information not being persisted.
    * */
    ReportingStructure read(String id);
}
