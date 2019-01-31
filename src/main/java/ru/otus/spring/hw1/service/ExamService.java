package ru.otus.spring.hw1.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw1.entity.Exam;
import ru.otus.spring.hw1.entity.Student;
import ru.otus.spring.hw1.entity.Task;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;

@Service
class ExamService {
    private static final String ENTER_YOUR_NAME = "enter.your.name";
    private static final String QUESTION = "question";

    private QuestionService questionService;
    private MessageSource messageSource;
    private Locale locale;

    ExamService(QuestionService questionService, MessageSource messageSource, Locale locale) {
        this.questionService = questionService;
        this.messageSource = messageSource;
        this.locale = locale;
    }

    Exam takeExam(Set<String> questions) {
        String questionName = messageSource.getMessage(ENTER_YOUR_NAME, new Object[]{}, locale);
        String name = questionService.ask(questionName);

        Exam exam = new Exam(new Student(name), new ArrayList<>());

        int n = 0;
        for (String question : questions) {
            n++;
            String questionTask = messageSource.getMessage(QUESTION, new Object[]{n, question}, locale);
            String answer = questionService.ask(questionTask);
            exam.getTasks().add(new Task(question, answer));
        }

        return exam;
    }
}
