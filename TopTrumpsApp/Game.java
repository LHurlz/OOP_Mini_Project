package TopTrumpsApp;

//Game.java

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;

/**
 * An instantiable class which defines a Game.  This class contains methods that allow games of top trumps to
 * be played and serialized.  It also implements the MouseListener interface to handle MouseEvents on JButtons.
 * @author Liam Hurley
 */

public class Game extends JFrame implements MouseListener, Serializable{
    private static int gameID=0;
    private int gameNumber;
    private String mode;
    private ArrayList<Player> players;
    private ArrayList<Card> middlePile;
    private Deck deck;
    private String result;
    private JLabel imageLabel;
    private JPanel panel;
    private JButton attackButton;
    private JButton defenceButton;
    private JButton heightButton;
    private JButton capsButton;
    private JButton goalsButton;
    private JButton trophiesButton;
    private JButton ratingButton;
    private JButton[] buttons;
    private final Color selectedColor = new Color(150,150,250,62);
    private int startingPlayers;
    private ArrayList<String> finishedGames=new ArrayList<>();
    private static final long serialVersionUID = 1;
    private Clip whistleClip;
    private Clip themeClip;

    /**
     * Game 5-argument constructor.  Calls 5 mutators to initialise the attributes of a Game object with some user supplied values.
     * The state of the middle pile is determined by the number of players.  It is always set to 0 unless there are 4 total players in
     * which case 2 cards begin in the middle pile.  The Game Number is set internally via a call to setGameNumber() which increments a
     * counter.
     * @param mode the game mode selected by the player
     * @param players a list of players in the game
     * @param startingPlayers total amount of players at the beginning of the game
     * @param deck deck selected by the player
     * @param middlePile list containing cards in the middle pile at the start of the game
     */

    public Game(String mode, ArrayList<Player> players, int startingPlayers, Deck deck, ArrayList<Card> middlePile){
        setGameNumber();
        setMode(mode);
        setPlayers(players);
        setMiddlePile(middlePile);
        setDeck(deck);
        setStartingPlayers(startingPlayers);
        this.openGame();
        this.playWhistleClip();
        this.playThemeClip();
    }

    /**
     * Method to get list of games that have been completed and stored in a data file.
     * @return ArrayList of String values containing information about completed games.
     */

    public ArrayList<String> getFinishedGames() {
        return finishedGames;
    }

    /**
     * Method to set the list of finished games.
     * @param finishedGames the list of the finished games.
     */

    public void setFinishedGames(ArrayList<String> finishedGames) {
        this.finishedGames = finishedGames;
    }

    /**
     * Method to play an audio clip signalling the beginning of a Game.
     * Contains exception-handling code.
     */

