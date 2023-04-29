package com.portal.healthportal.service;

import com.portal.healthportal.entity.Record;
import com.portal.healthportal.repository.RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService implements IRecordService {

    @Autowired
    private RecordRepository repos;

    @Override
    public List<Record> viewRecord() {
        
        List<Record> records = repos.findAll(); 

        
        return records;
    }

   
}
