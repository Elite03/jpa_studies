package com.app.service;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.model.Address;
import com.model.Company;
import com.model.Employee;
import com.service.CompanyService;
import com.service.EmployeeService;

public class ApplicationClient {

	public void testApplication(EntityManager manager, EmployeeService employeeService, CompanyService companyService,
			Address address) {
		manager.getTransaction().begin();
		Employee employee = employeeService.create(address, manager);
		manager.getTransaction().commit();
		manager.clear();
		manager.getTransaction().begin();
		Company company = companyService.addEmployeeAddress(address, manager);
		manager.getTransaction().commit();
		manager.close();
		System.out.println(String.format("[%s] created ", employee.toString()));
		System.out.println(String.format("[%s] created ", company.toString()));

	}

	public static void main(String[] args) {
		System.out.println("<>+++++++++++++++++++++++START+++++++++++++++++++++++<>");
		EntityManager manager = Persistence.createEntityManagerFactory("Embedded-Objects").createEntityManager();
		EmployeeService employeeService = new EmployeeService();
		CompanyService companyService = new CompanyService();
		ApplicationClient client = new ApplicationClient();
		Address address = new Address("India", "J&K", "184202", "9023564364");
		client.testApplication(manager, employeeService, companyService, address);
		System.out.println("<>+++++++++++++++++++++++END+++++++++++++++++++++++<>");
	}
}
