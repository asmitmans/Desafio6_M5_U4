<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StartUp</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer">
<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
</head>
<body class="bg-dark text-light">
	<nav class="navbar navbar-dark bg-dark">
		<form class="container" method="get">
			<a class="navbar-brand text-center" href="#">StartUp <i
				class="fa-solid fa-rocket"></i></a>
			<div class="d-flex justify-content-end">
				<a href="${pageContext.request.contextPath}/user?view=login" class="btn btn-success me-2" role="button">Login</a>
            	<a href="${pageContext.request.contextPath}/user?view=create" class="btn btn-secondary" role="button">Register</a>
			</div>
		</form>
	</nav>
	
	<c:if test="${not empty sessionScope.message}">
		<div class="alert ${fn:contains(sessionScope.message, 'ERROR') ? 'alert-danger' : 'alert-success'} mt-3">${sessionScope.message}</div>
		<c:remove var="message" scope="session"/>
	</c:if>
	
	<div class="container vertical-center">
		<div class="text-center">
			<h1 class="display-1">Bienvenido</h1>
			<h2 class="display-5">StartUp: innovacion y tecnologia</h2>
		</div>
	</div>

</body>
</html>