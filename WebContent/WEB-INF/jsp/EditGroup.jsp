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
	<h1>Edytuj grupę</h1>
	<form action="edit" method="post">
	Nazwa działu: <br>
	<input style="border:solid 1px black" type="text" name=nameGr>
	<input type="hidden" name="id" value="${id}">
	<input type="submit" value="zapisz">
	</form>
</body>
</html>