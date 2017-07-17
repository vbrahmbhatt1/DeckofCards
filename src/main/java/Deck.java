import java.util.ArrayList;
import java.util.*;

public class Deck {

    //instance vars
    private ArrayList<Card> cards;

    //constructor
    public Deck() {
        this.cards = new ArrayList<Card>();
    } //create a new deck of playing cards

    //putting cards in the deck
    //creating a full deck of cards

    public void createafulldeckofcards() {

        //generating cards, looping through Suits
        for (Suit cardSuit : Suit.values()) {
            for (Values cardValue : Values.values()) {
                //add a new card
                this.cards.add(new Card(cardSuit, cardValue));  //add new card
            }
        }
    }

    //shuffle the deck
    public void shuffle() {
        ArrayList<Card> tmpDeck = new ArrayList<Card>();    //create a new arraylist to hold shuffled card temp
        //random
        //currentCard = 0;
        Random random = new Random();   //randomly pick from old deck and copy to new deck
        int randomCardIndex;
        int originalSize = this.cards.size();
        for (int i = 0; i < originalSize; i++) {
            randomCardIndex = random.nextInt((this.cards.size() - 1) + 1);
            tmpDeck.add(this.cards.get(randomCardIndex));   //throw random card into new deck
            this.cards.remove(randomCardIndex);     //removing picked card from old deck
        }
        this.cards = tmpDeck;       //setting the current deck to new shuffled deck
    }

    //print out the deck
    public String toString() {
        String cardListOutput = "";
        int i = 0;
        for (Card aCard : this.cards) {
            cardListOutput += "\n" + "-" + aCard.toString();
            i++;
        }
        return cardListOutput;
    }

    //public Card dealOneCard(){}

    public void removeCard(int i) {
        this.cards.remove(i);
    }       //remove card from deck

    public Card getCard(int i) {
        return this.cards.get(i);
    }       //get card from deck

    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }       //add card to the deck

    public void draw(Deck comingfrom) {     //drawing top card from the deck
        this.cards.add(comingfrom.getCard(0));      //add card to this get
        comingfrom.removeCard(0);       //remove card from the deck its coming from
    }

    public int deckSize(){
        return this.cards.size();
    }

    public void movealltodeck(Deck moveTo){
        int thisdecksize = this.cards.size();

        for(int i = 0; i < thisdecksize; i++){
            moveTo.addCard(this.getCard(i));
        }
        for(int i = 0; i < thisdecksize; i++){
            this.removeCard(0);
        }
    }

    public int carddsValue() {
        int totalValue = 0;
        int aces = 0;

        for (Card aCard : this.cards) {
            switch (aCard.getValue()) {
                case TWO:
                    totalValue += 2;
                    break;
                case THREE:
                    totalValue += 3;
                    break;
                case FOUR:
                    totalValue += 4;
                    break;
                case FIVE:
                    totalValue += 5;
                    break;
                case SIX:
                    totalValue += 6;
                    break;
                case SEVEN:
                    totalValue += 7;
                    break;
                case EIGHT:
                    totalValue += 8;
                    break;
                case NINE:
                    totalValue += 9;
                    break;
                case TEN:
                    totalValue += 10;
                    break;
                case JACK:
                    totalValue += 10;
                    break;
                case QUEEN:
                    totalValue += 10;
                    break;
                case KING:
                    totalValue += 10;
                    break;
                case ACE:
                    aces += 1;
                    break;
            }
        }

        //total current values with aces
        //Aces are 11 or 1, if 11 and the deck in hand goes over 21, aces is now 1
        for (int i = 0; i < aces; i++) {
            if (totalValue > 10) {
                totalValue += 1;
            } else {
                totalValue += 11;
            }
        }
        return totalValue;
    }
}
