package com.service.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.models.Department;
import com.models.Employee;
import com.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	private EntityManager entityManager;

	public EmployeeServiceImpl() {
	}

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee create(String name, Department department) {
		entityManager.getTransaction().begin();
		Employee employeeOne = new Employee(name, department);
		Employee employeeTwo = new Employee("Pathania", department);
		entityManager.persist(employeeOne);

		entityManager.persist(employeeTwo);
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println(String.format("Employee [%s] created with department [%s]", employeeOne.getName(),
				employeeOne.getDepartment().getDeptName()));
		System.out.println(String.format("Employee [%s] created with department [%s]", employeeTwo.getName(),
				employeeTwo.getDepartment().getDeptName()));
		return employeeOne;
	}

	@Override
	public Employee findEmployee(int id) {
		entityManager.getTransaction().begin();
		Employee employee = entityManager.find(Employee.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return employee;
	}

	@Override
	public Collection<Employee> findAll() {
		Query query = entityManager.createQuery("SELECT e FROM EMPLOYEE e");
		return query.getResultList();
	}

}
