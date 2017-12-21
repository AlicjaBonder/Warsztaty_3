<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
<td> <a href="<% out.print(request.getContextPath()); %>
	/main">Strona główna</a></td>
<td><a href="<% out.print(request.getContextPath()); %>
	/showgroups"> Grupy</td>
<td><a href="<% out.print(request.getContextPath()); %>
	/admin"> Panel administratora</td>
</tr>

</table>

</body>
</html>