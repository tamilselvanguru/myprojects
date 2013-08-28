package com.test.mongo.morphia;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Address {

	private String street;
	private String city;
	private String postCode;
	private String country;

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}