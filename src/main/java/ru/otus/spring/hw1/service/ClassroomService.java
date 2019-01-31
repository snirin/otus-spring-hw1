package ru.otus.spring.hw1.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.hw1.entity.Exam;

import java.util.Map;

@Service
public class ClassroomService {
    private static final String TASK_FILE_NAME = "questions.csv";

    private TaskService taskService;
    private ExamService examService;
    private EvaluationService evaluationService;
    private PrintService printService;

    public ClassroomService(TaskService taskService, ExamService examService,
                            EvaluationService evaluationService, PrintService printService) {
        this.taskService = taskService;
        this.examService = examService;
        this.evaluationService = evaluationService;
        this.printService = printService;
    }

    public void execute() {
        Map<String, String> questions = taskService.readTasks(TASK_FILE_NAME);
        Exam exam = examService.takeExam(questions.keySet());
        exam.setScore(evaluationService.evaluate(questions, exam));
        printService.printResult(exam);
    }
}
