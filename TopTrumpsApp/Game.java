package TopTrumpsApp;

import jdk.nashorn.internal.scripts.JO;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.Serializable;
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
    private Color selectedColor = new Color(150,150,250,62);
    private Clip clip;
    private Clip loopClip;
    //private int roundWinnerIndex;

    public Game(ArrayList<Player> players, Deck deck, ArrayList<Card> middlePile, int result){
        setGameNumber();
        setPlayers(players);
        setMiddlePile(middlePile);
        setDeck(deck);
        setResult(result);
    }

    public void playClip(){
        try
        {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("TopTrumpsApp/sounds/whistle.wav")));   // learned from https://www.codeproject.com/Questions/1210248/Play-wav-file-in-java //
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);  // learned from https://stackoverflow.com/questions/953598/audio-volume-control-increase-or-decrease-in-java //
            gainControl.setValue(-10.0f);
            clip.start();
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

    public void playGameMusic(){
        try
        {
            loopClip = AudioSystem.getClip();
            loopClip.open(AudioSystem.getAudioInputStream(new File("TopTrumpsApp/sounds/gametheme.wav")));   // learned from https://www.codeproject.com/Questions/1210248/Play-wav-file-in-java //
            FloatControl gainControl = (FloatControl) loopClip.getControl(FloatControl.Type.MASTER_GAIN);  // learned from https://stackoverflow.com/questions/953598/audio-volume-control-increase-or-decrease-in-java //
            gainControl.setValue(-25.0f);
            loopClip.start();
            loopClip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

    public void startGame(){
        this.setTitle("Your Card");
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.panel=new JPanel();
        this.panel.setLayout(new BorderLayout());

        imageLabel = new JLabel();
        if(players.get(0)!=null)
            imageLabel.setIcon(new ImageIcon(players.get(0).getHand().get(0).getIcon().toString()));

        /*this.promptLabel = new JLabel("It's your turn.. call a stat and see if you can beat the CPU!");
        Font font = new Font("Serif",Font.BOLD,16);                                                    ---PROMPT/INSTRUCTIONS LABEL TO BE ADDED LATER---
        this.promptLabel.setFont(font);*/

        this.heightButton=new JButton();
        this.heightButton.setBounds(303,357,83,15);
        this.capsButton=new JButton();
        this.capsButton.setBounds(303,373,83,15);
        this.goalsButton=new JButton();
        this.goalsButton.setBounds(303,389,83,15);
        this.trophiesButton=new JButton();
        this.trophiesButton.setBounds(303,407,83,15);
        this.ratingButton=new JButton();
        this.ratingButton.setBounds(303,423,83,15);
        this.attackButton=new JButton();
        this.attackButton.setBounds(205,155,32,29);
        this.defenceButton=new JButton();
        this.defenceButton.setBounds(238,155,31,29);

        buttons = new JButton[]{heightButton,capsButton,goalsButton,trophiesButton,ratingButton,attackButton,defenceButton};

        for(int i=0; i<buttons.length; i++){
            this.buttons[i].setBorderPainted(false);
            this.buttons[i].setOpaque(false);
            this.buttons[i].setBackground(selectedColor);
            this.buttons[i].addMouseListener(this);
            this.imageLabel.add(buttons[i]);
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

    /*public int getRoundWinnerIndex() {
        return roundWinnerIndex;
    }

    public void setRoundWinnerIndex(int roundWinnerIndex) {
        this.roundWinnerIndex = roundWinnerIndex;
    }*/

    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        button.setOpaque(false);
        button.setBackground(selectedColor);
        panel.repaint();

        if (button == attackButton) {
            int confirmCall = JOptionPane.showConfirmDialog(null, "Do you wish to \"call\" the attack stat?");

            if (confirmCall == JOptionPane.YES_OPTION)
                processRound(1,"Attack: ");
        }
        if (button == defenceButton) {
            int confirmCall = JOptionPane.showConfirmDialog(null, "Do you wish to \"call\" the defence stat?");

            if (confirmCall == JOptionPane.YES_OPTION)
                processRound(2,"Defence: ");
        }
        if (button == heightButton) {
            int confirmCall = JOptionPane.showConfirmDialog(null, "Do you wish to \"call\" the height stat?");

            if (confirmCall == JOptionPane.YES_OPTION)
                processRound(3,"Height: ");
        }
        if (button == capsButton) {
            int confirmCall = JOptionPane.showConfirmDialog(null, "Do you wish to \"call\" the caps stat?");

            if (confirmCall == JOptionPane.YES_OPTION)
                processRound(4, "Caps: ");
        }
        if (button == goalsButton) {
            int confirmCall = JOptionPane.showConfirmDialog(null, "Do you wish to \"call\" the goals stat?");

            if (confirmCall == JOptionPane.YES_OPTION)
                processRound(5, "Goals: ");
        }
        if (button == trophiesButton) {
            int confirmCall = JOptionPane.showConfirmDialog(null, "Do you wish to \"call\" the trophies stat?");

            if (confirmCall == JOptionPane.YES_OPTION)
                processRound(6,"Trophies: ");
        }
        if (button == ratingButton) {
            int confirmCall = JOptionPane.showConfirmDialog(null, "Do you wish to \"call\" the rating stat?");

            if (confirmCall == JOptionPane.YES_OPTION)
                processRound(7,"TOP rating: ");
        }
    }

    public void processRound(int selectedStat, String call){
        int highest = players.get(0).getHand().get(0).getValueAtIndex(selectedStat);
        int winningPlayer=1;
        boolean isDraw=false;

        System.out.println(this.getGameNumber());

        players = isOut(players);

        for(int i=0; i<players.size(); i++)
            if(players.get(i)!=null)
                middlePile.add(players.get(i).getHand().get(0));

        String str="The cards currently in play are:\n\n";

        for(int i=0; i<middlePile.size(); i++)
            str+="Name: "+middlePile.get(i).getName()+" "+call+middlePile.get(i).getValueAtIndex(selectedStat)+"\n";

        JOptionPane.showMessageDialog(null,str,"Cards In Play",JOptionPane.INFORMATION_MESSAGE);

        for(int i=1; i<players.size(); i++){
            if(players.get(i).getHand().get(0).getValueAtIndex(selectedStat)==highest){
                isDraw=true;
                break;
            }
            if(players.get(i).getHand().get(0).getValueAtIndex(selectedStat)>highest){
                highest=players.get(i).getHand().get(0).getValueAtIndex(selectedStat);
                winningPlayer=(i+1);
            }
        }

        String winnersOriginalHand="Winners Original Hand:\n\n";

        for(int i=0; i<players.get(winningPlayer-1).getHand().size(); i++)
            winnersOriginalHand+=players.get(winningPlayer-1).getHand().get(i).getName()+"\n";

        for(int i=0; i<players.size(); i++)
            players.get(i).getHand().remove(0);

        if(!isDraw){
            JOptionPane.showMessageDialog(null,"Winner was player "+winningPlayer+" with "+call+highest,"Winner!",JOptionPane.INFORMATION_MESSAGE);

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

        String stateOfPlayers="";

        for(int i=0; i<players.size(); i++){
            stateOfPlayers+="Player "+(i+1)+" cards left: "+players.get(i).getHand().size()+"\n";
        }

        System.out.print(stateOfPlayers+"\n\n");

        ArrayList<Player> checkOut = isOut(players);

        if(checkOut.get(0).getType().toLowerCase().equals("human")){
            if(checkOut.size()!=1 && !isDraw){
                if((winningPlayer-1)==0){
                    middlePile.clear();
                    this.setPlayers(checkOut);
                    this.startGame();
                }
                else{
                    middlePile.clear();
                    this.setPlayers(checkOut);
                    this.startCPURound();
                }
            }
            else if(checkOut.size()!=1 && isDraw){
                if((winningPlayer-1)==0){
                    this.setPlayers(checkOut);
                    this.startGame();
                }
                else{
                    this.setPlayers(checkOut);
                    this.startCPURound();
                }
            }
            else{
                Player winner = null;
                String output = "The game is over!\n\n";

                for(Player p : checkOut){
                    if(p.getHand().size()==deck.getCards().size())
                        winner=p;
                }

                if(winner.getType().toLowerCase().equals("human")){
                    output+="You won! Congratulations!!";
                    JOptionPane.showMessageDialog(null,output,"You Won!",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    output+="The CPU wins this time. Unlucky.";
                    JOptionPane.showMessageDialog(null,output,"CPU Wins!",JOptionPane.ERROR_MESSAGE);
                }

                this.gameOver();
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"You have lost all of your cards!","Game Over!",JOptionPane.ERROR_MESSAGE);
            this.gameOver();
        }
    }

    public void startCPURound(){
        this.imageLabel.setIcon(new ImageIcon(players.get(0).getHand().get(0).getIcon().toString()));
        int randomNumber = (int)(Math.random()*((7-1)+1))+1;
        String call = "";

        if(randomNumber==1)
            call+="Attack: ";
        if(randomNumber==2)
            call+="Defence: ";
        if(randomNumber==3)
            call+="Height: ";
        if(randomNumber==4)
            call+="Caps: ";
        if(randomNumber==5)
            call+="Goals: ";
        if(randomNumber==6)
            call+="Trophies: ";
        if(randomNumber==7)
            call+="TOP Rating: ";

        JOptionPane.showMessageDialog(null,"CPU is now picking a stat\n\nCPU has called "+call);

        System.out.println("Stat index generated "+randomNumber);

        processRound(randomNumber,call);
    }

    public void gameOver(){
        int playAgain = JOptionPane.showConfirmDialog(null, "Would you like to play again");

        if (playAgain == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Now returning to the main menu so you can set up a new game of Top Trumps!", "Returning to Main Menu", JOptionPane.PLAIN_MESSAGE);
            new TopTrumpsMenu();
            this.loopClip.stop();
            this.loopClip.setFramePosition(0);
            this.loopClip.close();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Thanks for playing Top Trumps! See you again soon!", "Goodbye", JOptionPane.PLAIN_MESSAGE);
            this.loopClip.stop();
            this.loopClip.setFramePosition(0);
            this.loopClip.close();
            System.exit(0);
        }
    }

    public ArrayList<Player> isOut(ArrayList<Player> players){
        for(int i=0; i<players.size(); i++){
            if(players.get(i).getHand().size()==0){
                players.remove(i);
            }
        }
        return players;
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
