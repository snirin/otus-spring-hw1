package ru.otus.spring.hw1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.spring.hw1.service.ClassroomServiceImpl;

@ComponentScan
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        ClassroomServiceImpl classroomService = context.getBean(ClassroomServiceImpl.class);
        classroomService.execute();
    }
}
