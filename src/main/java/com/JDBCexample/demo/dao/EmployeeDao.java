package com.JDBCexample.demo.dao;

import java.util.List;

import com.JDBCexample.demo.model.Employee;

public interface EmployeeDao {
	
	List<Employee> findAll();
	Employee findById(int id);
	void save (Employee employee);
	void delete (int id);

}
