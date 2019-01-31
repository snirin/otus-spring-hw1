package ru.otus.spring.hw1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.spring.hw1.service.ClassroomService;

@ComponentScan
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        ClassroomService classroomService = context.getBean(ClassroomService.class);
        classroomService.execute();
    }
}
