package com.service.impl;

import javax.persistence.EntityManager;

import com.model.Employee;
import com.model.ParkingSpace;
import com.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl() {

	}

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee create(String name, ParkingSpace parkingSpace) {
		entityManager.getTransaction().begin();
		Employee employee = new Employee(name, parkingSpace);
		Employee employee2 = new Employee("test", parkingSpace);
		entityManager.persist(employee2);
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
		return employee;
	}

	@Override
	public Employee findById(int id) {
		entityManager.getTransaction().begin();
		Employee employee = entityManager.find(Employee.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return employee;
	}

}
