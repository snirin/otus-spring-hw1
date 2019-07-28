package ru.otus.spring.hw1.shell;

import java.util.LinkedHashMap;

import org.springframework.context.annotation.Profile;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.hw1.entity.Exam;
import ru.otus.spring.hw1.service.EvaluationService;
import ru.otus.spring.hw1.service.ExamService;
import ru.otus.spring.hw1.service.LocalizationService;
import ru.otus.spring.hw1.service.PrintService;
import ru.otus.spring.hw1.service.TaskService;

@ShellComponent
@Profile("shell")
public class ClassroomCommands {
    private static final String TASK_FILE_TEMPLATE = "questions_%s.csv";

    private String userName;
    private LinkedHashMap<String, String> questions;
    private Exam exam;

    private TaskService taskService;
    private LocalizationService localizationService;
    private ExamService examService;
    private EvaluationService evaluationService;
    private PrintService printService;

    public ClassroomCommands(TaskService taskService, LocalizationService localizationService,
                             ExamService examService, EvaluationService evaluationService,
                             PrintService printService) {
        this.taskService = taskService;
        this.localizationService = localizationService;
        this.examService = examService;
        this.evaluationService = evaluationService;
        this.printService = printService;
    }

    @ShellMethod(value = "Login command", key = {"l", "login"})
    public void login(@ShellOption String userName) {
        this.userName = userName;
    }

    @ShellMethod(value = "Exam command", key = {"e", "exam"})
    @ShellMethodAvailability(value = "isExamCommandAvailable")
    public void exam() {
        System.out.println(localizationService.getMessage("student", userName));
        String taskFileName = String.format(TASK_FILE_TEMPLATE, localizationService.getLocale().getLanguage());
        questions = taskService.readTasks(taskFileName);
        exam = examService.takeExam(userName, questions.keySet());
    }

    @ShellMethod(value = "Result command", key = {"r", "result"})
    @ShellMethodAvailability(value = "isResultCommandAvailable")
    public void result() {
        exam.setScore(evaluationService.evaluate(questions, exam));
        printService.printResult(exam);
    }

    private Availability isExamCommandAvailable() {
        String message = localizationService.getMessage("log.first");
        return userName == null? Availability.unavailable(message): Availability.available();
    }

    private Availability isResultCommandAvailable() {
        String message = localizationService.getMessage("questions.first");
        return exam == null? Availability.unavailable(message): Availability.available();
    }
}
