package TopTrumps;

import java.util.ArrayList;

public class Player {
    private String type;
    private ArrayList<Card> cards;

    public Player(String type, ArrayList<Card> cards){
        setType(type);
        setCards(cards);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Player{" +
                "type='" + type + '\'' +
                ", cards=" + cards +
                '}';
    }
}
