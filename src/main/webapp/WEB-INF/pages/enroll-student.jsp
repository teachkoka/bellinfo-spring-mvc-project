<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
  <title> Welcome to bellinfo</title>
</head>
${message}
<body>
<div>
<form:form action="/student/enroll" method="post" modelAttribute="enrollStudent">
  <fieldset>
    <legend>Student Enrollment</legend>
    <form:label path="name">
      Name <form:errors path="name" cssStyle="color: red"/>
    </form:label>
    <form:input path="name"/><br>
    <form:label path="email">
      Email <form:errors path="email" cssStyle="color: red"/>
    </form:label>
    <form:input path="email"/><br>
    <form:label path="password">
      Password <form:errors path="password" cssStyle="color: red"/>
    </form:label>
    <form:input path="password"/><br>
    <form:label path="technology">
      Technology <form:errors path="technology" cssStyle="color: red"/>
    </form:label>
    <form:input path="technology"/><br>
  </fieldset>
  <button type="submit">submit</button>
  </form:form>
</div>
</body>
</html>
