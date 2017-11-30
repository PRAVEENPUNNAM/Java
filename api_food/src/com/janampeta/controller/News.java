package com.janampeta.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.janampeta.dao.UtlDao;
import com.janampeta.model.Encript1;


@WebServlet("/news")
public class News extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

doPost(request, response);	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtlDao dao = new UtlDao();
		List<Encript1> list =dao.getEncript();
		System.out.println(list);
		request.setAttribute("news", list);
		request.getRequestDispatcher("news.jsp").forward(request, response);
		
	}

}
