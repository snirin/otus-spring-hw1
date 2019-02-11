package ru.otus.spring.hw1.сommandLineRunners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.otus.spring.hw1.service.ClassroomService;


@Component
@Profile("prod")
public class RunnerProd implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(RunnerProd.class);

    private ClassroomService classroomService;

    @Autowired
    public RunnerProd(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("PROD mode!!!");
        classroomService.execute();
    }
}
