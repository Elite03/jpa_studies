package com.service;

import javax.persistence.EntityManager;

import com.model.Employee;
import com.model.ParkingSpace;

public class ParkingService {

	private EntityManager em;

	public ParkingService(EntityManager em) {
		this.em = em;
	}

	public ParkingSpace create(int lot, String employeeName) {

		ParkingSpace parkingSpace = new ParkingSpace(lot);
		Employee employee = new Employee("Manpreet", parkingSpace);
		parkingSpace.setEmployee(employee);
		em.persist(parkingSpace);
		return parkingSpace;

	}

	public ParkingSpace findById(int id) {
		return em.find(ParkingSpace.class, id);
	}
}
