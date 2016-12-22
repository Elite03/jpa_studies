package com.service;

import javax.persistence.EntityManager;

import com.model.Address;
import com.model.Company;

public class CompanyService {

	public Company addEmployeeAddress(Address address, EntityManager entityManager) {
		Company company = new Company("IBM");
		company.setAddress(address);
		entityManager.persist(company);

		return company;
	}
}
