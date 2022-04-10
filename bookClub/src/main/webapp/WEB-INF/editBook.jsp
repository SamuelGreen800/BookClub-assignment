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
<div class="container col-5 mx-aut border border-secondary  shadow-lg p-3 mb-5 rounded p-4 bg-light">

	<h1 class="text-center fw-bold text-primary">Edit your book:</h1>
	<form:form action = "/editBook/${book.id}" method = "post" class="form" modelAttribute="book">
		<input type="hidden" name="_method" value="put"/>
	
	<div class="form-row">
				<form:errors path="user" class="error"/>
				<form:input type="hidden" path="user" value="${user.id}" class="form-control"/>
			</div>
	
	<div class = "form-group d-flex flex-column">
		<form:label path="title">Title:</form:label>
		<form:errors path="title" class="text-warning"/>
		<form:input path="title"/>
	</div>
	
	<div class = "form-group d-flex flex-column">
		<form:label path="author">Author:</form:label>
		<form:errors class="text-warning" path="author"/>
		<form:input path="author"/>
	</div>
	
	<div class = "form-group d-flex flex-column">
		<form:label path="description">Description:</form:label>
		<form:errors class="text-warning" path="description"/>
		<form:textarea path="description"/>
	</div>
	
	
	<div class = "form-group d-flex justify-content-end">
		<input type ="submit" class="btn my-4 mr-auto shadow-lg btn-primary" value ="Submit">
		</div>
	</form:form>
	
	<form action="/delete/<c:out value ="${book.id}"/>" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete" class=" btn btn-sm btn-danger">
					</form>

</div>

</body>
</html>