import java.util.ArrayList;

public class Dealer extends Player
{
    private ArrayList<Card> dealerHand = new ArrayList<>();
    public Dealer()
    {
        super("Robert");

    }

    public int getDealerHandValue()
    {
        int total = 0;
        int aces = 0;
        for (Card card : dealerHand)
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

    public void dealerHit(Deck deck)
    {
        Card newCard = deck.getTopCard();
        this.dealerHand.add(newCard);

        if (dealerHand.size() ==  1)
        {

        }
        else
        {
            for (int i = 1; i <= dealerHand.size(); i++)
            {
                System.out.println(newCard);
            }
        }
    }
}