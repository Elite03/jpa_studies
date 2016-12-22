package com.service;

import javax.persistence.EntityManager;

import com.model.Employee;
import com.model.ParkingSpace;

public class EmployeeService {

	private EntityManager em;

	public EmployeeService(EntityManager em) {
		this.em = em;
	}

	public Employee createEmployee(String employeeName, int lot) {
		ParkingSpace parkingSpace = new ParkingSpace(lot);
		Employee employee = new Employee(employeeName, parkingSpace);
		parkingSpace.setEmployee(employee);
		em.persist(employee);
		return employee;
	}

	public Employee findById(int id) {
		return em.find(Employee.class, id);
	}
}
