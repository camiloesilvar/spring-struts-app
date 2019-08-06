<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

        <h3>Detalles</h3>
        Formulario basico sin utilizar los tags spring
        <form method="POST" name="formulaire" action="${contextPath}/app/springapp/springaction/tile/postformulaire">
             <table>
                <tr>
                    <td><label>Name</label></td>
                    <td><input name="name"/></td>
                </tr>
                <tr>
                    <td><label >Id</label></td>
                    <td><input name="id"/></td>
                </tr>
                <tr>
                    <td><label >
                      Contact Number</label></td>
                    <td><input name="contactNumber"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
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