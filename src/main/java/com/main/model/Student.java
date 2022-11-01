package com.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="firstName", nullable=false)
	private String firstName;
	@Column(name="lastName", nullable= false)
	private String lastName;
	@Column(name="address", nullable=false)
	private String address;
	@Column(name="currentClass", nullable=true)
	private int currentClass;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(long id, String firstName, String lastName, String address, int currentClass) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.currentClass = currentClass;
	}
	public long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getAddress() {
		return address;
	}
	public int getCurrentClass() {
		return currentClass;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCurrentClass(int currentClass) {
		this.currentClass = currentClass;
	}
	
	
	

}
