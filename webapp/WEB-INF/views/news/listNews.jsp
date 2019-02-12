<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Listado de Noticias</title>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/news/create" var="urlCreate" />
<spring:url value="/news/edit" var="urlEdit" />
<spring:url value="/news/delete" var="urlDelete" />
<link href="${urlPublic }/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic }/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

	<!-- Fixed navbar -->
	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3>Listado de Noticias</h3>
		<c:if test="${message != null }">
			<div class='alert alert-success' role="alert">${message}</div>
		</c:if>

		<a href="${urlCreate}" class="btn btn-success" role="button"
			title="Nueva Pelicula">Nueva</a><br>
		<br>

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Titulo</th>
						<th>Fecha</th>
						<th>Estatus</th>
						<th>Opciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listNews}" var="news">
						<tr>
							<td>${news.id}</td>
							<td>${news.title}</td>
							<td><fmt:formatDate value="${news.date}"
									pattern="dd-MM-yyyy" /></td>
							<td><c:choose>
									<c:when test="${news.status=='Activa' }">
										<span class="label label-success">ACTIVA</span>
									</c:when>
									<c:otherwise>
										<span class="label label-danger">INACTIVA</span>
									</c:otherwise>

								</c:choose></td>
							<td><a href="${urlEdit}/${news.id}"
								class="btn btn-success btn-sm" role="button" title="Edit"><span
									class="glyphicon glyphicon-pencil"></span></a> <a
								href="${urlDelete}/${news.id}"
								onclick='return confirm("¿Estas seguro?")'
								class="btn btn-danger btn-sm" role="button" title="Eliminar"><span
									class="glyphicon glyphicon-trash"></span></a></td>

						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
		<hr class="featurette-divider">

		<!-- FOOTER -->
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
