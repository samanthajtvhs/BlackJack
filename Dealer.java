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

    public boolean isSoft()
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
                return false;
            }
            else 
            {
                return true;
            }
        }
        return false;
    }

    public void firstDealerHit(Deck deck)
    {
        Card newCard = deck.getTopCard();
        this.dealerHand.add(newCard);
    }


    public void secondDealerHit(Deck deck)
    {
        Card newCard = deck.getTopCard();
        this.dealerHand.add(newCard);
        System.out.println(newCard);
    }

    public void dealerHit(Deck deck)
    {
        Card newCard = deck.getTopCard();
        this.dealerHand.add(newCard);
        System.out.println(dealerHand);
    }

    public void dealerTurn(Deck deck)
    {
        while (getDealerHandValue() < 17|| getDealerHandValue() == 17 && isSoft() == true)
        {
            System.out.println("Dealer is showing: ");
            dealerHit(deck);
        }
    }
}