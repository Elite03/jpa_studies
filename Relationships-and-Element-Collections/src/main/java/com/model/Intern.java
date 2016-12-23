package com.model;

import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "intern")
public class Intern {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;

	@Column(name = "internName")
	private String internName;

	@ElementCollection(targetClass = VacationEntry.class)
	@CollectionTable(name = "interns_vacations", joinColumns = @JoinColumn(name = "intern_id"))
	private Collection<VacationEntry> vacationEntries;

	@ElementCollection
	@CollectionTable(name = "intern_nicknames", joinColumns = @JoinColumn(name = "intern_id"))
	@Column(name = "nickname")
	private Collection<String> nickName;

	public Intern() {
	}

	public Intern(String internName) {
		this.internName = internName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInternName() {
		return internName;
	}

	public void setInternName(String internName) {
		this.internName = internName;
	}

	public Collection<VacationEntry> getVacationEntries() {
		return vacationEntries;
	}

	public void setVacationEntries(Collection<VacationEntry> vacationEntries) {
		this.vacationEntries = vacationEntries;
	}

	public Collection<String> getNickName() {
		return nickName;
	}

	public void setNickName(Collection<String> nickName) {
		this.nickName = nickName;
	}

}
