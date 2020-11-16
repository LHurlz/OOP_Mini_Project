package TopTrumpsApp;

import java.util.ArrayList;

public class Player {
    private String type;
    private ArrayList<Card> hand;

    public Player(String type,ArrayList<Card> hand){
        setType(type);
        setHand(hand);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        String str="Player Type: "+getType()+"\nHand:\n\n";

        for(int i=0; i< hand.size(); i++){
            str+=hand.get(i).getName()+"\n";
        }

        return str;
    }
}
