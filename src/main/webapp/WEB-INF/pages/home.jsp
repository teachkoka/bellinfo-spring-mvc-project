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
   <jsp:useBean id="student" class="com.springapp.mvc.Student" scope="request"/>
   Bellinfo student login here <jsp:forward page="student-login.jsp">
    <jsp:param name="student" value="student"/>
    </jsp:forward>
 </div>
</body>
</html>
