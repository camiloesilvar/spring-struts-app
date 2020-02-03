<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<c:forEach items="${sessionScope}" var="sessAttr">
		<div class="col-sm-6">
			<div class="card border-success">
				<div class="card-body">
					<h5 class="card-title">${sessAttr.key}</h5>
					<p class="card-text">${sessAttr.value}</p>
				</div>
			</div>
		</div>
	</c:forEach>
</div>