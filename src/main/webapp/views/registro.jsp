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
<link href="${pageContext.request.contextPath}/css/styles.css"
	rel="stylesheet">
</head>
<body class="bg-dark text-light">
	<nav class="navbar navbar-dark bg-dark">
		<form class="container" method="get">
			<a class="navbar-brand text-center" href="#">StartUp <i
				class="fa-solid fa-rocket"></i></a>
		</form>
	</nav>
	
	<c:if test="${not empty sessionScope.message}">
		<div class="alert ${fn:contains(sessionScope.message, 'ERROR') ? 'alert-danger' : 'alert-success'} mt-3">${sessionScope.message}</div>
		<c:remove var="message" scope="session"/>
	</c:if>

	<div class="container">
		<h2 class="text-center pb-2">Registro de Usuario</h2>
		<form name="formulario" class="form" method="post"
			action="${pageContext.request.contextPath}/user?action=create">
			<div class="row mb-3 d-flex justify-content-center">
				<div class="col-md-6">
					<div class="mb-3">
						<label for="email" class="form-label">Correo</label> <input
							type="email" class="form-control bg-dark text-light" id="email"
							name="email" required
							title="Debe ser un correo electrónico válido" value="${email}">
					</div>
					<div class="mb-3">
						<label for="nick" class="form-label">Nick</label> <input
							type="text" class="form-control bg-dark text-light" id="nick"
							name="nick" required pattern="[A-Za-z0-9]+"
							title="Debe contener solo letras y números" value="${nick}">
					</div>
					<div class="mb-3">
						<label for="username" class="form-label">Nombre</label> <input
							type="text" class="form-control bg-dark text-light" id="username"
							name="username" required pattern="[A-Za-z0-9\s]+"
							title="Debe contener solo letras, números y espacios"
							value="${username}">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password </label> <input
							type="password" class="form-control bg-dark text-light"
							id="password" name="password" required value="${password}">
					</div>
					<div class="mb-3">
						<label for="weight" class="form-label">Peso</label> <input
							type="text" class="form-control bg-dark text-light" id="weight"
							name="weight" required pattern="[0-9]+"
							title="Debe contener solo números" value="${weight}">
					</div>
					<div class="mb-3 text-center pt-2">
						<a href="${pageContext.request.contextPath}/"
							class="btn btn-secondary me-3">Cancelar</a>
						<button type="submit" class="btn btn-primary">Guardar</button>
					</div>
				</div>
			</div>
		</form>
	</div>

</body>
</html>