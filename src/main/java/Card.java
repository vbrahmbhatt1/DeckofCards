public class Card {

    private Suit suits;
    private Values value;

    //constructor for the card object
    public Card (Suit suits, Values value){
        this.suits = suits;
        this.value = value;
    }

    //print out the value and the suit into a formatted string
    public String toString(){
        return this.suits.toString() + "-" + this.value.toString();
    }

    //checking values of things in the deck class
    //to see the actual value of the card
    //and the points in the users hand
    public Values getValue(){
        return this.value;
    }

}
