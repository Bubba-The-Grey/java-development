package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.text.*;
public class PayrollCalculator {
    public static DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("employees.csv"));
        String words = "";
        Employee[] employees = new Employee[8];
        int count = 0;
        while((words = reader.readLine()) != null){
            String[] parameters = words.split("\\|");
            if(!parameters[0].equals("id")) {
                employees[count] = new Employee(parameters[0], parameters[1], parameters[2], parameters[3]);
                count++;
            }
        }
        reader.close();
        for(int i = 0; i < employees.length; i++){
            System.out.println("Employee ID: " + employees[i].getId() + " | Employee Name: " + employees[i].getName() + " | Employee Gross Pay: $" + df.format(employees[i].getGrossPay()));
        }
    }
}
