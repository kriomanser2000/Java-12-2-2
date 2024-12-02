<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login" method="post">
  <label for="username">Username:</label>
  <input type="text" name="username" required>
  <label for="password">Password:</label>
  <input type="password" name="password" required>
  <button type="submit">Login</button>
</form>
<c:if test="${param.error != null}">
  <p style="color: red;">${param.error}</p>
</c:if>

</body>
</html>
