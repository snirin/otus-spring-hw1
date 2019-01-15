package ru.otus.spring.hw1.service.stub;

import ru.otus.spring.hw1.service.QuestionService;

import static ru.otus.spring.hw1.service.ExamServiceImpl.ENTER_YOUR_NAME;

public class QuestionServiceStub implements QuestionService {

    public static final String NAME = "John";
    public static final String ANSWER = "answer";

    @Override
    public String ask(String question) {
        if (ENTER_YOUR_NAME.equals(question)) {
            return NAME;
        } else {
            return ANSWER;
        }
    }
}
