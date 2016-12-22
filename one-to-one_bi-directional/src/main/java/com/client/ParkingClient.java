package com.client;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.model.Employee;
import com.model.ParkingSpace;
import com.service.ParkingService;

public class ParkingClient {

	public void create(EntityManager em, int lot, String name, ParkingService service) {
		em.getTransaction().begin();
		ParkingSpace parkingSpace = service.create(lot, name);
		Employee employee = parkingSpace.getEmployee();
		employee.setParkingSpace(parkingSpace);
		parkingSpace.setEmployee(employee);
		em.getTransaction().commit();

		System.out.printf("Parking space [%d] has been assined to Employee [%s]", parkingSpace.getLot(),
				employee.getName());
	}

	public void findById(EntityManager em, ParkingService service, int id) {
		em.getTransaction().begin();
		ParkingSpace parkingSpace = service.findById(id);
		em.getTransaction().commit();

		System.out.printf("Employee [%s] found with Parking space alloted [%d]", parkingSpace.getEmployee().getName(),
				parkingSpace.getLot());
	}

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("one-to-one_bi-directional").createEntityManager();
		ParkingClient client = new ParkingClient();
		ParkingService service = new ParkingService(em);
		// client.create(em, 45, "Manpreet", service);
		client.findById(em, service, 1);
	}
}
