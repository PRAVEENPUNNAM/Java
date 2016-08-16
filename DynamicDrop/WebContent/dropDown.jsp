<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type= "text/javascript" src = "js/countries.js"></script>
</head>
<body>
<select id="country" name ="country"></select>
Select State: <select name ="state" id ="state"></select>
 <script language="javascript">
populateCountries("country", "state");
 </script>
</body>
</html>