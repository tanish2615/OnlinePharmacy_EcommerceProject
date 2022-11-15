<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#3cdfff">

<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost/core"  user="root" password=""/>
<sql:query dataSource="${db}"   var="rs">
select * from bookorder;
</sql:query>
<table border="2" align="center" cellpadding="5px" cellspacing="0px">
<tr>

<th> Product Name</th>
<th> Product Quantity</th>
<th> Customer Email</th>
<th> Customer Address</th>

</tr>
<tr>
<c:forEach var="table" items="${rs.rows}">
</tr>
<tr>

<td><c:out value="${table.p_name}"/></td>
<td><c:out value="${table.p_qty}"/></td>
<td><c:out value="${table.p_email}"/></td>
<td><c:out value="${table.p_address}"/></td>


</tr>

</c:forEach>
</table>
</body>
</html>