
<!-- @author Daniel -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="myTags" uri="/WEB-INF/lib/myTags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="styles.css" rel="stylesheet" type="text/css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Serienübersicht</title>
</head>
<body>
<div id="seite">

	<!-- Unknown tag header wegen css-Einstellungen -->
	<header>
	
		<div id="logo">
			<img src="tv.png" width="100" height="50">
		</div>
			
		<!-- Einfügen des Navigationstags -->
		<myTags:navigation activeSite="SerienUebersicht"></myTags:navigation> <br>
			
		<!-- Wenn ein Benutzer angemeldet ist wird ein Ausloggen Button angezeigt -->
		<c:if test="${isUserLogged}">
			<label style="color: white; text-align: center" ><b>Angemeldet als <%= session.getAttribute("loggedUser") %>.<br></b></label>
			<form action="AbmeldenServlet" method="post">
			<input type="submit" value="Abmelden">
			</form>
		</c:if>
		
		<!-- Formular mit Textfeld und Absende-Button für die schnelle Suche  -->
		<form action="SchnelleSuche" id="textfeld" method="get">
			<input type="text" name="name" placeholder="Name der Serie"> 
			<button type="submit"> Suchen</button>
		</form>		
						
	</header>

	<br>

	<div id="main">
	
	<h1>Serien</h1>
	
	<!-- Serienübersicht in Tabellenform mit Name, Beschreibung, FSK und Detailansicht -->
	<table border=3 align="center">
	<thead>
    <tr>
    	<td>Name</td>
    	<td>Beschreibung</td>
    	<td>FSK</td>
    	<td>Detailansicht</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${result}" var="columns">
      <tr>
        <c:forEach items="${columns}" var="column">
          <td> <c:out value="${column.value}"></c:out> </td>
        </c:forEach>
        <td>
        <!-- Link zur Detailansicht der jeweiligen Serie -->
        <a href="DetailAnsichtServlet?name=${columns.serie_name}">Serieninfo</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
	</table>
	</div>
	
	<!--  Unknown tag footer wegen css-Einstellungen --> 
	<footer>
		
		<!-- footer-navmenu -->
		<ul id="navmenu">
			<li><a href="#">Impressum</a></li>
			<li><a href="#">AGB</a></li>
			<li><a href="kontakt.jsp">Kontakt</a></li>
		</ul>
		
	</footer>
</div>
</body>
</html>