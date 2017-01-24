package com.swa.app.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	

	
	public static Connection getNewConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		//connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/hamarapa_db?noAccessToProcedureBodies=true","hamarapa_root","JTUN?Wp.6-?P");
		connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/serv?noAccessToProcedureBodies=true","root","");
		return connection;
	}
	
	/*public static Connection getRemoteConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection =java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/opd_test","opduser","opdusertest");
		//connection =DriverManager.getConnection("jdbc:mysql://http://69.175.56.226:2082/pcindian_apiplane","pcindian","Dnwb2VF4X15kSlHw");
		
		return connection;
	}*/
	
	public static void closeConnection(Connection connection) throws SQLException
	{
		connection.close();                                                             
		connection = null; 
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection con = getNewConnection();
		if(con != null)
		{
			System.out.println("Got Connection");
			closeConnection(con);
		}
		/*con = getRemoteConnection();
		if(con != null)
		{
			System.out.println("Got Remote Connection");
			closeConnection(con);

		}*/
	}

}
