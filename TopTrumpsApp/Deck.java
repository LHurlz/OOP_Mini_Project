package TopTrumpsApp;
import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * An instantiable class that defines a Deck. This class contains methods for shuffling and dealing a Deck of cards.
 * @author Liam Hurley
 */

public class Deck implements Serializable {
    private int deckID=0;
    private int deckNumber;
    private String name;
    private ArrayList<TopTrumpsApp.Card> cards;
    private static final long serialVersionUID = 1;

    /**
     * Deck 2-argument constructor. Calls the 2 mutators and setDeckNumber() method to initialise the attributes
     * of a Deck object with some user-supplied values. The Deck ID is set internally using the value of a count
     * variable to ensure unique Deck ID values.
     * @param name the name of the Deck
     * @param cards an ArrayList of Cards stored inside the Deck object
     */

    public Deck(String name, ArrayList<TopTrumpsApp.Card> cards){
        setDeckNumber();
        setName(name);
        setCards(cards);
    }

    /**
     * Method to get the ID number of a Deck object.
     * @return an Integer value specifying the ID of a Deck object
     */

    public int getDeckNumber() {
        return deckNumber;
    }

    /**
     * Method to set the ID of a Deck object via incrementation of the static deckID count variable of the class.
     * Ensures every Deck object will have a unique ID value.
     */

    public void setDeckNumber() {
        deckID++;
        this.deckNumber = deckID;
    }

    /**
     * Method to get the name of a Deck object
     * @return a String a value specifying the name of the Deck object
     */

    public String getName() {
        return name;
    }

    /**
     * Method to set the name of a Deck object
     * @param name the name of the Deck object
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the cards of a Deck object
     * @return an ArrayList of Cards within the Deck object
     */

    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Method to set the cards of a Deck object
     * @param cards the cards inside a Deck object
     */

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /**
     * Method to shuffle a Deck object
     * @param deck the name of the Deck object to be shuffled
     * @return a Deck object which has been shuffled (cards rearranged into random positions in the ArrayList)
     */

    public Deck shuffle(Deck deck){
        ArrayList<Card> shuffledCards = new ArrayList<>(30);
        boolean alreadyPicked[] = new boolean[30];
        int randomNum;
        String output="";

        for(int i=0; i<30; i++){
            randomNum = (int)(Math.random()*30);

            while(alreadyPicked[randomNum])
                randomNum = (int)(Math.random()*30);            // MY OWN SHUFFLING METHOD, WRITTEN BEFORE LEARNING ABOUT COLLECTIONS.SHUFFLE() //

            alreadyPicked[randomNum]=true;

            shuffledCards.add(cards.get(randomNum));
            output+=shuffledCards.get(i)+"\n";
        }

        Deck shuffledDeck = new Deck("",shuffledCards);

        JOptionPane.showMessageDialog(null,"Shuffled deck is as follows:\n\n" +
                        output,
                "Shuffled Deck", JOptionPane.INFORMATION_MESSAGE);

        return shuffledDeck;
    }

    /**
     * Method to deal the cards of a Deck object to players in a Game object
     * @param shuffledDeck Deck object which has been shuffled
     * @param players ArrayList of Player objects inside a Game object
     * @return an ArrayList of Player objects with cards added to their "hands" so they maybe partake in a game
     * of Top Trumps.
     */

    public ArrayList<Player> deal(Deck shuffledDeck, ArrayList<Player> players){
        ArrayList<Card> p1Cards = new ArrayList<>(15);
        ArrayList<Card> p2Cards = new ArrayList<>(15);
        ArrayList<Card> p3Cards = new ArrayList<>(15);
        ArrayList<Card> p4Cards = new ArrayList<>(15);
        ArrayList<Card> p5Cards = new ArrayList<>(15);
        ArrayList<Card> p6Cards = new ArrayList<>(15);
        ArrayList<ArrayList<Card>> allCards = new ArrayList<>();
        allCards.add(p1Cards);
        allCards.add(p2Cards);
        allCards.add(p3Cards);
        allCards.add(p4Cards);
        allCards.add(p5Cards);
        allCards.add(p6Cards);

        int cpuPlayers=players.size()-1;

        if(cpuPlayers==1){
            for(int i=0; i<shuffledDeck.getCards().size(); i++){
                if(i<15){
                    p1Cards.add(shuffledDeck.getCards().get(i));
                }
                else if(i>14 && i<30)
                    p2Cards.add(shuffledDeck.getCards().get(i));
            }
        }
        else if(cpuPlayers==2){
            for(int i=0; i<shuffledDeck.getCards().size(); i++){
                if(i<10)
                    p1Cards.add(shuffledDeck.getCards().get(i));
                else if(i>9 && i<20)
                    p2Cards.add(shuffledDeck.getCards().get(i));
                else if(i>19 && i<30)
                    p3Cards.add(shuffledDeck.getCards().get(i));
            }
        }
        else if(cpuPlayers==3){
            for(int i=0; i<shuffledDeck.getCards().size(); i++){
                if(i<7)
                    p1Cards.add(shuffledDeck.getCards().get(i));
                else if(i>6 && i<14)
                    p2Cards.add(shuffledDeck.getCards().get(i));
                else if(i>13 && i<21)
                    p3Cards.add(shuffledDeck.getCards().get(i));
                else if(i>20 && i<28)
                    p4Cards.add(shuffledDeck.getCards().get(i));
            }
        }
        else if(cpuPlayers==4){
            for(int i=0; i<shuffledDeck.getCards().size(); i++){
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
        }
        else if(cpuPlayers==5){
            for(int i=0; i<shuffledDeck.getCards().size(); i++){
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
        }

        for(int i=0; i<players.size(); i++){
            if(players.get(i)!=null){
                players.get(i).setHand(allCards.get(i));
            }
        }

        return players;
    }

    /**
     * Method to get the state of a Deck object
     * @return a String value specifying the state of a Deck object
     */

    @Override
    public String toString() {

        String str="ID: "+getDeckNumber()+"  Name: "+getName();

        return str;

    }
}
