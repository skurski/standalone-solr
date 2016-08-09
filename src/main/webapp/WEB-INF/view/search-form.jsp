<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Engine</title>
</head>

<body>
<h1>Search Engine</h1>
<p>${message}</p>
<form:form method="POST" action="search" modelAttribute="searching">
    <form:input path="keywords"/>&nbsp
    <input type="submit" value="Search"/>
</form:form>
</body>

</html>