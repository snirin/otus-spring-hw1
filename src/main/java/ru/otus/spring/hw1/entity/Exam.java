package ru.otus.spring.hw1.entity;

import java.util.List;

public class Exam {

    private Student student;
    private List<Task> tasks;
    private int score;

    public Exam(Student student, List<Task> tasks) {
        this.student = student;
        this.tasks = tasks;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return score == exam.score &&
                com.google.common.base.Objects.equal(student, exam.student) &&
                com.google.common.base.Objects.equal(tasks, exam.tasks);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(student, tasks, score);
    }
}
