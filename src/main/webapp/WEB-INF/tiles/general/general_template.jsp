<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<spring:url value='/app/css/bootstrap.min.css'/>">
<link rel="stylesheet" href="<spring:url value='/app/css/all.min.css'/>">
</head>
<body>
	<div class="container">
		<div>
			<tiles:insertAttribute name="header" />
		</div>
		<div>
			<tiles:insertAttribute name="menu" />
		</div>
		<div>
			<tiles:insertAttribute name="framework" />
		</div>
		<div>
			<tiles:insertAttribute name="body" />
		</div>
		<div>
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	
	<script src="<spring:url value='/app/js/jquery-3.4.1.min.js'/>"></script>
	<script src="https://unpkg.com/@popperjs/core@2.0.0-rc.3"></script>
	<script src="<spring:url value='/app/js/bootstrap.min.js'/>"></script>
	<script src="<spring:url value='/app/js/all.min.js'/>"></script>
</body>
</html>