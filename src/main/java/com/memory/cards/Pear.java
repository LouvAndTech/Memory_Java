package com.memory.cards;

public class Pear extends Card{
    static int count;

    public Pear() throws Exception {
        super("Pear", "img/img2.png");
        count++;
        if (count > 2) {
            throw new IllegalArgumentException("Too many strawberries");
        }
    }
}
