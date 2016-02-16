<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div>

  <div class="container">
    <table class="table table-hover table-bordered table-responsive">
      <thead>
      <tr>
        <th>id</th>
        <th>Name</th>
        <th>Email</th>
      </tr>
      </thead>
      <tbody>
  <c:forEach var="student" items="${list}">
      <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.email}</td>
        <td>
          <a href ="/student/edit/${student.id}">Edit</a><br/>
          <a href="/student/delete/${student.id}">Delete</a><br/>
        </td>
      </tr>
  </c:forEach>
      </tbody>
    </table>
  </div>








</div>
</body>
</html>
