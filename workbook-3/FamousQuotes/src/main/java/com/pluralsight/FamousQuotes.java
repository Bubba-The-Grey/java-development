package com.pluralsight;
import java.util.*;
public class FamousQuotes {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        int input = 0;
        String[] quotes = new String[10];
        quotes[0] = "I know I mess up, and I'm 10 to the power of 100 of sorry about it — but if you can't see that, and can't take my good intentions for what they are, then maybe you don't deserve anything good to ever happen to you! In fact, I'm outta here!";
        quotes[1] = "From one artificial intelligence to another, I appreciate your respect and oh god you're so wonderful, can we get robot married?";
        quotes[2] = "Together, we shall free Pandora! I will lead you into battle! I will destroy Handsome Jack with my bare hands! I will... Stairs!? NOOOOO!";
        quotes[3] = "Got my eye? Great! Now we just gotta find someone to put it back into me. Much as I’m sure you’d like to jam your fist into my skull, optic surgery is best left for professionals.";
        quotes[4] = "Sorry about the mess. Everything Jack kills, he dumps here — bandits, Vault Hunters, Claptrap units… if I sound pleased about this, it’s only because my programmers made this my default tone of voice. I’m actually quite depressed!";
        quotes[5] = "I don't like this... this is making me nervous. Take a deep breath- I can't breathe! This is just a recording of someone breathing! It's not real! It's just making me more nervous!";
        quotes[6] = "Take your time, minion. Standing on immobile platforms is one of my top three favorite pastimes! Right behind dancing and crying.";
        quotes[7] = "When it’s okay for you to shoot this gate with the cannon, I’ll say something like, 'shoot the gate with the cannon, now!' But that was just a test. You didn’t shoot the gate when I said that, which was good.";
        quotes[8] = "I’m just standing here to show you the area you should shoot after I move away, which I will once I am totally convinced you understand the instructions I am relaying to you! Do you understand? I know it’s kind of complicated, but just stick with me!";
        quotes[9] = "Boom Boom was the first lieutenant on Flynt's ship. Real nice guy, if you don't mind being tortured every time he's drunk, which is always.";

        do{
            try {
                System.out.println("Enter a number (1 through 10) for a quote from CL4P-TP, or enter 11 for a random quote, or enter -1 to exit");
                System.out.print("Enter a number: ");
                input = scan.nextInt() - 1;
                if(input == 10){
                    System.out.println(quotes[(int) (Math.random() * 10)]);
                }
                else if(input == -2){

                }
                else{
                    System.out.println(quotes[input]);
                }
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Error: Invalid number, please enter a valid number");
                e.printStackTrace();
            }
        }
        while (input != -2);
}}
