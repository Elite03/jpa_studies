package com.client;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.model.Department;
import com.model.Employee;
import com.service.DepartmentService;
import com.service.EmployeeService;

public class EmployeeClient {

	public void createEmployee(EntityManager manager, EmployeeService empService, DepartmentService deptService,
			String deptName, List<Integer> deptPrimaryKeys) {
		Department department = this.findExistingDepartment(deptPrimaryKeys, deptService, deptName);
		Employee employee = empService.create(department);
		System.out.println(String.format("Employee [%s] persisted in department [%s]", employee.getEmpName(),
				department.getDeptName()));
	}

	public Department findExistingDepartment(List<Integer> list, DepartmentService service, String deptName) {

		for (Integer i : list) {
			Department department = service.findEmployeeByDept(i);
			System.out.println(department.getDeptName());
			if (department.getDeptName().equalsIgnoreCase(deptName)) {
				System.out.println("department returned");
				return department;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("one-to-many_Collection-Valued")
				.createEntityManager();
		EmployeeService empService = new EmployeeService(manager);
		DepartmentService deptService = new DepartmentService(manager);
		List<Integer> deptPrimaryKeys = Arrays.asList(1, 2);
		EmployeeClient client = new EmployeeClient();
		client.createEmployee(manager, empService, deptService, "Production", deptPrimaryKeys);

	}
}
