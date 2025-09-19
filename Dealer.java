import java.util.ArrayList;

public class Dealer extends Player
{
    private ArrayList<Card> dealerHand = new ArrayList<>();
    public Dealer()
    {
        super("Robert");

    }

    public int getDealerHandValue();
    {
        //copy from hand value
    }

    public void DealerHit(Deck deck)
    {
        Card newCard = deck.getTopCard();
        this.dealerHand.add(newCard);
        for (int i = 1; i <= dealerHand.size(); i++)
        {
            System.out.println(newCard);
        }
    }

}