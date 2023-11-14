package com.pluralsight;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> myFamily = new ArrayList<>();
        myFamily.add( new Person("Dana", "Wyatt", 63) );
        myFamily.add( new Person("Zachary", "Westly", 31) );
        myFamily.add( new Person("Elisha", "Aslan", 14) );
        myFamily.add( new Person("Ian", "Auston", 16) );
        myFamily.add( new Person("Zephaniah", "Hughes", 9) );
        myFamily.add( new Person("Ezra", "Aiden", 17) );
        Collections.sort(myFamily, (o1, o2) -> o1.getLastName().compareToIgnoreCase(o2.getLastName()));
        for(Person p: myFamily){
            System.out.println(p);
        }
    }
}
