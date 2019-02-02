package ru.otus.spring.hw1.service;

import java.util.LinkedHashMap;

public interface TaskService {
    LinkedHashMap<String, String> readTasks(String filename);
}
