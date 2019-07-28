package ru.otus.spring.hw1.service;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;
import ru.otus.spring.hw1.entity.Exam;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    private static final String ENTER_YOUR_NAME = "enter.your.name";
    private static final String TASK_FILE_TEMPLATE = "questions_%s.csv";

    private QuestionService questionService;
    private TaskService taskService;
    private LocalizationService localizationService;
    private ExamService examService;
    private EvaluationService evaluationService;
    private PrintService printService;

    public ClassroomServiceImpl(QuestionService questionService, TaskService taskService, LocalizationService localizationService,
                                ExamService examService, EvaluationService evaluationService,
                                PrintService printService) {
        this.questionService = questionService;
        this.taskService = taskService;
        this.localizationService = localizationService;
        this.examService = examService;
        this.evaluationService = evaluationService;
        this.printService = printService;
    }

    @Override
    public void execute() {
        String taskFileName = String.format(TASK_FILE_TEMPLATE, localizationService.getLocale().getLanguage());
        LinkedHashMap<String, String> questions = taskService.readTasks(taskFileName);
        String questionName = localizationService.getMessage(ENTER_YOUR_NAME);
        String name = questionService.ask(questionName);
        Exam exam = examService.takeExam(name, questions.keySet());
        exam.setScore(evaluationService.evaluate(questions, exam));
        printService.printResult(exam);
    }
}
