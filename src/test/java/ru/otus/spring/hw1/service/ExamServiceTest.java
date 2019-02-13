package ru.otus.spring.hw1.service;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.spring.hw1.entity.Exam;
import ru.otus.spring.hw1.entity.Student;
import ru.otus.spring.hw1.entity.Task;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExamServiceTest {
    private static final String Q_1 = "q1";
    private static final String Q_2 = "q2";
    private static final String NAME = "John";
    private static final String ANSWER = "answer";
    private static final String ENTER_YOUR_NAME_LOCAL = "Введите имя:";

    private static Set<String> QUESTIONS = ImmutableSet.of(Q_1, Q_2);

    @Autowired
    private ExamService examService;

    @MockBean
    private QuestionServiceImpl questionService;

    @Before
    public void setUp() throws Exception {
        when(questionService.ask(any())).thenReturn(ANSWER);
        when(questionService.ask(ENTER_YOUR_NAME_LOCAL)).thenReturn(NAME);
    }

    @Test
    public void takeExam() throws Exception {
        Exam exam = examService.takeExam(QUESTIONS);
        Exam expectedExam = new Exam(new Student(NAME), ImmutableList.of(new Task(Q_1, ANSWER), new Task(Q_2, ANSWER)));
        assertEquals(expectedExam, exam);
    }
}
