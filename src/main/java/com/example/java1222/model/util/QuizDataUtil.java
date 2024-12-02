package com.example.java1222.model.util;

import com.example.java1222.model.Question;
import com.example.java1222.model.QuizCategory;
import java.util.ArrayList;
import java.util.List;

public class QuizDataUtil
{
    public static List<Question> getQuestions(QuizCategory category)
    {
        List<Question> questions = new ArrayList<>();
        switch (category)
        {
            case HISTORY:
                questions.add(new Question("Who was the first President of the USA?",
                        new String[]{"George Washington", "Abraham Lincoln", "Thomas Jefferson", "John Adams"}, 0));
                questions.add(new Question("In what year did World War II end?",
                        new String[]{"1941", "1945", "1948", "1950"}, 1));
                break;
            case SPORTS:
                questions.add(new Question("Which country won the FIFA World Cup in 2018?",
                        new String[]{"Germany", "Argentina", "France", "Brazil"}, 2));
                break;
            case POP_CULTURE:
                questions.add(new Question("Who sang 'Thriller'?",
                        new String[]{"Elvis Presley", "Michael Jackson", "Prince", "Madonna"}, 1));
                break;
            case SPACE:
                questions.add(new Question("What is the largest planet in our solar system?",
                        new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 2));
                break;
        }
        return questions;
    }
}
