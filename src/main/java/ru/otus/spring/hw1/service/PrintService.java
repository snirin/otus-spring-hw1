package ru.otus.spring.hw1.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.hw1.entity.Exam;

@Service
class PrintService {
    void printResult(Exam exam) {
        System.out.println("Student: " + exam.getStudent().getName());
        System.out.println("Result: " + exam.getScore() + " out of " + exam.getTasks().size());
    }
}
