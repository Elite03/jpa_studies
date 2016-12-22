package com.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private String deptName;

	public Department() {
	}

	public Department(String deptName) {
		this.deptName = deptName;
	}

	public int getId() {
		return id;
	}

	public String getDeptName() {
		return deptName;
	}
}
