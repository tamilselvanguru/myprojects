package com.partnerconnect.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "groups")
public class Groups {
	private int id;
	private String groupId;
	private String name;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "groupId")
	public String getGroupId() {
		return groupId;
	}

	public void setgroupId(String groupId) {
		this.groupId = groupId;
	}
@Column(name="Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Groups [id=" + id + ", groupId=" + groupId + ", name=" + name
				+ "]";
	}
}