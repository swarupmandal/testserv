package com.swa.app.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.swa.app.bean.Employee;
import com.swa.app.db.ConnectionFactory;

public class EmpDao {

	public static int save(Employee employee){
		
		int i = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "insert into user (name,password,email,country) values (?,?,?,?) ";
		try {
			connection = (Connection) ConnectionFactory.getNewConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getPassword());
			preparedStatement.setString(3, employee.getEmail());
			preparedStatement.setString(4, employee.getCountry());
			
			i = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return i;
		
	}
	
}
