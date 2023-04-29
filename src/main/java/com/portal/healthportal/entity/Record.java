package com.portal.healthportal.entity;



import java.sql.Date;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "record")
public class Record{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int p_id;
	private String diagnosis;
	private String treatment;
	private Date date;
	private String doc_name;
	private Date admission;
	private Date discharge;
	public Record(int id, int p_id,String diagnosis,String treatment, Date date, String doc_name, Date admission,Date discharge) {
		super();
		this.id = id;
		this.p_id = p_id;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.date = date;
		this.doc_name=doc_name;
		this.admission=admission;
		this.discharge=discharge;
		
	}
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	public Date getAdmission() {
		return admission;
	}
	public void setAdmission(Date admission) {
		this.admission = admission;
	}
	public Date getDischarge() {
		return discharge;
	}
	public void setDischarge(Date discharge) {
		this.discharge = discharge;
	}
}