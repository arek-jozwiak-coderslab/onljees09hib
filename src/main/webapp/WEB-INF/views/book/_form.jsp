<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:hidden path="id"/>
<form:input path="title"/><br/>
<form:errors path="title" /><br/>
<form:input path="description"/><br/>
<form:errors path="description" /><br/>
<form:select path="publisher"><br/>

    <form:options items="${publishers}" itemLabel="name" itemValue="id"/>
</form:select><br/>
<form:checkboxes path="authors" items="${authors}" itemLabel="lastName" itemValue="id"/><br/>
