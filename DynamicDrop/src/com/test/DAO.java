package com.test;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DAO {

	public List<Country> getCountry()
	{
		List<Country> list=new ArrayList<Country>();
		Connection con=databasecon.getconnection();
		String sql="select * from countries";
		
	try {
		PreparedStatement pst = con.prepareStatement(sql);
		
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			Country c= new Country();
			c.setCountry_id(rs.getInt(1));
			c.setCountry(rs.getString(3));
			
			list.add(c);
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	}
	
	public List<State> getState(int key)
	{
		List<State> list=new ArrayList<State>();
		Connection con=databasecon.getconnection();
		String sql="select * from states where country_id=?";
		
	try {
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, key);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			State s= new State();
			s.setState_id(rs.getInt(1));
			s.setState(rs.getString(2));
			
			list.add(s);
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	}
	
	
	
	
	public static String convertListObjectToJSON(List<?> list) {
		String json = null;
		Gson gson = new Gson();
		Type type = new TypeToken<List<?>>() {}.getType();
		json = gson.toJson(list, type);
		return json;
	}
	
}
