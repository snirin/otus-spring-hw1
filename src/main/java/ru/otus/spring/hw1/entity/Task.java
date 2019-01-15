package ru.otus.spring.hw1.entity;

import com.google.common.base.Objects;

public class Task {

    private String question;
    private String answer;

    public Task(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equal(question, task.question) &&
                Objects.equal(answer, task.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(question, answer);
    }
}
