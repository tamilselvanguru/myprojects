package com.partnerconnect.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "AddPartner")
public class Partner {
	private int id;
	private String partnerName;
	private String group;
	private String streetAddress;
	private String city;
	private String state;
	private long zipCode;
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
@Column(name="PartnerName")
	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
@Column(name="groupId")
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
@Column(name="StreetAddress")
	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
@Column(name="city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
@Column(name="State")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
@Column(name="zipcode")
	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "AddPartner [id=" + id + ", partnerName=" + partnerName
				+ ", group=" + group + ", streetAddress=" + streetAddress
				+ ", city=" + city + ", state=" + state + ", zipcode="
				+ zipCode + ", getId()=" + getId() + ", getPartnerName()="
				+ getPartnerName() + ", getGroup()=" + getGroup()
				+ ", getStreetAddress()=" + getStreetAddress() + ", getCity()="
				+ getCity() + ", getState()=" + getState() + ", getZipcode()="
				+ getZipCode() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
