package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private String name;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn
	private ParkingSpace parkingSpace;

	public Employee() {
	}

	public Employee(String name, ParkingSpace parkingSpace) {
		this.name = name;
		this.parkingSpace = parkingSpace;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

}
