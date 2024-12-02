package com.example.java1222.model.servlet;

import com.example.java1222.model.Question;
import com.example.java1222.model.QuizCategory;
import com.example.java1222.model.util.QuizDataUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;
    private long totalQuizTime = 0;
    private long startTime;
    @Override
    public void init() throws ServletException
    {
        questions = QuizDataUtil.getQuestions(QuizCategory.HISTORY);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String userAnswer = request.getParameter("answer");
        Question currentQuestion = questions.get(currentQuestionIndex);
        if (currentQuestion.getOptions() == null)
        {
            if (userAnswer != null && userAnswer.equalsIgnoreCase(currentQuestion.getOptions()[currentQuestion.getCorrectAnswerIndex()])) {
                correctAnswers++;
            }
            else
            {
                incorrectAnswers++;
            }
        }
        else
        {
            if (userAnswer != null && userAnswer.equals(currentQuestion.getOptions()[currentQuestion.getCorrectAnswerIndex()])) {
                correctAnswers++;
            }
            else
            {
                incorrectAnswers++;
            }
        }
        long endTime = System.currentTimeMillis();
        totalQuizTime += (endTime - startTime);
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size())
        {
            startTime = System.currentTimeMillis();
            request.setAttribute("questions", List.of(questions.get(currentQuestionIndex)));
            request.getRequestDispatcher("/quiz.jsp").forward(request, response);
        }
        else
        {
            long averageTimePerQuestion = totalQuizTime / questions.size();
            request.setAttribute("correctAnswers", correctAnswers);
            request.setAttribute("incorrectAnswers", incorrectAnswers);
            request.setAttribute("totalQuizTime", totalQuizTime / 1000);
            request.setAttribute("averageTime", averageTimePerQuestion / 1000);
            request.setAttribute("questions", questions);
            request.getRequestDispatcher("/results.jsp").forward(request, response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String categoryParam = request.getParameter("category");
        if (categoryParam != null)
        {
            QuizCategory category = QuizCategory.valueOf(categoryParam);
            questions = QuizDataUtil.getQuestions(category);
        }
        currentQuestionIndex = 0;
        correctAnswers = 0;
        incorrectAnswers = 0;
        totalQuizTime = 0;
        startTime = System.currentTimeMillis();
        request.setAttribute("questions", List.of(questions.get(currentQuestionIndex)));
        request.getRequestDispatcher("/quiz.jsp").forward(request, response);
    }
}
