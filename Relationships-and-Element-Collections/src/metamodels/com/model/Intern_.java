package com.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-23T09:46:02.445+0530")
@StaticMetamodel(Intern.class)
public class Intern_ {
	public static volatile SingularAttribute<Intern, Integer> id;
	public static volatile SingularAttribute<Intern, String> internName;
	public static volatile CollectionAttribute<Intern, VacationEntry> vacationEntries;
	public static volatile CollectionAttribute<Intern, String> nickName;
}
