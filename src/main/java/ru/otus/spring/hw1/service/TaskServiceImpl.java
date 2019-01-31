package ru.otus.spring.hw1.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

@Service
class TaskServiceImpl implements TaskService {

    private static final String SEPARATOR = ",";

    @Override
    public LinkedHashMap<String, String> readTasks(String filename) {

        LinkedHashMap<String, String> questions = new LinkedHashMap<>();

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(filename);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(SEPARATOR);
                if (row.length == 2) {
                    questions.put(row[0], row[1]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }

        return questions;
    }
}
