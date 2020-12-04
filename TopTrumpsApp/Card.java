package TopTrumpsApp;

//Card.java

import javax.swing.*;
import java.io.Serializable;

/**
 * An instantiable class which defines a Card.  This class contains a method assigning each stat its own index value
 * so that it may be accessed when the corresponding button is clicked during a Game.
 * @author Liam Hurley
 */

public class Card implements Serializable {
    private static int cardID=0;
    private int cardNumber;
    private String name;
    private int attack;
    private int defence;
    private int height;
    private int caps;
    private int goals;
    private int trophies;
    private int rating;
    private ImageIcon icon;
    private static final long serialVersionUID = 1;

    /**
     * Card 9-argument constructor. Calls the 9 mutators and setCardNumber() method to initialise the attributes of a Card object.
     * The Card ID is set internally using the value of a count attribute called cardID to ensure unique Card ID values.
     * @param name the name of the card
     * @param attack the attack rating of the card
     * @param defence the defence rating of the card
     * @param height the height rating of the card
     * @param caps the caps rating of the card
     * @param goals the goals rating of the card
     * @param trophies the trophies rating of the card
     * @param rating the overall rating of the card
     * @param icon the associated image of the card
     */

    public Card(String name, int attack, int defence, int height, int caps, int goals, int trophies, int rating, ImageIcon icon){
        setCardNumber();
        setName(name);
        setAttack(attack);
        setDefence(defence);
        setHeight(height);
        setCaps(caps);
        setGoals(goals);
        setTrophies(trophies);
        setRating(rating);
        setIcon(icon);
    }

    /**
     * Card 8-argument constructor used for the creation of user-defined cards. Calls the 8 mutators setCardNumber() method to initialise
     * the attributes of a Card object with user supplied values. The Card ID is set internally using the value of a count attribute
     * called cardID to ensure unique Card ID values.
     * @param name the name of the card
     * @param attack the attack rating of the card
     * @param defence the defence rating of the card
     * @param height the height rating of the card
     * @param caps the caps rating of the card
     * @param goals the goals rating of the card
     * @param trophies the trophies rating of the card
     * @param rating the overall rating of the card
     */

    public Card(String name, int attack, int defence, int height, int caps, int goals, int trophies, int rating){
        setCardNumber();
        setName(name);
        setAttack(attack);
        setDefence(defence);
        setHeight(height);
        setCaps(caps);
        setGoals(goals);
        setTrophies(trophies);
        setRating(rating);
    }

    /**
     * Method to get the Card ID of a Card object
     * @return an Integer value specifying the ID of a Card object
     */

    public int getCardNumber() {
        return cardNumber;
    }

    /**
     * Method to set the ID of a Card object via incrementation of cardID counter variable
     */

    public void setCardNumber() {
        cardID++;
        this.cardNumber = cardID;
    }

    /**
     * JB - Method to get the static Card ID of all Card objects
     * @return an Integer value specifying the static ID of all Card objects
     */

    public static int getCardID() {
        return cardID;
    }

    /**
     * JB - Method to set the static ID value of all Card objects - needed to allow values to be
     * read/written from/to file successfully
     * @param cardID the ID of the Card object.
     */

    public static void setCardID(int cardID) {
        Card.cardID = cardID;
    }

    /**
     * Method to get the name of a Card object
     * @return a String value specifying the name of a Card object
     */

    public String getName() {
        return name;
    }

    /**
     * Method to set the name of a Card object
     * @param name the name of the Card
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the attack rating of a Card object
     * @return an Integer value specifying the attack rating of a Card
     */

    public int getAttack() {
        return attack;
    }

    /**
     * Method to set the attack rating of a Card object
     * @param attack the attack rating of the Card
     */

    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Method to get the defence rating of a Card object
     * @return an Integer value specifying the defence rating of a Card
     */

    public int getDefence() {
        return defence;
    }

    /**
     * Method to set the defence rating of a Card object
     * @param defence the defence rating of the Card
     */

    public void setDefence(int defence) {
        this.defence = defence;
    }

    /**
     * Method to get the height rating of a Card object
     * @return an Integer value specifying the height rating of a Card
     */

    public int getHeight() {
        return height;
    }

    /**
     * Method to set the height rating of a Card object
     * @param height the height rating of the Card
     */

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Method to get the caps rating of a Card object
     * @return an Integer value specifying the caps rating of a Card
     */

    public int getCaps() {
        return caps;
    }

    /**
     * Method to set the caps rating of a Card object
     * @param caps the caps rating of the Card
     */

    public void setCaps(int caps) {
        this.caps = caps;
    }

    /**
     * Method to get the goals rating of a Card object
     * @return an Integer value specifying the goals rating of a Card
     */

    public int getGoals() {
        return goals;
    }

    /**
     * Method to set the goals rating of a Card object
     * @param goals the goals rating of the Card
     */

    public void setGoals(int goals) {
        this.goals = goals;
    }

    /**
     * Method to get the trophies rating of a Card object
     * @return an Integer value specifying the trophies rating of a Card
     */

    public int getTrophies() {
        return trophies;
    }

    /**
     * Method to set the trophies rating of a Card object
     * @param trophies the trophies rating of the Card
     */

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }

    /**
     * Method to get the overall rating of a Card object
     * @return an Integer value specifying the overall rating of a Card
     */

    public int getRating() {
        return rating;
    }

    /**
     * Method to set the overall rating of a Card object
     * @param rating the overall rating of the Card
     */

    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Method to get the ImageIcon of a Card object
     * @return an ImageIcon value specifying the ImageIcon of a Card
     */

    public ImageIcon getIcon() {
        return icon;
    }

    /**
     * Method to set the ImageIcon of a Card object
     * @param icon the ImageIcon of the Card
     */

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    /**
     * Method to get the value of a certain stat based on the index number passed into the method.
     * Each stat is assigned it's own "index" value so that if it is selected in the game it may be returned
     * for comparison via this method
     * @param index the index value of the accessor
     * @return an Integer value containing the selected stat's value
     */

    //Inspiration for following method from https://github.com/ambidextrous/TopTrumps/blob/master/TeamATopTrumps/src/Card.java

    public int getValueAtIndex(int index){

        switch (index){
            case 1:
                return getAttack();
            case 2:
                return getDefence();
            case 3:
                return getHeight();
            case 4:
                return getCaps();
            case 5:
                return getGoals();
            case 6:
                return getTrophies();
            case 7:
                return getRating();
        }

        return -1;
    }

    /**
     * Method to get the state of a Card object
     * @return a String value specifying the state of a Card object
     */

    public String toString() {
        return "ID: "+getCardNumber()+" Name: "+getName()+"  Attack:  "+getAttack()+"  Defence: "+getDefence()+"  Height: "+getHeight()+"cm  Caps: "+getCaps()+
                "  Goals: "+getGoals()+"  Trophies: "+getTrophies()+"  Rating: "+getRating();
    }
}
