package com.android;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.janampeta.dao.UtlDao;
import com.janampeta.model.LongNews;
import com.janampeta.model.MobileUser;
import com.janampeta.model.NewsCat;
import com.janampeta.model.ShortNews;

public class AndroidDao {

	public static final String JDBC_DRIVER = UtlDao.JDBC_DRIVER;
	public static final String DB_URL = UtlDao.DB_URL;
	public static final String USR = UtlDao.USR;
	public static final String PASS = UtlDao.PASS;
	Connection conn = null;
	Statement stmt = null;

	public List<String> getBanners() {
		String reg = "select use_data from android_use where use_name='home_banners' and use_status=1 ";
		String data = "";
		List<String> banners = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USR, PASS);
			PreparedStatement pst = conn.prepareStatement(reg);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				data = rs.getString("use_data");
			}
			banners = new ArrayList<String>(Arrays.asList(data.split("___")));
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
System.out.println(banners.toString());
		return banners;
	}

	
public MobileUser mobileReg(MobileUser u)
	
	{
		String reg="insert into user(fname,lname,mobile,email,pass,fcmid,deviceid) values(?,?,?,?,?,?,?);";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USR, PASS);
			PreparedStatement pst = conn.prepareStatement(reg);
			pst.setString(1, u.getFname());
			pst.setString(2,u.getLname());
			pst.setString(3,u.getMobile());
			pst.setString(4,u.getEmail());
			pst.setString(5,u.getPassword());
			pst.setString(6, u.getFcmId());
			pst.setString(7, u.getDeviceId());
			int flag=pst.executeUpdate();
			if(flag==1)
				return u;
			else
				System.out.println("else");
				return new MobileUser();
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
	

public List<ShortNews> getShortNews()
{

	List<ShortNews> list = new ArrayList<ShortNews>();
	
	String reg="select newsid,title,img,date(time) AS uploadtime,(select cat_name from news_cat where cat_id=1) AS newstype from news where status=1 and cat_id=1";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, USR, PASS);
		PreparedStatement pst = conn.prepareStatement(reg);
		
	ResultSet rs = pst.executeQuery();
	while(rs.next())
	{
	ShortNews e = new ShortNews();
	e.setId(rs.getInt("newsid"));
	e.setTitle(rs.getString("title"));
	e.setImage(rs.getString("img"));
	e.setDate(rs.getString("uploadtime"));
	e.setNewscat(rs.getString("newstype"));
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

public List<LongNews> getLongNews(int newsId)
{

	List<LongNews> list = new ArrayList<LongNews>();
	
	String reg="select newsid,title,ldesc,img,date(news.time) AS uploadtime, news_cat.cat_name as newstype from news inner join news_cat on news.cat_id=news_cat.cat_id where news.status=1 and newsid="+newsId;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, USR, PASS);
		PreparedStatement pst = conn.prepareStatement(reg);
		
	ResultSet rs = pst.executeQuery();
	while(rs.next())
	{
		LongNews e = new LongNews();
	e.setId(rs.getInt("newsid"));
	e.setTitle(rs.getString("title"));
	e.setLongdesc(rs.getString("ldesc"));
	e.setImage(rs.getString("img"));
	e.setDate(rs.getString("uploadtime"));
	e.setNewscat(rs.getString("newstype"));
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



public List<NewsCat> getNewsCat()
{

	List<NewsCat> list = new ArrayList<NewsCat>();
	
	String reg="select cat_id,cat_name,cat_image from news_cat where status=1";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, USR, PASS);
		PreparedStatement pst = conn.prepareStatement(reg);
		
	ResultSet rs = pst.executeQuery();
	while(rs.next())
	{
		NewsCat e = new NewsCat();
	e.setCatId(rs.getInt("cat_id"));
	e.setCatName(rs.getString("cat_name"));
	e.setCatImage(rs.getString("cat_image"));
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


public List<ShortNews> getSingleCatNewsList(int catId)
{

	List<ShortNews> list = new ArrayList<ShortNews>();
	
	String reg="select newsid,title,img,date(time) AS uploadtime,(select cat_name from news_cat where cat_id=?) AS newstype from news where status=1 and cat_id=?";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, USR, PASS);
		PreparedStatement pst = conn.prepareStatement(reg);
		pst.setInt(1, catId);
		pst.setInt(2, catId);
	ResultSet rs = pst.executeQuery();
	while(rs.next())
	{
	ShortNews e = new ShortNews();
	e.setId(rs.getInt("newsid"));
	e.setTitle(rs.getString("title"));
	e.setImage(rs.getString("img"));
	e.setDate(rs.getString("uploadtime"));
	e.setNewscat(rs.getString("newstype"));
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

}
