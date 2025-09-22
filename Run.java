import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) 
    {
        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        ArrayList<Player> playerList = new ArrayList<>();
        boolean gameOn = true;
        
        //creating and assigning players
        Scanner newScanner = new Scanner(System.in);
        System.out.print("How many players are there? ");
        int numOfPlayers = newScanner.nextInt();
        for (int i = 0; i < numOfPlayers; i++)
        {
            Scanner nameScanner = new Scanner(System.in);
            System.out.print("What is player " + i + "'s name?");
            String playerName = nameScanner.nextLine();

            Player player = new Player(playerName);
            playerList.add(player);
        }


        // game on
        while (gameOn = true)
        {
            dealer.dealerHit(deck);
            dealer.dealerHit(deck);

            for (Player player : playerList)
            {
                player.setBet();
                player.hit(deck);
                player.hit(deck);
            }


             for (Player player : playerList)
            {
                player.playTurn(deck);
                player.handleBet(dealer.getDealerHandValue());
            }
            gameOn = false;
        }
        
        // for(Card card : deck.getCards())
        // {
        //     System.out.println(card);
        // }
    }
}
