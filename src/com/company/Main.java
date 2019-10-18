package com.company;


import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private ArrayList<Card> cards;
    private static final int BLACKJACK = 21;



    public static void main(String[] args) {
        Main mainClass = new Main();
        System.out.println("Enter the no of decks");
        int n = scan.nextInt();
        mainClass.creatAllCards(n);

        Player player = new Player("Player");
        Player dealer = new Player("Dealer");

        mainClass.distributeCard(player,2);
        mainClass.distributeCard(dealer,2);

        mainClass.play(player);
        mainClass.play(dealer);

        mainClass.evaluateResult(player,dealer);
    }

    private void distributeCard(Player player,int n) {
        for(int i = 0;i<n;i++) {
            player.allocateCards(cards.get(0));
            print(player.getName() + " got card" + cards.get(0).getVal());
            cards.remove(0);
        }
    }

    private void play(Player player) {
        print("Enter your choice \n1.Hit \n.Stand");
        print(player.getName()+" score is :" +player.getScore());
        int choice = scan.nextInt();
        if(choice == 1) {
            distributeCard(player,1);
            boolean[] result = bustedOrNot(player);
            if(result[0]) {
                print(player.getName() +"LOSSES");
                System.exit(0);
                return ;
            } else if(result[1]) {
                print(player.getName()+ "WINS BLACKJACK------");
                System.exit(0);
                return ;
            }
            play(player);
        } else if(choice == 2) return ;
        else {
            print("Please enter valid choice");
            play(player);
        }
    }


    private void evaluateResult(Player player,Player dealer) {
        int playerScore = player.getScore();
        int dealerScore = dealer.getScore();
        System.out.println("\n\nPlayer's score: " + player.getScore() + "\n" + "Dealer score: " + dealer.getScore());
        int dealerDiff = Math.abs(dealerScore - 21);
        int playerDiff = Math.abs(playerScore -21);

        if (dealerDiff < playerDiff) {
            System.out.println("Dealer wins as score is closer to 21");
        }else if (dealerDiff > playerDiff) {
            System.out.println("Player wins as score is closer to 21");
        }else {
            System.out.println("Draw as diff is same.");
        }
    }

    private boolean[] bustedOrNot(Player player) {
        int score = player.getScore();

        if(score > BLACKJACK) return new boolean[]{true,false};
        else return new boolean[]{false,score == BLACKJACK};
    }

    private void creatAllCards(int n) {
        cards = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            Deck deck = new Deck();
            cards.addAll(deck.getCards());
        }
        shuffleCards(cards);
    }
    private void print(String s) {
        System.out.println(s);
    }
    private void  shuffleCards(ArrayList<Card> cards) {
        Collections.shuffle(cards);
        print("Successfully shuffled");
    }



}
