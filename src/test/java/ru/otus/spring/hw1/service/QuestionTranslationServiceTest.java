package ru.otus.spring.hw1.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.LinkedHashMap;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class QuestionTranslationServiceTest {
    private static final Locale LOCALE = new Locale("ru", "RU");

    private QuestionTranslationService translationService;

    @Before
    public void setUp() throws Exception {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/i18n/bundle");
        messageSource.setDefaultEncoding("UTF-8");

        translationService = new QuestionTranslationService(messageSource, LOCALE);
    }

    @Test
    public void translate() throws Exception {
        LinkedHashMap<String, String> questions = new LinkedHashMap<>();
        questions.put("q1", "a1");
        questions.put("q2", "a2");
        questions.put("q3", "a3");
        questions.put("q4", "a4");

        LinkedHashMap<String, String> translatedQuestions = new LinkedHashMap<>();
        translatedQuestions.put("Вопрос 1", "Ответ 1");
        translatedQuestions.put("Вопрос 2", "Ответ 2");
        translatedQuestions.put("Вопрос 3", "Ответ 3");
        translatedQuestions.put("Вопрос 4", "Ответ 4");

        assertEquals(translatedQuestions, translationService.translate(questions));
    }
}
