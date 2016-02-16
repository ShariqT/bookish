<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>404</title>
<%@ include file="components/assets.jsp" %>
</head>
<body>
<%@ include file="components/main_menu.jsp" %>
<div class="container">
	<h1>Page Not Found!</h1>
	<p>Return to the <a href="${pageContext.request.contextPath}/">homepage</a></p>
</div>

</body>
</html>