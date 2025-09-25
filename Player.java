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
        System.out.println(" ");
        System.out.println(this.name + "'s turn:");
        while (getHandValue() <= 21)
        {
            // ask to hit or stay
            Scanner play = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("Your cards are "+ hand);
            System.out.println("Your cards are equal to: "+ getHandValue());
            System.out.print("Do you want to hit or stay? h for hit, s for stay: ");
            String hitOrStay = play.nextLine();
            hitOrStay.toLowerCase();
            if (hitOrStay.equals("h"))
            {
                this.hit(deck);
            }
            else if (hitOrStay.equals("s"))
            {
                break;
            }

        }
        System.out.println("Your cards are equal to: " + getHandValue());
        System.out.println(" ");
        
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

    public void setBet()
    {
        boolean validBet = false;
        while (validBet == false)
        {
            Scanner betScanner = new Scanner(System.in);
            System.out.print("What is " + this.name+"'s bet? You have "+ this.money + " dollars. Enter: ");
            double bet = betScanner.nextDouble();
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
                System.out.print(this.name +" lost. ");
                this.money = this.money - bet;
           }
           else if (getHandValue() == dealerHandValue)
           {
                System.out.print(this.name + " tied with the dealer, you don't win or lose money. ");
           }
           else if (getHandValue() == 21)
           {
                System.out.print(this.name + "won! ");
                this.bet = this.bet * 1.5;
                this.money = bet + money;
           }
           else if (getHandValue() < dealerHandValue)
           {
                System.out.print(this.name + " lost. ");
                this.money = this.money - bet;
           }
           else 
           {
                System.out.print(this.name + " won! ");
                this.money = this.money + bet;
           }
           System.out.println(this.name + " now has " + this.money + " dollars");
    }

    public double getMoney()
    {
        return this.money;
    }

    public String getName()
    {
        return this.name;
    }
}