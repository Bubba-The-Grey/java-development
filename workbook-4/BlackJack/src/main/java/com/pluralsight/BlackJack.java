package com.pluralsight;
import java.util.*;
public class BlackJack {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand dealer = new Hand();
        Scanner scan = new Scanner(System.in);
        deck.shuffle();
        System.out.print("How many players are at the table? ");
        int numPlayers = scan.nextInt();
        ArrayList<Hand> players = new ArrayList<>();
        for(int i = 0; i < numPlayers; i++){
            players.add(new Hand());
        }
        for (int i = 0; i < 2; i++) {
            Card card = deck.deal();
            dealer.deal(card);
            for (int j = 0; j < numPlayers; j++) {
                Card card2 = deck.deal();
                players.get(j).deal(card2);
            }
        }
        boolean winner = true;
        StringBuilder winningStatement = new StringBuilder("Winner (Note: In the event a player is tied with the dealer, dealer wins): ");
        do {
            for (int i = 0; i <= numPlayers; i++) {
                if (i == numPlayers) {
                    int value = dealer.getValue();
                    System.out.println("Dealer has: " + dealer.getValue());
                    if (value == 21) {
                        winner = false;
                        winningStatement = new StringBuilder("Winner (Note: In the event a player is tied with the dealer, dealer wins): Dealer");
                    }
                } else {
                    int value = players.get(i).getValue();
                    System.out.println("Player " + (i + 1) + " has: " + players.get(i).getValue());
                    if (value == 21) {
                        winner = false;
                        winningStatement.append("Player ").append(i + 1).append(", ");
                    }
                }
            }
            if(winner){
                int highest = 0;
                for(int i = 0; i <= numPlayers; i++){
                    if(i == numPlayers){
                        if(dealer.getValue() >= highest) {
                            winningStatement = new StringBuilder("Winner (Note: In the event a player is tied with the dealer, dealer wins): Dealer");
                            winner = false;
                        }
                    }
                    else{
                        if(players.get(i).getValue() >= highest){
                            highest = players.get(i).getValue();
                        }
                    }
                }
                if(winner) {
                    for (int i = 0; i < numPlayers; i++) {
                        if (players.get(i).getValue() == highest) {
                            winningStatement.append("Player ").append(i + 1).append(", ");
                            winner = false;
                        }
                    }
                }
            }
        } while (winner);
        System.out.println(winningStatement);
    }
}
