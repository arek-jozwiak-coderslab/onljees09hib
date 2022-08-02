<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="student" cssClass="some-class">
    <form:input path="firstName"/>
    <form:input path="lastName"/>
    <input type="submit"/>
</form:form>


<form method="post" class="form">
    <input type="text" name="firstName"/>
    <input type="text" name="lastName"/>
    <input type="submit"/>
</form>
</body>
</html>
