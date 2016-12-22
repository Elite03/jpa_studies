package com.service;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.model.Employee;
import com.model.VacationEntry;

public class EmployeeService {

	public void create(EntityManager entityManager) {
		entityManager.getTransaction().begin();
		Employee employee = new Employee("Pankaj");
		Set<VacationEntry> vacationEntries = new HashSet<>();
		vacationEntries.add(new VacationEntry(Calendar.getInstance(), 4));
		Set<String> nickNames = new HashSet<>();
		nickNames.add("A");
		nickNames.add("B");

		employee.setNickNames(nickNames);
		employee.setVacationEntries(vacationEntries);

		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();

		System.out.println(String.format("Employee [%s] created ", employee.getEmployeeName()));
	}

	public static void main(String[] args) {
		System.out.println("start");
		EntityManager entityManager = Persistence.createEntityManagerFactory("Relationships-and-Element-Collections")
				.createEntityManager();

		EmployeeService service = new EmployeeService();
		service.create(entityManager);
		System.out.println("end");
	}
}
