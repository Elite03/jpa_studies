package com.model;

import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;

	@Column(name = "employeeName")
	private String employeeName;

	@ElementCollection(targetClass = VacationEntry.class, fetch = FetchType.LAZY)
	@CollectionTable(name = "employee_vacations", joinColumns = @JoinColumn(name = "employee_id"))
	private Collection<VacationEntry> vacationEntries;

	@ElementCollection
	@CollectionTable(name = "employee_nicknames", joinColumns = @JoinColumn(name = "employee_id"))
	@Column(name = "nickname")
	private Collection<String> nickNames;

	public Employee() {

	}

	public Employee(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Collection<VacationEntry> getVacationEntries() {
		return vacationEntries;
	}

	public void setVacationEntries(Collection<VacationEntry> vacationEntries) {
		this.vacationEntries = vacationEntries;
	}

	public Collection<String> getNickNames() {
		return nickNames;
	}

	public void setNickNames(Collection<String> nickNames) {
		this.nickNames = nickNames;
	}

}
