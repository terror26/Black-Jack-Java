package com.company;

import javax.annotation.Generated;
import java.util.ArrayList;


public class Deck {
    private static int SUITS = 4;
    private static int NCARDS = 13;
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for(int i = 1;i<=SUITS;i++)          // Number of spades,leaf
            for(int j = 1;j<=NCARDS;j++) {
                cards.add(new Card(i,j > 9?10:j));       // SUITS,VAL
            }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }


}
