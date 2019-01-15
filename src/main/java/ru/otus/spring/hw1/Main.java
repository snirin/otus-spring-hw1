package ru.otus.spring.hw1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.hw1.service.ClassroomService;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        ClassroomService classroomService = context.getBean(ClassroomService.class);
        classroomService.execute();
    }
}
