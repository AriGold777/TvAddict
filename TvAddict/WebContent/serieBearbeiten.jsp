
<!-- @author Marcel -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Serie Bearbeiten</title>
</head>
<!-- Hier werden die aktuellen Daten zur Serie angezeigt und mit per Eingabefelder dem Mitarbeiter ermöglicht Serieninformationen zu bearbeiten -->
<body>
	Hinweis: Da Genre 2 und Genre 3 optional sind kann ein Genre auch wieder rausgenommen werden.<br>
	Dazu bitte "clear" (ohne ") in das gewünschte "Neues Genre" - Feld eingeben.<br><br>
	<form action="SerieAktualisierenServlet" method="post">
	<input type="hidden" name="aktuelleID" value="${serie.id}">
	<table>
	<tr><td><label>ID: ${serie.id}</label></td> <td>--></td> <td><label>Neue ID: </label><input type="text" name="neueID"></td></tr>
	<tr><td><label>Name: ${serie.name}</label></td> <td>--></td> <td><label>Neuer Name: </label><input type="text" name="neuerName"></td></tr>
	<tr><td><label>Beschreibung: ${serie.beschreibung}</label></td> <td>--></td> <td><label>Neue Beschreibung: </label><input type="text" name="neueBeschreibung"></td></tr>
	<tr><td><label>FSK: ${serie.fsk}</label></td> <td>--></td> <td><label>Neue FSK: </label><input type="text" name="neueFSK"></td></tr>
	<tr><td><label>Sendetag: ${serie.sendetag}</label></td> <td>--></td> <td><label>Neuer Sendetag: </label><input type="text" name="neuerSendetag"></td></tr>
	<tr><td><label>Genre 1: ${serie.genre1}</label></td> <td>--></td> <td><label>Neues Genre 1: </label><input type="text" name="neuesGenre1"></td></tr>
	<tr><td><label>Genre 2: ${serie.genre2}</label></td> <td>--></td> <td><label>Neues Genre 2: </label><input type="text" name="neuesGenre2"></td></tr>
	<tr><td><label>Genre 3: ${serie.genre3}</label></td> <td>--></td> <td><label>Neues Genre 3: </label><input type="text" name="neuesGenre3"></td></tr>
	<tr><td><button type="submit">Serie aktualisieren</button></td></tr>
	</table>
	</form>
</body>
</html>