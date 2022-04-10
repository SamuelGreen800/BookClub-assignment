<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container">
		<h1 class="p-4 text-center text-primary">Welcome, <c:out value="${user.userName}"/>!</h1>
		
		
		<div class="card">
			<div class="card-body p-4">
		
				<div class="card-title">
					<h3><span class="text-danger"><c:out value="${book.user.userName}"/></span> read 
						<span class="text-info"><c:out value="${book.title}"/></span> by 
						<span class="text-success"><c:out value="${book.author}"/></span>
					</h3>
				</div>
		
				<div class="card-text">
					<h4>Here are their thoughts:</h4>
					<hr />
			
					<p><c:out value="${book.description}"/></p>
					
		
				</div>
			</div>
			
		</div>
		
		
		
			<div class="my-2 d-flex justify-content-around">
			<a href="/dashboard" class="text-success">Dashboard</a>
			<a href="/logout" class="text-danger">logout</a>
			</div>
	</div>

		
</body>
</html>