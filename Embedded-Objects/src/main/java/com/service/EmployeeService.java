package com.service;

import javax.persistence.EntityManager;

import com.model.Address;
import com.model.Employee;

public class EmployeeService {

	public Employee create(Address address, EntityManager manager) {
		Employee employee = new Employee("Pankaj");
		employee.setAddress(address);
		manager.persist(employee);
		return employee;
	}

}
