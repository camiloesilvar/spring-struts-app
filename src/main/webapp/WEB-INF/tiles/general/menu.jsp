<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link" href="${contextPath}/strutsapp/strutsaction/tile/getAction.action">struts (no Tiles)</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="${contextPath}/strutsapp/strutsaction/tile/getTileAction.action">struts (Tiles)</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="${contextPath}/app/springapp/springaction/tile/getTileAction">spring</a>
  </li>
  
  <li class="nav-item">
    <a class="nav-link" href="${contextPath}/app/springapp/springaction/tile/homeformulaireAction">spring formulario</a>
  </li>
  
</ul>