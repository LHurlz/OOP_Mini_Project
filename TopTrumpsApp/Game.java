package TopTrumpsApp;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Game {
    private static int gameID=0;
    private int gameNumber;
    private ArrayList<Player> players;
    private ArrayList<Card> middlePile;
    private Deck deck;

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

    public Game(){
        String confirmString = JOptionPane.showInputDialog("How many CPU opponents do you wish to face?");

        while(!confirmString.equals("1") && !confirmString.equals("2") && !confirmString.equals("3") && !confirmString.equals("4") && !confirmString.equals("5")){
            confirmString = JOptionPane.showInputDialog("Your choice must be numeric and between 1 and 5. Please try again!");
        }

        int cpuPlayers = Integer.parseInt(confirmString);

        ArrayList<Player> players = new ArrayList<>(cpuPlayers+1);

        for(int i=0; i<cpuPlayers+1; i++){
            if(i==0){
                players.add(new Player("Human",null));
            }
            else{
                players.add(new Player("CPU",null));
            }
        }

        String deckList="";

        for(int i=0; i<allDecks.size(); i++){
            deckList+="ID: "+allDecks.get(i).getDeckNumber()+"\t\tName: "+allDecks.get(i).getName();
        }

        String chooseDeck = JOptionPane.showInputDialog(deckList+"\n\nEnter the ID number of the deck you wish to use");

        while(!chooseDeck.equals("1")){
            chooseDeck = JOptionPane.showInputDialog("A deck with this ID does not exist - please try again!");
        }

        int chosenDeck = Integer.parseInt(chooseDeck);

        Collections.shuffle(allDecks.get(chosenDeck-1).getCards());

        String output="Shuffled deck as follows:\n\n";

        for(int i=0; i<30; i++){
            output+=allDecks.get(chosenDeck-1).getCards().get(i)+"\n";
        }

        JOptionPane.showMessageDialog(null,output, "Shuffled Deck",JOptionPane.INFORMATION_MESSAGE);

        this.createGame(players,allDecks.get(chosenDeck-1));
    }

    public void createGame(ArrayList<Player> players,Deck deck){
        setGameNumber();
        setPlayers(players);
        setDeck(deck);
        setMiddlePile(middlePile);

        System.out.println(this.toString());
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

    @Override
    public String toString() {
        String str="Game ID: "+getGameNumber()+"\n\nPlayers:\n\n";

        for(int i=0; i<players.size(); i++){
            str+=players.get(i).getType()+"\n";
        }




        return str;
    }
}
