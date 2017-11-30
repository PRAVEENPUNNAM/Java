package com.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.janampeta.dao.UtlDao;
import com.janampeta.model.LongNews;
import com.janampeta.model.MobileUser;
import com.janampeta.model.NewsCat;
import com.janampeta.model.ShortNews;


@WebServlet("/android")
public class AndroidController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		Gson gson = new Gson();	
		String json="";
	
String type=request.getParameter("type");
if(type.equals("home-page"))
{
	Map<String,String> map= new HashMap<>();
	List<String> banners= new AndroidDao().getBanners();
    map.put("banner", banners.get(0));
    map.put("icon", banners.get(1));
    map.put("text", "MY JANAMPETA");
	json=gson.toJson(map);
     out.print(json);
}
		
//-------------------------------------

if(request.getParameter("type").equals("user_reg"))
{
	com.janampeta.model.MobileUser u = new com.janampeta.model.MobileUser();
	u.setFname(request.getParameter("fname"));
	u.setLname(request.getParameter("lname"));
	u.setMobile(request.getParameter("mobile"));
	u.setEmail(request.getParameter("email"));
    u.setPassword(request.getParameter("pass"));
    u.setFcmId(request.getParameter("fcm"));
    u.setDeviceId(request.getParameter("device"));
    System.out.println(u.toString());
	
	AndroidDao dao= new AndroidDao();
	MobileUser newuser =dao.mobileReg(u);
	json = gson.toJson(newuser);
	 out.print(json);
	
}

if(request.getParameter("type").equals("log_in"))
{
	String email=request.getParameter("email");
	String password=request.getParameter("pass");
	UtlDao dao = new UtlDao();
	com.janampeta.model.User1 u = dao.login(email, password);
	if(u.getFname().equals("janampeta1"))
	{
		Map<String, String> map = new HashMap<String,String>();
		map.put("error", "Please check Email/Password");
		json=gson.toJson(map);
		out.print(json);
	}
	else{
		
		 json = gson.toJson(u);
		 out.print(json);
	}
	}


if(request.getParameter("type").equals("newcat"))
{
	
	AndroidDao dao = new AndroidDao();
	List<NewsCat> list =dao.getNewsCat();
	json=gson.toJson(list);
	response.setContentType("text/html; charset=UTF-8");
	out.print(json);
	//out.flush();

}


if(request.getParameter("type").equals("localnews"))
{
	
	AndroidDao dao = new AndroidDao();
	List<ShortNews> list =dao.getShortNews();
	json=gson.toJson(list);
	response.setContentType("text/html; charset=UTF-8");
	out.print(json);
	//out.flush();

}

if(request.getParameter("type").equals("singlenews"))
{
	
	AndroidDao dao = new AndroidDao();
	List<LongNews> list =dao.getLongNews(Integer.parseInt(request.getParameter("newsid")));
	json=gson.toJson(list);
	response.setContentType("text/html; charset=UTF-8");
	out.print(json);
	//out.flush();

}

if(request.getParameter("type").equals("singlecategory"))
{
	
	AndroidDao dao = new AndroidDao();
	List<ShortNews> list =dao.getSingleCatNewsList(Integer.parseInt(request.getParameter("catId")));
	json=gson.toJson(list);
	response.setContentType("text/html; charset=UTF-8");
	out.print(json);
	//out.flush();

}



	}

}
