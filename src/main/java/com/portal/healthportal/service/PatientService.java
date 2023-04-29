package com.portal.healthportal.service;

import com.portal.healthportal.entity.Patient;
import com.portal.healthportal.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

	@Autowired
	private PatientRepository repos;

	public List<Patient> viewPatient() {
		return repos.findAll();
	}

	public List<Patient> viewRecord() {
		return repos.findAll();
	}

	// Other methods of PatientService as needed
}