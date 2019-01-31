package ru.otus.spring.hw1.service;

import java.util.Locale;

public interface LocalizationService {
    Locale getLocale();

    String getMessage(String key);

    String getMessage(String key, Object object);

    String getMessage(String key, Object[] params);
}
