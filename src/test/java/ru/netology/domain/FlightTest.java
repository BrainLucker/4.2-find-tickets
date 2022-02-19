package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightTest {
    private Flight flight1 = new Flight(1, 70_000, "VKO", "HND", 567);
    private Flight flight2 = new Flight(2, 50_000, "VHO", "HND", 567);
    private Flight flight3 = new Flight(3, 90_000, "VKH", "HND", 567);

    @ParameterizedTest
    @CsvSource({
            "Success, VKO, HND, true",
            "Not Found 1, VKO, VKO, false",
            "Not Found 2, HND, HND, false"
    })
    public void shouldMatchesFlights(String name, String from, String to, boolean expected) {
        boolean actual = flight1.matches(from, to);
        assertEquals(actual, expected);
    }
}