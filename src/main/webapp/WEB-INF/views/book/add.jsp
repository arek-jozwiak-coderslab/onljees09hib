<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="book" cssClass="some-class">
    <form:hidden path="id"/>
    <form:input path="title"/>
    <form:input path="description"/>
    <form:select path="publisher">
        <form:options items="${publishers}" itemLabel="name" itemValue="id"/>
    </form:select>
    <input type="submit"/>
</form:form>

</body>
</html>
