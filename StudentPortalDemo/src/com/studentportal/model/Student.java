package com.studentportal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Student")
public class Student {
	private int studentID;
	private String name;
	private String deparment;
	private int idno;
	private long phno;
	private Address address;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "StudentId")
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	@Column(name = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Department")
	public String getDeparment() {
		return deparment;
	}

	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}

	@Column(name = "IdNo")
	public int getIdno() {
		return idno;
	}

	public void setIdno(int idno) {
		this.idno = idno;
	}

	@Column(name = "PhoneNo")
	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", deparment=" + deparment + ", idno="
				+ idno + ", phno=" + phno + ", address=" + address + "]";
	}

}
