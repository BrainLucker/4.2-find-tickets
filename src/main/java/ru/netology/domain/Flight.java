package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Flight implements Comparable<Flight> {
    private int id;
    private double price;
    private String from;
    private String to;
    private int time;

    public boolean matches(String from, String to) {
        return (this.from.equals(from) && this.to.equals(to));
    }

    @Override
    public int compareTo(Flight f) {
        return (int) (price - f.price);
    }
}