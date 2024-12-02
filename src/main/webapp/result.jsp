<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Your Quiz Results</h1>
<p>Correct answers: ${correctAnswers}</p>
<p>Incorrect answers: ${incorrectAnswers}</p>
<p>Total time: ${totalQuizTime} seconds</p>
<p>Average time per question: ${averageTime} seconds</p>
<h2>Review:</h2>
<c:forEach var="question" items="${questions}">
    <p>Question: ${question.text}</p>
    <p>Correct Answer: ${question.options[question.correctAnswerIndex]}</p>
</c:forEach>
</body>
</html>
