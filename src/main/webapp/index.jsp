<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Answer the following questions:</h1>
<form action="result" method="post">
    <c:forEach var="question" items="${questions}">
        <p>${question.text}</p>
        <c:forEach var="option" items="${question.options}">
            <input type="radio" name="question_${question.text}" value="${option}" required> ${option} <br>
        </c:forEach>
    </c:forEach>
    <button type="submit">Submit</button>
</form>
</body>
</html>