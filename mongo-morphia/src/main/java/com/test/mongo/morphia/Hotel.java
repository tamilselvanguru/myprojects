
package com.test.mongo.morphia;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Hotel {

	@Id
	private ObjectId id;
	private String name;
	private int stars;
	@Embedded
	private Address address;

	public String getName() {
		return name;
	}

	public int getStars() {
		return stars;
	}

	public Address getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

}