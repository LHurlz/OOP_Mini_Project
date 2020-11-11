package TopTrumps;

import javax.swing.*;

public class Card {
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

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber=" + cardNumber +
                ", name='" + name + '\'' +
                ", attack=" + attack +
                ", defence=" + defence +
                ", height=" + height +
                ", caps=" + caps +
                ", goals=" + goals +
                ", trophies=" + trophies +
                ", rating=" + rating +
                ", icon=" + icon +
                '}';
    }
}
