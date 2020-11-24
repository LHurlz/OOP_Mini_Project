package TopTrumpsApp;

import javax.swing.*;
import java.io.Serializable;

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

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber() {
        cardID++;
        this.cardNumber = cardID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCaps() {
        return caps;
    }

    public void setCaps(int caps) {
        this.caps = caps;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

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

    public String toString() {
        return "ID: "+getCardNumber()+" Name: "+getName()+"  Attack:  "+getAttack()+"  Defence: "+getDefence()+"  Height: "+getHeight()+"cm  Caps: "+getCaps()+
                "  Goals: "+getGoals()+"  Trophies: "+getTrophies()+"  Rating: "+getRating();
    }
}
