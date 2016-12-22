package com.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class VacationEntry {

	@Temporal(TemporalType.DATE)
	private Calendar startDay;

	@Column(name = "days")
	private int totalDays;

	public VacationEntry() {
	}

	public VacationEntry(Calendar startDay, int totalDays) {
		this.startDay = startDay;
		this.totalDays = totalDays;
	}

	public Calendar getStartDay() {
		return startDay;
	}

	public void setStartDay(Calendar startDay) {
		this.startDay = startDay;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

}
