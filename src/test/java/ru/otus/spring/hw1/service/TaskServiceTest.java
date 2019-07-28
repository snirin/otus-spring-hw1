package ru.otus.spring.hw1.service;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskServiceTest {
    private static Map<String, String> QUESTIONS = ImmutableMap.of(
            "q1", "a1",
            "q2", "a2"
    );

    @Autowired
    private TaskService taskService;

    @Test
    public void readTasks() {
        Map<String, String> map = taskService.readTasks("test.csv");
        assertEquals(QUESTIONS, map);
    }
}
