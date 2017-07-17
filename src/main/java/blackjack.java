/**
 * Created by Home on 7/16/2017.
 */
public class blackjack {

    public static void main(String[] args){

        System.out.println("Blackjack!");

        //Create our playing deck
        Deck playingDeck = new Deck();
        playingDeck.createafulldeckofcards();
        playingDeck.shuffle();

        System.out.println(playingDeck);
    }
}
