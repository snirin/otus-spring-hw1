package ru.otus.spring.hw1.service;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.spring.hw1.entity.Exam;
import ru.otus.spring.hw1.entity.Student;
import ru.otus.spring.hw1.entity.Task;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EvaluationServiceTest {
    private static Map<String, String> QUESTIONS = ImmutableMap.of(
            "q1", "a1",
            "q2", "a2"
    );

    @Autowired
    private EvaluationService evaluationService;

    @Test
    public void evaluate() {
        Exam exam = new Exam(new Student(""),
                ImmutableList.of(new Task("q1", "a1"),
                        new Task("q1", "a3")));

        assertEquals(1, evaluationService.evaluate(QUESTIONS, exam));
    }
}
