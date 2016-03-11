<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="styles.css" rel="stylesheet" type="text/css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ErweiterteSuche" id="textfeldE" method="get">
		<input type="text" name="name" placeholder="Name der Serie"><br>
		<input type="text" name="fsk" placeholder="Max. Altersfreigabe"><br>
<!-- 		Wird noch dynamisch gemacht, damit alle vorhandenen Genres bei Serien angezeigt werden + Dropdownmenü 
			bis jetzt kommt noch ein Fehler, wenn kein Genre ausgewählt ist. Irgendwie überwindet der "Null-String" die if
			Abfrage bei SearchObject advancedSearch, mache ich morgen ;)-->
		<select name="genre"> <%-- size="3" multiple --%>
			<option>Beliebig</option>
			<c:forEach items="${genreList}" var="genres">
				<c:forEach items="${genres}" var="genre">
					<option><c:out value="${genre.value}" /></option>
				</c:forEach>
			</c:forEach>
  		</select>
		<button type="submit" id="suche">Suchen</button>
	</form>
	
	<h3>${genre}</h3>
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
          <td><c:out value="${column.value}" /></td>
        </c:forEach>
        <td>
        <a href="DetailAnsichtServlet?name=${columns.serie_name}">Click</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
	</table>
	<%-- <table border=4>
  	<thead>
    <tr>
      <c:forEach items="${result[0]}" var="column">
        <td><c:out value="${column.key}" /></td>
      </c:forEach>
    </tr>
  	</thead>
  	<tbody>
    <c:forEach items="${result}" var="columns">
      <tr>
        <c:forEach items="${columns}" var="column">
          <td><c:out value="${column.value}" /></td>
        </c:forEach>
      </tr>
    </c:forEach>
  	</tbody>
	</table> --%>
</body>
</html>