package ru.otus.spring.hw1.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.hw1.entity.Exam;

import java.util.LinkedHashMap;

@Service
public class ClassroomService {
    private static final String TASK_FILE_NAME = "questions.csv";

    private TaskService taskService;
    private QuestionTranslationService questionTranslationService;
    private ExamService examService;
    private EvaluationService evaluationService;
    private PrintService printService;

    public ClassroomService(TaskService taskService, QuestionTranslationService questionTranslationService,
                            ExamService examService, EvaluationService evaluationService, PrintService printService) {
        this.taskService = taskService;
        this.questionTranslationService = questionTranslationService;
        this.examService = examService;
        this.evaluationService = evaluationService;
        this.printService = printService;
    }

    public void execute() {
        LinkedHashMap<String, String> questions = taskService.readTasks(TASK_FILE_NAME);
        LinkedHashMap<String, String> translatedQuestions = questionTranslationService.translate(questions);
        Exam exam = examService.takeExam(translatedQuestions.keySet());
        exam.setScore(evaluationService.evaluate(translatedQuestions, exam));
        printService.printResult(exam);
    }
}
