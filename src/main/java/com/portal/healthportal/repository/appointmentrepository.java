package com.portal.healthportal.repository;

import com.portal.healthportal.entity.appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface appointmentrepository extends JpaRepository<appointment, Integer> {

}