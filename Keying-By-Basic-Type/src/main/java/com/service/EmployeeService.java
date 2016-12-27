package com.service;

import java.util.Map;

import javax.persistence.EntityManager;

import com.model.Employee;

public class EmployeeService {

	public Employee createEmployee(EntityManager entityManager, String employeeName, Map<String, String> phoneNumbers) {
		Employee employee = new Employee(employeeName);
		employee.setId(employee.getId());
		employee.setPhoneNumbers(phoneNumbers);
		entityManager.persist(employee);

		return employee;
	}

	public Employee findEmployee(EntityManager entityManager, int id) {
		return entityManager.find(Employee.class, id);
	}
}
