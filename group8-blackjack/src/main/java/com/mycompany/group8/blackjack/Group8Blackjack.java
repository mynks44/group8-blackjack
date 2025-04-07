/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.group8.blackjack;

/**
 *
 * @author suran, Mir Ali, Mohammded Rizwan
 */



/**
 * Separation of Concerns:
 * - This is the controller handling the game loop and user interaction.
 */

import java.util.Scanner;

// Game Controller: Separates game logic from models
public class Group8Blackjack {
    private final Deck deck;
    private final Player player;
    private final Dealer dealer;
    private final Scanner scanner;

    public Group8Blackjack() {
        deck = Deck.getInstance(); // Singleton
        player = new Player("Player");
        dealer = new Dealer(new SimpleDealerStrategy()); // Strategy Pattern
        scanner = new Scanner(System.in);
    }

    public void dealInitialCards() {
        player.addCard(deck.deal());
        player.addCard(deck.deal());
        dealer.addCard(deck.deal());
        dealer.addCard(deck.deal());
    }

    public void playerTurn() {
        boolean playerTurn = true;

        while (playerTurn) {
            System.out.println("Player's Hand: " + player.getHand() + " (Value: " + player.getHandValue() + ")");
            System.out.println("Dealer's Visible Card Value: " + dealer.getHand().getValue());

            if (player.getHandValue() > 21) {
                System.out.println("Player busts! Dealer wins.");
                return;
            }

            System.out.print("Hit or Stand? ");
            String decision = scanner.nextLine().trim().toLowerCase();

            switch (decision) {
                case "hit" -> player.addCard(deck.deal());
                case "stand" -> playerTurn = false;
                default -> System.out.println("Invalid input. Type 'hit' or 'stand'.");
            }
        }
    }

    public void dealerTurn() {
        while (dealer.shouldHit()) {
            dealer.addCard(deck.deal());
        }
    }

    public void determineWinner() {
        System.out.println("\nFinal Hands:");
        System.out.println("Player: " + player.getHand() + " (Value: " + player.getHandValue() + ")");
        System.out.println("Dealer: " + dealer.getHand() + " (Value: " + dealer.getHandValue() + ")");

        if (dealer.getHandValue() > 21) {
            System.out.println("Dealer busts! Player wins.");
        } else if (player.getHandValue() > dealer.getHandValue()) {
            System.out.println("Player wins!");
        } else if (player.getHandValue() < dealer.getHandValue()) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public void play() {
        dealInitialCards();
        playerTurn();
        dealerTurn();
        determineWinner();
    }

    public static void main(String[] args) {
        Group8Blackjack game = new Group8Blackjack();
        game.play();
    }
}