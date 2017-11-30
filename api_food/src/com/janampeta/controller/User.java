package com.janampeta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.janampeta.dao.UtlDao;

/**
 * Servlet implementation class User
 */
@WebServlet("/user")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
		response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
		response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
		response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
try { 
if(request.getParameterMap().size()==0)
{
	request.getRequestDispatcher("index.jsp").forward(request, response);
}
else{	
		if(request.getParameter("type").equals("user_reg"))
		{
			com.janampeta.model.User1 u = new com.janampeta.model.User1();
			u.setFname(request.getParameter("fname"));
			u.setLname(request.getParameter("lname"));
			u.setMobile(request.getParameter("mobile"));
			u.setEmail(request.getParameter("email"));
		    u.setPassword(request.getParameter("pass"));
		    System.out.println(u.toString());
			
			UtlDao dao= new UtlDao();
			com.janampeta.model.User1 newuser =dao.reg(u);
			if(!newuser.getEmail().contains("fail"))
			{
			request.getSession().setAttribute("user", newuser);
			}
			else
			{
				request.setAttribute("error", "Please check Email / Password");
				request.getRequestDispatcher("form-register.jsp").forward(request, response);
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);	
			
		}
		
		if(request.getParameter("type").equals("log_in"))
		{
			String email=request.getParameter("email");
			String password=request.getParameter("pass");
			UtlDao dao = new UtlDao();
			com.janampeta.model.User1 u = dao.login(email, password);
			if(u.getFname().equals("janampeta1"))
			{
				request.setAttribute("error", "Please check Email/Password");
				request.getRequestDispatcher("form-login.jsp").forward(request, response);
		
			}
			else{
				request.getSession().setAttribute("user", u);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}
			}
		
		if(request.getParameter("type").equals("logout"))
		{
			System.out.println("logout");
			HttpSession session = request.getSession(false);
			session.removeAttribute("user");
			session.invalidate();
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}//if(request.getParameterMap().size()!=0)  else close
}//tryclose
catch(Exception e)
{
e.printStackTrace();
request.getRequestDispatcher("index.jsp").forward(request, response);
}
	}//dopost close
}//class close