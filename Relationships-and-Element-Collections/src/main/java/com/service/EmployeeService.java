package com.service;

import java.util.Collection;

import javax.persistence.EntityManager;

import com.model.Employee;
import com.model.VacationEntry;

public class EmployeeService {
	private EntityManager entityManager;

	public EmployeeService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Employee create(Collection<VacationEntry> vacationEntries, Collection<String> nickNames, String name) {
		Employee employee = new Employee(name);
		employee.setNickNames(nickNames);
		employee.setVacationEntries(vacationEntries);
		entityManager.persist(employee);

		return employee;
	}

	public void readEmployee() {
		entityManager.getTransaction().begin();
		Employee employee = entityManager.find(Employee.class, 1);
		for (VacationEntry v : employee.getVacationEntries()) {
			System.out.println(
					String.format("Employee [%s],Holidays [%s]", employee.getEmployeeName(), v.getTotalDays()));
		}
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
