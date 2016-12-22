package com.client;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.model.Employee;
import com.service.EmployeeService;

public class EmployeeClient {

	public void createEmployee(EntityManager em, EmployeeService service) {
		em.getTransaction().begin();
		Employee employee = service.createEmployee("Pankaj", 32);
		em.getTransaction().commit();

		System.out.println(String.format("Employee [%s] alloted space [%d]", employee.getName(),
				employee.getParkingSpace().getLot()));
	}

	public void findEmployee(EntityManager em, EmployeeService service, int id) {
		em.getTransaction().begin();
		Employee employee = service.findById(id);
		em.getTransaction().commit();

		System.out.printf("Employee [%s] found with paking space [%d]", employee.getName(),
				employee.getParkingSpace().getLot());
	}

	public static void main(String[] args) {

		EntityManager em = Persistence.createEntityManagerFactory("one-to-one_bi-directional").createEntityManager();
		EmployeeService service = new EmployeeService(em);
		EmployeeClient client = new EmployeeClient();
		// client.createEmployee(em, service);
		client.findEmployee(em, service, 1);
	}
}
