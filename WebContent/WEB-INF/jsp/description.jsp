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

		<h1> Szczegóły rozwiązania zadania</h1>
		<c:forEach var="des" items="${description}">

		<ul>
			<li>Id - ${des.id}</li>
			<li>Created - ${des.created}</li>
			<li>Updated - ${des.updated}</li>
			<li>User Id - ${des.users_id}</li>
			<li>Exercise Id - ${des.exerc_id}</li>
			<li>Solution:<br> ${des.description}</li>
			
		</ul>

	</c:forEach>


</body>
</html>