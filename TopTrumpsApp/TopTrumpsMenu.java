package TopTrumpsApp;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import javax.sound.sampled.*;

public class TopTrumpsMenu extends JFrame implements ActionListener,Serializable {
    private JButton playButton;
    private JButton historyButton;
    private JMenu exitMenu;
    private JMenu cardsMenu;
    private JMenu helpMenu;
    private JLabel imageLabel;
    private JPanel panel;
    private ArrayList<Game> games = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Card> middlePile = new ArrayList<>();
    private JTextArea textarea;
    private Game g;
    private static final long serialVersionUID = 1;
    //private Clip clip;

    //  card images sourced from https://cartophilic-info-exch.blogspot.com/2016/10/top-trumps-world-football-stars-2015.html?m=1 //

    Card courtois = new Card("Thibaut Courtois", 4, 99, 199, 31, 0, 6, 84, new ImageIcon("TopTrumpsApp/images/courtois.png"));
    Card neuer = new Card("Manuel Neuer", 5, 100, 193, 57, 0, 12, 97, new ImageIcon("TopTrumpsApp/images/neuer.png"));
    Card kompany = new Card("Vincent Kompany", 60, 94, 193, 66, 4, 7, 73, new ImageIcon("TopTrumpsApp/images/kompany.png"));
    Card hummels = new Card("Mats Hummels", 61, 85, 192, 39, 4, 8, 84, new ImageIcon("TopTrumpsApp/images/hummels.png"));
    Card diMaria = new Card("Angel Di Maria", 81, 64, 180, 65, 15, 10, 75, new ImageIcon("TopTrumpsApp/images/dimaria.png"));
    Card ronaldo = new Card("Cristiano Ronaldo", 99, 35, 185, 124, 55, 17, 100, new ImageIcon("TopTrumpsApp/images/ronaldo.png"));
    Card sterling = new Card("Raheem Sterling", 71, 54, 170, 16, 1, 0, 77, new ImageIcon("TopTrumpsApp/images/sterling.png"));
    Card sanchez = new Card("Alexis Sanchez", 90, 45, 169, 86, 27, 11, 94, new ImageIcon("TopTrumpsApp/images/sanchez.png"));
    Card vidal = new Card("Arturo Vidal", 79, 83, 180, 69, 12, 8, 74, new ImageIcon("TopTrumpsApp/images/vidal.png"));
    Card falcao = new Card("Radamel Falcao", 83, 40, 177, 56, 24, 11, 87, new ImageIcon("TopTrumpsApp/images/falcao.png"));
    Card lewandowski = new Card("Robert Lewandowski", 88, 44, 185, 68, 26, 8, 92, new ImageIcon("TopTrumpsApp/images/lewandowski.png"));
    Card suarez = new Card("Luis Suarez", 91, 49, 182, 79, 44, 9, 93, new ImageIcon("TopTrumpsApp/images/suarez.png"));
    Card benzema = new Card("Karim Benzema", 85, 36, 187, 78, 25, 12, 88, new ImageIcon("TopTrumpsApp/images/benzema.png"));
    Card gervinho = new Card("Gervinho", 74, 42, 179, 71, 20, 3, 80, new ImageIcon("TopTrumpsApp/images/gervinho.png"));
    Card hazard = new Card("Eden Hazard", 80, 34, 173, 59, 8, 5, 86, new ImageIcon("TopTrumpsApp/images/hazard.png"));
    Card ibrahimovic = new Card("Zlatan Ibrahimovic", 95, 44, 195, 105, 56, 27, 99, new ImageIcon("TopTrumpsApp/images/ibrahimovic.png"));
    Card messi = new Card("Lionel Messi", 100, 32, 170, 102, 46, 26, 100, new ImageIcon("TopTrumpsApp/images/messi.png"));
    Card neymar = new Card("Neymar Jr.", 82, 33, 174, 63, 43, 10, 96, new ImageIcon("TopTrumpsApp/images/neymar.png"));
    Card rooney = new Card("Wayne Rooney", 86, 50, 176, 105, 48, 15, 85, new ImageIcon("TopTrumpsApp/images/rooney.png"));
    Card aguero = new Card("Sergio Aguero", 87, 32, 173, 65, 29, 7, 95, new ImageIcon("TopTrumpsApp/images/aguero.png"));
    Card bale = new Card("Gareth Bale", 90, 66, 183, 50, 17, 4, 91, new ImageIcon("TopTrumpsApp/images/bale.png"));
    Card oscar = new Card("Oscar", 76, 41, 179, 50, 11, 6, 76, new ImageIcon("TopTrumpsApp/images/oscar.png"));
    Card robben = new Card("Arjen Robben", 94, 38, 180, 85, 28, 20, 98, new ImageIcon("TopTrumpsApp/images/robben.png"));
    Card muller = new Card("Thomas Muller", 83, 52, 186, 62, 26, 13, 90, new ImageIcon("TopTrumpsApp/images/muller.png"));
    Card modric = new Card("Luka Modric", 75, 72, 172, 79, 10, 10, 78, new ImageIcon("TopTrumpsApp/images/modric.png"));
    Card ramos = new Card("Sergio Ramos", 60, 88, 181, 128, 10, 13, 81, new ImageIcon("TopTrumpsApp/images/ramos.png"));
    Card lahm = new Card("Philipp Lahm", 68, 90, 170, 111, 5, 21, 83, new ImageIcon("TopTrumpsApp/images/lahm.png"));
    Card rojo = new Card("Marcos Rojo", 64, 75, 186, 37, 2, 1, 79, new ImageIcon("TopTrumpsApp/images/rojo.png"));
    Card vanPersie = new Card("Robin Van Persie", 88, 37, 186, 98, 49, 5, 80, new ImageIcon("TopTrumpsApp/images/vanpersie.png"));
    Card costa = new Card("Diego Costa", 85, 52, 188, 7, 1, 4, 77, new ImageIcon("TopTrumpsApp/images/diegocosta.png"));

