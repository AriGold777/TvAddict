<%@page import="java.util.Enumeration"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<table border=3>
	<thead>
    <tr>
    	<td>ID</td>
    	<td>Benutzername</td>
    	<td>Vorname</td>
    	<td>Nachname</td>
    	<td>Email</td>
    	<td>Verschl. PW</td>
    	<td>Bearbeiten</td>
    	<td>Löschen</td>
    </tr>
    </thead>
    <tbody>
	<c:forEach items="${BenutzerList}" var="benutzer">
		<tr>
		<td><c:out value="${benutzer.userID}" /></td>
		<td><c:out value="${benutzer.benutzername}" /></td>
		<td><c:out value="${benutzer.vorname}" /></td>
		<td><c:out value="${benutzer.nachname}" /></td>
		<td><c:out value="${benutzer.email}" /></td>
		<td><c:out value="${benutzer.verschluesseltesPW}" /></td>
		<td>
		<form action="BenutzerBearbeitenServlet" method="post">
			<input type="SUBMIT" name="bearbeiten" value="Bearbeiten">
			<input type="hidden" name="userID" value="${benutzer.userID}">
			<input type="hidden" name="benutzername" value="${benutzer.benutzername}">
			<input type="hidden" name="vorname" value="${benutzer.vorname}">
			<input type="hidden" name="nachname" value="${benutzer.nachname}">
			<input type="hidden" name="email" value="${benutzer.email}">
			<input type="hidden" name="verschluesseltesPW" value="${benutzer.verschluesseltesPW}">
		</form>
		</td>
		<td>
		<form action="BenutzerLoeschenServlet" method="post">
			<input type="SUBMIT" name="löschen" value="Löschen">
			<input type="hidden" name="userID" value="${benutzer.userID}">
		</form>
		</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<%
// 		Enumeration ParamNames = request.getParameterNames();
// 		while(ParamNames.hasMoreElements()) {
// 			String paramName = (String)ParamNames.nextElement();
// 			out.print(paramName+"<br>"+request.getParameter(paramName)+"<br>");
// 		}
	%>
	</div>
</body>
</html>