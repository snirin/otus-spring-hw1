package ru.otus.spring.hw1.service;

import ru.otus.spring.hw1.entity.Exam;

public class PrintServiceImpl implements PrintService {
    @Override
    public void printResult(Exam exam) {
        System.out.println("Student: " + exam.getStudent().getName());
        System.out.println("Result: " + exam.getScore() + " out of " + exam.getTasks().size());
    }
}
