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
 * Inheritance:
 * - Extends Player class.
 * Strategy Pattern:
 * - Accepts DealerStrategy to determine behavior.
 */

// Inherits from Player, uses Strategy Pattern
public class Dealer extends Player {
    private final DealerStrategy strategy;

    public Dealer(DealerStrategy strategy) {
        super("Dealer");
        this.strategy = strategy;
    }

    // Delegates decision to strategy
    public boolean shouldHit() {
        return strategy.shouldHit(hand);
    }
}