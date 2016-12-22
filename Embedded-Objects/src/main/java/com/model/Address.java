package com.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String country;
	private String state;
	private String zipCode;
	private String phoneNumber;

	public Address() {
	}

	public Address(String country, String state, String zipCode, String phoneNumber) {
		this.country = country;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Address [country=" + country + ", state=" + state + ", zipCode=" + zipCode + ", phoneNumber="
				+ phoneNumber + "]";
	}

}
