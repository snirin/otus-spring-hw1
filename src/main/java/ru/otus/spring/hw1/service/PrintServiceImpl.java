package ru.otus.spring.hw1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw1.entity.Exam;

@Service
class PrintServiceImpl implements PrintService {
    private LocalizationService localizationService;

    @Autowired
    PrintServiceImpl(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @Override
    public void printResult(Exam exam) {
        System.out.println(localizationService.getMessage("student", exam.getStudent().getName()));
        System.out.println(localizationService.getMessage("result", new Integer[] {exam.getScore(), exam.getTasks().size()}));
    }
}
