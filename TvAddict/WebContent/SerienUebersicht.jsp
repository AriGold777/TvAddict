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
</body>
</html>
<%-- Here should be the link to a servlet with an parameter of the     name, so I know what tvshow was clicked, so I can display its detailview properly. something like
<a href="DetailAnsichtServlet?name=${columns[0].value">Click</a>
but it doesnt work. --%>