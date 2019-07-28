package ru.otus.spring.hw1.service;

import java.util.Set;

import ru.otus.spring.hw1.entity.Exam;

public interface ExamService {
    Exam takeExam(String name, Set<String> questions);
}
