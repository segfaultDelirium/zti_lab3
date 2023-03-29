<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="rs" dataSource="jdbc/postgres">
    SELECT fname, lname FROM public.person
</sql:query>

<html>
<head>
    <title>JSP, JNDI i JDBC</title>
</head>
<body>

<h2>Polaczenie z RBD - JSP & JSTL & JNDI & JDBC</h2>

<c:forEach var="row" items="${rs.rows}">
    ${row.fname}, ${row.lname}<br/>
</c:forEach>

</body>
</html>