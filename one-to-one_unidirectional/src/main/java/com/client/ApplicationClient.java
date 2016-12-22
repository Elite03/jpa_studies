package com.client;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.model.Employee;
import com.model.ParkingSpace;
import com.service.EmployeeService;
import com.service.impl.EmployeeServiceImpl;

public class ApplicationClient {

	public void createParkingSpace(EmployeeService service) {
		ParkingSpace parkingSpace = new ParkingSpace(32);
		Employee employee = service.create("Pankaj", parkingSpace);
		System.out.println(String.format("Employee [%s] has been alloted [%d] foot parking space", employee.getName(),
				employee.getParkingSpace().getLot()));
	}

	public void findById(EmployeeService service) {
		Employee employee = service.findById(1);
		System.out.println(String.format("Employee [%s] with alloted parking space [%d]", employee.getName(),
				employee.getParkingSpace().getLot()));
		Employee employee2 = service.findById(2);
		System.out.println(String.format("Employee [%s] with alloted parking space [%d]", employee2.getName(),
				employee2.getParkingSpace().getLot()));
	}

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("one-to-one_unidirectional")
				.createEntityManager();
		EmployeeService service = new EmployeeServiceImpl(manager);
		ApplicationClient client = new ApplicationClient();
		// client.createParkingSpace(service);
		client.findById(service);
	}
}
