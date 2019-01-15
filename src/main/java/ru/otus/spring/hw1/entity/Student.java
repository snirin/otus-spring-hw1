package ru.otus.spring.hw1.entity;

import com.google.common.base.Objects;

public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equal(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
