package com.JDBCexample.demo.model;

import java.util.Date;

public class Employee {

	int id;
	String name;
	boolean gender;
	Date birthDate;
	double salary;
	public Employee() {
		super();
	}
	public Employee(int id, String name, boolean gender, Date birthDate, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public static EmployeeBuilder builder() {
		return new EmployeeBuilder();
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", birthDate=" + birthDate + ", salary="
				+ salary + "]";
	}
	
}
