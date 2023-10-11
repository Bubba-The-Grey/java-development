package com.pluralsight;

import java.util.*;
public class TestStatistics {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        int length;
        int high = 0, low = 101, sum = 0;
        double average, median;
        System.out.print("How many test scores do you want to add? ");
        length = scan.nextInt();
        System.out.println();

        int[] scores = new int[length];
        for(int i = 0; i < scores.length; i++){
            System.out.print("Please enter a test score: ");
            scores[i] = scan.nextInt();
            sum += scores[i];
        }
        Arrays.sort(scores);

        high = scores[scores.length - 1];
        low = scores[0];
        average = (double) sum / scores.length;
        if(scores.length % 2 == 0){
            median = (double) ((scores[scores.length / 2]) + (scores[(scores.length / 2) - 1])) / 2;
        }
        else{
            median = scores[(scores.length / 2)];
        }

        System.out.println("Highest score: " + high);
        System.out.println("Lowest score: " + low);
        System.out.println("Average score: " + average);
        System.out.println("Median score: " + median);

    }
}
