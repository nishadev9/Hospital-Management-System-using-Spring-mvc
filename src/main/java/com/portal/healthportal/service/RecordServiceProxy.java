package com.portal.healthportal.service;

import com.portal.healthportal.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceProxy implements IRecordService {

    @Autowired
    private RecordService recordService;

    @Override
    public List<Record> viewRecord() {
        
        System.out.println("Proxy: Performing pre-processing before fetching records...");

        
        List<Record> records = recordService.viewRecord();

        
        System.out.println("Proxy: Performing post-processing after fetching records...");

        return records;
    }

}
