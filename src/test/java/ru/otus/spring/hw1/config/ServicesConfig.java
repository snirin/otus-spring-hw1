package ru.otus.spring.hw1.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@ComponentScan({"ru.otus.spring.hw1.service", "ru.otus.spring.hw1.config"})
@EnableConfigurationProperties(YamlProps.class)
public class ServicesConfig {
}
