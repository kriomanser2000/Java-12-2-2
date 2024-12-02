<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="theme" method="post">
    <c:forEach var="theme" items="${themes}">
        <input type="radio" name="theme" value="${theme}" ${sessionScope.theme == theme ? "checked" : ""}>
        ${theme}
    </c:forEach>
    <button type="submit">Apply Theme</button>
</form>
</body>
</html>
