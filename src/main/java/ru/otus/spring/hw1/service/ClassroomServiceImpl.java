package ru.otus.spring.hw1.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.hw1.entity.Exam;

import java.util.LinkedHashMap;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    private static final String TASK_FILE_TEMPLATE = "questions_%s.csv";

    private TaskService taskService;
    private LocalizationService localizationService;
    private ExamService examService;
    private EvaluationService evaluationService;
    private PrintService printService;

    public ClassroomServiceImpl(TaskService taskService, LocalizationService localizationService,
                                ExamService examService, EvaluationService evaluationService,
                                PrintService printService) {
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
        Exam exam = examService.takeExam(questions.keySet());
        exam.setScore(evaluationService.evaluate(questions, exam));
        printService.printResult(exam);
    }
}
