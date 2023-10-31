package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    public static void punchTimeCard_With_Times(){
        Employee employee = new Employee(1, "Guest Services", "Enrico Suave", 7.25, 0.0);
        employee.punchIn(LocalDateTime.parse("2023-05-11 08:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        employee.punchOut(LocalDateTime.parse("2023-05-11 16:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        employee.punchTimeCard();
        System.out.println(employee.getHours());
        assertEquals(8, employee.getHours());
    }

    public static void punchTimeCard_Without_Times() throws InterruptedException {
        Employee employee = new Employee(1, "Guest Services", "Enrico Suave", 7.25, 0.0);
        employee.punchIn();
        Thread.sleep(359995);
        employee.punchOut();
        employee.punchTimeCard();
        System.out.println(employee.getHours());
        assertEquals(0.1, employee.getHours());
    }

    public static void main(String[] args) throws InterruptedException {
        punchTimeCard_With_Times();
        punchTimeCard_Without_Times();
    }
}