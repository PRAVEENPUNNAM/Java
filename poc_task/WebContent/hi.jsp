<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Map <String,String>data=new HashMap<String,String>();
String temp="temp";
for(int i=0;i<=12;i++)
{
	data.put("temp"+i, temp+i);
}

%>
<table>
<% 
Set<String> key=data.keySet();
for(int i=0;i<=data.size();i++){%>
<tr><td><%=data.get("temp"+i) %></td></tr>


<%} %>
</table>

</body>
</html>