<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table style="border:solid 1px black">
	<sql:forEach var="solutions" items="${solutions} ">
	
	<tr>
	<td style="border:solid 1px black">${solutions.id}</td>
	<td style="border:solid 1px black">${solutions.created}</td>
	<td style="border:solid 1px black">${solutions.updated}</td>
	<td style="border:solid 1px black">${solutions.description}</td>
	<td style="border:solid 1px black">${solutions.exercise_id}</td>
	<td style="border:solid 1px black">${solutions.users_id}</td>
	</tr>
	</sql:forEach> 
	</table>

</body>
</html>