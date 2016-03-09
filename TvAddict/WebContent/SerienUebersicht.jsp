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
<div id="seite">
	<header>
		<div id="logo">
			<img src="tv.png" width="100" height="50">
		</div>
		<nav id="navig">
			<ul>
				<li><a href="index">Startseite</a></li>
				<li><a href="SerienUebersicht">Serien</a></li>
				<li><a href="Anmelden.jsp">Mein Profil</a></li>
				<li><a href="kontakt.jsp">Kontakt</a></li>
			</ul>
						
				<form action="Testsuche" id="textfeld" method="post">
				<input type="text" name="name" placeholder="Name der Serie"> 
				<button type="submit"> Suchen</button>
				</form>
		</nav>			
	</header>
</br>
	<div id="main">
	<h1>Serien</h1>
	<table border=3>
	<thead>
    <tr>
    	<td>Name</td>
    	<td>Beschreibung</td>
    	<td>FSK</td>
    	<td>Link</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${result}" var="columns">
      <tr>
        <c:forEach items="${columns}" var="column">
          <td> <c:out value="${column.value}"></c:out> </td>
        </c:forEach>
        <td>
        <a href="DetailAnsichtServlet?name=${columns.serie_name}">Click</a>
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
<%-- Here should be the link to a servlet with an parameter of the     name, so I know what tvshow was clicked, so I can display its detailview properly. something like
<a href="DetailAnsichtServlet?name=${columns[0].value">Click</a>
but it doesnt work. --%>