package com.pluralsight.collection;
import java.time.*;
public class Main {
    public static void main(String[] args) {
        FixedList<Integer> numbers = new FixedList<>(3);
        numbers.add(10);
        numbers.add(3);
        numbers.add(92);
        numbers.add(43); // this line should fail
        System.out.println(numbers.getItems().size());
        FixedList<LocalDate> dates = new FixedList<>(2);
        dates.add(LocalDate.now());
        dates.add(LocalDate.parse("2023-06-08"));
        dates.add(LocalDate.parse("2023-07-09")); // this line should fail
    }
}
