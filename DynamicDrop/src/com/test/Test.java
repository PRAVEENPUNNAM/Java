package com.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		
		if(action=="country"||action.equals("country"))
		{
		List<Country> list=new DAO().getCountry();
		String json=DAO.convertListObjectToJSON(list);
		response.getWriter().print(json);
	}
		
		if(action=="state"||action.equals("state"))
		{
			String state_id=request.getParameter("value");
			int key=Integer.parseInt(state_id);
			List<State> list=new DAO().getState(key);
			String json=DAO.convertListObjectToJSON(list);
			response.getWriter().print(json);
		}
	
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);	
	}

}
