/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.group8.blackjack;

/**
 *
 * @author suran, Mir Ali, Mohammded Rizwan
 */

import java.util.Scanner;

public class Group8Blackjack {
    private final Deck deck;
    private final Player player;
    private final Dealer dealer;
    private final Scanner scanner;

    public Group8Blackjack() {
        deck = new Deck();
        player = new Player("Player");
        dealer = new Dealer();
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
            System.out.println("Dealer's Visible Card: " + dealer.getHand().getValue());

            if (player.getHandValue() > 21) {
                System.out.println("Player busts! Dealer wins.");
                return;
            }

            System.out.print("Hit or Stand? ");
            String decision = scanner.nextLine().trim().toLowerCase();

            if (decision.equals("hit")) {
                player.addCard(deck.deal());
            } else if (decision.equals("stand")) {
                playerTurn = false;
            } else {
                System.out.println("Invalid input. Type 'hit' or 'stand'.");
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