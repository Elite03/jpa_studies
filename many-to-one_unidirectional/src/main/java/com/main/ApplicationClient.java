package com.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.models.Department;
import com.models.Employee;
import com.service.EmployeeService;
import com.service.impl.EmployeeServiceImpl;

public class ApplicationClient {

	public void createEmployee(EmployeeService service) {
		Department department = new Department("Development");
		Employee employee = service.create("Pankaj", department);
		// System.out.println(String.format("Employee (%s) persisted",
		// employee.getName()));
	}

	public void findEmployee(int id, EmployeeService service) {
		Employee employee = service.findEmployee(id);
		Department department = employee.getDepartment();
		System.out.println(
				String.format("Employee (%s) exists in deparment (%s)", employee.getName(), department.getDeptName()));
	}

	public void findAll(EntityManager manager, EmployeeService service) {
		manager.getTransaction().begin();
		List<Employee> employeeList = (List<Employee>) service.findAll();
		if (employeeList.isEmpty() || employeeList == null || employeeList.size() == 0)
			throw new NullPointerException(String.format("No Employee Found"));
		for (Employee employee : employeeList) {
			String.format("Employee (%s) exists in deparment (%s)", employee.getName(),
					employee.getDepartment().getDeptName());
		}
	}

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("many-to-one_unidirectional");
		EntityManager manager = entityManagerFactory.createEntityManager();
		ApplicationClient client = new ApplicationClient();
		EmployeeService service = new EmployeeServiceImpl(manager);
		client.createEmployee(service);
		// client.findEmployee(1, service);
		// client.findAll(manager, service);
	}
}
