package com.JDBCexample.demo.model;

import java.util.Date;

public class EmployeeBuilder {

	int id;
	String name;
	boolean gender;
	Date birthDate;
	double salary;
	
	public EmployeeBuilder id(int id) {
		this.id=id;
		return this;
	}
	public EmployeeBuilder name(String name) {
		this.name=name;
		return this;
	}
	public EmployeeBuilder gender(boolean gender) {
		this.gender=gender;
		return this;
	}
	public EmployeeBuilder date(Date date) {
		this.birthDate=date;
		return this;
	}
	public EmployeeBuilder salary(double salary) {
		this.salary=salary;
		return this;
	}
	
	public Employee build() {
		return new Employee(id,name,gender,birthDate, salary);
	}
}
