package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    GeoServiceImpl testGeoService;

    @BeforeEach
    public void prepare() {
        testGeoService = new GeoServiceImpl();
    }

    @org.junit.jupiter.api.Test
    void byIp() {
        Country expected = null;

        Country result = testGeoService.byIp("127.0.0.1").getCountry();

        Assertions.assertEquals(expected,result);
    }

    @Test
    public void testByIpRussian() {
        Country expected = Country.RUSSIA;

        Country result = testGeoService.byIp("172.0.32.11").getCountry();

        Assertions.assertEquals(expected, result);
    }
}