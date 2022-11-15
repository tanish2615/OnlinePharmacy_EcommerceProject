<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>\
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost/core"  user="root" password=""/>
<sql:query dataSource="${db}"   var="rs">
select * from entry;
</sql:query>
<table border="3" align="center" cellpadding="5px" cellspacing="0px">
<tr>
<th> Customer Name</th>
<th> Customer Password</th>
<th> Customer Email</th>
<th> Customer Address</th>
<th> Customer Mobile No.</th>
</tr>
<tr>
<c:forEach var="table" items="${rs.rows}">
</tr>
<tr>

<td><c:out value="${table.name}"/></td>
<td><c:out value="${table.pass}"/></td>
<td><c:out value="${table.email}"/></td>
<td><c:out value="${table.address}"/></td>
<td><c:out value="${table.mobno}"/></td>

</tr>

</c:forEach>
</table>
</body>
</html>