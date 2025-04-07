/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group8.blackjack;

/**
 *
 * @author suran
 */

/**
 * Strategy Pattern (Implementation):
 * - Dealer hits until reaching a value of 17 or more.
 */

// Strategy Pattern Implementation: Dealer hits if hand < 17
public class SimpleDealerStrategy implements DealerStrategy {
    @Override
    public boolean shouldHit(Hand hand) {
        return hand.getValue() < 17;
    }
}
