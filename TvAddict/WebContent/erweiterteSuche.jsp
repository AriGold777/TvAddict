<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="myTags" uri="/WEB-INF/lib/myTags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="styles.css" rel="stylesheet" type="text/css"/>
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
			
			<myTags:navigation activeSite="ErweiterteSuche"></myTags:navigation>
	
				<div id="beideSuchen">	
				<form action="SchnelleSuche" id="textfeld" method="get">
					<input type="text" name="name" placeholder="Name der Serie"> 
					<button type="submit">Suchen</button>
				</form>
				</div>
		</nav>			
	</header>
	</br>
    <div id="main">
	<form action="ErweiterteSuche" id="textfeldE" method="get">
		<input type="text" name="name" placeholder="Name der Serie"><br>
		<input type="text" name="fsk" placeholder="Max. Altersfreigabe"><br>
		<b><label style="color: white">Genre:</label></b><br>
		<select name="genre">
			<option>Beliebig</option>
			<c:forEach items="${genreList}" var="genres">
				<c:forEach items="${genres}" var="genre">
					<option><c:out value="${genre.value}" /></option>
				</c:forEach>
			</c:forEach>
  		</select>
		<button type="submit" id="suche">Suchen</button>
	</form>
	
	<b><h3 style="color: white">${genre}</h3></b>
	<table border=3>
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
          <td><c:out value="${column.value}" /></td>
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