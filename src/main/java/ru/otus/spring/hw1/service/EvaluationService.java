package ru.otus.spring.hw1.service;

import ru.otus.spring.hw1.entity.Exam;

import java.util.Map;

public interface EvaluationService {

    int evaluate(Map<String, String> questions, Exam exam);
}
