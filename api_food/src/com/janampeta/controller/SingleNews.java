package com.janampeta.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.janampeta.dao.UtlDao;
import com.janampeta.model.Encript1;


@WebServlet("/singleNews")
public class SingleNews extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doPost(request, response);	
		}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newsId=request.getParameter("type");
		UtlDao dao = new UtlDao();
		Encript1 e = dao.getSingleEncript(Integer.parseInt(newsId));
		System.out.println(e);
		request.setAttribute("snews", e);
		request.getRequestDispatcher("fullwidth.jsp").forward(request, response);
	}

}
