/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group8.blackjack;

/**
 *
 * @author suran
 */
public class Player {
    protected String name;
    protected Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public int getHandValue() {
        return hand.getValue();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }
}
