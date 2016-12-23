package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.model.Department;
import com.model.Employee;

public class DepartmentService {
	private EntityManager em;

	public DepartmentService(EntityManager em) {
		this.em = em;
	}

	public Department create(String deptName) {
		List<Employee> empList = new ArrayList<>();
		Department department = new Department(deptName);
		Employee pankaj = new Employee("Pankaj");
		Employee manpreet = new Employee("Manpreet");
		pankaj.setDepartment(department);
		manpreet.setDepartment(department);
		empList.add(manpreet);
		empList.add(pankaj);
		department.setEmployees(empList);
		em.persist(department);
		return department;
	}

	public Department findEmployeeByDept(int deptId) {
		return em.find(Department.class, deptId);
	}
}
