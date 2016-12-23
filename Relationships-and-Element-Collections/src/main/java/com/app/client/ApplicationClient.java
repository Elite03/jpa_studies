package com.app.client;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.model.Employee;
import com.model.Intern;
import com.model.VacationEntry;
import com.service.EmployeeService;
import com.service.InternService;

public class ApplicationClient {

	public void createApplication(EntityManager entityManager, EmployeeService employeeService,
			InternService internService) {
		String shveta = "Shveta";
		String manpreet = "Manpreet";
		List<VacationEntry> vacationEntries = new ArrayList<>();
		VacationEntry vacationEntry = new VacationEntry(Calendar.getInstance(), 4);
		vacationEntries.add(vacationEntry);
		List<String> nickNames = new ArrayList<>();
		nickNames.add("shenu");
		nickNames.add("sveta");
		entityManager.getTransaction().begin();
		Employee employee = employeeService.create(vacationEntries, nickNames, shveta);
		entityManager.getTransaction().commit();
		entityManager.clear();
		System.out.println(String.format("++++++++++++++++++++EMPLOYEE : [%s] PERSISTED++++++++++++++++++++",
				employee.getEmployeeName()));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entityManager.getTransaction().begin();
		vacationEntries.clear();
		nickNames.clear();
		vacationEntry = new VacationEntry(Calendar.getInstance(), 5);
		nickNames.add("Manu");
		vacationEntries.add(vacationEntry);
		Intern intern = internService.createIntern(vacationEntries, nickNames, manpreet);
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println(String.format("++++++++++++++++++++Intern : [%s] PERSISTED++++++++++++++++++++",
				intern.getInternName()));
	}

	public static void main(String[] args) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("Relationships-and-Element-Collections")
				.createEntityManager();
		// InternService internService = new InternService(entityManager);
		EmployeeService employeeService = new EmployeeService(entityManager);
		// ApplicationClient client = new ApplicationClient();
		// client.createApplication(entityManager, employeeService,
		// internService);
		employeeService.readEmployee();

	}
}
