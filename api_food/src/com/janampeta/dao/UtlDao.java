package com.janampeta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.janampeta.model.Encript1;
import com.janampeta.model.User1;

public class UtlDao {

	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost/jpt";
	public static final String USR = "mysql";
	public static final String PASS = "mysql";
	Connection conn = null;
	Statement stmt = null;

	public String con() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USR, PASS);
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
		return conn.toString();
	}
	
	public User1 reg(User1 u)
	{
		String reg="insert into user(fname,lname,mobile,email,pass) values(?,?,?,?,?);";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USR, PASS);
			PreparedStatement pst = conn.prepareStatement(reg);
			pst.setString(1, u.getFname());
			pst.setString(2,u.getLname());
			pst.setString(3,u.getMobile());
			pst.setString(4,u.getEmail());
			pst.setString(5,u.getPassword());
			int flag=pst.executeUpdate();
			if(flag==1)
				return u;
			else
				System.out.println("else");
				return new User1();
		} catch (Exception e) {
			if(e.getMessage().contains("for key 'email'") || e.getMessage().contains("for key 'mobile'"))
			{
				u = new User1();
				u.setEmail("fail");
				return u;
			}
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return u;
	}
	
	public User1 login(String email,String pass)
	{
		User1 u = new User1();
		u.setFname("janampeta1");
		String reg="select fname,lname,mobile,email from user where email=? and pass=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USR, PASS);
			PreparedStatement pst = conn.prepareStatement(reg);
			pst.setString(1, email);
			pst.setString(2, pass);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
		 u.setFname(rs.getString("fname"));
		 u.setLname(rs.getString("lname"));
		 u.setMobile(rs.getString("mobile"));
		 u.setEmail(rs.getString("email"));
		}
			return u;
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
		
		return u;
	}
	
	
	
	public List<Encript1> getEncript()
	{
	
		List<Encript1> list = new ArrayList<Encript1>();
		
		String reg="select newsid,title,short,ldesc,img from news where status=1 order by news.time DESC";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USR, PASS);
			PreparedStatement pst = conn.prepareStatement(reg);
			
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
		Encript1 e = new Encript1();
		e.setId(rs.getInt("newsid"));
		e.setTitle(rs.getString("title"));
		e.setSdec(rs.getString("short"));
		e.setLdec(rs.getString("ldesc"));
		e.setImgUrl(rs.getString("img"));
		list.add(e);
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
		
		return list;
	}
	
	
	public Encript1 getSingleEncript(int newsId)
	{
		Encript1 e = new Encript1();
		String reg="select newsid,title,short,ldesc,img from news where newsid=? and status=1";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USR, PASS);
			PreparedStatement pst = conn.prepareStatement(reg);
			pst.setInt(1, newsId);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
		e.setId(rs.getInt("newsid"));
		e.setTitle(rs.getString("title"));
		e.setSdec(rs.getString("short"));
		e.setLdec(rs.getString("ldesc"));
		e.setImgUrl(rs.getString("img"));
		
		}
		
		
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
		
		return e;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new UtlDao().getEncript());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public static void main(String[] args) {
	System.out.println(new UtlDao().login("praveenswathi222@gmail.com", "12345"));
	}*/
	
	
	
}
