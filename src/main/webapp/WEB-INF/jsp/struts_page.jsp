<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value='/app/css/bootstrap.min.css'/>">
<link rel="stylesheet" href="<c:url value='/app/css/all.min.css'/>">

</head>
<body>
	<div class="container">
		<div>SId: [${pageContext.session.id}]</div>

		<c:set var="contextPath" value="${pageContext.request.contextPath}" />

		<div>Pagina directa</div>
		<a class="nav-link"
			href="${contextPath}/strutsapp/strutsaction/tile/getTileAction.action">struts
			(Tiles)</a>

		<div class="row">
			<c:forEach items="${sessionScope}" var="sessAttr">
			<div class="col-sm-6">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">${sessAttr.key}</h5>
						<p class="card-text">${sessAttr.value}</p>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
	<script src="<c:url value='/app/js/jquery-3.4.1.min.js'/>"></script>
	<script src="https://unpkg.com/@popperjs/core@2.0.0-rc.3"></script>
	<script src="<c:url value='/app/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/app/js/all.min.js'/>"></script>
</body>
</html>