import java.util.ArrayList;
import java.util.*;

public class Deck {

    //instance vars
    private ArrayList<Card> cards;

    //constructor
    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    //putting cards in the deck
    //creating a full deck of cards

    public void createafulldeckofcards(){

        //generating cards
        for(Suit cardSuit : Suit.values()){
            for(Values cardValue : Values.values()){
                //add a new card
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }

    //shuffle the deck
    public void shuffle(){
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        //random
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();
        for (int i = 0; i < originalSize; i++){
            randomCardIndex = random.nextInt((this.cards.size() -1 ) + 1);
            tmpDeck.add(this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);
        }
        this.cards = tmpDeck;
    }


    public String toString(){
        String cardListOutput = "";
        int i = 0;
        for(Card aCard: this.cards){
            cardListOutput += "\n" + i + "-" + aCard.toString();
            i++;
        }
        return cardListOutput;
    }

}
