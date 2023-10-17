package com.pluralsight;
import java.io.*;
import java.util.*;
import java.text.*;
public class PayrollCalculator {
    public static DecimalFormat df = new DecimalFormat("0.00");
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.print("Enter the name of the employee file to process: ");
        BufferedReader reader = new BufferedReader(new FileReader(scan.nextLine()));
        System.out.print("Enter the name of the payroll file to create (please include the extension of .csv or .json): ");
        String option = scan.nextLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(option));
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
        if(option.contains("json")) {
            writer.write("[\n");
            for (int i = 0; i < employees.length; i++) {
                writer.write("\t{ \"id\" : " + employees[i].getId() + ",  \"name\" : \"" + employees[i].getName() + "\", \"grossPay\" : " + df.format(employees[i].getGrossPay()) + " }");
                if(i == employees.length - 1){
                    writer.write("\n");
                }
                else{
                    writer.write(",\n");
                }
            }
            writer.write("]");
        }
        else{
            for (int i = 0; i < employees.length; i++) {
                writer.write(employees[i].getId() + "|" + employees[i].getName() + "|" + df.format(employees[i].getGrossPay()) + "\n");
            }
        }
        writer.close();
    }
}
