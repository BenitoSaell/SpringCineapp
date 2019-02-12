<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Creacion de imagenes del Banner</title>

<spring:url value="/resources" var="urlPublic" />
<spring:url value="/banners/save" var="urlForm" />
<link rel="stylesheet"
	href="${urlPublic}/bootstrap/css/bootstrap.min.css">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

	<jsp:include page="../includes/menu.jsp" />

	<div class="container theme-showcase" role="main">

		<h3 class="blog-title">
			<span class="label label-success">Datos de la imagen</span>
		</h3>
		
		<spring:hasBindErrors name="banner">
			<div class='alert alert-danger' role='alert'>
				Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>

		<form:form action="${urlForm}" method="post" enctype="multipart/form-data" modelAttribute="banner">
			<c:if test="${banner.file!=null}">
				<div class="row">
					<div class="col-sm-3">
						<div class="form-group">
							<img class="img-rounded" src="${urlPublic}/images/${banner.file}"
								title="Imagen actual del banner" width="450" height="200">
						</div>
	
					</div>
				</div>
			</c:if>
			
			<div class="row">
				
				<div class="col-sm-6">
					<div class="form-group">
						<label for="title">Titulo</label> 
						<form:hidden path="id"/>
						<form:input type="text"
							class="form-control" path="title" id="title"
							required="required" />
					</div>
				</div>


				<div class="col-sm-3">
					<div class="form-group">
						<label for="fileImage">Imagen</label> <input type="file"
							id="fileImage" name="fileImage" required="required" />
						<p class="help-block">Tamaño recomendado: 1140 x 250</p>
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<label for="status">Estatus</label> 
						<form:select id="status" path="status" class="form-control">
							<form:option value="Activo">Activo</form:option>
							<form:option value="Inactivo">Inactivo</form:option>
						</form:select>
					</div>
				</div>
			</div>

			<form:button type="submit" class="btn btn-danger">Guardar</form:button>
		</form:form>

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
