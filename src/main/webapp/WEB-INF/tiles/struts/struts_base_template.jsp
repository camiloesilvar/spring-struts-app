<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div><a href="<s:url value="/strutsapp/strutsaction/tile/sessionInvalidateAction.action"/>">nueva sesion</a></div>

<form id="mainForm" method="post">
	<div>Struts</div>
	<s:token />
</form>


