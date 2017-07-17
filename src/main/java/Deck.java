import java.util.ArrayList;
import java.util.*;

public class Deck {

    //instance vars
    private ArrayList<Card> cards;

    //constructor
    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    //putting cards in the deck
    //creating a full deck of cards

    public void createafulldeckofcards() {

        //generating cards
        for (Suit cardSuit : Suit.values()) {
            for (Values cardValue : Values.values()) {
                //add a new card
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }

    //shuffle the deck
    public void shuffle() {
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        //random
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();
        for (int i = 0; i < originalSize; i++) {
            randomCardIndex = random.nextInt((this.cards.size() - 1) + 1);
            tmpDeck.add(this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);
        }
        this.cards = tmpDeck;
    }


    public String toString() {
        String cardListOutput = "";
        int i = 0;
        for (Card aCard : this.cards) {
            cardListOutput += "\n" + "-" + aCard.toString();
            i++;
        }
        return cardListOutput;
    }


    public void removeCard(int i) {
        this.cards.remove(i);
    }

    public Card getCard(int i) {
        return this.cards.get(i);
    }

    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }

    public void draw(Deck comingfrom) {
        this.cards.add(comingfrom.getCard(0));
        comingfrom.removeCard(0);
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
