<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>SId: [${pageContext.session.id}]</div>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div>Pagina directa</div>
<a class="nav-link" href="${contextPath}/strutsapp/strutsaction/tile/getTileAction.action">struts (Tiles)</a>

<c:forEach items="${sessionScope}" var="sessAttr">
	<div>${sessAttr.key}-> ${sessAttr.value}</div>
</c:forEach>