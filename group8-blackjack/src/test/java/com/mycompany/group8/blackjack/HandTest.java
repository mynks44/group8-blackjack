/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author suran
 */

package com.mycompany.group8.blackjack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandTest {

    /**
     * Test for a Blackjack hand (Ace + 10).
     */
    @Test
    public void testGetValueWithAceAndTen() {
        Hand hand = new Hand();
        hand.addCard(new Card("Hearts", "Ace"));
        hand.addCard(new Card("Spades", "10"));

        int expected = 21;
        int actual = hand.getValue();

        assertEquals(expected, actual, "Hand with Ace and Ten should equal 21");
    }

    /**
     * Test summing of multiple numeric cards (5 + 7 + 9 = 21).
     */
    @Test
    public void testGetValueWithMultipleCards() {
        Hand hand = new Hand();
        hand.addCard(new Card("Clubs", "5"));
        hand.addCard(new Card("Diamonds", "7"));
        hand.addCard(new Card("Spades", "9"));

        int expected = 21;
        int actual = hand.getValue();

        assertEquals(expected, actual, "5 + 7 + 9 should equal 21");
    }

    /**
     * Test a hand with two Aces and a 9.
     * One Ace should be counted as 11 and the other as 1.
     */
    @Test
    public void testGetValueWithTwoAcesAndNine() {
        Hand hand = new Hand();
        hand.addCard(new Card("Hearts", "Ace"));
        hand.addCard(new Card("Clubs", "Ace"));
        hand.addCard(new Card("Diamonds", "9"));

        int expected = 21; // 11 (Ace) + 1 (Ace) + 9
        int actual = hand.getValue();

        assertEquals(expected, actual, "Two Aces and a 9 should equal 21");
    }

    /**
     * Test bust logic: Ace must be counted as 1 if 11 would bust the hand.
     */
    @Test
    public void testGetValueWithAceBustLogic() {
        Hand hand = new Hand();
        hand.addCard(new Card("Hearts", "Ace"));
        hand.addCard(new Card("Clubs", "9"));
        hand.addCard(new Card("Spades", "5"));
        hand.addCard(new Card("Diamonds", "9"));

        int expected = 24; // Ace = 1, total: 1 + 9 + 5 + 9 = 24
        int actual = hand.getValue();

        assertEquals(expected, actual, "Hand should bust with total value 24");
    }
}
