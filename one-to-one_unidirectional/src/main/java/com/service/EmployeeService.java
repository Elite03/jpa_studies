package com.service;

import com.model.Employee;
import com.model.ParkingSpace;

public interface EmployeeService {

	Employee create(String name, ParkingSpace parkingSpace);

	Employee findById(int id);
}
