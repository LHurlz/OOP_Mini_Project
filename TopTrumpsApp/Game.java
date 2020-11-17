package TopTrumpsApp;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Game extends JFrame implements MouseListener{
    private static int gameID=0;
    private int gameNumber;
    private ArrayList<Player> players;
    private ArrayList<Card> middlePile;
    private Deck deck;
    private int result;
    private JLabel imageLabel;
    private JPanel panel;
    private JLabel promptLabel;
    private JButton attackButton;
    private JButton defenceButton;
    private JButton heightButton;
    private JButton capsButton;
    private JButton goalsButton;
    private JButton trophiesButton;
    private JButton ratingButton;
    private JButton[] buttons;
    Color selectedColor = new Color(150,150,250,62);

    public Game(ArrayList<Player> players, Deck deck, ArrayList<Card> middlePile, int result){
        setGameNumber();
        setPlayers(players);
        setMiddlePile(middlePile);
        setDeck(deck);
        setResult(result);
    }

    public void startGame(){
        this.setTitle("Your Turn");
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.panel=new JPanel();
        this.panel.setLayout(new BorderLayout());

        imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(players.get(0).getHand().get(0).getIcon().toString()));

        /*this.promptLabel = new JLabel("It's your turn.. call a stat and see if you can beat the CPU!");
        Font font = new Font("Serif",Font.BOLD,16);                                                    ---PROMPT/INSTRUCTIONS LABEL TO BE ADDED LATER---
        this.promptLabel.setFont(font);*/

        this.heightButton=new JButton();
        this.heightButton.setBounds(300,357,83,15);
        this.capsButton=new JButton();
        this.capsButton.setBounds(300,372,83,15);
        this.goalsButton=new JButton();
        this.goalsButton.setBounds(300,389,83,15);
        this.trophiesButton=new JButton();
        this.trophiesButton.setBounds(300,406,83,15);
        this.ratingButton=new JButton();
        this.ratingButton.setBounds(300,423,83,15);
        this.attackButton=new JButton();
        this.attackButton.setBounds(200,150,31,30);
        this.defenceButton=new JButton();
        this.defenceButton.setBounds(232,150,32,30);

        buttons = new JButton[]{heightButton,capsButton,goalsButton,trophiesButton,ratingButton,attackButton,defenceButton};

        for(int i=0; i<buttons.length; i++){
            buttons[i].setBorderPainted(false);
            buttons[i].setOpaque(false);
            buttons[i].setBackground(selectedColor);
            buttons[i].addMouseListener(this);
            imageLabel.add(buttons[i]);
        }

        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.panel.add(imageLabel,BorderLayout.CENTER);

        //this.panel.add(this.promptLabel);
        //pane.add(this.panel);

        this.setResizable(false);
        this.setContentPane(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

    /*public boolean isWinner(ArrayList<Player> players){
        for(int i=0; i<players.size(); i++){
            if(players.get(i).getHand().size()==30){
                return true;
            }
        }
        return false;
    }

    public void processRound(attribute){
        selectedStat = attribute;
    }*/

    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton)e.getSource();
        button.setOpaque(false);
        button.setBackground(selectedColor);
        panel.repaint();

        if(button==heightButton){
            int confirmCall = JOptionPane.showConfirmDialog(null,"Do you wish to \"call\" the height stat?");

            if(confirmCall==JOptionPane.YES_OPTION){
                //how to get all the following into one method.. processRound();?

                int highest=players.get(0).getHand().get(0).getHeight();
                int winningPlayer=1;
                boolean isDraw=false;

                for(int i=0; i<players.size(); i++)
                    middlePile.add(players.get(i).getHand().get(0));

                String str="The cards currently in play are:\n\n";

                for(int i=0; i<middlePile.size(); i++)
                    str+="Name: "+middlePile.get(i).getName()+"   Height: "+middlePile.get(i).getHeight()+"\n";

                JOptionPane.showMessageDialog(null,str,"Cards In Play",JOptionPane.INFORMATION_MESSAGE);

                for(int i=1; i<players.size(); i++){
                    if(players.get(i).getHand().get(0).getHeight()==highest){
                        isDraw=true;
                        break;
                    }
                    if(players.get(i).getHand().get(0).getHeight()>highest){
                        highest=players.get(i).getHand().get(0).getHeight();
                        winningPlayer=(i+1);
                    }
                }

                String winnersOriginalHand="Winners Original Hand:\n\n";

                for(int i=0; i<players.get(winningPlayer-1).getHand().size(); i++)
                    winnersOriginalHand+=players.get(winningPlayer-1).getHand().get(i).getName()+"\n";

                for(int i=0; i<players.size(); i++)
                    players.get(i).getHand().remove(0);

                if(!isDraw){
                    JOptionPane.showMessageDialog(null,"Winner was player "+winningPlayer+" with stat: "+highest,"Winner!",JOptionPane.INFORMATION_MESSAGE);

                    for(int i=0; i<middlePile.size(); i++)
                    players.get(winningPlayer-1).getHand().add(middlePile.get(i));

                    String newHand="\n\nWinning players new hand:\n\n";

                    for(int i=0; i<players.get(winningPlayer-1).getHand().size(); i++)
                        newHand+=players.get(winningPlayer-1).getHand().get(i).getName()+"\n";

                    JOptionPane.showMessageDialog(null,winnersOriginalHand+newHand,"Winners New Hand",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    String newHand="Your hand is now..\n";

                    for(int i=0; i<players.get(0).getHand().size(); i++){
                        newHand+=players.get(0).getHand().get(i).getName()+"\n";
                    }

                    newHand+="\nCurrent state of middle pile...\n\n";

                    for(int i=0; i<middlePile.size(); i++)
                       newHand+=middlePile.get(i).getName()+"\n";

                    JOptionPane.showMessageDialog(null,"Round was a draw!\n\n"+newHand,"Round Drawn!",JOptionPane.INFORMATION_MESSAGE);
                }

                //check if game is won
                //check if a player is "out" - has 0 cards in hand
                //use current players, middlePile etc to play a new round
                //use counter to determine if CPU or Human turn?
            }
        }
        if(button==capsButton){
            System.out.println("caps selected");
        }
    }

    public void mouseEntered(MouseEvent e) {
        JButton button = (JButton)e.getSource();
        button.repaint();
        button.setOpaque(true);
        button.setBackground(selectedColor);
        panel.repaint();
    }

    public void mouseExited(MouseEvent e) {
        JButton button = (JButton)e.getSource();
        button.repaint();
        button.setOpaque(false);
        panel.repaint();
    }

    public void mousePressed(MouseEvent e){
        JButton button = (JButton)e.getSource();
        button.setOpaque(true);
        button.setBackground(selectedColor);
        panel.repaint();
        button.repaint();
    }

    public void mouseReleased(MouseEvent e){}

    public String toString() {
        String str="Game ID: "+getGameNumber()+"\n\nPlayers:\n\n";

        for(int i=0; i<players.size(); i++){
            if(players.get(i)!=null)
                str+=players.get(i).getType()+"\n";
        }

        str+="\n\nDeck :"+getDeck().getName()+"\n\nMiddle Pile:\n\n";

        for(int i=0; i< middlePile.size(); i++){
            if(middlePile.get(i)!=null)
                str+=middlePile.get(i).getName()+"\n";
        }

        return str;
    }
}
