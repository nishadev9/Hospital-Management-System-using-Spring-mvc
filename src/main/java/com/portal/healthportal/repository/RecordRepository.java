package com.portal.healthportal.repository;

import com.portal.healthportal.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Integer> {

}