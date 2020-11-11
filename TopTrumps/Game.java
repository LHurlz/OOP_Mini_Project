package TopTrumps;

import javax.swing.*;
import java.util.ArrayList;

public class Game {
    private static int gameID=0;
    private int gameNumber;
    private int players;
    private Deck deck;
    private int result;
    private ArrayList<Card> inMiddle;

    public Game(int players, Deck deck,ArrayList<Card> inMiddle){
        setGameNumber();
        setPlayers(players);
        setDeck(deck);
        setInMiddle(inMiddle);
        setResult(result);
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber() {
        gameID++;
        this.gameNumber = gameID;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public ArrayList<Card> getInMiddle() {
        return inMiddle;
    }

    public void setInMiddle(ArrayList<Card> inMiddle) {
        this.inMiddle = inMiddle;
    }

    public void createGame(int players, Deck deck, ArrayList<Card> inMiddle){
        int confirm = JOptionPane.showConfirmDialog(null,"Game Details:\n\n\nNumber of CPU players: "+players+"\n\nDeck: "+deck.getName()
                                     +"\n\n\nAre these details correct?");

        if(confirm==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"Now shuffling the deck before dealing");
            Deck shuffledDeck = deck.shuffle();

            ArrayList<Player> playersReady = shuffledDeck.deal(shuffledDeck,players);

            if(playersReady.size()==4){
                inMiddle.add(shuffledDeck.getCards().get(28));
                inMiddle.add(shuffledDeck.getCards().get(29));
            }
        }

        /*for(int i=0; i<inMiddle.size(); i++)
            if(inMiddle.get(i)!=null)                       --------TESTING IF INMIDDLE WORKS------- STATUS: WORKING
                System.out.println(inMiddle.get(i).toString());*/
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameNumber=" + gameNumber +
                ", players=" + players +
                ", deck=" + deck +
                ", result=" + result +
                ", inMiddle=" + inMiddle +
                '}';
    }
}