    public void playWhistleClip(){
        try
        {
            whistleClip = AudioSystem.getClip();
            whistleClip.open(AudioSystem.getAudioInputStream(new File("TopTrumpsApp/sounds/whistle.wav"))); // audio sourced from https://www.youtube.com/watch?v=CgTc_-A_Gzw
            FloatControl gainControl = (FloatControl) whistleClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);       //   setting volume 25dB lower than default   //
            whistleClip.setFramePosition(50000);       //    setting frame position of clip due to silence in first 1-2 seconds of file  //
            whistleClip.start();
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

    /**
     * Method to play an audio clip that will provide background music for the Game.
     * Contains exception-handling code.
     */

    public void playThemeClip(){
        try
        {
            themeClip = AudioSystem.getClip();
            themeClip.open(AudioSystem.getAudioInputStream(new File("TopTrumpsApp/sounds/gametheme.wav"))); // audio sourced from https://www.youtube.com/watch?v=_8DN1vbnjMk
            FloatControl gainControl = (FloatControl) themeClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);       //   setting volume 25dB lower than default   //
            themeClip.start();
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

    /**
     * Method to start a game of Top Trumps and every subsequent round in which it is the human player's turn.  Method begins with a check to
     * determine if the game has been "won" or not before creating a GUI containing the player's top card and adding
     * buttons for stat selection.
     */

    public void startGame(){
        for(Player p : players){
            if(p.getHand().size()==30 && p.getType().equals("Human")){
                this.setResult("Human");
                JOptionPane.showMessageDialog(null,"You won! Congratulations!!","You Won!",JOptionPane.INFORMATION_MESSAGE);
                this.gameOver();
            }
            else if(p.getHand().size()==30 && p.getType().equals("CPU")){
                this.setResult("CPU");
                this.gameOver();
            }
        }

        this.setTitle("Your Card");
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.panel=new JPanel();
        this.panel.setLayout(new BorderLayout());

        imageLabel = new JLabel();
        if(players.get(0)!=null)
            imageLabel.setIcon(new ImageIcon(players.get(0).getHand().get(0).getIcon().toString()));

        this.heightButton=new JButton();
        this.heightButton.setBounds(303,357,83,15);
        this.capsButton=new JButton();
        this.capsButton.setBounds(303,373,83,15);
        this.goalsButton=new JButton();
        this.goalsButton.setBounds(303,389,83,15);
        this.trophiesButton=new JButton();
        this.trophiesButton.setBounds(303,406,83,15);
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

        this.setResizable(false);
        this.setContentPane(panel);
        this.setVisible(true);
        JOptionPane.showMessageDialog(null,"It's your turn!\n\nPick a stat and try to beat the computer!\n\nYou have " +
                players.get(0).getHand().size()+" cards remaining!","Your Turn",JOptionPane.QUESTION_MESSAGE);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Method to get the mode of a game object
     * @return a String value specifying the selected game mode
     */

    public String getMode() {
        return mode;
    }

    /**
     * Method to set the mode of a game object
     * @param mode the selected game mode
     */

    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Method to get the unique game number of a Game object
     * @return an Integer value specifying the game number
     */

    public int getGameNumber() {
        return gameNumber;
    }

    /**
     * Method to set the game number of a game object by incrementing a gameID which acts as a count variable
     * Ensures Game object will have a unique value
     */

    public void setGameNumber() {
        gameID++;
        this.gameNumber = gameID;
    }

    /**
     * JB - Method to get the static game ID of all Game objects
     * @return an Integer value specifying the static game ID value
     */

    public static int getGameID() {
        return gameID;
    }

    /**
     * JB - Method to set the static game ID of all Game objects, needed to allow values to be
     * read/written from/to file successfully
     * @param gameID the ID of the Game object.
     */

    public static void setGameID(int gameID) {
        Game.gameID = gameID;
    }

    /**
     * Method to get the players in a Game object
     * @return an ArrayList of Player containing the players involved
     */

    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Method to set the players in a Game object
     * @param players the players in a Game object
     */

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Method to get the cards in the middle pile of a Game object
     * @return an ArrayList of Card inside the middle pile
     */

    public ArrayList<Card> getMiddlePile() {
        return middlePile;
    }

    /**
     * Method to set the middle pile of a Game object
     * @param middlePile the middle pile of cards of a Game object
     */

    public void setMiddlePile(ArrayList<Card> middlePile) {
        this.middlePile = middlePile;
    }

    /**
     * Method for retrieving the deck of a Game object
     * @return a Deck object containing the details of the selected deck
     */

    public Deck getDeck() {
        return deck;
    }

    /**
     * Method for setting the deck of a Game object
     * @param deck the Deck object being used in the Game object
     */

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * Method for retrieving the result of a Game object
     * @return a String value specifying the result of a Game object
     */

    public String getResult() {
        return result;
    }

    /**
     * Method for setting the result of a Game object
     * @param result the result of a Game object
     */

    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Method for retrieving the amount of players at the beginning of a new Game object
     * @return an Integer value specifying the amount of starting players
     */

    public int getStartingPlayers() {
        return startingPlayers;
    }

    /**
     * Method for setting the amount of starting players of a Game object
     * @param startingPlayers the amount of starting players
     */

    public void setStartingPlayers(int startingPlayers) {
        this.startingPlayers = startingPlayers;
    }

    /**
     * Method for processing a round of Top Trumps.
     * The method begins by evaluating which stat has been selected via a call to getValueAtIndex(int).
     * Once the selected stat has been determined, the human player's selected stat is set as the "highest".
     * A check is then made to see if any players have 0 cards via a call to isOut(), if a player
     * has 0 cards this method will remove them from the game before the round begins.
     * processRound() will then determine the result of the round and distribute the cards "in-play" to the winning
     * player, or leave all cards in the middle pile if the round was drawn.
     * Finally checks are made to see if any players are out or if the game is over.
     * @param selectedStat the index value of the selected stat
     * @param call the name of "called" stat
     */

    public void processRound(int selectedStat, String call){
        int highest = players.get(0).getHand().get(0).getValueAtIndex(selectedStat);
        int winningPlayer=1;
        boolean isDraw=false;

        players = isOut(players);

        for (Player player : players)
            if (player != null)
                middlePile.add(player.getHand().get(0));

        String str="The cards currently in play are:\n\n";

        for(int i=0; i<middlePile.size(); i++)
            str+="Player "+(i+1)+"  Name: "+middlePile.get(i).getName()+" "+call+": "+middlePile.get(i).getValueAtIndex(selectedStat)+"\n";

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

        String winnerString="";

        if((winningPlayer-1)==0){
            winnerString+="You Won!\n\nYou have gained the following cards from the other players:\n\n";

            for(int i=1; i< middlePile.size(); i++){
                winnerString+=middlePile.get(i).getName()+"\n";
            }
        }
        else{
            winnerString+="CPU Player "+winningPlayer+" won.\n\nThey acquired the following cards (including their own):\n\n";

            for(Card card : middlePile) {
                winnerString += card.getName() + "\n";
            }
        }

        for (Player player : players)
            player.getHand().remove(0);

        if(!isDraw){
            for (Card card : middlePile)
                players.get(winningPlayer - 1).getHand().add(card);

            JOptionPane.showMessageDialog(null,winnerString,"Winners New Hand",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            String drawString="Round was drawn! All cards remain in the middle pile!\nThe cards remaining in your hand are:\n\n";

            for(int i=0; i<players.get(0).getHand().size(); i++){
                drawString+=players.get(0).getHand().get(i).getName()+"\n";
            }

            drawString+="\nCards in middle pile\n\n";

            for (Card card : middlePile)
                drawString += card.getName() + "\n";

            JOptionPane.showMessageDialog(null,drawString,"Round Drawn!",JOptionPane.INFORMATION_MESSAGE);
        }

        ArrayList<Player> checkOut = isOut(players);

        if(checkOut.get(0).getType().toLowerCase().equals("human")){
            if(checkOut.size()!=1 && !isDraw){
                middlePile.clear();
                this.setPlayers(checkOut);

                if(this.getMode().toLowerCase().equals("traditional") && (winningPlayer-1)!=0)
                    this.startCPURound();
                else
                    this.startGame();
            }
            else if(checkOut.size()!=1 && isDraw){
                this.setPlayers(checkOut);

                if(this.getMode().toLowerCase().equals("traditional") && (winningPlayer-1)!=0)
                    this.startCPURound();
                else
                    this.startGame();
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
                    this.setResult("Human");
                }
                this.gameOver();
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"You have lost all of your cards!","Game Over!",JOptionPane.ERROR_MESSAGE);
            this.setResult("CPU");
            this.gameOver();
        }
    }

    /**
     * Method for starting a round of Top Trumps where it is the CPU's turn to select a stat
     * Random number between 1 and 7 inclusive generated to be used as an index value and passed through to processRound()
     * along with corresponding name of index value
     */

    public void startCPURound(){
        this.imageLabel.setIcon(new ImageIcon(players.get(0).getHand().get(0).getIcon().toString()));
        int randomNumber = (int)(Math.random()*((7-1)+1))+1;
        String call = "";

        if(randomNumber==1)
            call+="Attack";
        if(randomNumber==2)
            call+="Defence";
        if(randomNumber==3)
            call+="Height";
        if(randomNumber==4)
            call+="Caps";
        if(randomNumber==5)
            call+="Goals";
        if(randomNumber==6)
            call+="Trophies";
        if(randomNumber==7)
            call+="TOP Rating";

        JOptionPane.showMessageDialog(null,"CPU is now picking a stat\n\nCPU has called "+call);

        processRound(randomNumber,call);
    }

    /**
     * Method called when Game object is deemed to be over. Makes call to saveGame() to save desired details of
     * the Game object before asking the user if they wish to play again or exit the application.
     */

    public void gameOver() {
        this.saveGame();

        int playAgain = JOptionPane.showConfirmDialog(null, "Would you like to play again");

        if (playAgain == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "The results of the game have been successfully saved.\nCheck out the \"View History\" button on the main menu to see!\n\n" +
                    "Now returning to the main menu so you can set up a new game of " +
                    "Top Trumps!", "Returning to Main Menu", JOptionPane.PLAIN_MESSAGE);
            whistleClip.close();
            themeClip.close();
            new TopTrumpsMenu();
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "Thanks for playing Top Trumps! See you again soon!", "Goodbye", JOptionPane.PLAIN_MESSAGE);
            whistleClip.close();
            themeClip.close();
            this.dispose();
            System.exit(0);
        }
    }

    /**
     * Method for opening input stream to allow serialization of Game objects
     */

    public void openGame(){
        try{
            ObjectInputStream objectInStream2 = new ObjectInputStream(new FileInputStream("TopTrumpsApp/game_history.data"));
            finishedGames  = (ArrayList)objectInStream2.readObject();
            objectInStream2.close();
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
            JOptionPane.showMessageDialog(null,"You have not played any games yet!",
                    "No Games Played!",JOptionPane.ERROR_MESSAGE);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null,"File could not be read!",
                    "Problem Writing to File!",JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            JOptionPane.showMessageDialog(null,"Could not convert object to the appropriate class!","Problem Converting Object Read " +
                    "From File!",JOptionPane.ERROR_MESSAGE);

        }
        catch (ClassCastException cce) {
            cce.printStackTrace();
            JOptionPane.showMessageDialog(null,"Could not convert the object to the appropriate class!","Problem Converting " +
                    "Object!",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Method for serializing a Game object.  Desired information is obtained through use of this reference and accessor methods before being added
     * to an ArrayList of String values which is then written to a data file.
     */

    public void saveGame(){
        try {
            ObjectOutputStream objectOutStream = new ObjectOutputStream(new FileOutputStream("TopTrumpsApp/game_history.data"));

            finishedGames.add("Game Number: "+ this.getGameNumber()+"  ");
            finishedGames.add("Mode: "+ this.getMode()+"  ");
            finishedGames.add("Players: " + this.getStartingPlayers()+"  ");
            finishedGames.add("Winner: "+ this.getResult());
            finishedGames.add("\n");

            objectOutStream.writeObject(finishedGames);

            objectOutStream.close();
        }
        catch(FileNotFoundException fnfe){
            System.out.println(fnfe.getStackTrace());
            JOptionPane.showMessageDialog(null,"File could not be found!",
                    "Problem Finding File!",JOptionPane.ERROR_MESSAGE);
        }
        catch(IOException ioe){
            System.out.println(ioe.getStackTrace());
            JOptionPane.showMessageDialog(null,"File could not be written!",
                    "Problem Writing to File!",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Method for determining whether or not a player is "out" of a Game object
     * For loop used to check if any current players have 0 cards, if so they are then removed from the ArrayList of Players
     * that was initially passed into the method.
     * @param players the players currently partaking in the Game object
     * @return an ArrayList of Player containing only players who still have 1 or more cards in their hand.
     */

    public ArrayList<Player> isOut(ArrayList<Player> players){
        for(int i=0; i<players.size(); i++){
            if(players.get(i).getHand().size()==0){
                players.remove(i);
            }
        }
        return players;
    }

    /**
     * Method for handling mouseClicked events.  The button clicked is determined through the use of .getSource() and the
     * player is asked for confirmation before "calling" their chosen attribute.
     * Once confirmed, a call to processRound(int,String) is made containing the index value and name of the selected stat.
     * @param e a mouseClicked event
     */

    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        button.setOpaque(false);
        button.setBackground(selectedColor);
        panel.repaint();

        if (button == attackButton) {
            int confirmCall = JOptionPane.showConfirmDialog(null, "Do you wish to \"call\" the attack stat?");

            if (confirmCall == JOptionPane.YES_OPTION)
                processRound(1,"Attack");
        }
        if (button == defenceButton) {
            int confirmCall = JOptionPane.showConfirmDialog(null, "Do you wish to \"call\" the defence stat?");

            if (confirmCall == JOptionPane.YES_OPTION)
                processRound(2,"Defence");
        }
        if (button == heightButton) {
            int confirmCall = JOptionPane.showConfirmDialog(null, "Do you wish to \"call\" the height stat?");

            if (confirmCall == JOptionPane.YES_OPTION)
                processRound(3,"Height");
        }
        if (button == capsButton) {
            int confirmCall = JOptionPane.showConfirmDialog(null, "Do you wish to \"call\" the caps stat?");

            if (confirmCall == JOptionPane.YES_OPTION)
                processRound(4, "Caps");
        }
        if (button == goalsButton) {
            int confirmCall = JOptionPane.showConfirmDialog(null, "Do you wish to \"call\" the goals stat?");

            if (confirmCall == JOptionPane.YES_OPTION)
                processRound(5, "Goals");
        }
        if (button == trophiesButton) {
            int confirmCall = JOptionPane.showConfirmDialog(null, "Do you wish to \"call\" the trophies stat?");

            if (confirmCall == JOptionPane.YES_OPTION)
                processRound(6,"Trophies");
        }
        if (button == ratingButton) {
            int confirmCall = JOptionPane.showConfirmDialog(null, "Do you wish to \"call\" the rating stat?");

            if (confirmCall == JOptionPane.YES_OPTION)
                processRound(7,"TOP rating");
        }
    }

    /**
     * Method for handling mouseEntered events.
     * setOpaque(true) used to make a button "see-through" when hovered over and allows the player to see
     * which stat they may be about to select.
     * panel.repaint() used to prevent painting issues.
     * @param e a mouseEntered event
     */

    public void mouseEntered(MouseEvent e) {
        JButton button = (JButton)e.getSource();
        button.setOpaque(true);
        button.setBackground(selectedColor);
        panel.repaint();
    }

    /**
     * Method for handling mouseExited events.
     * setOpaque(false) essentially makes button invisible so that stat values beneath may be seen.
     * panel.repaint() used to prevent painting issues.
     * @param e a mouseExited event
     */

    public void mouseExited(MouseEvent e) {
        JButton button = (JButton)e.getSource();
        button.setOpaque(false);
        panel.repaint();
    }

    /**
     * Method for handling mousePressed events.
     * @param e a mousePressed event
     */

    public void mousePressed(MouseEvent e){
        JButton button = (JButton)e.getSource();
        panel.repaint();
        button.setOpaque(true);
        button.setBackground(selectedColor);
    }

    /**
     * Method for handling mouseReleased events
     * @param e a mouseReleased event
     */

    public void mouseReleased(MouseEvent e){}

    /**
     * Method to get the state of a Game object
     * @return a String value specifying the state of a Game object
     */

    public String toString() {
        String str="Game ID: "+getGameNumber()+"  Mode: "+getMode()+"  Players: "+getStartingPlayers()+"  Winner: "+getResult();

        return str;
    }
}
