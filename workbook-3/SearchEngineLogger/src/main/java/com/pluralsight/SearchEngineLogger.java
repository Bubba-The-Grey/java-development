package com.pluralsight;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.time.*;
import java.time.format.*;
public class SearchEngineLogger {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"));
        LocalDateTime launch = LocalDateTime.now();
        DateTimeFormatter log = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss ");
        String output = launch.format(log);
        writer.write(output + "launch\n");
        Scanner scan = new Scanner (System.in);
        String input = " ";
        do{
                System.out.print("Enter a search term (X to exit): ");
                input = scan.nextLine();
                if(!input.equalsIgnoreCase("X")) {
                    LocalDateTime now = LocalDateTime.now();
                    output = now.format(log);
                    writer.write(output + "search : " + input + "\n");
                }
        }
        while(!input.equalsIgnoreCase("X"));
        scan.close();
        LocalDateTime exit = LocalDateTime.now();
        output = exit.format(log);
        writer.write(output + "exit");
        writer.close();
    }
}
