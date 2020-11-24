package TopTrumpsApp;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private String type;
    private ArrayList<Card> hand;
    private static final long serialVersionUID = 1;

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

        for(int i=0; i<hand.size(); i++){
            str+=hand.get(i).getName()+"\n";
        }

        return str;
    }
}
