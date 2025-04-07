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
 * Strategy Design Pattern:
 * - Abstraction for dealer behavior.
 */

// Strategy Pattern Interface: abstraction for dealer decision logic
public interface DealerStrategy {
    boolean shouldHit(Hand hand);
}