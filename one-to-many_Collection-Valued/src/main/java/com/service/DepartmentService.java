package com.service;

import javax.persistence.EntityManager;

import com.model.Department;
import com.model.Employee;

public class DepartmentService {
	private EntityManager em;

	public DepartmentService(EntityManager em) {
		this.em = em;
	}

	public Department create(String deptName) {
		em.getTransaction().begin();
		Department department = new DepartmentService(em).findEmployeeByDept(2);
		em.getTransaction().commit();
		em.close();
		System.out.println(department.getDeptName());
		Employee pankaj = new Employee("Pankaj");
		pankaj.setDepartment(department);

		Employee manpreet = new Employee("Manpreet");
		manpreet.setDepartment(department);
		em.persist(manpreet);
		em.persist(pankaj);
		em.persist(department);
		return department;
	}

	public Department findEmployeeByDept(int deptId) {
		em.getTransaction().begin();
		Department department = em.find(Department.class, deptId);
		em.getTransaction().commit();
		em.close();
		return department;
	}
}
