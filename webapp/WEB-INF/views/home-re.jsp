<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a CineApp</title>
<spring:url value="/resources" var="urlPublic" />
<link rel="stylesheet"
	href="${urlPublic}/bootstrap/css/bootstrap.min.css">

</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">Lista de peliculas</div>
		<div class="panel-body">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Titulo</th>
						<th>Duracion</th>
						<th>Clasificacion</th>
						<th>Genero</th>
						<th>Imagen</th>
						<th>Fecha de estreno</th>
						<th>Estatus</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${movies}" var="movie">
						<tr>
							<td>${movie.id }</td>
							<td>${movie.title}</td>
							<td>${movie.duration }</td>
							<td>${movie.classification }</td>
							<td>${movie.gender }</td>
							<td><img src="${urlPublic}/images/${movie.image}" width="80"
								height="100"></td>
							<td><fmt:formatDate value="${movie.releaseDate}"
									pattern="dd-MM-yyyy" /></td>
							<td><c:choose>
									<c:when test="${movie.status=='Activa'}">
										<span class="label label-success">ACTIVA</span>
									</c:when>
									<c:otherwise>
										<span class="label label-danger">INACTIVA</span>
									</c:otherwise>

								</c:choose></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>