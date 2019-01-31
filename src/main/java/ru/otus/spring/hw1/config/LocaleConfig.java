package ru.otus.spring.hw1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@PropertySource("classpath:locale.properties")
@Configuration
public class LocaleConfig {

    @Bean
    public MessageSource messageSource () {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    public Locale locale (@Value("${locale.language}") String language, @Value("${locale.country}") String country) {
//        return Locale.forLanguageTag("ru_RU"); //todo не работает
//        return new Locale("ru", "RU");
        return new Locale(language, country);
    }
}
