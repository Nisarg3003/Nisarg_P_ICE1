/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1.
 * @author srinivsi
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();

        // Fill the magic hand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1); // Random value between 1 and 13
            c.setSuit(Card.SUITS[random.nextInt(4)]); // Random suit
            magicHand[i] = c;
        }

        // Display the magic hand
        System.out.println("Your hand:");
        for (Card card : magicHand) {
            System.out.println(card.getSuit() + " " + card.getValue());
        }

        // Ask the user to pick a card
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a card value (1-13):");
        int userValue = scanner.nextInt();
        System.out.println("Enter a suit (0-3 where 0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades):");
        int userSuitIndex = scanner.nextInt();

        // Validate suit index
        if (userSuitIndex < 0 || userSuitIndex > 3) {
            System.out.println("Invalid suit selection.");
            return;
        }

        String userSuit = Card.SUITS[userSuitIndex];

        // Check if the user's card is in the magic hand
        boolean cardFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == userValue && card.getSuit().equalsIgnoreCase(userSuit)) {
                cardFound = true;
                break;
            }
        }

        // Report result
        if (cardFound) {
            System.out.println("Congratulations! Your card is in the magic hand!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }

        // Add a hardcoded lucky card
        Card luckyCard = new Card();
        luckyCard.setValue(2); // Hardcoded value
        luckyCard.setSuit("Clubs"); // Hardcoded suit
        System.out.println("\nLucky Card: " + luckyCard.getSuit() + " " + luckyCard.getValue());

        // Check if the lucky card is in the magic hand
        boolean luckyCardFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                luckyCardFound = true;
                break;
            }
        }

        // Report lucky card result
        if (luckyCardFound) {
            System.out.println("You win! The lucky card is in the magic hand!");
        } else {
            System.out.println("You lose! The lucky card is not in the magic hand.");
        }

        scanner.close();
    }
}
