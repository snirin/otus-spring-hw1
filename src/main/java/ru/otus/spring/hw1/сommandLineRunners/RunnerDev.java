package ru.otus.spring.hw1.сommandLineRunners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("dev")
public class RunnerDev implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(RunnerDev.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("DEV mode!!!");
    }
}
