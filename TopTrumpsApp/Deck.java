package TopTrumpsApp;

import javax.swing.*;
import java.util.ArrayList;

public class Deck {
    private int deckID=0;
    private int deckNumber;
    private String name;
    private ArrayList<TopTrumpsApp.Card> cards;

    public Deck(String name, ArrayList<TopTrumpsApp.Card> cards){
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

    /*public Deck shuffle(Deck deck){
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
    }*/

    @Override
    public String toString() {

        String str="ID: "+getDeckNumber()+"  Name: "+getName();

        return str;

    }
}
