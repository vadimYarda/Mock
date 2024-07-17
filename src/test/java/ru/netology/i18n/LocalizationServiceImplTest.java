package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

        LocalizationServiceImpl testLocalizationService;

        @BeforeEach
        public void prepare(){
            testLocalizationService = new LocalizationServiceImpl();
        }
        @Test
        public void localeRussia(){
            String expected = ("Добро пожаловать");
            String result = testLocalizationService.locale(Country.RUSSIA);
            Assertions.assertEquals(expected, result);
        }

        @Test
    public void localUsa(){
            String expected = ("Welcome");
            String result = testLocalizationService.locale(Country.USA);
            Assertions.assertEquals(expected, result);
    }
}