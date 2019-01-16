package ru.otus.spring.hw1.service;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.Before;
import org.junit.Test;
import ru.otus.spring.hw1.entity.Exam;
import ru.otus.spring.hw1.entity.Student;
import ru.otus.spring.hw1.entity.Task;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static ru.otus.spring.hw1.service.ExamServiceImpl.ENTER_YOUR_NAME;

public class ExamServiceImplTest {
    private static final String Q_1 = "q1";
    private static final String Q_2 = "q2";
    private static final String NAME = "John";
    private static final String ANSWER = "answer";

    private static Set<String> QUESTIONS = ImmutableSet.of(Q_1, Q_2);

    private ExamService examService;

    @Before
    public void setUp() throws Exception {
        QuestionService questionService = mock(QuestionService.class);
        when(questionService.ask(any())).thenReturn(ANSWER);
        when(questionService.ask(ENTER_YOUR_NAME)).thenReturn(NAME);

        examService = new ExamServiceImpl(questionService);
    }

    @Test
    public void takeExam() throws Exception {
        Exam exam = examService.takeExam(QUESTIONS);
        Exam expectedExam = new Exam(new Student(NAME), ImmutableList.of(new Task(Q_1, ANSWER), new Task(Q_2, ANSWER)));
        assertEquals(expectedExam, exam);
    }
}
