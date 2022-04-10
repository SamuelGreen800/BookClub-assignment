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
<title>Dashboard</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<body class="mx-auto">
	<div>
		<div class="col-12 text-center p-4">
			<h1>Welcome, <c:out value="${user.userName}"></c:out>!</h1>
			<table class="table table-striped table-light  shadow p-3 mb-5 rounded">
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Author</th>
				<th>Posted By</th>
			
									
				
			</tr>
			
			<c:forEach var="eachBook" items="${books}">
			
				<tr>
					<td><c:out value="${eachBook.id}"/></td>
					<td><a href="/viewBook/<c:out value="${eachBook.id}"/>" class="text-dark"> <c:out value="${eachBook.title}"/></a> 
					<td><c:out value="${eachBook.author}"/></td>
					<td><c:out value="${eachBook.user.userName}"/></td>
					
				</tr>
			</c:forEach>
		</table>
	</div>
		<div class=" container col-12 text-center">
		<a href="/newBook" class="btn text-center btn-primary">Add a book!</a>
		</div>
			
			<p><a href="/logout" class="btn my-3 btn-primary btn-lg">logout</a></p>
	</div>

</body>
</html>