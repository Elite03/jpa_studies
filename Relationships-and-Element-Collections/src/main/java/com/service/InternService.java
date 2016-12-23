package com.service;

import java.util.Collection;

import javax.persistence.EntityManager;

import com.model.Intern;
import com.model.VacationEntry;

public class InternService {

	private EntityManager entityManager;

	public InternService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Intern createIntern(Collection<VacationEntry> vacationEntries, Collection<String> nickNames,
			String InternName) {
		Intern intern = new Intern(InternName);
		intern.setNickName(nickNames);
		intern.setVacationEntries(vacationEntries);
		entityManager.persist(intern);

		return intern;
	}
}
