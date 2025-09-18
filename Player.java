import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    private String name;
    private double money;
    private ArrayList<Card> hand = new ArrayList<>();

    public Player(String name)
    {
        this.name = name;
        this.money = 100;
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
        this.hand.add(newCard);
    }

    public int getHandValue()
    {
        int total = 0;
        int aces = 0;
        for (int i = 0; i <= hand.size(); i++)
        {
            // int total = total + ;
        }

        //for(Card )

        //add values together (aces are 11 or 1)
        
        return 1;
    }

    public void getCard(Deck deck)
    {
        //do stuff
    }
}