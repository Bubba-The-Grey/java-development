package com.pluralsight;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class FormatDates {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter simpleStandard = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter monthDyear = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        DateTimeFormatter longdate = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy\t HH:mm");
        DateTimeFormatter challenge = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String simpleDate = today.format(simpleStandard);
        LocalDateTime todayTime = LocalDateTime.now();
        System.out.println(simpleDate);
        String monthDyearDate = today.format(monthDyear);
        System.out.println(today);
        System.out.println(monthDyearDate);
        String longDate = todayTime.format(longdate);
        System.out.println(longDate);
        String challengeDate = today.format(challenge);
        LocalTime time = LocalTime.now();
        System.out.println(time.getHour() + ":" + time.getMinute() + " on " + challengeDate);

    }
}
