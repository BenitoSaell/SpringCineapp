<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/" var="urlRoot"></spring:url>
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<c:choose>
			<c:when test="${user.hasRole('editor') }">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="${urlRoot}">My CineSite | Administraci&oacute;n</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="${urlRoot}news/index">Noticias</a></li>
						<li><a href="${urlRoot}movies/index">Peliculas</a></li>
						<li><a href="${urlRoot}schedules/index">Horarios</a></li>
						<li><a href="${urlRoot}admin/logout">Cerrar sesi&oacute;n</a></li>
					</ul>
				</div>
			</c:when>
			<c:when test="${user.hasRole('gerente')}">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="${urlRoot}">My CineSite | Administraci&oacute;n</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="${urlRoot}banners/index">Banners</a></li>
						<li><a href="${urlRoot}news/index">Noticias</a></li>
						<li><a href="${urlRoot}movies/index">Peliculas</a></li>
						<li><a href="${urlRoot}schedules/index">Horarios</a></li>
						<li><a href="${urlRoot}admin/logout">Cerrar sesi&oacute;n</a></li>
					</ul>
				</div>
			</c:when>
			<c:otherwise>
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="${urlRoot}">My CineSite | Administraci&oacute;n</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="${urlRoot}about">Acerca</a></li>
						<li><a href="${urlRoot}admin/index">Login</a></li>
					</ul>
				</div>
			</c:otherwise>
		</c:choose>
		
		<!--/.nav-collapse -->
	</div>
</nav>
