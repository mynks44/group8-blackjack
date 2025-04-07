/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group8.blackjack;

/**
 *
 * @author suran
 */
import java.util.ArrayList;
import java.util.List;
/**
 * Encapsulation:
 * - Internal list of cards is private.
 * - All logic (e.g., Ace value) is handled inside.
 */

// Encapsulation: Hand manages its internal list of cards and value logic
public class Hand {
    private final List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    
    // Handles special Ace logic (1 or 11) to avoid busting
    public int getValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            switch (card.getRank()) {
                case "2" -> value += 2;
                case "3" -> value += 3;
                case "4" -> value += 4;
                case "5" -> value += 5;
                case "6" -> value += 6;
                case "7" -> value += 7;
                case "8" -> value += 8;
                case "9" -> value += 9;
                case "10", "Jack", "Queen", "King" -> value += 10;
 case "Ace" ->  {
     value += 11; aceCount++;
                }
            }
        }

         // Adjust for Aces if value > 21
        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}