<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="BenutzerAktualisierenServlet" method="post">
	<input type="hidden" name="aktuelleUserID" value="${benutzer.userID}">
	<table>
	<tr><td><label>Benutzer ID: ${benutzer.userID}</label></td> <td>--></td> <td><label>Neue Benutzer ID: </label><input type="text" name="neueUserID"></td></tr>
	<tr><td><label>Benutzername: ${benutzer.benutzername}</label></td> <td>--></td> <td><label>Neuer Benutzername: </label><input type="text" name="neuerBenutzername"></td></tr>
	<tr><td><label>Vorname: ${benutzer.vorname}</label></td> <td>--></td> <td><label>Neuer Vorname: </label><input type="text" name="neuerVorname"></td></tr>
	<tr><td><label>Nachname: ${benutzer.nachname}</label></td> <td>--></td> <td><label>Neuer Nachname: </label><input type="text" name="neuerNachname"></td></tr>
	<tr><td><label>Email: ${benutzer.email}</label></td> <td>--></td> <td><label>Neue Email: </label><input type="text" name="neueEmail"></td></tr>
	<tr><td><label>Verschlüsseltes PW: ${benutzer.verschluesseltesPW}</label></td> <td>--></td> <td><label>Neues verschlüsseltes PW: </label><input type="text" name="neuesVerschluesseltesPW"></td></tr>
	<tr><td><button type="submit">Benutzer aktualisieren</button></td></tr>
	</table>
	</form>
</body>
</html>