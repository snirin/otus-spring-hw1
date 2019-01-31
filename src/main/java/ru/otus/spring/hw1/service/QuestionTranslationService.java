package ru.otus.spring.hw1.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
class QuestionTranslationService {
    private MessageSource messageSource;
    private Locale locale;

    QuestionTranslationService(MessageSource messageSource, Locale locale) {
        this.messageSource = messageSource;
        this.locale = locale;
    }

    LinkedHashMap<String,String> translate(LinkedHashMap<String, String> questions) {
        return questions.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> messageSource.getMessage(e.getKey(), new Object[]{}, locale),
                        e -> messageSource.getMessage(e.getValue(), new Object[]{}, locale),
                        (x, y) -> y,
                        LinkedHashMap::new));
    }
}
