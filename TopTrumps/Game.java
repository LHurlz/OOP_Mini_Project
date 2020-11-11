package TopTrumps;

import java.util.ArrayList;

public class Game {
    private static int gameID=0;
    private int gameNumber;
    private ArrayList<Player> players;
    private Deck deck;
    private int result;
    private ArrayList<Card> inMiddle;

    public Game(ArrayList<Player> players, Deck deck, ArrayList<Card> inMiddle){
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

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
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
}
