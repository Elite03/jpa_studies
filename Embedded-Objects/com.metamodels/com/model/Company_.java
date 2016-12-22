package com.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-21T11:40:05.254+0530")
@StaticMetamodel(Company.class)
public class Company_ {
	public static volatile SingularAttribute<Company, Integer> id;
	public static volatile SingularAttribute<Company, String> name;
	public static volatile SingularAttribute<Company, Address> address;
}
