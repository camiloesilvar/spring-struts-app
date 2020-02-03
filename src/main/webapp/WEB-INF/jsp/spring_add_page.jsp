<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<h4>Formulario basico sin utilizar los tags spring</h4>
<form method="POST" name="formulaire"
	action="<spring:url value='/app/springapp/springaction/tile/postformulaire'/>">
	<div class="form-group">
		<input name="id" class="form-control" placeholder="Id" />
	</div>
	<div class="form-group">
		<input name="name" class="form-control" placeholder="Name" />
	</div>
	<div class="form-group">
		<input name="contactNumber" class="form-control" placeholder="Contact Number" />
	</div>
	<button type="submit" class="btn btn-primary">Sign in</button>
</form>
<div class="row">
	<div class="col">Name</div>
	<div class="col">${name}</div>
	<div class="w-100"></div>
	<div class="col">Id</div>
	<div class="col">${id}</div>
	<div class="w-100"></div>
	<div class="col">Contact Number</div>
	<div class="col">${contactNumber}</div>
</div>