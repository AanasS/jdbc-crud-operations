package com.JDBCexample.demo.dao;

import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.JDBCexample.demo.model.Employee;
import com.JDBCexample.demo.model.EmployeeBuilder;
import com.JDBCexample.demo.utils.Utils;


public class EmployeeDaoImp implements EmployeeDao {

	public List<Employee> findAll() {
		Connection con = DBConnection.getConnection();
		if(con == null) {
			return null;
		}
		String query = "SELECT * FROM employee";
		List<Employee> employees =new LinkedList<>();
		try(PreparedStatement preparedStatement = con.prepareStatement(query)){
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Employee employee = new Employee(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getBoolean("gender"),
						resultSet.getDate("birth_date"),resultSet.getDouble("salary"));
				employees.add(employee);
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try{
				con.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		return employees;
	}

	public Employee findById(int id) {
		Connection con = DBConnection.getConnection();
		if(con == null) {
			return null;
		}
		String query = "SELECT * FROM employee WHERE id=?;";
		
		try(PreparedStatement preparedStatement = con.prepareStatement(query)){
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				Employee employee = new Employee(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getBoolean("gender"),
						resultSet.getDate("birth_date"),resultSet.getDouble("salary"));
//				Employee employee= Employee.builder()
//						.id(resultSet.getInt("id"))
//						.name(resultSet.getString("name"))
//						.gender(resultSet.getBoolean("gender"))
//						.date(resultSet.getDate("birth_date"))
//						.salary(resultSet.getDouble("salary")).build();
					return employee;
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException se) {
				
				se.printStackTrace();
			}
		}
		return null;
	}

	public void save(Employee employee) {
		Connection con = DBConnection.getConnection();
		if(con == null) {
			return;
		}
		if(employee.getId()>0 ) { 	
			String query ="UPDATE employee SET name=?, gender=?, birth_date=?, salary=? WHERE id=?";
			try(PreparedStatement preparedStatement= con.prepareStatement(query)){
				preparedStatement.setString(1, employee.getName());
				preparedStatement.setBoolean(2, employee.isGender());
				preparedStatement.setDate(3, Utils.getSqlDate(employee.getBirthDate()));
				preparedStatement.setDouble(4, employee.getSalary());
				preparedStatement.setInt(5, employee.getId());
				
				preparedStatement.executeUpdate();
			}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//update
			
		}else {//create
			
			String query ="INSERT INTO employee(name, gender, birth_date, salary) VALUES (?, ?, ?, ?);";
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)){
				preparedStatement.setString(1, employee.getName());
				preparedStatement.setBoolean(2, employee.isGender());
				preparedStatement.setDate(3,Utils.getSqlDate(employee.getBirthDate()));
				preparedStatement.setDouble(4, employee.getSalary());
				
				preparedStatement.executeUpdate();
			
				
			}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				try {
					con.close();
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		}
		
	}

	public void delete(int id) {
		Connection con = DBConnection.getConnection();
		if(con == null) {
			return;
		}
		String query = "DELETE FROM employee WHERE id=?;";
		try(PreparedStatement preparedStatement= con.prepareStatement(query)){
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}

}
