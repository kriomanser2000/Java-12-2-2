<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Select a Category</h1>
<form action="quiz" method="post">
    <c:forEach var="category" items="${categories}">
        <input type="radio" name="category" value="${category}" required> ${category} <br>
    </c:forEach>
    <button type="submit">Start Quiz</button>
</form>
</body>
</html>