    ArrayList<Card> allCards = new ArrayList<>(Arrays.asList(courtois, neuer, kompany, hummels, diMaria, ronaldo, sterling, sanchez, vidal, falcao, lewandowski, suarez, benzema
            , gervinho, hazard, ibrahimovic, messi, neymar, rooney, aguero, bale, oscar, robben, muller, modric, ramos, lahm, rojo, vanPersie, costa));

    ArrayList<Card> createdCards = new ArrayList<>(Arrays.asList(courtois, neuer, kompany, hummels, diMaria, ronaldo, sterling, sanchez, vidal, falcao, lewandowski, suarez, benzema
            , gervinho, hazard, ibrahimovic, messi, neymar, rooney, aguero, bale, oscar, robben, muller, modric, ramos, lahm, rojo, vanPersie, costa));

    Deck worldStars2015 = new Deck("World Football Stars 2015", allCards);

    ArrayList<Deck> allDecks = new ArrayList<>(Arrays.asList(worldStars2015));

    public TopTrumpsMenu() {
        /*try                                             // learned from https://www.codeproject.com/Questions/1210248/Play-wav-file-in-java //
            {
                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File("TopTrumpsApp/sounds/gametheme.wav")));  // music from https://www.youtube.com/watch?v=_8DN1vbnjMk
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-30.0f);       // learned from https://stackoverflow.com/questions/953598/audio-volume-control-increase-or-decrease-in-java //
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        catch (Exception exc)
            {
                exc.printStackTrace(System.out);
            }*/


        this.setTitle("Welcome to Top Trumps");
        this.setSize(750, 750);
        this.setLocationRelativeTo(null);
        //this.loadHistory();

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout());
        this.createCardsMenu();
        this.createHelpMenu();
        this.createExitMenu();

