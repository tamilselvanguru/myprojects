package com.studentportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Marks")
@JsonIgnoreProperties({ "student" })
public class Marks {
	private int studentID;
	private int tamil;
	private int english;
	private int maths;
	private int science;
	private int socialScience;
	private Student student;

	@Id
	@Column(name = "StudentId")
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "student"))
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	@Column(name = "tamil")
	public int getTamil() {
		return tamil;
	}

	public void setTamil(int tamil) {
		this.tamil = tamil;
	}

	@Column(name = "english")
	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	@Column(name = "maths")
	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	@Column(name = "science")
	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	@Column(name = "socialscience")
	public int getSocialScience() {
		return socialScience;
	}

	public void setSocialScience(int socialScience) {
		this.socialScience = socialScience;
	}

	@OneToOne
	@PrimaryKeyJoinColumn
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
