package com.dahlia.cont;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public Connection getConnection() 
	{
		Connection con=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		
		}
		catch(Exception e)
		{
			System.out.println("exception"+e);
		}
		return con;
	}
	
	
}
