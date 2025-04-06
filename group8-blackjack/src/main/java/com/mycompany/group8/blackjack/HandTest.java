/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group8.blackjack;

/**
 *
 * @author suran
 */


import static junit.framework.Assert.assertEquals;
import org.junit.Test;

public class HandTest {

    @Test
    public void testHandValue() {
        Hand hand = new Hand();
        hand.addCard(new Card("Hearts", "10"));
        hand.addCard(new Card("Spades", "Ace"));
        assertEquals(21, hand.getValue());
    }
}