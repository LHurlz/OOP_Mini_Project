package TopTrumpsApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TopTrumpsMenu extends JFrame implements ActionListener {
    private JButton playButton;
    private JMenu decksMenu;
    private JLabel imageLabel;
    private JPanel panel;
    private ArrayList<Game> games;
    private ArrayList<Player> players;
    private ArrayList<Card> middlePile;
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

    Deck worldStars2015 = new Deck("World Football Stars 2015", allCards);

    ArrayList<Deck> allDecks = new ArrayList<>(Arrays.asList(worldStars2015));

    public TopTrumpsMenu() {
        this.setTitle("Welcome to Top Trumps");
        this.setSize(750, 750);
        this.setLocationRelativeTo(null);


        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout());
        this.createDecksMenu();

        this.imageLabel = new JLabel();
        this.imageLabel.setIcon(new ImageIcon(this.getClass().getResource("images/logo.png")));

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menuBar.add(this.decksMenu);


        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, 1));
        this.panel.add(this.imageLabel);
        pane.add(this.panel);


        playButton = new JButton("Play Top Trumps");
        playButton.addActionListener(this);
        this.add(playButton);


        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void createDecksMenu() {
        this.decksMenu = new JMenu("Decks");

        JMenuItem view = new JMenuItem("View Decks");
        view.addActionListener(this);
        this.decksMenu.add(view);

        JMenuItem edit = new JMenuItem("Edit Decks");
        edit.addActionListener(this);
        this.decksMenu.add(edit);

        JMenuItem add = new JMenuItem("Add Decks");
        add.addActionListener(this);
        this.decksMenu.add(add);

        JMenuItem remove = new JMenuItem("Remove Decks");
        remove.addActionListener(this);
        this.decksMenu.add(remove);

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            int confirm = JOptionPane.showConfirmDialog(null, "Would you like to play Top Trumps?");
            ArrayList<Game> games = new ArrayList<>();
            ArrayList<Player> players;
            ArrayList<Card> middlePile = new ArrayList<>();

            if (confirm == JOptionPane.YES_OPTION) {
                //games.add(new Game());

                String confirmString = JOptionPane.showInputDialog("How many CPU opponents do you wish to face?");

                while (!confirmString.equals("1") && !confirmString.equals("2") && !confirmString.equals("3") && !confirmString.equals("4") && !confirmString.equals("5")) {
                    confirmString = JOptionPane.showInputDialog("Your choice must be numeric and between 1 and 5. Please try again!");
                }

                int cpuPlayers = Integer.parseInt(confirmString);

                /*ArrayList<Player>*/ players = new ArrayList<>(cpuPlayers + 1);

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

                while (!chooseDeck.equals("1")) {
                    chooseDeck = JOptionPane.showInputDialog("A deck with this ID does not exist - please try again!");
                }

                int chosenDeck = Integer.parseInt(chooseDeck);

                Collections.shuffle(allDecks.get(chosenDeck - 1).getCards()); //https://www.tutorialspoint.com/shuffle-elements-of-arraylist-with-java-collections#:~:text=In%20order%20to%20shuffle%20elements,shuffle()%20method.//

                if(players.size()==4){
                    middlePile.add(allDecks.get(chosenDeck - 1).getCards().get(28));
                    middlePile.add(allDecks.get(chosenDeck - 1).getCards().get(29));
                }

                String output = "Shuffled deck as follows:\n\n";

                for (int i = 0; i < 30; i++) {
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

                games.add(new Game(playersDealtTo,allDecks.get(chosenDeck-1),middlePile,0));

                System.out.println(games.get(0));

                for(int i=0; i<games.size(); i++){
                        if(games.get(i).getResult()==0){
                            games.get(i).createGame();
                        }
                }


                this.dispose();
            }
        }
    }
}
