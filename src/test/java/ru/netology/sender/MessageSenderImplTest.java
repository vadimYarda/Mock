package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {
    GeoServiceImpl geoServiceMock;
    LocalizationServiceImpl localizationServiceMock;
    MessageSenderImpl testMessageSender;
    Map<String, String> headers;

    @BeforeEach
    public void prepare() {
        geoServiceMock = Mockito.mock(GeoServiceImpl.class);
        localizationServiceMock = Mockito.mock(LocalizationServiceImpl.class);
        testMessageSender = new MessageSenderImpl(geoServiceMock, localizationServiceMock);
        headers = new HashMap<String, String>();
    }

    @Test
    public void testSendRussia() {

        //arrange
        String expected = ("Добро пожаловать");

        Mockito.when(geoServiceMock.byIp("172."))
                .thenReturn(new Location(null, Country.RUSSIA, null, 0));

        Mockito.when(localizationServiceMock.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");

        //act
        String result = testMessageSender.send(headers);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSendUSA() {

        //arrange
        String expected = ("Welcome");

        Mockito.when(geoServiceMock.byIp("96."))
                .thenReturn(new Location(null, Country.USA, null, 0));

        Mockito.when(localizationServiceMock.locale(Country.USA))
                .thenReturn("Welcome");

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");

        //act
        String result = testMessageSender.send(headers);

        //assert
        Assertions.assertEquals(expected, result);
    }

}