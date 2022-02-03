package com.JDBCexample.demo;

import java.sql.Connection;
import java.util.Date;

import com.JDBCexample.demo.dao.DBConnection;
import com.JDBCexample.demo.dao.EmployeeDao;
import com.JDBCexample.demo.dao.EmployeeDaoImp;
import com.JDBCexample.demo.model.Employee;

public class App {
	
	public static void main(String[] args) {
		
		EmployeeDao employeeDao = new EmployeeDaoImp();
		
		Employee employee= Employee.builder()
				.gender(true)
				.date(new Date())
				.salary(2506d).build();
//		Employee employee = new Employee(1,"Fatima",false,new Date(),2500d);
		
		employeeDao.save(employee);
//		employeeDao.findAll().forEach(System.out::println);
//		Employee emp = employeeDao.findById(1);
//		System.out.println(emp);
//		employeeDao.delete(1);
		System.out.println("done");
   }

}
