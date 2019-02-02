package ru.otus.spring.hw1.service;

import ru.otus.spring.hw1.entity.Exam;

import java.util.Set;

public interface ExamService {
    Exam takeExam(Set<String> questions);
}
