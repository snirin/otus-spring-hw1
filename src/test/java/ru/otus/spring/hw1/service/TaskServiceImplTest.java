package ru.otus.spring.hw1.service;

import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TaskServiceImplTest {
    private static Map<String, String> QUESTIONS = ImmutableMap.of(
            "q1", "a1",
            "q2", "a2"
    );

    private TaskService taskService;

    @Before
    public void setUp() throws Exception {
        taskService = new TaskServiceImpl();
    }

    @Test
    public void readTasks() throws Exception {
        Map<String, String> map = taskService.readTasks("test.csv");
        assertEquals(QUESTIONS, map);
    }
}
