
<!-- @author Daniel -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Benutzerbearbeitung</title>
</head>
<body>
	<!-- Formular zum bearbeiten des Benutzers in Tabellenform mittels Eingabefeldern -->
	<form action="BenutzerAktualisierenServlet" method="post">
	<input type="hidden" name="aktuelleUserID" value="${benutzer.userID}">
	<table>
	<tr><td><label>Benutzer ID: ${benutzer.userID}</label></td> <td>--></td> <td><label>Neue Benutzer ID: </label><input type="text" name="neueUserID"></td></tr>
	<tr><td><label>Benutzername: ${benutzer.benutzername}</label></td> <td>--></td> <td><label>Neuer Benutzername: </label><input type="text" name="neuerBenutzername"></td></tr>
	<tr><td><label>Vorname: ${benutzer.vorname}</label></td> <td>--></td> <td><label>Neuer Vorname: </label><input type="text" name="neuerVorname"></td></tr>
	<tr><td><label>Nachname: ${benutzer.nachname}</label></td> <td>--></td> <td><label>Neuer Nachname: </label><input type="text" name="neuerNachname"></td></tr>
	<tr><td><label>Email: ${benutzer.email}</label></td> <td>--></td> <td><label>Neue Email: </label><input type="text" name="neueEmail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="bsp@blabla.de"></td></tr>
	<tr><td><label>Verschlüsseltes PW: ${benutzer.verschluesseltesPW}</label></td> <td>--></td> <td><label>Neues verschlüsseltes PW: </label><input type="text" name="neuesVerschluesseltesPW" pattern="[A-Za-z0-9]{5,15}" title="A-Z, a-z, 0-9, min. 5, max.15 Zeichen"></td></tr>
	<tr><td><button type="submit">Benutzer aktualisieren</button></td></tr>
	</table>
	</form>
</body>
</html>