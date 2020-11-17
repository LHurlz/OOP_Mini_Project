package TopTrumpsApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Game extends JFrame implements MouseListener{
    private static int gameID=0;
    private int gameNumber;
    private ArrayList<Player> players;
    private ArrayList<Card> middlePile;
    private Deck deck;
    private int result;
    JLabel imageLabel;
    JPanel panel;
    JLabel promptLabel;

    public Game(){
        this(null,null,null,0);
    }

    public Game(ArrayList<Player> players, Deck deck, ArrayList<Card> middlePile, int result){
        setGameNumber();
        setPlayers(players);
        setMiddlePile(middlePile);
        setDeck(deck);
        setResult(result);
    }

    public void createGame(){
        System.out.println("this is working!!");

        this.setTitle("Your Turn");
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout());

        this.imageLabel = new JLabel();
        this.imageLabel.setIcon(new ImageIcon(players.get(0).getHand().get(0).getIcon().toString()));

        this.promptLabel = new JLabel("It's your turn.. call a stat and see if you can beat the CPU!");
        Font font = new Font("Serif",Font.BOLD,16);
        this.promptLabel.setFont(font);

        this.panel=new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel,1));
        this.panel.add(this.imageLabel);
        this.panel.add(this.promptLabel);
        pane.add(this.panel);

        this.setVisible(true);

        System.out.println(middlePile.toString());
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

    public ArrayList<Card> getMiddlePile() {
        return middlePile;
    }

    public void setMiddlePile(ArrayList<Card> middlePile) {
        this.middlePile = middlePile;
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

    @Override
    public String toString() {
        String str="Game ID: "+getGameNumber()+"\n\nPlayers:\n\n";

        for(int i=0; i<players.size(); i++){
            if(players.get(i)!=null)
                str+=players.get(i).getType()+"\n\n";
        }

        str+="Deck :"+getDeck().getName()+"\n\nMiddle Pile:\n\n";



        return str;
    }
}
