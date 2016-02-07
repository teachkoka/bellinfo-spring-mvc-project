<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title> Welcome to bellinfo</title>
</head>
<body>
  <div>
     student page
    <form:form action="/student" method="post" modelAttribute="student">
       Student Name: <form:input path="name"/>
       <div>
         <form:errors path="name" cssStyle="color: red"/>
       </div>
        <button type="submit">submit</button>
    </form:form>
  </div>
</body>
</html>
