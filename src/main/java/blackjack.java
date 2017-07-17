import java.util.Scanner;
import java.util.*;

public class blackjack {

    public static void main(String[] args){

        System.out.println("The Blackjack Game!");

        //Create our playing deck
        Deck playingDeck = new Deck();
        playingDeck.createafulldeckofcards();
        playingDeck.shuffle();

        Deck playersdeck = new Deck();   //Create a deck for the player
        double playingmoney = 10000.00;
        Deck dealersdeck = new Deck();      //Create a deck for the dealer

        Scanner userInput = new Scanner(System.in);

        //Game Loop, the player has money
        while(playingmoney > 0){
            System.out.println(playingmoney + "\n" + "bet how much: ");
            double playbet = userInput.nextDouble();
            boolean endRound = false;
            if(playbet > playingmoney){
                System.out.println("your're done!");
                break;
            }

            //Start dealing, player gets 2 cards
            playersdeck.draw(playingDeck);
            playersdeck.draw(playingDeck);

            //dealer gets 2 cards
            dealersdeck.draw(playingDeck);
            dealersdeck.draw(playingDeck);

            while(true){
                System.out.println("In hand:" + playersdeck.toString());    //show's player's card
                System.out.println("your hand: " + playersdeck.carddsValue());      //show value
                System.out.println("dealer hand: " + dealersdeck.getCard(0).toString());

                //hit or stand?
                System.out.println("(1)Hit or (2)Stand?");
                int respone = userInput.nextInt();

                if (respone == 1){      //hit
                    playersdeck.draw(playingDeck);
                    System.out.println("you draw" + "\n" + playersdeck.getCard(playersdeck.deckSize()-1).toString());
                    if(playersdeck.carddsValue() > 21){
                        System.out.println("Bust, Current value:" + playersdeck.carddsValue());
                        playingmoney -= playbet;
                        endRound = true;
                        break;
                    }
                }

                if (respone == 2){
                    break;
                }
            }

            System.out.println("dealers cards: " + dealersdeck.toString());
            if((dealersdeck.carddsValue() > playersdeck.carddsValue()) && endRound == false ){
                System.out.println("dealer wins");
                playingmoney -= playbet;
                endRound = true;
            }

            while((dealersdeck.carddsValue() < 17 && endRound == false)){
                dealersdeck.draw(playingDeck);
                System.out.println("dealer draws: " + dealersdeck.getCard(dealersdeck.deckSize()-1).toString());
            }

            System.out.println("dealer's had is valued at: " + dealersdeck.carddsValue());
            if((dealersdeck.carddsValue() > 21) && endRound == false){
                System.out.println("Dealer busts!");
                playingmoney += playbet;
                endRound = true;
            }

            //for push
            if((playersdeck.carddsValue() == dealersdeck.carddsValue()) && endRound == false){
                endRound = true;
            }

            if((playersdeck.carddsValue() > dealersdeck.carddsValue() && endRound == false)){
                System.out.println("you win the hand!");
                playingmoney += playbet;
                endRound = true;
            }
            else if(endRound == false){
                System.out.println("you lose the hand.");
                playingmoney -= playbet;
                //endRound = true;
            }

            playersdeck.movealltodeck(playingDeck);
            dealersdeck.movealltodeck(playersdeck);
            System.out.println("End Hand!" + "\n");
        }

        System.out.println("Game over!");
        userInput.close();

    }

}
