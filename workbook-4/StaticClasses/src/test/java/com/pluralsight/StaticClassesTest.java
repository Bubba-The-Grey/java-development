package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;

class StaticClassesTest {
    public static void format_With_FirstName_LastName(){
        System.out.println(StaticClasses.format("Jake", "Arnett"));
        assertEquals("Arnett, Jake", StaticClasses.format("Jake", "Arnett"));
    }

    public static void format_With_Prefix_FirstName_MiddleName_LastName_Suffix(){
        System.out.println(StaticClasses.format("Dr.", "Jake", "D", "Arnett", "PhD"));
        assertEquals("Arnett, Dr. Jake D, PhD", StaticClasses.format("Dr.", "Jake", "D", "Arnett", "PhD"));
    }

    public static void format_With_FullName(){
        System.out.println(StaticClasses.format("Dr. Jake D Arnett, PhD"));
        assertEquals("Arnett, Dr. Jake D, PhD", StaticClasses.format("Dr. Jake D Arnett, PhD"));
        System.out.println(StaticClasses.format("Jake D Arnett, Jr"));
        assertEquals("Arnett, Jake D, Jr", StaticClasses.format("Jake D Arnett, Jr"));
        System.out.println(StaticClasses.format("Dr. Jake D Arnett"));
        assertEquals("Arnett, Dr. Jake D", StaticClasses.format("Dr. Jake D Arnett"));
    }

    public static void main(String[] args) {
        format_With_FirstName_LastName();
        format_With_Prefix_FirstName_MiddleName_LastName_Suffix();
        format_With_FullName();
    }
}