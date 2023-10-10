package com.pluralsight;

import java.util.*;
public class HighScoreWins {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        System.out.print("Enter the game score (team1:team2|team1points:team2points): ");
        String input = scan.nextLine();
        String[] stats = input.split("\\|");
        String[] teamNames = stats[0].split("\\:");
        String[] teamPoints = stats[1].split("\\:");
        if (Integer.parseInt(teamPoints[0]) > Integer.parseInt(teamPoints[1])){
            System.out.println("Winner: " + teamNames[0]);
        }
        else{
            System.out.println("Winner: " + teamNames[1]);
        }
    }
}
