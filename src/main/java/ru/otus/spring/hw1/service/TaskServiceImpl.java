package ru.otus.spring.hw1.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskServiceImpl implements TaskService {

    private static final String SEPARATOR = ",";

    @Override
    public Map<String, String> readTasks(String filename) {

        Map<String, String> questions = new LinkedHashMap<>();

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(filename);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(SEPARATOR);
                questions.put(row[0], row[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }

        return questions;
    }
}
