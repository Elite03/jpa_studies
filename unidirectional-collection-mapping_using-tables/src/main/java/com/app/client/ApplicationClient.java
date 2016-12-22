package com.app.client;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.model.Employee;
import com.service.ApplicationService;

public class ApplicationClient {

	public void operateOnUniDirectionalCollectionMapping(ApplicationService service, EntityManager manager) {
		manager.getTransaction().begin();
		Employee employee = service.createEmployee();
		manager.getTransaction().commit();
		manager.close();
		System.out.println(String.format("Employee [%s] persisted ", employee.getEmployeeName()));
	}

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("unidirectional-collection-mapping_using-tables")
				.createEntityManager();
		ApplicationService service = new ApplicationService(manager);
		ApplicationClient client = new ApplicationClient();
		client.operateOnUniDirectionalCollectionMapping(service, manager);
	}
}
