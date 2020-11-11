package TopTrumps;

import java.util.ArrayList;

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

    @Override
    public String toString() {
        String str="Name: "+getName()+"\n\nCards:\n\n";

        for(int i=0; i<cards.size(); i++){
            str+=cards.get(i).toString()+"\n";
        }

        return str;
    }
}
