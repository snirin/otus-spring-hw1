package ru.otus.spring.hw1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw1.entity.Exam;

import java.util.Locale;

@Service
class PrintService {
    private MessageSource messageSource;
    private Locale locale;

    @Autowired
    PrintService(MessageSource messageSource, Locale locale) {
        this.messageSource = messageSource;
        this.locale = locale;
    }

    void printResult(Exam exam) {
        System.out.println(messageSource.getMessage("student",
                new String[] {exam.getStudent().getName()}, locale));
        System.out.println(messageSource.getMessage("result",
                new Integer[] {exam.getScore(), exam.getTasks().size()}, locale));
    }
}
