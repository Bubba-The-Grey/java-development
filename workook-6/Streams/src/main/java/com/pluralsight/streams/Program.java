package com.pluralsight.streams;

import java.util.*;
import java.util.function.BiFunction;

public class Program {
    public static void main(String[] args) {
        List<Person> myFamily = new ArrayList<>();
        myFamily.add(new Person("Alice", "Johnson", 35));
        myFamily.add(new Person("Bob", "Smith", 42));
        myFamily.add(new Person("Charlie", "Davis", 28));
        myFamily.add(new Person("Diana", "Williams", 50));
        myFamily.add(new Person("Ethan", "Miller", 22));
        myFamily.add(new Person("Fiona", "Taylor", 38));
        myFamily.add(new Person("George", "Brown", 45));
        myFamily.add(new Person("Hannah", "Clark", 31));
        myFamily.add(new Person("Isaac", "Moore", 29));
        myFamily.add(new Person("Jack", "Anderson", 40));
        myFamily.sort((o1, o2) -> o1.getLastName().compareToIgnoreCase(o2.getLastName()));
        char option = 'y';
        Scanner scan = new Scanner(System.in);



        do{
            System.out.print("Enter the name you wish to search for: ");
            String name = scan.nextLine();
            System.out.println("Here are the results: ");
            myFamily.stream().filter(person ->
                    person.getFirstName().equalsIgnoreCase(name) || person.getLastName().equalsIgnoreCase(name))
                    .forEach(System.out::println);
            System.out.println("Would you like to search again (Y/N)? ");
            option = scan.nextLine().charAt(0);
        }while (option != 'n' && option != 'N');
        scan.close();


        double average = myFamily.stream()
                .mapToDouble(Person::getAge)
                .reduce(0, Double::sum);
        System.out.println("The average age of the group is: " + average/myFamily.size());


        int youngest = myFamily.stream().mapToInt(Person::getAge).reduce(100, Integer::min);
        myFamily.stream()
                .filter(person -> person.getAge() == youngest)
                .forEach(person -> System.out.println("The youngest is " + person.getFirstLast() + " with " + person.getAge()));


        int oldest = myFamily.stream().mapToInt(Person::getAge).reduce(0, Integer::max);
        myFamily.stream()
                .filter(person -> person.getAge() == oldest)
                .forEach(person -> System.out.println("The oldest is " + person.getFirstLast() + " with " + person.getAge()));

    }
}
