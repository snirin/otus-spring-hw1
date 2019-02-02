package ru.otus.spring.hw1.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.hw1.entity.Exam;
import ru.otus.spring.hw1.entity.Student;
import ru.otus.spring.hw1.entity.Task;

import java.util.ArrayList;
import java.util.Set;

@Service
class ExamServiceImpl implements ExamService {
    private static final String ENTER_YOUR_NAME = "enter.your.name";
    private static final String QUESTION = "question";

    private QuestionService questionService;
    private LocalizationService localizationService;

    ExamServiceImpl(QuestionService questionService, LocalizationService localizationService) {
        this.questionService = questionService;
        this.localizationService = localizationService;
    }

    @Override
    public Exam takeExam(Set<String> questions) {
        String questionName = localizationService.getMessage(ENTER_YOUR_NAME);
        String name = questionService.ask(questionName);

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
