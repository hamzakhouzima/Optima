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
<a href="hello-servlet">Hello Servlet</a>

<form action="SaveDataServlet" method="post">
    Username: <input type="text" name="username"><br>
    First Name: <input type="text" name="firstName"><br>
    Last Name: <input type="text" name="lastName"><br>
    Email: <input type="text" name="email"><br>
    Password: <input type="password" name="password"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>