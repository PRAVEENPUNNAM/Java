package com.test;
import java.sql.*;
public class databasecon
{
	public static Connection getconnection()
	{ 			
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		}
		catch(Exception e)
		{
			System.out.println("Connection error :"+e.getMessage());
		}
		return con;
	}
	
	public static void closeConnection(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
