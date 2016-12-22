package com.service;

import javax.persistence.EntityManager;

import com.model.Department;
import com.model.Employee;

public class EmployeeService {
	private EntityManager em;

	public EmployeeService(EntityManager em) {
		this.em = em;
	}

	public Employee create(Department department) {
		em.getTransaction().begin();
		Employee employee = new Employee("Shveta");
		employee.setDepartment(department);
		department.getEmployees().add(employee);
		em.getTransaction().commit();
		em.close();
		return employee;
	}

	public Employee find(int id) {
		Employee employee = em.find(Employee.class, id);
		if (employee == null)
			throw new NullPointerException(String.format("Employee with id [%d] does not exist", employee.getId()));
		return employee;
	}

}
