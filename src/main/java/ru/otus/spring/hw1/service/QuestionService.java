package ru.otus.spring.hw1.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
class QuestionService {

    String ask(String question) {
        System.out.println(question);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer;
        try {
            answer = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }

        return answer;
    }
}
