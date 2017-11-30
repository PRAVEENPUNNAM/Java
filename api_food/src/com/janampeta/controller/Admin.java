package com.janampeta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.janampeta.dao.AdminDao;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/bittu")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession s = request.getSession(false);
		
		response.sendRedirect("adminjanampeta.jsp");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
			if(request.getParameter("type").equals("login"))
			{HttpSession session =request.getSession(false);
				String email=request.getParameter("email");
				String pass=request.getParameter("pass");
				AdminDao dao = new AdminDao();
				int adminId=dao.login(email, pass);
				System.out.println(adminId+"  "+dao.getUsers());
				if(adminId!=0)
				{
					request.getSession().setAttribute("ADMIN", adminId);
				request.setAttribute("users", dao.getUsers());
				System.out.println(adminId +"  "+dao.getUsers());
				request.getRequestDispatcher("admin.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("adminjanampeta.jsp").forward(request, response);
				}
				}
			else
			{
				request.setAttribute("users", new AdminDao().getUsers());
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			}
		
	
	
	}
		/*else
		{
			request.setAttribute("users", new AdminDao().getUsers());
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}*/
	}


