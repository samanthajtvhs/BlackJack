import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) 
    {
        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        ArrayList<Player> playerList = new ArrayList<>();
        boolean gameOn = true;
        
            //checking number of players
        boolean validNumOfPlayers = false;
        while (validNumOfPlayers == false)
        {
            //creating and assigning players
            Scanner newScanner = new Scanner(System.in);
            System.out.print("How many players are there? ");
            int numOfPlayers = newScanner.nextInt();
            if (numOfPlayers <= 4)
            {
                for (int i = 0; i < numOfPlayers; i++)
                {
                    Scanner nameScanner = new Scanner(System.in);
                    System.out.print("What is player " + (i+1) + "'s name? ");
                    String playerName = nameScanner.nextLine();

                    Player player = new Player(playerName);
                    playerList.add(player);
                }
                validNumOfPlayers = true;
                System.out.println(" ");
            }
            else 
            {
                System.out.println("You can't have more than 4 players.");
            }
        }
        
        

        // game on
        while (gameOn == true)
        {
            System.out.println(" ");
            System.out.print("Dealer is showing: ");
            dealer.dealNewCards(deck);
            System.out.println(" ");
            //start
            for (Player player : playerList)
            {
                
                player.setBet();
            }
            System.out.println(" ");
            //player hit
            for (Player player : playerList)
            {
                System.out.println(player.getName() + "'s hand:");
                player.dealNewCards(deck);
                System.out.println(" ");
            }
            //player turn
             for (Player player : playerList)
            {
                player.playTurn(deck);
            }
            //dealer turn
            dealer.dealerTurn(deck);
            dealer.getDealerHandValue();
            // bets outcome
            for (Player player : playerList)
            {
                player.handleBet(dealer.getDealerHandValue());
            }
            // remove players with no money
            for (int i = playerList.size()-1; i >= 0; i--)
            {
                Player player = playerList.get(i);
                if (player.getMoney() == 0.0)
                {
                    playerList.remove(i);
                    System.out.println(player.getName() + " was removed because they don't have any money :(");
                }
            }
            if (playerList.size() == 0)
            {
                break;
            }
            Scanner gameScanner = new Scanner(System.in);
            System.out.print("Do want to keep playing? type y or n ");
            String keepPlaying = gameScanner.nextLine();
            keepPlaying.toLowerCase();
            if (keepPlaying.equals("n"))
            {
                break;
            }
        }
    }
}