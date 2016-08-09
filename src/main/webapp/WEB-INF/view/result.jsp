<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search Result</title>
</head>
<body>
<h1>Search Result</h1>

<c:forEach items="${result}" var="element">
    <ul>
        <li>Id: ${element.id}</li>
        <li>Name: ${element.solr_name}</li>
        <li>Code: ${element.solr_code}</li>
    </ul>
</c:forEach>
</body>
</html>
