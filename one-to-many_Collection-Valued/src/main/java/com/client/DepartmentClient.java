package com.client;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.model.Department;
import com.model.Employee;
import com.service.DepartmentService;

public class DepartmentClient {

	public void create(String deptName, DepartmentService service, EntityManager entityManager) {
		entityManager.getTransaction().begin();
		Department department = service.create(deptName);
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println(String.format("Department [%s] persisted", department.getDeptName()));
	}

	public void findEmployee(EntityManager entityManager, DepartmentService departmentService) {
		entityManager.getTransaction().begin();
		Department department = departmentService.findEmployeeByDept(1);
		entityManager.getTransaction().commit();
		entityManager.close();
		for (Employee e : department.getEmployees()) {
			System.out.println(String.format("Employee [%s] exists in [%s] department ", e.getEmpName(),
					department.getDeptName()));
		}
	}

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("one-to-many_Collection-Valued")
				.createEntityManager();
		DepartmentService service = new DepartmentService(manager);
		DepartmentClient client = new DepartmentClient();
		// client.create("Production", service, manager);
		client.findEmployee(manager, service);

	}
}
