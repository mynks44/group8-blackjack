/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group8.blackjack;

/**
 *
 * @author suran
 */
public class Dealer extends Player {
    public Dealer() {
        super("Dealer");
    }

    public boolean shouldHit() {
        return hand.getValue() < 17;
    }
}