package com.portal.healthportal.service;

import com.portal.healthportal.entity.Patient;
import com.portal.healthportal.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class DecoratorPatientService {

	@Autowired
	private PatientService patientService; // Reference to the original PatientService

	@Autowired
	private PatientRepository patientRepository; // Patient repository for accessing database

	public List<Patient> viewPatient() {
		
		System.out.println("DecoratorPatientService adds or modifies behavior in viewPatient method.");
		List<Patient> patients = patientService.viewPatient();
		
		for (Patient patient : patients) {
			updateAgeBasedOnDOB(patient); 
		}
		return patients;
	}

	public List<Patient> viewRecord() {
		
		System.out.println("DecoratorPatientService adds or modifies behavior in viewRecord method.");
		List<Patient> records = patientService.viewRecord();
		
		
		return records;
	}

	
	
	// Decorator function to update the age of a patient based on the date of birth (DOB)
	private void updateAgeBasedOnDOB(Patient patient) {
	    LocalDate currentDate = LocalDate.now();
	    LocalDate dob = patient.getP_dob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 
	    int currentAge = patient.getP_age();
	    int dobMonth = dob.getMonthValue(); 
	    int dobDay = dob.getDayOfMonth(); 
	    int currentMonth = currentDate.getMonthValue(); 
	    int currentDay = currentDate.getDayOfMonth();
	    
	    if (currentMonth > dobMonth || (currentMonth == dobMonth && currentDay >= dobDay)) {
	        
	        patient.setP_age(currentAge + 1);
	        patientRepository.save(patient); 
	    }
	}


	
}