package ru.otus.spring.hw1.service;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.stereotype.Service;
import ru.otus.spring.hw1.entity.Exam;
import ru.otus.spring.hw1.entity.Student;
import ru.otus.spring.hw1.entity.Task;

@Service
class ExamServiceImpl implements ExamService {
    private static final String QUESTION = "question";

    private QuestionService questionService;
    private LocalizationService localizationService;

    ExamServiceImpl(QuestionService questionService, LocalizationService localizationService) {
        this.questionService = questionService;
        this.localizationService = localizationService;
    }

    @Override
    public Exam takeExam(String name, Set<String> questions) {
        Exam exam = new Exam(new Student(name), new ArrayList<>());

        int n = 0;
        for (String question : questions) {
            n++;
            String questionTask = localizationService.getMessage(QUESTION, new Object[]{n, question});
            String answer = questionService.ask(questionTask);
            exam.getTasks().add(new Task(question, answer));
        }

        return exam;
    }
}
