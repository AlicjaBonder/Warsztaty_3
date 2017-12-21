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
	<jsp:include page="header.jsp"/>
	
	
	<h1> Ostatnie rozwiązania</h1>
	<table style="border:solid 1px black">
	<tr>
	<th style="border:solid 1px black">ID zadania</th>
	<th style="border:solid 1px black"> ID Autora </th>
	<th style="border:solid 1px black"> Data dodania </th>
	<th style="border:solid 1px black">Szczegóły </th>
	
	</tr>
	
	<c:forEach items="${solutions}" var="solution">
	<tr>
	<td style="border:solid 1px black">${solution.exerc_id}</td> 
	<td style="border:solid 1px black">${solution.users_id}</td>
	<td style="border:solid 1px black">${solution.created}</td>
	<td  style="border:solid 1px black"><a href="<% out.print(request.getContextPath()); %>
	/details?id=${solution.id}">Szczegóły</a></td>

	</tr>
	</c:forEach> 
	</table>

</body>
</html>
<%@	include	file="footer.jsp"	%>