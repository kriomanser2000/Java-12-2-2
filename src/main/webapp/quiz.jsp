<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        let timeLimit = 10;
        let timer;
        function startTimer(questionIndex)
        {
            let timeLeft = timeLimit;
            const timerElement = document.getElementById("timer_" + questionIndex);
            timer = setInterval(() =>
            {
                if (timeLeft > 0)
                {
                    timeLeft--;
                    timerElement.innerText = "Time left: " + timeLeft + " seconds";
                }
                else
                {
                    clearInterval(timer);
                    document.getElementById("form_" + questionIndex).submit();
                }
            }, 1000);
        }
    </script>
</head>
<body>
<h1>Answer the following questions:</h1>
<% int questionIndex = 0; %>
<c:forEach var="question" items="${questions}">
    <form id="form_<%= questionIndex %>" action="nextQuestion" method="post">
        <p>${question.text}</p>
        <input type="text" name="answer" required> <br>
        <p id="timer_<%= questionIndex %>">Time left: 10 seconds</p>
        <button type="submit">Submit</button>
    </form>
    <script>startTimer(<%= questionIndex %>);</script>
    <% questionIndex++; %>
</c:forEach>
</body>
</html>
