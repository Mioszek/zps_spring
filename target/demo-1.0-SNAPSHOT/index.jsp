<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="hello-servlet" method="get" target="_blank">
    <label for="firstNumber">First number: </label>
    <input type ="text" id="firstNumber" name ="x"><br><br>
    <label for="secondNumber">Second number: </label>
    <input type ="text" id="secondNumber" name ="y"><br><br>
    <input type = "submit" value="Submit">
</form>
<%--<a href="hello-servlet?x=10&y=20">Hello Servlet</a>--%>

</body>
</html>