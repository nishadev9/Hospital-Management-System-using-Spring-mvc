package com.portal.healthportal.entity;





import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String p_name;
	private String p_email;
	private String p_gender;
	private Date p_dob;
	private String p_address;
	private int p_age;
	private String p_number;
	public Patient(int id, String p_name,String p_number, String p_email, String p_gender, Date p_dob,String p_address,int p_age) {
		super();
		this.id = id;
		this.p_name = p_name;
		this.p_number=p_number;
		this.p_email = p_email;
		this.p_gender = p_gender;
		this.p_dob = p_dob;
		this.p_address=p_address;
		this.p_age=p_age;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_number() {
		return p_number;
	}
	public void setP_number(String p_number) {
		this.p_number = p_number;
	}
	public String getP_email() {
		return p_email;
	}
	public void setP_email(String p_email) {
		this.p_email = p_email;
	}
	public String getP_gender() {
		return p_gender;
	}
	public void setP_gender(String p_gender) {
		this.p_gender = p_gender;
	}
	public Date getP_dob() {
		return p_dob;
	}
	public void setP_dob(Date p_dob) {
		this.p_dob = p_dob;
	}
	public String getP_address() {
		return p_address;
	}
	public void setP_address(String p_address) {
		this.p_address = p_address;
	}
	public int getP_age() {
		return p_age;
	}
	public void setP_age(int p_age) {
		this.p_age = p_age;
	}
	
}