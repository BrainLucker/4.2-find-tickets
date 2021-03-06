package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.Flight;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.repository.FlightRepository;

import java.util.Arrays;

@AllArgsConstructor
@Data
public class FlightManager {
    private FlightRepository repository;

    public void add(Flight flight) throws AlreadyExistsException {
        repository.save(flight);
    }

    public Flight[] findAll(String from, String to) {
        Flight[] result = new Flight[0];
        Flight[] tmp;
        int length = 0;
        for (Flight flight : repository.findAll()) {
            if ((flight.matches(from, to))) {
                length++;
                tmp = Arrays.copyOf(result, length);
                tmp[length - 1] = flight;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}