package com.pluralsight;

public class RollTheDice {
    public static void main(String[] args){
        Dice dice = new Dice();
        int roll1, roll2, twoCount = 0, fourCount = 0, sixCount = 0, sevenCount = 0, sum;
        for(int i = 1; i <= 100; i++){
            roll1 = dice.roll();
            roll2 = dice.roll();
            sum = roll1 + roll2;
            System.out.println("Roll " + i + ": " + roll1 + " + " + roll2 + " = " + sum);
            switch(sum){
                case 2:
                    twoCount++;
                    break;
                case 4:
                    fourCount++;
                    break;
                case 6:
                    sixCount++;
                case 7:
                    sevenCount++;
                    break;
            }
        }
        System.out.println("There are " + twoCount + " 2's, " + fourCount + " 4's, " + sixCount + " 6's, and " +
                sevenCount + " 7's.");
    }
}
