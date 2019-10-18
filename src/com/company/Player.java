package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    private  String name ;
    private int score = 0;
    ArrayList<Card> cards;

    public Player(String name) {
        this.name = name;
        cards = new ArrayList<>();
    }

    public void allocateCards(Card card) {
        cards.add(card);
        if(card.getVal() == 1) {
            score += (score +card.getVal()+10 <=21 ? 11:1 );
        } else score += card.getVal();
    }

    public int getScore() {
        return score;
    }
    public String getName() {
        return name;
    }
}
