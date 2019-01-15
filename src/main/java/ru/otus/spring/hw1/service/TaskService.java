package ru.otus.spring.hw1.service;

import java.util.Map;

public interface TaskService {

    Map<String, String> readTasks(String filename);
}
