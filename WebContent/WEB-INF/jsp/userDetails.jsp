<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Szczegóły użytkownika ${user.username}</h1>
	
	Nazwa: ${user.username}
	Email: ${user.email}
	
	Dodane rozwiązania zadań:
	<table style="border:solid 1px black">
	<tr>
	<th style="border:solid 1px black"> Tytuł zadania </th>
	<th style="border:solid 1px black"> Data dodania </th>
	<th style="border:solid 1px black"> Szczegóły </th>
	</tr>
	
	<c:forEach items= "${solutions}"  var="sol"  >
	<tr>
	<td style="border:solid 1px black">${sol.exerc_id}</td>
	<td style="border:solid 1px black">${sol.created}</td>
	<td style="border:solid 1px black"><a href="<% out.print(request.getContextPath()); %>
	/details?id=${sol.id}">Szczegóły</a></td>
	</c:forEach> 
	</table>

</body>
</html>