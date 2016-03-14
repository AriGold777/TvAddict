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
	<c:choose>
		<c:when test="${abfrage=='7'}">
			Anmeldung erfolgreich!<br>
			<b>Hallo Mitarbeiter ${benutzer}</b><br><br>
			Weiterleitung zur Mitarbeiterseite...
			<%
				response.setHeader("Refresh", "3; URL=http://localhost:8080/TvAddict/MitarbeiterFunktionenServlet");
			%>
		</c:when>
		<c:when test="${abfrage=='1'}">
			Anmeldung erfolgreich!<br>
			<b>Hallo ${benutzer}</b><br><br>
			Weiterleitung...
			<%
				response.setHeader("Refresh", "3; URL=http://localhost:8080/TvAddict/MeinProfilServlet");
			%>
		</c:when>
		<c:otherwise>
			Benutzerdaten nicht korrekt!<br>
			Weiterleitung...
			<%
				response.setHeader("Refresh", "2; URL=http://localhost:8080/TvAddict/Anmelden.jsp");
			%>
		</c:otherwise>
	</c:choose>
</body>
</html>