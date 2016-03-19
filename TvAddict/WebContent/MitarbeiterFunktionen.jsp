
<!-- @author Marcel -->

<%@page import="java.util.Enumeration"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mitarbeiter Funktionen</title>
</head>
<body>
	<!-- Abfrage ob der Benutzer Mitarbeiter ist um die Funktionen zu nutzen -->
	<c:if test="${isMitarbeiter == true}">
	<div align="center">
	<a href="http://localhost:8080/TvAddict/">Zurück auf die Hauptseite</a><br><br>
	<label style="text-align: center" ><b>Angemeldet als <%= session.getAttribute("loggedUser") %>.<br></b></label>
	<form action="AbmeldenServlet" method="post">
		<input type="submit" value="Abmelden">
	</form>
	<!-- Benutzerübersichttabelle -->
	<h1>Benutzerübersicht</h1> <label style="size: 10px;">(Mitarbeiter ausgeschlossen)</label>
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
    <!-- Jeder Benutzer wird ausgegeben -->
	<c:forEach items="${BenutzerList}" var="benutzer">
		<tr>
		<td><c:out value="${benutzer.userID}" /></td>
		<td><c:out value="${benutzer.benutzername}" /></td>
		<td><c:out value="${benutzer.vorname}" /></td>
		<td><c:out value="${benutzer.nachname}" /></td>
		<td><c:out value="${benutzer.email}" /></td>
		<td><c:out value="${benutzer.verschluesseltesPW}" /></td>
		<td>
		<!-- Parameter werden als hidden für das Servlet zur Verfügung gestellt -->
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
	<br><br>
	<!-- Serienübersicht nach dem gleichen Prinzip wie bei der Benutzerübersicht -->
	<h1>Serienübersicht</h1><br>
	<table border=3>
	<thead>
    <tr>
    	<td>ID</td>
    	<td>Name</td>
    	<td>Beschreibung</td>
    	<td>FSK</td>
    	<td>Sendetag</td>
    	<td>Genre 1</td>
    	<td>Genre 2</td>
    	<td>Genre 3</td>
    	<td>Bearbeiten</td>
    	<td>Löschen</td>
    </tr>
    </thead>
    <tbody>
	<c:forEach items="${SerieList}" var="serie">
		<tr>
		<td><c:out value="${serie.id}" /></td>
		<td><c:out value="${serie.name}" /></td>
		<td><c:out value="${serie.beschreibung}" /></td>
		<td><c:out value="${serie.fsk}" /></td>
		<td><c:out value="${serie.sendetag}" /></td>
		<td><c:out value="${serie.genre1}" /></td>
		<td><c:out value="${serie.genre2}" /></td>
		<td><c:out value="${serie.genre3}" /></td>
		<td>
		<form action="SerieBearbeitenServlet" method="post">
			<input type="SUBMIT" name="bearbeiten" value="Bearbeiten">
			<input type="hidden" name="id" value="${serie.id}">
			<input type="hidden" name="name" value="${serie.name}">
			<input type="hidden" name="beschreibung" value="${serie.beschreibung}">
			<input type="hidden" name="fsk" value="${serie.fsk}">
			<input type="hidden" name="sendetag" value="${serie.sendetag}">
			<input type="hidden" name="genre1" value="${serie.genre1}">
			<input type="hidden" name="genre2" value="${serie.genre2}">
			<input type="hidden" name="genre3" value="${serie.genre3}">
		</form>
		</td>
		<td>
		<form action="SerieLoeschenServlet" method="post">
			<input type="SUBMIT" name="löschen" value="Löschen">
			<input type="hidden" name="id" value="${serie.id}">
		</form>
		</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<!-- Neue Serien können angelegt werden indem die Parameter an das SerieAnlegenServlet gesendet werden -->
	<h1>Neue Serie anlegen</h1><br>
		<form action="SerieAnlegenServlet" method="post">
			<Label>Name: </Label>
			<input type="text" name="name" value="${serie.name}" required="required"><br>
			<Label>Beschreibung: </Label>
			<input type="text" name="beschreibung" value="${serie.beschreibung}" required="required"><br>
			<Label>FSK: </Label>
			<input type="text" name="fsk" value="${serie.fsk}" required="required"><br>
			<Label>Sendetag: </Label>
			<input type="text" name="sendetag" value="${serie.sendetag}" required="required"><br>
			<Label>Genre 1: </Label>
			<input type="text" name="genre1" value="${serie.genre1}" required="required"><br>
			<Label>Genre 2: </Label>
			<input type="text" name="genre2" value="${serie.genre2}"><br>
			<Label>Genre 3: </Label>
			<input type="text" name="genre3" value="${serie.genre3}"><br>
			<input type="SUBMIT" name="anlegen" value="Anlegen!">
		</form>
	</div>
	</c:if>
	<!-- Wenn ein Benutzer versucht auf die Seite zuzugreifen, und kein Mitarbeiter ist wird der Zugriff verweigert und er wird weitergeleitet -->
	<c:if test="${isMitarbeiter == false}">
		Zugriff verweigert!
		<%
			response.setHeader("Refresh", "3; URL=http://localhost:8080/TvAddict/");
		%>
	</c:if>
</body>
</html>