package TopTrumps;

import TopTrumps.Card;
import TopTrumps.Deck;
import TopTrumps.Player;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Game {
    private static int gameID=0;
    private int gameNumber;
    private ArrayList<Player> players;
    private Deck deck;
    private int result;
    private ArrayList<Card> inMiddle;

    public Game(ArrayList<Player> players, Deck deck,ArrayList<Card> inMiddle){
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

            this.setDeck(shuffledDeck);
            this.setPlayers(playersReady);
            JOptionPane.showMessageDialog(null,"Now starting game "+gameNumber+" of Top Trumps! Good luck!");
            //System.out.println(players.get(0).toString());
            JOptionPane.showMessageDialog(null,"You are first! Get ready to select a stat...");

            //Round round = new Round(inMiddle,playersReady);
        }

        /*for(int i=0; i<inMiddle.size(); i++)
            if(inMiddle.get(i)!=null)                       --------TESTING IF INMIDDLE WORKS------- STATUS: WORKING
                System.out.println(inMiddle.get(i).toString());*/

        //System.out.println(this.getGameNumber()+"\n"+this.getPlayers());
    }

    public void viewTopCard(int gameNumber, ArrayList<Player> players, Deck deck, ArrayList<Card> inMiddle){
        JFrame frame = new JFrame("Your Turn... Select a Stat!");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(new BorderLayout());

        JLabel imageLabel=new JLabel("");
        ImageIcon topCard = new ImageIcon(players.get(0).getHand().get(0).getIcon().toString());
        imageLabel.setIcon(topCard);

        JButton heightButton = new JButton();
        heightButton.setBounds(300,351,83,15);
        heightButton.setName("\"Height\"");
        JButton capsButton = new JButton();
        capsButton.setBounds(300,367,83,15);
        capsButton.setName("\"Caps\"");
        JButton goalsButton = new JButton();
        goalsButton.setBounds(300,383,83,15);
        goalsButton.setName("\"Goals\"");
        JButton trophiesButton = new JButton();
        trophiesButton.setBounds(300,399,83,15);
        trophiesButton.setName("\"Trophies\"");
        JButton ratingButton = new JButton();
        ratingButton.setBounds(300,415,83,15);
        ratingButton.setName("\"Rating\"");
        JButton attackButton = new JButton();
        attackButton.setBounds(200,150,31,30);
        attackButton.setName("\"Attack\"");
        JButton defenceButton = new JButton();
        defenceButton.setBounds(232,150,32,30);
        defenceButton.setName("\"Defence\"");
        JButton[] buttons = {heightButton,capsButton,goalsButton,trophiesButton,ratingButton,attackButton,defenceButton};

        Color selectedColor = new Color(150,150,250,62);

        for(int i=0; i<buttons.length; i++){
            buttons[i].setBorderPainted(false);
            buttons[i].setOpaque(false);
            buttons[i].setBackground(selectedColor);
            imageLabel.add(buttons[i]);
            int finalI = i;
            buttons[i].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    buttons[finalI].setOpaque(false);

                    int confirm = JOptionPane.showConfirmDialog(null,"sure");

                    if(confirm==JOptionPane.YES_OPTION){
                        JButton selectedStat = (JButton)e.getSource();
                        String selectedStatName = selectedStat.getName();
                        imageLabel.hide();
                        int winningPlayer=1;

                        if(selectedStatName.toLowerCase().contains("height")){
                            int highest = players.get(0).getHand().get(0).getHeight();


                            for(int i=1; i<players.size(); i++){
                                if(players.get(i).getHand().get(0).getHeight()>highest){
                                    highest=players.get(i).getHand().get(0).getHeight();
                                    winningPlayer=(i+1);
                                }
                            }

                            System.out.println("Winner was player "+winningPlayer+" with stat "+highest);
                        }

                        for(int j=0; j<players.size(); j++){
                            inMiddle.add(players.get(j).getHand().get(0));
                        }


                        for(int k=0; k<inMiddle.size();k++){
                            //if(){
                                players.get(winningPlayer-1).getHand().add(inMiddle.get(k));
                            //}
                        }

                        System.out.println("Winners hand is now: \n\n"+players.get(winningPlayer-1).toString());

                    }
                }

                public void mouseEntered(MouseEvent e) {
                    panel.repaint(); //necessary to prevent the painting problems encountered (stick one in each method)
                    Color selectedColor = new Color(150,150,250,62);
                    buttons[finalI].setOpaque(true);
                    buttons[finalI].setBackground(selectedColor);
                }

                public void mouseExited(MouseEvent e) {
                    buttons[finalI].setOpaque(false);
                    panel.repaint();
                }
            });

        }

        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        imageLabel.setBounds(0,0, topCard.getIconWidth(), topCard.getIconHeight());
        imageLabel.setPreferredSize(new Dimension(topCard.getIconWidth(),topCard.getIconHeight()));
        frame.setContentPane(panel);


        panel.add(imageLabel);
        frame.setSize(600,600);
        frame.setVisible(true);
    }

    public boolean isWinner(){
        return false;
    }


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
