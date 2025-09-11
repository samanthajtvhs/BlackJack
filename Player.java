import java.util.ArrayList;

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

    public void playTurn()
    {
        // bet
        // ask to hit or stay
    }

    public void hit()
    {
        // Card newCard = gethand();
        // this.hand.add(getHand)
    }

    public int getHandValue()
    {
        //add values together (aces are 11 or 1)
        // int totalVal = 0;
        
        return 1;
    }

    public void getCard(Deck deck)
    {
        //do stuff
    }
}