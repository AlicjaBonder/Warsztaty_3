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
	<h1> Zarządzanie grupami użytkowników</h1>
	<a href="<%out.print(request.getContextPath());%>/add">Dodaj nową grupę</a>
	<table style="border:solid 1px black">
	<tr>
	<th >Nazwa działu </th>
	<th > Akcje </th>
	</tr>
	<c:forEach items="${groups}" var="gr">
	<tr>
	<td style="border:solid 1px black">${gr.name}</td> 
	<td><a href="<% out.print(request.getContextPath()); %>
	/edit?id=${gr.id}">Edytuj</a></td>
	<td ><a href="<% out.print(request.getContextPath()); %>
	/delete?id=${gr.id}&name=${gr.name}">Usuń</a></td>
	</tr>
	</c:forEach>
	</table>
	
</body>
</html>