        this.imageLabel = new JLabel();
        this.imageLabel.setIcon(new ImageIcon(this.getClass().getResource("images/logo.png"))); // https://www.seekpng.com/ima/u2y3q8i1w7r5o0w7/

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menuBar.add(this.cardsMenu);
        menuBar.add(this.helpMenu);
        menuBar.add(Box.createHorizontalGlue());        // advice from https://stackoverflow.com/questions/8560810/aligning-jmenu-on-the-right-corner-of-jmenubar-in-java-swing
                                                        // to position JMenuItem
        menuBar.add(this.exitMenu);

        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, 1));
        this.panel.add(this.imageLabel);
        pane.add(this.panel);

        playButton = new JButton("Play Top Trumps");
        playButton.addActionListener(this);
        this.add(playButton);

        historyButton=new JButton("View Game History");
        historyButton.addActionListener(this);
        this.add(historyButton);

        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void createCardsMenu(){
        JMenuItem item;
        this.cardsMenu = new JMenu("Cards");

        item = new JMenuItem("Add Card");
        item.addActionListener(this);
        this.cardsMenu.add(item);

        item = new JMenuItem("Edit Cards");
        item.addActionListener(this);
        this.cardsMenu.add(item);

        item = new JMenuItem("Remove Cards");
        item.addActionListener(this);
        this.cardsMenu.add(item);

        item = new JMenuItem("View Cards");
        item.addActionListener(this);
        this.cardsMenu.add(item);
    }

    public void createHelpMenu(){
        JMenuItem item;
        this.helpMenu = new JMenu("Help");

        item = new JMenuItem("Rules");
        item.addActionListener(this);
        this.helpMenu.add(item);
    }

    public void createExitMenu() {
        JMenuItem item;
        this.exitMenu = new JMenu("Quit");

        item = new JMenuItem("Quit");
        item.addActionListener(this);
        this.exitMenu.add(item);
    }

    public boolean hasSpecialCharacter(String string){
        for(int i=0; i<string.length(); i++){
            if(string.charAt(i)=='!'||string.charAt(i)=='?'||string.charAt(i)=='.'||string.charAt(i)=='@'||string.charAt(i)=='&'||string.charAt(i)=='#'||string.charAt(i)=='='
                    ||string.charAt(i)=='('||string.charAt(i)==')'||string.charAt(i)=='_'||string.charAt(i)=='+'||string.charAt(i)=='"'||string.charAt(i)=='$'||string.charAt(i)=='/'
                    ||string.charAt(i)=='|'||string.charAt(i)=='\\'||string.charAt(i)=='£'||string.charAt(i)==';'||string.charAt(i)==':'||string.charAt(i)=='~'||string.charAt(i)==','
                    ||string.charAt(i)=='%'||string.charAt(i)=='`'||string.charAt(i)=='*'||string.charAt(i)=='>'||string.charAt(i)=='<'||string.charAt(i)=='^'
                    ||string.charAt(i)=='['||string.charAt(i)==']')
                return false;
        }

        return true;
    }

    public boolean hasDigit(String string){
        for(int i=0; i<string.length(); i++){
            if(Character.isDigit(string.charAt(i)))
                return false;
        }

        return true;
    }

    public boolean isValidStat(String stat){
        if(stat.equals(""))
            return false;

        for(int i=0; i<stat.length(); i++){
            if(!Character.isDigit(stat.charAt(i)))
                return false;
        }

        int statInt = Integer.parseInt(stat);

        if(statInt<1 || statInt>100)
            return false;

        return true;
    }

    public boolean isValidStatHeight(String stat){
        if(stat.equals(""))
            return false;

        for(int i=0; i<stat.length(); i++){
            if(!Character.isDigit(stat.charAt(i)))
                return false;
        }

        int statInt = Integer.parseInt(stat);

        if(statInt<150 || statInt>210)
            return false;

        return true;
    }

    public boolean isValidStatCaps(String stat){
        if(stat.equals(""))
            return false;

        for(int i=0; i<stat.length(); i++){
            if(!Character.isDigit(stat.charAt(i)))
                return false;
        }

        int statInt = Integer.parseInt(stat);

        if(statInt<0 || statInt>200)
            return false;

        return true;
    }

    public boolean isValidStatTrophies(String stat){
        if(stat.equals(""))
            return false;

        for(int i=0; i<stat.length(); i++){
            if(!Character.isDigit(stat.charAt(i)))
                return false;
        }

        int statInt = Integer.parseInt(stat);

        if(statInt<0 || statInt>40)
            return false;

        return true;
    }

    public void loadHistory(){
        try{
            File inFile	= new File("TopTrumpsApp/game_history.data");
            FileInputStream inStream = new FileInputStream(inFile);

            ObjectInputStream objectInStream = new ObjectInputStream(inStream);

            this.games  = (ArrayList)objectInStream.readObject();

            String str = "";

            for(Game g : games){
                str+=g + "\n";
            }

            JOptionPane.showMessageDialog(null,str,"Game History",JOptionPane.PLAIN_MESSAGE);

            inStream.close();
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
            JOptionPane.showMessageDialog(null,"File could not be found!",
                    "Problem Finding File!",JOptionPane.ERROR_MESSAGE);
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

    public void actionPerformed(ActionEvent e) {
        String menuName = e.getActionCommand();

        if(menuName.equals("Quit")){
            int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the Top Trumps app?");
              if(confirm==JOptionPane.YES_OPTION){
                  JOptionPane.showMessageDialog(null,"Thanks for playing!","Goodbye",JOptionPane.INFORMATION_MESSAGE);
                  System.exit(0);
              }
        }

        if(menuName.equals("Rules")){
            textarea=new JTextArea();
            Font font = new Font("Monospaced",Font.PLAIN,12);
            textarea.setFont(font);
            textarea.setRows(30);
            textarea.setColumns(200);
            textarea.setLineWrap(true);

            textarea.setText("Welcome to Top Trumps!\n\nRules of the Game:\n\nTraditional Mode:\n\nGood old fashioned Top Trumps.  Each player is dealt an equal amount of " +
                    "cards, with any leftover being put automatically into the middle pile. As the dealer, you will play first. Select the stat from your card which " +
                    "you think has the highest chance of winning.  If you win, you will gain all of the other CPU players' top card. However if you lose, you will " +
                    "lose your card and it'll be the CPU's turn to select a stat until you win a round.\n\nIn the event of a tie, all cards that were \"in play\" " +
                    "will remain in the middle pile until a round is won.\n\nShould you lose all of your cards, you will be knocked out of the " +
                    "game and returned to the main menu.  The first player to hold all 30 cards wins the game.\n\n\nYou're The Boss:\n\nTop Trumps with a twist!\n" +
                    "In this mode, you get to make the call every single turn.  This mode is better suited to players looking for a more engaging experience " +
                    "and has you involved in every single turn!");

            JOptionPane.showMessageDialog(null,textarea,"Rules",JOptionPane.PLAIN_MESSAGE);
        }

        if(menuName.equals("Edit Cards")){
            ArrayList<Card> matchingCards = new ArrayList<>();
            String name = JOptionPane.showInputDialog("Please enter the name or part of the name of the card you wish to edit");
            String related="";


            while(!hasDigit(name) || !hasSpecialCharacter(name) || name.equals("")){
                name = JOptionPane.showInputDialog("Invalid entry!!\n\nPlease enter the name or part of the name of the card you wish to edit");
            }

            for(Card c : createdCards){
                if(c.getName().toLowerCase().contains(name))
                    matchingCards.add(c);
            }

            for(Card c : matchingCards){
                if(c!=null){
                    related+=c.toString()+"\n";
                }
            }

            String choiceStr = JOptionPane.showInputDialog("Cards that matched your query:\n\n"+related+"\n\nEnter the ID of the card you wish" +
                    " to edit");

            while(hasDigit(choiceStr) || !hasSpecialCharacter(choiceStr) || choiceStr.equals(""))
            {
                choiceStr = JOptionPane.showInputDialog("Invalid Entry!!!\n\nCards that matched your query:\n\n"+related+"\n\nEnter the ID of the card you wish" +
                        " to edit");
            }

            int choice = Integer.parseInt(choiceStr);

            for(Card c : matchingCards){
                if(c!=null && c.getCardNumber()==choice){
                    int statSelect = Integer.parseInt(JOptionPane.showInputDialog("The details of the card you wish to edit are:\n\n"+c.toString()+
                            "\n\n1 - Edit Attack\n2 - Edit Defence\n3 - Edit Height\n4 - Edit Caps\n5 - Edit Goals\n6 - Edit Trophies\n7 - Edit Rating"));

                    while(statSelect!=1 && statSelect!=2&&statSelect!=3 &&statSelect!=4 &&statSelect!=5 &&statSelect!=6 &&statSelect!=7){
                        statSelect = Integer.parseInt(JOptionPane.showInputDialog("The details of the card you wish to edit are:\n\n"+c.toString()+
                                "\n1 - Edit Attack\n2 - Edit Defence\n3 - Edit Height\n4 - Edit Caps\n5 - Edit Goals\n6 - Edit Trophies\n7 - Edit Rating" +
                                "\n\nInvalid entry, select a number between 1 and 7 inclusive"));
                    }

                    if(statSelect==1){
                        String stat = JOptionPane.showInputDialog("Enter new attack rating for "+c.getName());
                        int oldStat = c.getAttack();

                        while(!isValidStat(stat)){
                            stat = JOptionPane.showInputDialog("Invalid!!\n\nEnter new attack rating for "+c.getName());
                        }
                        int newStat = Integer.parseInt(stat);
                        c.setAttack(newStat);
                        JOptionPane.showMessageDialog(null,"Attack rating for "+c.getName()+" successfully changed from "+oldStat+" to "+c.getAttack());
                    }

                    if(statSelect==2){
                        String stat = JOptionPane.showInputDialog("Enter new defence rating for "+c.getName());
                        int oldStat = c.getDefence();

                        while(!isValidStat(stat)){
                            stat = JOptionPane.showInputDialog("Invalid!!\n\nEnter new defence rating for "+c.getName());
                        }
                        int newStat = Integer.parseInt(stat);
                        c.setDefence(newStat);
                        JOptionPane.showMessageDialog(null,"Defence rating for "+c.getName()+" successfully changed from "+oldStat+" to "+c.getDefence());
                    }

                    if(statSelect==3){
                        String stat = JOptionPane.showInputDialog("Enter new height rating for "+c.getName());
                        int oldStat = c.getHeight();

                        while(!isValidStatHeight(stat)){
                            stat = JOptionPane.showInputDialog("Invalid!!\n\nEnter new height rating for "+c.getName());
                        }
                        int newStat = Integer.parseInt(stat);
                        c.setHeight(newStat);
                        JOptionPane.showMessageDialog(null,"Height rating for "+c.getName()+" successfully changed from "+oldStat+" to "+c.getHeight());
                    }

                    if(statSelect==4){
                        String stat = JOptionPane.showInputDialog("Enter new caps rating for "+c.getName());
                        int oldStat = c.getCaps();

                        while(!isValidStatCaps(stat)){
                            stat = JOptionPane.showInputDialog("Invalid!!\n\nEnter new caps rating for "+c.getName());
                        }
                        int newStat = Integer.parseInt(stat);
                        c.setCaps(newStat);
                        JOptionPane.showMessageDialog(null,"Caps rating for "+c.getName()+" successfully changed from "+oldStat+" to "+c.getCaps());
                    }

                    if(statSelect==5){
                        String stat = JOptionPane.showInputDialog("Enter new goals rating for "+c.getName());
                        int oldStat = c.getGoals();

                        while(!isValidStat(stat)){
                            stat = JOptionPane.showInputDialog("Invalid!!\n\nEnter new goals rating for "+c.getName());
                        }
                        int newStat = Integer.parseInt(stat);
                        c.setGoals(newStat);
                        JOptionPane.showMessageDialog(null,"Goals rating for "+c.getName()+" successfully changed from "+oldStat+" to "+c.getGoals());
                    }
                    if(statSelect==6){
                        String stat = JOptionPane.showInputDialog("Enter new trophies rating for "+c.getName());
                        int oldStat = c.getTrophies();

                        while(!isValidStat(stat)){
                            stat = JOptionPane.showInputDialog("Invalid!!\n\nEnter new trophies rating for "+c.getName());
                        }
                        int newStat = Integer.parseInt(stat);
                        c.setTrophies(newStat);
                        JOptionPane.showMessageDialog(null,"Trophies rating for "+c.getName()+" successfully changed from "+oldStat+" to "+c.getTrophies());
                    }
                    if(statSelect==7){
                        String stat = JOptionPane.showInputDialog("Enter new overall TOP rating for "+c.getName());
                        int oldStat = c.getRating();

                        while(!isValidStatTrophies(stat)){
                            stat = JOptionPane.showInputDialog("Invalid!!\n\nEnter new overall TOP rating for "+c.getName());
                        }
                        int newStat = Integer.parseInt(stat);
                        c.setRating(newStat);
                        JOptionPane.showMessageDialog(null,"Overall TOP rating for "+c.getName()+" successfully changed from "+oldStat+" to "+c.getRating());
                    }
                }
            }
        }

        if(menuName.equals("Remove Cards")){
            ArrayList<Card> matchingCards = new ArrayList<>();
            String name = JOptionPane.showInputDialog("Please enter the name of the card you wish to remove");
            String related="";

            for(Card c : createdCards){
                if(c.getName().toLowerCase().contains(name))
                    matchingCards.add(c);
            }

            for(Card c : matchingCards){
                if(c!=null){
                    related+=c.toString()+"\n";
                }
            }

            int choice = Integer.parseInt(JOptionPane.showInputDialog("Cards that matched your query:\n\n"+related+"\n\nEnter the ID of the card you wish" +
                    " to remove"));

            for(Card c : matchingCards){
                if(c.getCardNumber()==choice){
                   int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to remove "+c.getName()+ " from Top Trumps?");

                   if(confirm==JOptionPane.YES_OPTION)
                       createdCards.remove(c);

                   JOptionPane.showMessageDialog(null,c.getName() + " successfully removed!","Player Removed",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        if(menuName.equals("View Cards")){
            String output="";

            for(Card c : createdCards){
                if(c!=null)
                    output+=c.toString()+"\n";
            }

            JOptionPane.showMessageDialog(null,"Created Cards:\n\n"+output,"View Cards",JOptionPane.PLAIN_MESSAGE);
        }

        if(menuName.equals("Add Card")){
            int spaceCounter=0;
            boolean lastCharSpace=false;

            String name=JOptionPane.showInputDialog("Create your very own Top Trumps card and add it to the database!\n\nLet's start with the Player's name:");

            for(int i=0; i<name.length(); i++){
                if(name.charAt(i)==' '){
                    spaceCounter++;
                }
                if(name.charAt(name.length()-1)==' '){
                    lastCharSpace=true;
                }
            }

            while(!hasDigit(name) || !hasSpecialCharacter(name) || spaceCounter>2 || name.equals("") || lastCharSpace){
                if(!hasDigit(name))
                    name=JOptionPane.showInputDialog("Player Name invalid! May not contain numbers!\n\nPlease try again:");
                if(!hasSpecialCharacter(name))
                    name=JOptionPane.showInputDialog("Player Name invalid! May not contain special characters!\n\nPlease try again:");
                if(spaceCounter>3)
                    name=JOptionPane.showInputDialog("Player Name invalid! May not contain more than 3 spaces!\n\nPlease try again:");
                if(name.equals(""))
                    name=JOptionPane.showInputDialog("Player Name invalid! May not be blank!\n\nPlease try again:");
                if(lastCharSpace)
                    name=JOptionPane.showInputDialog("Player Name invalid! Last character may not be a space!\n\nPlease try again:");
            }

            String attackStr = JOptionPane.showInputDialog("Now their \"Attack\" rating:");
            while(!isValidStat(attackStr)){
                attackStr = JOptionPane.showInputDialog("Attack rating invalid!\n May not be left blank or contain characters and must be between 1-100 inclusive." +
                        "\n\nPlease try again:");
            }int attack=Integer.parseInt(attackStr);

            String defenceStr = JOptionPane.showInputDialog("\"Defence\" rating:");
            while(!isValidStat(defenceStr)){
                defenceStr = JOptionPane.showInputDialog("Defence rating invalid! \nMay not be left blank or contain characters and must be between 1-100 inclusive." +
                        "\n\nPlease try again:");
            }int defence=Integer.parseInt(defenceStr);

            String heightStr = JOptionPane.showInputDialog("\"Height\" rating:");
            while(!isValidStatHeight(heightStr)){
                heightStr = JOptionPane.showInputDialog("Height rating invalid! \nMay not be left blank or contain characters and must be between 150-210 inclusive." +
                        "\n\nPlease try again:");
            }int height=Integer.parseInt(heightStr);

            String capsStr = JOptionPane.showInputDialog("\"Caps\" rating:");
            while(!isValidStatCaps(capsStr)){
                capsStr = JOptionPane.showInputDialog("Caps rating invalid! \nMay not be left blank or contain characters and must be between 0-200 inclusive." +
                        "\n\nPlease try again:");
            }int caps=Integer.parseInt(capsStr);

            String goalsStr = JOptionPane.showInputDialog("\"Goals\" rating:");
            while(!isValidStatCaps(goalsStr)){
                goalsStr = JOptionPane.showInputDialog("Goals rating invalid! \nMay not be left blank or contain characters and must be between 0-200 inclusive." +
                        "\n\nPlease try again:");
            }
            int goals=Integer.parseInt(goalsStr);

            String trophiesStr = JOptionPane.showInputDialog("\"Trophies\" rating:");
            while(!isValidStatTrophies(trophiesStr)){
                trophiesStr = JOptionPane.showInputDialog("Trophies rating invalid! \nMay not be left blank or contain characters and must be between 0-40 inclusive." +
                        "\n\nPlease try again:");
            }
            int trophies=Integer.parseInt(trophiesStr);

            String ratingStr = JOptionPane.showInputDialog("\"Overall TOP\" rating:");
            while(!isValidStat(ratingStr)){
                ratingStr = JOptionPane.showInputDialog("Overall TOP rating invalid! \nMay not be left blank or contain characters and must be between 1-100 inclusive." +
                        "\n\nPlease try again:");
            }
            int rating=Integer.parseInt(ratingStr);

            this.createdCards.add(new Card(name,attack,defence,height,caps,goals,trophies,rating));

            JOptionPane.showMessageDialog(null,name+" successfully created! Check the \"View Cards\" tab for confirmation!","Success!",JOptionPane.INFORMATION_MESSAGE);
        }

        if(e.getSource()==historyButton){
            this.loadHistory();
        }

        if (e.getSource() == playButton) {
            int confirm = JOptionPane.showConfirmDialog(null, "Would you like to play Top Trumps?");

            if (confirm == JOptionPane.YES_OPTION) {
                String modeChoice = JOptionPane.showInputDialog("Which game mode do you wish to play? (see rules on main menu for info)" +
                        "\n\n1 - Traditional\n2 - You're The Boss");

                while(!modeChoice.equals("1") &&  !modeChoice.equals("2")){
                    modeChoice = JOptionPane.showInputDialog("Which game mode do you wish to play? (see rules on main menu for info)" +
                            "\n\n1 - Traditional\n2 - You're The Boss");
                }

                int mode = Integer.parseInt(modeChoice);
                String modeString ="";

                if(mode==1)
                    modeString+="Traditional";
                else
                    modeString+="You're The Boss";

                String confirmString = JOptionPane.showInputDialog("How many CPU opponents do you wish to face?");

                while (!confirmString.equals("1") && !confirmString.equals("2") && !confirmString.equals("3") && !confirmString.equals("4") && !confirmString.equals("5")) {
                    confirmString = JOptionPane.showInputDialog("Your choice must be numeric and between 1 and 5. Please try again!");
                }

                int cpuPlayers = Integer.parseInt(confirmString);

                players = new ArrayList<>(cpuPlayers + 1);

                for (int i = 0; i < cpuPlayers + 1; i++) {
                    if (i == 0) {
                        players.add(new Player("Human", null));
                    } else {
                        players.add(new Player("CPU", null));
                    }
                }

                String deckList = "";

                for (int i = 0; i < allDecks.size(); i++) {
                    deckList += "ID: " + allDecks.get(i).getDeckNumber() + "\t\tName: " + allDecks.get(i).getName();
                }

                String chooseDeck = JOptionPane.showInputDialog(deckList + "\n\nEnter the ID number of the deck you wish to use");

                while (!chooseDeck.equals("1"))
                    chooseDeck = JOptionPane.showInputDialog("A deck with this ID does not exist - please try again!");

                int chosenDeck = Integer.parseInt(chooseDeck);

                Collections.shuffle(allDecks.get(chosenDeck - 1).getCards()); //https://www.tutorialspoint.com/shuffle-elements-of-arraylist-with-java-collections#:~:text=In%20order%20to%20shuffle%20elements,shuffle()%20method.//

                if(players.size()==4){
                    middlePile.add(allDecks.get(chosenDeck - 1).getCards().get(28));
                    middlePile.add(allDecks.get(chosenDeck - 1).getCards().get(29));
                }

                String output = "Shuffled deck as follows:\n\n";

                for (int i = 0; i < allDecks.get(chosenDeck - 1).getCards().size(); i++) {
                    if(allDecks.get(chosenDeck - 1).getCards().get(i)!=null)
                        output += allDecks.get(chosenDeck - 1).getCards().get(i) + "\n";
                }

                JOptionPane.showMessageDialog(null,"Now shuffling the deck before game commences...","Shuffling Deck",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null,output,"Shuffled Deck",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null,"Cards are now being dealt before game begins.. press OK to see your hand!","Dealing Cards",JOptionPane.INFORMATION_MESSAGE);

                ArrayList<Player> playersDealtTo = allDecks.get(chosenDeck-1).deal(allDecks.get(chosenDeck-1),players);

                String str="Your hand is...\n\n\n";

                for(int i=0; i<players.get(0).getHand().size(); i++){
                     str+=players.get(0).getHand().get(i).getName()+"\n";
                }

                str+="\n\nGet ready to play Top Trumps!!";

                JOptionPane.showMessageDialog(null,str);

                g = (new Game(modeString,playersDealtTo,cpuPlayers + 1,allDecks.get(chosenDeck-1),middlePile,0));

                //gamesToLoad = g.getFinishedGames();

                games.add(g);
                //g.saveGame();

                g.startGame();

                this.dispose();
            }
        }
    }
}
