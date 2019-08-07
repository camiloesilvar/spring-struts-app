<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${sessionScope}" var="sessAttr">
	<div>${sessAttr.key}-> ${sessAttr.value}</div>
</c:forEach>