package TopTrumps;

import java.util.ArrayList;

public class Game {
    private static int gameID=0;
    private int gameNumber;
    private int players;
    private Deck deck;
    private int result;
    private ArrayList<Card> inMiddle;

    public Game(int players, Deck deck, ArrayList<Card> inMiddle){
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

    public int newGame(int players, Deck deck, ArrayList<Card> inMiddle){
        System.out.println("dfdfs");

        return 1;
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
