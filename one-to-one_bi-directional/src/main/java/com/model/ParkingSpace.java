package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ParkingSpace {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private int lot;

	@OneToOne(cascade = CascadeType.ALL)
	private Employee employee;

	public ParkingSpace() {
	}

	public ParkingSpace(int lot) {
		this.lot = lot;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLot() {
		return lot;
	}

	public void setLot(int lot) {
		this.lot = lot;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
