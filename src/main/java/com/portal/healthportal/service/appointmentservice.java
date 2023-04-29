package com.portal.healthportal.service;

import com.portal.healthportal.entity.appointment;
import com.portal.healthportal.repository.appointmentrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class appointmentservice {
    
    private static appointmentservice instance;
    
    @Autowired
    private static appointmentrepository appointmentRepo;

    private appointmentservice(appointmentrepository appointmentRepo) {
        appointmentservice.appointmentRepo = appointmentRepo;
    }
    
    public static synchronized appointmentservice getInstance(appointmentrepository appointmentRepo) {
        if (instance == null) {
            instance = new appointmentservice(appointmentRepo);
        }
        return instance;
    }
    
    public List<appointment> viewAppointments() {
        return appointmentRepo.findAll();
    }
    
}
