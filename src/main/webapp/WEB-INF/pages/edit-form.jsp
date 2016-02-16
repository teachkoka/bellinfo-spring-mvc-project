<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title> Welcome to bellinfo</title>
</head>
<body>
<form:form action="/student/edit/${studentShow.id}" method="post" modelAttribute="studentShow">
    <fieldset>
        <legend>Edit Enrollment</legend>

        <form:label path="id">
            Id <form:errors path="id" cssStyle="color: red"/>
        </form:label>
        <form:input readonly="true" path="id"/><br>

        <form:label path="name">
            Name <form:errors path="name" cssStyle="color: red"/>
        </form:label>
        <form:input path="name"/><br>

        <form:label path="email">
            Email <form:errors path="email" cssStyle="color: red"/>
        </form:label>
        <form:input path="email"/><br>
    </fieldset>
    <button type="submit">submit</button>
</form:form>

</body>
</html>
