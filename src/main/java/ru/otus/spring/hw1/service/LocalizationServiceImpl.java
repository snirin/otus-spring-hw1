package ru.otus.spring.hw1.service;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class LocalizationServiceImpl implements LocalizationService {
    private MessageSource messageSource;
    private Locale locale;

    public LocalizationServiceImpl(MessageSource messageSource, Locale locale) {
        this.messageSource = messageSource;
        this.locale = locale;
    }

    @Override
    public Locale getLocale() {
        return locale;
    }

    @Override
    public String getMessage(String key) {
        return getMessage(key, new Object[]{});
    }

    @Override
    public String getMessage(String key, Object object) {
        return getMessage(key, new Object[]{object});
    }

    @Override
    public String getMessage(String key, Object[] params) {
        return messageSource.getMessage(key, params, locale);
    }
}
