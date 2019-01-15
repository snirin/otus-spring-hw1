package ru.otus.spring.hw1.service;

import ru.otus.spring.hw1.entity.Exam;
import ru.otus.spring.hw1.entity.Student;
import ru.otus.spring.hw1.entity.Task;

import java.util.ArrayList;
import java.util.Set;

public class ExamServiceImpl implements ExamService {
    public static final String ENTER_YOUR_NAME = "Enter your name: ";
    private QuestionService questionService;

    ExamServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Exam takeExam(Set<String> questions) {
        String name = questionService.ask(ENTER_YOUR_NAME);

        Exam exam = new Exam(new Student(name), new ArrayList<>());

        int n = 0;
        for (String question : questions) {
            n++;
            String answer = questionService.ask("Question " + n + ") " + question);
            exam.getTasks().add(new Task(question, answer));
        }

        return exam;
    }
}
