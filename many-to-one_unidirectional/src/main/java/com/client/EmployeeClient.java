package com.client;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EmployeeClient {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("").createEntityManager();
	}
}
