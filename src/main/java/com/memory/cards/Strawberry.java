package com.memory.cards;

public class Strawberry extends Card{
    static int count;

    public Strawberry() throws Exception {
        super("Strawberry", "img/img1.png");
        count++;
        if (count > 2) {
            throw new IllegalArgumentException("Too many strawberries");
        }
    }
}

