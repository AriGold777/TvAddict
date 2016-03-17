<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="myTags" uri="/WEB-INF/lib/myTags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<link href="styles.css" rel="stylesheet" type="text/css"/>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Serien</title>
</head>
<body>
<div id="seite">
	<header>
		<div id="logo">
			<img src="tv.png" width="100" height="50">
		</div>
			
			<myTags:navigation activeSite="SerienUebersicht"></myTags:navigation> <br>
			
			<c:if test="${isUserLogged}">
			<label style="color: white; text-align: center" ><b>Angemeldet als <%= session.getAttribute("loggedUser") %>.<br></b></label>
			<form action="AbmeldenServlet" method="post">
			<input type="submit" value="Abmelden">
			</form>
			
		</c:if>
			<!-- Muss neu positioniert werden -->
			<form action="SchnelleSuche" id="textfeld" method="get">
				<input type="text" name="name" placeholder="Name der Serie"> 
				<button type="submit"> Suchen</button>
			</form>		
						
	</header>
</br>

	<div id="main">
	<h1>Serien</h1>
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
        <a href="DetailAnsichtServlet?name=${columns.serie_name}">Serieninfo</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
	</table>
	</div>
	</br>
	<footer>
		<ul id="navmenu">
			<li><a href="#">Impressum</a></li>
			<li><a href="#">AGB</a></li>
			<li><a href="kontakt.jsp">Kontakt</a></li>
		</ul>
	</footer>
</div>
</body>
</html>