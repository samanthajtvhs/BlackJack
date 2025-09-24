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
            System.out.print("What is player " + (i+1) + "'s name? ");
            String playerName = nameScanner.nextLine();

            Player player = new Player(playerName);
            playerList.add(player);
        }


        // game on
        while (gameOn = true)
        {
            System.out.println("Dealer's Hand:");
            dealer.firstDealerHit(deck);
            dealer.secondDealerHit(deck);
            //start
            for (Player player : playerList)
            {
                
                player.setBet();
            }
            //player hit
            for (Player player : playerList)
            {
                System.out.println(player.getName() + "'s hand:");
                player.hit(deck);
                player.hit(deck);
            }
            //player turn
             for (Player player : playerList)
            {
                player.playTurn(deck);
            }
            //dealer turn
            dealer.dealerTurn(deck);
            // bets outcome
            for (Player player : playerList)
            {
                player.handleBet(dealer.getDealerHandValue());
                if (player.getMoney() == 0)
                {
                    gameOn = false;
                }
            }
            Scanner gameScanner = new Scanner(System.in);
            System.out.print("Do want to keep playing? type yes or no");
            String keepPlaying = gameScanner.nextLine();
            keepPlaying.toLowerCase();

            if (keepPlaying.equals("no"))
            {
                gameOn = false;
            }
        }
    }
}
