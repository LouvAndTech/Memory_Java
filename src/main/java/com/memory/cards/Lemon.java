package com.memory.cards;

public class Lemon extends Card{
    static int count;

    public Lemon() throws Exception {
        super("Lemon", "img/img3.png");
        count++;
        if (count > 2) {
            throw new IllegalArgumentException("Too many lemons");
        }
    }
}