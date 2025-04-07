/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group8.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author suran, Mir Ali, Mohammded Rizwan
 */
// Singleton Pattern: Only one instance of Deck is allowed
public final class Deck {
    private static Deck instance;
    private final List<Card> cards;

    private Deck() {
        cards = new ArrayList<>();
        build();
        shuffle();
    }

    // Singleton Accessor
    public static Deck getInstance() {
        if (instance == null) {
            instance = new Deck();
        }
        return instance;
    }

    private void build() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        return cards.remove(cards.size() - 1);
    }
}