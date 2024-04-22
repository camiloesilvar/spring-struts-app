<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


Liste Usager
<table class="table table-striped">
	<thead>
		<tr>
			<th scope="col">id</th>
			<th scope="col">nom</th>
			<th scope="col">prenom</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="usager" items="${listUsagers}" varStatus="rowstatus">
		<tr>
			<th scope="row">${usager.id}</th>
			<td>${usager.nom}</td>
			<td>${usager.prenom}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>