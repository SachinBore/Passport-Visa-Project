<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
This is Admin page


<c:forEach items="${ulist}" var="list">

	<c:out value="${list.userId}"></c:out><br>
</c:forEach>

<c:out value="${message}"></c:out>
</body>
</html>