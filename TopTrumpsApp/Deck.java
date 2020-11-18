package TopTrumpsApp;

import java.util.ArrayList;

public class Deck {
    private int deckID=0;
    private int deckNumber;
    private String name;
    private ArrayList<TopTrumpsApp.Card> cards;

    public Deck(String name, ArrayList<TopTrumpsApp.Card> cards){
        setDeckNumber();
        setName(name);
        setCards(cards);
    }

    public int getDeckNumber() {
        return deckNumber;
    }

    public void setDeckNumber() {
        deckID++;
        this.deckNumber = deckID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /*public Deck shuffle(Deck deck){
        ArrayList<Card> shuffledCards = new ArrayList<>(30);
        boolean alreadyPicked[] = new boolean[30];
        int randomNum;
        String output="";

        for(int i=0; i<30; i++){
            randomNum = (int)(Math.random()*30);

            while(alreadyPicked[randomNum])
                randomNum = (int)(Math.random()*30);            // MY OWN SHUFFLING METHOD, WRITTEN BEFORE LEARNING ABOUT COLLECTIONS.SHUFFLE() //

            alreadyPicked[randomNum]=true;

            shuffledCards.add(cards.get(randomNum));
            output+=shuffledCards.get(i)+"\n";
        }

        Deck shuffledDeck = new Deck("",shuffledCards);

        JOptionPane.showMessageDialog(null,"Shuffled deck is as follows:\n\n" +
                        output,
                "Shuffled Deck",JOptionPane.INFORMATION_MESSAGE);

        return shuffledDeck;
    }*/

    public ArrayList<Player> deal(Deck shuffledDeck, ArrayList<Player> players){
        ArrayList<Card> p1Cards = new ArrayList<>(15);
        ArrayList<Card> p2Cards = new ArrayList<>(15);
        ArrayList<Card> p3Cards = new ArrayList<>(15);
        ArrayList<Card> p4Cards = new ArrayList<>(15);
        ArrayList<Card> p5Cards = new ArrayList<>(15);
        ArrayList<Card> p6Cards = new ArrayList<>(15);
        ArrayList<ArrayList<Card>> allCards = new ArrayList<>();
        allCards.add(p1Cards);
        allCards.add(p2Cards);
        allCards.add(p3Cards);
        allCards.add(p4Cards);
        allCards.add(p5Cards);
        allCards.add(p6Cards);

        int cpuPlayers=players.size()-1;

        if(cpuPlayers==1){
            for(int i=0; i<shuffledDeck.getCards().size(); i++){
                if(i<15){
                    p1Cards.add(shuffledDeck.getCards().get(i));
                }
                else if(i>14 && i<30)
                    p2Cards.add(shuffledDeck.getCards().get(i));
            }
        }
        else if(cpuPlayers==2){
            for(int i=0; i<shuffledDeck.getCards().size(); i++){
                if(i<10)
                    p1Cards.add(shuffledDeck.getCards().get(i));
                else if(i>9 && i<20)
                    p2Cards.add(shuffledDeck.getCards().get(i));
                else if(i>19 && i<30)
                    p3Cards.add(shuffledDeck.getCards().get(i));
            }
        }
        else if(cpuPlayers==3){
            for(int i=0; i<shuffledDeck.getCards().size(); i++){
                if(i<7)
                    p1Cards.add(shuffledDeck.getCards().get(i));
                else if(i>6 && i<14)
                    p2Cards.add(shuffledDeck.getCards().get(i));
                else if(i>13 && i<21)
                    p3Cards.add(shuffledDeck.getCards().get(i));
                else if(i>20 && i<28)
                    p4Cards.add(shuffledDeck.getCards().get(i));
            }
        }
        else if(cpuPlayers==4){
            for(int i=0; i<shuffledDeck.getCards().size(); i++){
                if(i<6)
                    p1Cards.add(shuffledDeck.getCards().get(i));
                else if(i>5 && i<12)
                    p2Cards.add(shuffledDeck.getCards().get(i));
                else if(i>11 && i<18)
                    p3Cards.add(shuffledDeck.getCards().get(i));
                else if(i>17 && i<24)
                    p4Cards.add(shuffledDeck.getCards().get(i));
                else if(i>23 && i<30)
                    p5Cards.add(shuffledDeck.getCards().get(i));
            }
        }
        else if(cpuPlayers==5){
            for(int i=0; i<shuffledDeck.getCards().size(); i++){
                if(i<5)
                    p1Cards.add(shuffledDeck.getCards().get(i));
                else if(i>4 && i<10)
                    p2Cards.add(shuffledDeck.getCards().get(i));
                else if(i>9 && i<15)
                    p3Cards.add(shuffledDeck.getCards().get(i));
                else if(i>14 && i<20)
                    p4Cards.add(shuffledDeck.getCards().get(i));
                else if(i>19 && i<25)
                    p5Cards.add(shuffledDeck.getCards().get(i));
                else if(i>24 && i<30)
                    p6Cards.add(shuffledDeck.getCards().get(i));
            }
        }

        for(int i=0; i<players.size(); i++){
            if(players.get(i)!=null){
                players.get(i).setHand(allCards.get(i));
            }
        }

        return players;
    }

    @Override
    public String toString() {

        String str="ID: "+getDeckNumber()+"  Name: "+getName();

        return str;

    }
}
