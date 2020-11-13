package TopTrumps;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TestTopTrumps {
    public static void main(String[] args) {
        Card courtois = new Card("Thibaut Courtois",4,99,199,31,0,6,84,new ImageIcon("TopTrumps/images/courtois.png"));
        Card neuer = new Card("Manuel Neuer",5,100,193,57,0,12,97,new ImageIcon("TopTrumps/images/neuer.png"));
        Card kompany = new Card("Vincent Kompany",60,94,193,66,4,7,73,new ImageIcon("TopTrumps/images/kompany.png"));
        Card hummels = new Card("Mats Hummels",61,85,192,39,4,8,84,new ImageIcon("TopTrumps/images/hummels.png"));
        Card diMaria = new Card("Angel Di Maria",81,64,180,65,15,10,75,new ImageIcon("TopTrumps/images/dimaria.png"));
        Card ronaldo = new Card("Cristiano Ronaldo",99,35,185,124,55,17,100,new ImageIcon("TopTrumps/images/ronaldo.png"));
        Card sterling = new Card("Raheem Sterling",71,54,170,16,1,0,77,new ImageIcon("TopTrumps/images/sterling.png"));
        Card sanchez = new Card("Alexis Sanchez",90,45,169,86,27,11,94,new ImageIcon("TopTrumps/images/sanchez.png"));
        Card vidal = new Card("Arturo Vidal",79,83,180,69,12,8,74,new ImageIcon("TopTrumps/images/vidal.png"));
        Card falcao = new Card("Radamel Falcao",83,40,177,56,24,11,87,new ImageIcon("TopTrumps/images/falcao.png"));
        Card lewandowski = new Card("Robert Lewandowski",88,44,185,68,26,8,92,new ImageIcon("TopTrumps/images/lewandowski.png"));
        Card suarez = new Card("Luis Suarez",91,49,182,79,44,9,93,new ImageIcon("TopTrumps/images/suarez.png"));
        Card benzema = new Card("Karim Benzema",85,36,187,78,25,12,88,new ImageIcon("TopTrumps/images/benzema.png"));
        Card gervinho = new Card("Gervinho",74,42,179,71,20,3,80,new ImageIcon("TopTrumps/images/gervinho.png"));
        Card hazard = new Card("Eden Hazard",80,34,173,59,8,5,86,new ImageIcon("TopTrumps/images/hazard.png"));
        Card ibrahimovic = new Card("Zlatan Ibrahimovic",95,44,195,105,56,27,99,new ImageIcon("TopTrumps/images/ibrahimovic.png"));
        Card messi = new Card("Lionel Messi",100,32,170,102,46,26,100,new ImageIcon("TopTrumps/images/messi.png"));
        Card neymar = new Card("Neymar Jr.",82,33,174,63,43,10,96,new ImageIcon("TopTrumps/images/neymar.png"));
        Card rooney = new Card("Wayne Rooney",86,50,176,105,48,15,85,new ImageIcon("TopTrumps/images/rooney.png"));
        Card aguero = new Card("Sergio Aguero",87,32,173,65,29,7,95,new ImageIcon("TopTrumps/images/aguero.png"));
        Card bale = new Card("Gareth Bale",90,66,183,50,17,4,91,new ImageIcon("TopTrumps/images/bale.png"));
        Card oscar = new Card("Oscar",76,41,179,50,11,6,76,new ImageIcon("TopTrumps/images/oscar.png"));
        Card robben = new Card("Arjen Robben",94,38,180,85,28,20,98,new ImageIcon("TopTrumps/images/robben.png"));
        Card muller = new Card("Thomas Muller",83,52,186,62,26,13,90,new ImageIcon("TopTrumps/images/muller.png"));
        Card modric = new Card("Luka Modric",75,72,172,79,10,10,78,new ImageIcon("TopTrumps/images/modric.png"));
        Card ramos = new Card("Sergio Ramos",60,88,181,128,10,13,81,new ImageIcon("TopTrumps/images/ramos.png"));
        Card lahm = new Card("Philipp Lahm",68,90,170,111,5,21,83,new ImageIcon("TopTrumps/images/lahm.png"));
        Card rojo = new Card("Marcos Rojo",64,75,186,37,2,1,79,new ImageIcon("TopTrumps/images/rojo.png"));
        Card vanPersie = new Card("Robin Van Persie",88,37,186,98,49,5,80,new ImageIcon("TopTrumps/images/vanpersie.png"));
        Card costa = new Card("Diego Costa",85,52,188,7,1,4,77,new ImageIcon("TopTrumps/images/diegocosta.png"));



        ArrayList<Card> allCards = new ArrayList<>(Arrays.asList(courtois,neuer,kompany,hummels,diMaria,ronaldo,sterling,sanchez,vidal,falcao,lewandowski,suarez,benzema
                                                    ,gervinho,hazard,ibrahimovic,messi,neymar,rooney,aguero,bale,oscar,robben,muller,modric,ramos,lahm,rojo,vanPersie,costa));

        Deck worldStars2015 = new Deck("World Football Stars 2015",allCards);

        ArrayList<Deck> allDecks = new ArrayList<>(Arrays.asList(worldStars2015));

        int choice = JOptionPane.showConfirmDialog(null,"Would you like to play?");

        if(choice==JOptionPane.YES_OPTION){
            int numPlayers = Integer.parseInt(JOptionPane.showInputDialog("Num of CPU players"));

            ArrayList<Card> inMiddle = new ArrayList<>();

            while(numPlayers<1 || numPlayers>5){
                numPlayers = Integer.parseInt(JOptionPane.showInputDialog("You may have a minimum of 1 and a maximum of 5 CPU opponents, please enter again"));
            }
            String deckList="";
            ArrayList<Player> totalPlayers = new ArrayList<>(numPlayers+1);

            for(int i=0; i<allDecks.size(); i++){
                deckList+=allDecks.get(i).toString()+"\n";
            }

            int deckChoice = Integer.parseInt(JOptionPane.showInputDialog(deckList+"\n\nPlease enter the ID number of the deck you wish to play with"));

            for(int i=0; i<allDecks.size(); i++){
                while(deckChoice!=allDecks.get(i).getDeckNumber())
                    deckChoice = Integer.parseInt(JOptionPane.showInputDialog(deckList+"\n\nDeck not found.  \nPlease enter the ID number of the deck you wish to play with"));
            }


            Game game = new Game(totalPlayers,allDecks.get(deckChoice-1),inMiddle);

            game.createGame(numPlayers,allDecks.get(deckChoice-1),inMiddle);
            }




        /*int randomCard = (int)(Math.random()*(30-1+1)+1);

        System.out.println(randomCard);

        for(int i=0; i<allCards.size(); i++){
            if(randomCard==allCards.get(i).getCardNumber()){
                JFrame frame = new JFrame("Select a category...");
                frame.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel panel = (JPanel) frame.getContentPane();
                panel.setLayout(new BorderLayout());

                JLabel msgLabel = new JLabel("Select a category...");
                panel.add(msgLabel,BorderLayout.CENTER);
                msgLabel.setHorizontalAlignment(SwingConstants.CENTER);


                JLabel imageLabel=new JLabel("");
                ImageIcon icon = new ImageIcon(allCards.get(i).getIcon().toString());
                imageLabel.setIcon(icon);
                panel.add(imageLabel);
                imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

                Dimension size = imageLabel.getPreferredSize();
                imageLabel.setBounds(0,0,size.width,size.height);

                frame.setSize(600,600);
                frame.setVisible(true);
            }
        }*/
    }
}
