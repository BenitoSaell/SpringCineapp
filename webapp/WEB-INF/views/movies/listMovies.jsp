<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Listado de Peliculas</title>
<spring:url value="/resources" var="urlPublic" />

<spring:url value="/movies/create" var="urlForm" />
<spring:url value="/movies/edit" var="urlEdit" />
<spring:url value="/movies/delete" var="urlDelete" />
<link rel="stylesheet"
	href="${urlPublic}/bootstrap/css/bootstrap.min.css">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3>Listado de Peliculas</h3>
		<c:if test="${message != null }">
			<div class='alert alert-success' role="alert">${message}</div>
		</c:if>

		<a href="${urlForm }" class="btn btn-success" role="button"
			title="Nueva Pelicula">Nueva</a><br> <br>

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<thead>
					<tr>
						<th>Titulo</th>
						<th>Genero</th>
						<th>Clasificacion</th>
						<th>Duracion</th>
						<th>Fecha Estreno</th>
						<th>Estatus</th>
						<th>Opciones</th>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${movies}" var="movie">
				
						<tr>
							<td>${movie.title }</td>
							<td>${movie.gender }</td>
							<td>${movie.classification }</td>
							<td>${movie.duration }</td>
							<td>
								<fmt:formatDate value="${movie.releaseDate}"
									pattern="dd-MM-yyyy" />
							</td>
							<td>
								<c:choose>
									<c:when test="${movie.status=='Activa' }"> 
										<span class="label label-success">ACTIVA</span>
									</c:when>
									<c:otherwise>
										<span class="label label-danger">INACTIVA</span>
									</c:otherwise>
			
								</c:choose>
							</td>
							<td><a href="${urlEdit }/${movie.id}" class="btn btn-success btn-sm" role="button"
								title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
								<a href="${urlDelete }/${movie.id}" onclick='return confirm("¿Estas seguro?")' class="btn btn-danger btn-sm" role="button"
								title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>

		<hr class="featurette-divider">

		<jsp:include page="../includes/footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
