package TopTrumps;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Deck{
    private int deckID=0;
    private int deckNumber;
    private String name;
    private ArrayList<Card> cards;

    public Deck(String name, ArrayList<Card> cards){
        setDeckNumber();
        setName(name);
        setCards(cards);
    }

    public int getDeckNumber() {
        return deckNumber;
    }

    public void setDeckNumber() {
        deckID++;
        this.deckNumber = deckID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Deck shuffle(){
        ArrayList<Card> shuffledCards = new ArrayList<>(30);
        boolean alreadyPicked[] = new boolean[30];
        int randomNum;
        String output="";

        for(int i=0; i<30; i++){
            randomNum = (int)(Math.random()*30);

            while(alreadyPicked[randomNum])
                randomNum = (int)(Math.random()*30);

            alreadyPicked[randomNum]=true;

            shuffledCards.add(cards.get(randomNum));
            output+=shuffledCards.get(i)+"\n";
        }

        Deck shuffledDeck = new Deck("",shuffledCards);

        JOptionPane.showMessageDialog(null,"Shuffled deck is as follows:\n\n" +
                        output,
                "Shuffled Deck",JOptionPane.INFORMATION_MESSAGE);

        return shuffledDeck;
    }

    public ArrayList<Player> deal(Deck shuffledDeck, int cpuPlayers){
        ArrayList<Player> players = new ArrayList<>(cpuPlayers+1);
        ArrayList<Card> p1Cards = new ArrayList<>(15);
        ArrayList<Card> p2Cards = new ArrayList<>(15);
        ArrayList<Card> p3Cards = new ArrayList<>(15);
        ArrayList<Card> p4Cards = new ArrayList<>(15);
        ArrayList<Card> p5Cards = new ArrayList<>(15);
        ArrayList<Card> p6Cards = new ArrayList<>(15);

        if(cpuPlayers==1){
            for(int i=0; i<cpuPlayers+1; i++){
            if(i==0)
                players.add(new Player("Human"));
            else
                players.add(new Player("CPU"));
        }

        for(int i=0; i<30; i++){
            if(i<15){
                p1Cards.add(shuffledDeck.getCards().get(i));
            }
            else if(i>14 && i<30)
                p2Cards.add(shuffledDeck.getCards().get(i));
        }

        players.get(0).setHand(p1Cards);
        players.get(1).setHand(p2Cards);
        }

        else if(cpuPlayers==2){
            for(int i=0; i<cpuPlayers+1; i++){
                if(i==0)
                    players.add(new Player("Human"));
                else
                    players.add(new Player("CPU"));
            }

            for(int i=0; i<30; i++){
                if(i<10)
                    p1Cards.add(shuffledDeck.getCards().get(i));
                else if(i>9 && i<20)
                    p2Cards.add(shuffledDeck.getCards().get(i));
                else if(i>19 && i<30)
                    p3Cards.add(shuffledDeck.getCards().get(i));
            }

            players.get(0).setHand(p1Cards);
            players.get(1).setHand(p2Cards);
            players.get(2).setHand(p3Cards);
        }

        else if(cpuPlayers==3){
            for(int i=0; i<cpuPlayers+1; i++){
                if(i==0)
                    players.add(new Player("Human"));
                else
                    players.add(new Player("CPU"));
            }

            for(int i=0; i<30; i++){
                if(i<7)
                    p1Cards.add(shuffledDeck.getCards().get(i));
                else if(i>6 && i<14)
                    p2Cards.add(shuffledDeck.getCards().get(i));
                else if(i>13 && i<21)
                    p3Cards.add(shuffledDeck.getCards().get(i));
                else if(i>20 && i<28)
                    p4Cards.add(shuffledDeck.getCards().get(i));
            }

            players.get(0).setHand(p1Cards);
            players.get(1).setHand(p2Cards);
            players.get(2).setHand(p3Cards);
            players.get(3).setHand(p4Cards);
        }

        else if(cpuPlayers==4){
            for(int i=0; i<cpuPlayers+1; i++){
                if(i==0)
                    players.add(new Player("Human"));
                else
                    players.add(new Player("CPU"));
            }

            for(int i=0; i<30; i++){
                if(i<6)
                    p1Cards.add(shuffledDeck.getCards().get(i));
                else if(i>5 && i<12)
                    p2Cards.add(shuffledDeck.getCards().get(i));
                else if(i>11 && i<18)
                    p3Cards.add(shuffledDeck.getCards().get(i));
                else if(i>17 && i<24)
                    p4Cards.add(shuffledDeck.getCards().get(i));
                else if(i>23 && i<30)
                    p5Cards.add(shuffledDeck.getCards().get(i));
            }

            players.get(0).setHand(p1Cards);
            players.get(1).setHand(p2Cards);
            players.get(2).setHand(p3Cards);
            players.get(3).setHand(p4Cards);
            players.get(4).setHand(p5Cards);
        }

        else if(cpuPlayers==5){
            for(int i=0; i<cpuPlayers+1; i++){
                if(i==0)
                    players.add(new Player("Human"));
                else
                    players.add(new Player("CPU"));
            }

            for(int i=0; i<30; i++){
                if(i<5)
                    p1Cards.add(shuffledDeck.getCards().get(i));
                else if(i>4 && i<10)
                    p2Cards.add(shuffledDeck.getCards().get(i));
                else if(i>9 && i<15)
                    p3Cards.add(shuffledDeck.getCards().get(i));
                else if(i>14 && i<20)
                    p4Cards.add(shuffledDeck.getCards().get(i));
                else if(i>19 && i<25)
                    p5Cards.add(shuffledDeck.getCards().get(i));
                else if(i>24 && i<30)
                    p6Cards.add(shuffledDeck.getCards().get(i));
            }

            players.get(0).setHand(p1Cards);
            players.get(1).setHand(p2Cards);
            players.get(2).setHand(p3Cards);
            players.get(3).setHand(p4Cards);
            players.get(4).setHand(p5Cards);
            players.get(5).setHand(p6Cards);
        }

        System.out.println(players.toString());

        return players;
    }

    @Override
    public String toString() {
        String str="ID: "+getDeckNumber()+"  Name: "+getName();

        return str;
    }
}
