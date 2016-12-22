package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParkingSpace {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private int lot;

	public ParkingSpace() {
	}

	public ParkingSpace(int lot) {
		this.lot = lot;
	}

	public int getId() {
		return id;
	}

	public int getLot() {
		return lot;
	}
}
