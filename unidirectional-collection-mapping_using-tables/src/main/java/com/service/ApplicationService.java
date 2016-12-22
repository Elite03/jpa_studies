package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.model.Employee;
import com.model.PhoneNumber;

public class ApplicationService {

	private EntityManager entityManager;

	public ApplicationService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Employee createEmployee() {
		Employee pankaj = new Employee("Pankaj");
		List<PhoneNumber> numberList = new ArrayList<>();
		numberList.add(new PhoneNumber(123, "Nokia"));

		numberList.add(new PhoneNumber(345, "Lava"));
		pankaj.setPhoneNumbers(numberList);

		Employee manpreet = new Employee("Manpreet");

		numberList.add(new PhoneNumber(3310, "Nokia"));
		manpreet.setPhoneNumbers(numberList);
		entityManager.persist(pankaj);
		entityManager.persist(manpreet);
		return manpreet;
	}
}
