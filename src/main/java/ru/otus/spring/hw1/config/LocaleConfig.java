package ru.otus.spring.hw1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.spring.hw1.service.LocalizationService;
import ru.otus.spring.hw1.service.LocalizationServiceImpl;

import java.util.Locale;

@Configuration
public class LocaleConfig {

    @Bean
    public LocalizationService localizationService(YamlProps props) {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/i18n/bundle");
        messageSource.setDefaultEncoding("UTF-8");

        return new LocalizationServiceImpl(messageSource, Locale.forLanguageTag(props.getLocale()));
    }
}
