/**
 *  Codingame
 *  Winamax Sponsored Contest
 *  Solution by: Dario Carrasquel
 */

import java.util.*;
import java.io.*;
import java.math.*;


public class Winamax {

    // Number of rounds
    private static int rounds = 0;
    
    // Winner => 0: Tie - 1: P1 wins - 2: P2 wins
    private static int winner = -1; 
    
    // Player's Decks
    private static ArrayList<String> deck1 = new ArrayList<String>();
    private static ArrayList<String> deck2 = new ArrayList<String>();
    
    // War depositories
    private static ArrayList<String> wd1 = new ArrayList<String>();
    private static ArrayList<String> wd2 = new ArrayList<String>();
    
    // Cards values - Lower index means a lower value
    private static String[] cardsValues = {"2", "3", "4", "5", "6", "7", "8", 
                                         "9", "10", "J","Q", "K", "A"};
    
    public static void main(String args[]) 
    {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of cards for player 1
        for (int i = 0; i < n; i++) 
        {
            String cardp1 = in.next(); // the n cards of player 1
            deck1.add(cardp1);
        }
        
        int m = in.nextInt(); // the number of cards for player 2
        for (int i = 0; i < m; i++) 
        {
            String cardp2 = in.next(); // the m cards of player 2
            deck2.add(cardp2);
        }
        
        // Simulate the Fight
        fight();
        
        if(winner == 0) System.out.println("PAT");
        else System.out.println(winner + " " + rounds);
    }
    
    
    /*
     * Simulates the fight
     *
     */
     
    private static void fight()
    {
        while(!(deck1.isEmpty() || deck2.isEmpty()))
        {   
            String card1 = deck1.remove(0);
            String card2 = deck2.remove(0);
            
            // Add cards to depositories
            wd1.add(card1);
            wd2.add(card2);
            
            card1 = card1.substring(0, card1.length() - 1);
            card2 = card2.substring(0, card2.length() - 1);
            
            int val1 = getValue(card1);
            int val2 = getValue(card2);
    
            // If cards are equal in value we have a war 
            if(val1 == val2)
            {
                war(wd1, wd2);
            }
            else if(val1 > val2)
            {
                rounds++;
                for(String c1 : wd1) deck1.add(c1);
                for(String c2 : wd2) deck1.add(c2);
                wd1.clear(); wd2.clear();
                
                // Check if there's winner
                if(deck2.isEmpty()) winner = 1;
            }
            else
            {
                rounds++;
                for(String c1 : wd1) deck2.add(c1);
                for(String c2 : wd2) deck2.add(c2);
                wd1.clear(); wd2.clear();
                
                // Check if there's winner
                if(deck1.isEmpty()) winner = 2;
            }
        }
    }
    
    
    /*
     * Obtains the value of a card
     *
     */
     
    private static int getValue(String val)
    {
        int size = cardsValues.length;
        int finalValue = 0;
        
        for (int i = 0; i < size; ++i)
        {
            if(cardsValues[i].equals(val))
            {
                finalValue = i;     
            }
        }
        
        return finalValue;
    }
    
    
    /*
     * Simulates the war
     *
     */
    
    private static void war(ArrayList<String> wd1, ArrayList<String> wd2)
    {       
        for(int k = 0; k < 3; k++)
        {
            // Add cards to depositories
            if(!(deck1.isEmpty() || deck2.isEmpty()))
            {
                wd1.add(deck1.remove(0));    
                wd2.add(deck2.remove(0));
            }
            else
            {
                winner = 0;
                break;
            }
        }
        
        if(wd1.isEmpty() || wd2.isEmpty()) winner = 0;
    }
}