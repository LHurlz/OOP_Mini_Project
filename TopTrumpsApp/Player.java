package TopTrumpsApp;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * An instantiable class which defines a Player.
 * @author Liam Hurley
 */

public class Player implements Serializable {
    private String type;
    private ArrayList<Card> hand;
    private static final long serialVersionUID = 1;

    /**
     * Player 2-argument constructor.  Calls the 2 mutators to initialise the attributes of a Player object.
     * @param type the type of Player, either Human or CPU
     * @param hand the Player object's hand (ArrayList of Card objects)
     */

    public Player(String type,ArrayList<Card> hand){
        setType(type);
        setHand(hand);
    }

    /**
     * Method to get the type of a Player object
     * @return a String value specifying the type of a Player object
     */

    public String getType() {
        return type;
    }

    /**
     * Method to set the type of a Player object
     * @param type the type of the Player
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Method to get the hand of a Player object
     * @return an ArrayList of Card objects which make up the hand of a Player
     */

    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Method to set the hand of a Player object
     * @param hand the hand of a Player
     */

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    /**
     * Method to get the state of a Player object
     * @return a String value specifying the state of a Player object.
     */

    @Override
    public String toString() {
        String str="Player Type: "+getType()+"\nHand:\n\n";

        for(int i=0; i<hand.size(); i++){
            str+=hand.get(i).getName()+"\n";
        }

        return str;
    }
}
