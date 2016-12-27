package com.app.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.model.Employee;
import com.service.EmployeeService;

public class ApplicationClient {

	public void createEmployee(EntityManager entityManager, EmployeeService employeeService,
			Map<String, String> phoneNumbers) {
		entityManager.getTransaction().begin();
		Employee employee = employeeService.createEmployee(entityManager, "Pankaj", phoneNumbers);
		entityManager.getTransaction().commit();
		entityManager.close();

		System.out.println(String.format("Employee [%s] persisted", employee.getName()));

	}

	public void updateEmployee(EntityManager entityManager, EmployeeService employeeService) {
		entityManager.getTransaction().begin();
		Employee employee = employeeService.findEmployee(entityManager, 1);
		entityManager.getTransaction().commit();
		entityManager.clear();
		Map<String, String> updatedMap = employee.getPhoneNumbers();
		Set<String> employeeContacts = updatedMap.keySet();
		for (String s : employeeContacts) {
			System.out.println(s + "---->" + updatedMap.get(s));
		}
		entityManager.getTransaction().begin();
		updatedMap.put("others", "234");
		employee = employeeService.createEmployee(entityManager, employee.getName(), updatedMap);
		entityManager.merge(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public static void main(String[] args) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("Keying-By-Basic-Type")
				.createEntityManager();
		EmployeeService employeeService = new EmployeeService();
		ApplicationClient applicationClient = new ApplicationClient();
		Map<String, String> phoneNumbers = new HashMap<>();
		phoneNumbers.put("home", "111");
		phoneNumbers.put("work", "1123");
		phoneNumbers.put("mobile", "2365");
		// applicationClient.createEmployee(entityManager, employeeService,
		// phoneNumbers);
		applicationClient.updateEmployee(entityManager, employeeService);
	}
}
