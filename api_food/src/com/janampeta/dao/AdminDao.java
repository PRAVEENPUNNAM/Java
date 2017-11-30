package com.janampeta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.janampeta.model.Encript;
import com.janampeta.model.User;

public class AdminDao {

	public static final String JDBC_DRIVER = UtlDao.JDBC_DRIVER;
	public static final String DB_URL = UtlDao.DB_URL ;
	public static final String USR = UtlDao.USR;
	public static final String PASS = UtlDao.PASS;
	Connection conn = null;
	Statement stmt = null;
	public List<User> getUsers()
	{
		List<User> userList = new ArrayList<User>();
		
		String reg="select user_id,fname,lname,mobile,email,image from user";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USR, PASS);
			PreparedStatement pst = conn.prepareStatement(reg);
			
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			User u = new User();
		 u.setFname(rs.getString("fname"));
		 u.setLname(rs.getString("lname"));
		 u.setMobile(rs.getString("mobile"));
		 u.setEmail(rs.getString("email"));
		 u.setUserid(rs.getInt("user_id"));
		 u.setImageurl(rs.getString("image"));
		 userList.add(u);
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return userList;
	}
	
	
	
	public int login(String email,String pass)
	{
		int id=0;
		
		String reg="select id from admin where username=? and password=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USR, PASS);
			PreparedStatement pst = conn.prepareStatement(reg);
			pst.setString(1, email);
			pst.setString(2, pass);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			id=rs.getInt("id");
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return id;
	}

	
	public int uploadEncriptData( Encript e)
	{
		int status=0;
		String reg="insert into news (title,short,ldesc,img,cat_id) values (?,?,?,?,?);";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USR, PASS);
			PreparedStatement pst = conn.prepareStatement(reg);
		pst.setString(1, e.getTitle());
		pst.setString(2, e.getSdec());
		pst.setString(3, e.getLdec());
		pst.setString(4, e.getImgUrl());
		pst.setInt(5, Integer.parseInt(e.getCatId()));
		status=pst.executeUpdate();
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		
		return status;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		/*Encript e = new Encript();
		e.setImgUrl("image");
		e.setLdec("hi how r u");
		e.setSdec("hi");
		e.setTitle("my title");
	System.out.println(new AdminDao().uploadEncriptData(e));	*/
	}
}
