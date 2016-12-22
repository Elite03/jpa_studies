package com.service;

import java.util.Collection;

import com.models.Department;
import com.models.Employee;

public interface EmployeeService {

	Employee create(String name, Department department);

	Employee findEmployee(int id);

	Collection<Employee> findAll();

}
