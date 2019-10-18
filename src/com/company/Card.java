package com.company;

public class Card {
    private int suit;
    private int val;

    public Card(int suit, int val) {
        this.suit = suit;
        this.val = val;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
