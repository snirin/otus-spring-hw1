package ru.otus.spring.hw1.service;

import ru.otus.spring.hw1.entity.Exam;

import java.util.Map;

public class EvaluationServiceImpl implements EvaluationService {

    @Override
    public int evaluate(Map<String, String> questions, Exam exam) {

        return (int) exam.getTasks().stream()
                .filter(task -> questions.get(task.getQuestion()).equals(task.getAnswer()))
                .count();
    }
}
