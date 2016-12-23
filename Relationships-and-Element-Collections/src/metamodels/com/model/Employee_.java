package com.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-23T09:42:05.957+0530")
@StaticMetamodel(Employee.class)
public class Employee_ {
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, String> employeeName;
	public static volatile CollectionAttribute<Employee, VacationEntry> vacationEntries;
	public static volatile CollectionAttribute<Employee, String> nickNames;
}
