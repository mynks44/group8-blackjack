/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group8.blackjack;

/**
 *
 * @author suran
 */
public class SimpleDealerStrategy implements DealerStrategy {
    @Override
    public boolean shouldHit(Hand hand) {
        return hand.getValue() < 17;
    }
}
