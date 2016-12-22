package com.client;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.model.Department;
import com.service.DepartmentService;

public class DepartmentClient {

	public void create(String deptName, DepartmentService service, EntityManager entityManager) {
		entityManager.getTransaction().begin();
		Department department = service.create(deptName);
		entityManager.getTransaction().commit();
		System.out.println(String.format("Department [%s] persisted", department.getDeptName()));
	}

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("one-to-many_Collection-Valued")
				.createEntityManager();
		synchronized (manager) {
			DepartmentService service = new DepartmentService(manager);
			DepartmentClient client = new DepartmentClient();
			client.create("Production", service, manager);
		}

	}
}
