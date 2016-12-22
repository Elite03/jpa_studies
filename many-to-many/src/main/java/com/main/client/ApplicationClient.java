package com.main.client;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.model.Employee;
import com.model.Project;

public class ApplicationClient {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("many-to-many").createEntityManager();

		manager.getTransaction().begin();
		Employee employee = new Employee("Pankaj");
		Employee manpreet = new Employee("Manpreet");
		Project project = new Project("Development");
		Project manpreetsP = new Project("null");
		List<Employee> employeeList = Arrays.asList(new Employee("Shveta"), new Employee("Manpreet"), employee);
		List<Project> projectList = Arrays.asList(new Project("production"), new Project("Testing"),
				new Project("Designing"), project);
		employee.setProjects(projectList);
		project.setEmployees(employeeList);
		manpreet.setProjects(projectList);
		manpreetsP.setEmployees(employeeList);
		manager.persist(manpreet);
		manager.persist(project);
		manager.persist(employee);
		manager.getTransaction().commit();

		manager.close();

		System.out.println("DONE");
	}
}
