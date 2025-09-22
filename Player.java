import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    private String name;
    private double money;
    private ArrayList<Card> hand = new ArrayList<>();
    private double bet;

    public Player(String name)
    {
        this.name = name;
        this.money = 100;
        this.bet = 0;
    }

    public void playTurn(Deck deck)
    {
        // ask to hit or stay
        Scanner play = new Scanner(System.in);
        System.out.print("Do you want to hit or stay? 1 for hit, 2 for stay");
        int hitOrStay = play.nextInt();

        // while (Player.playTurn )
        if (hitOrStay == 1)
        {
            this.hit(deck);
        }
        else if (hitOrStay == 2)
        {
            return;
        }
    }

    public void hit(Deck deck)
    {
        Card newCard = deck.getTopCard();
        System.out.println(newCard);
        this.hand.add(newCard);
    }

    public int getHandValue()
    {
        int total = 0;
        int aces = 0;
        for (Card card : hand)
        {
            int cardVal = card.getCardValue();
            total = total + cardVal;
            if (cardVal == 11)
            {
                aces++;
            }
        }
        while (aces > 0)
        {
            if (total > 21)
            {
                total = total - 10;
                aces--;
            }
            else 
            {
                aces = 0;
            }
        }
        return total;
    }

    public void getCard(Deck deck)
    {
        //do stuff
    }

    public void setBet()
    {
        boolean validBet = false;
        while (validBet = false)
        {
            Scanner betScanner = new Scanner(System.in);
            double bet = betScanner.nextDouble();
            System.out.print("What is your bet? You have "+ money + " dollars.");
            betScanner.nextLine();
            if (bet <= this.money)
            {
                this.bet = bet;
                validBet = true;
            }
            else 
            {
                System.out.print("You can't bet more than you have.");
                System.out.print("Hit enter to continue"); 
            }
        }      
    }

    public void handleBet(int dealerHandValue)
    {
        if (getHandValue() > 21)
           {
                System.out.println("You lost");
                //minus bet
           }
           else if (getHandValue() == dealerHandValue)
           {
                System.out.print("You tied with the dealer, you don't win or lose money");
           }
           else if (getHandValue() == 21)
           {
                System.out.print("You win");
                this.bet = this.bet * 1.5;
                this.money = bet + money;
           }
           else if (getHandValue() < dealerHandValue)
           {
                System.out.print("You lost");
                this.money = this.money - bet;
           }
           else 
           {
                System.out.print("You win!");
                this.money = this.money + bet;
           }
    }
}