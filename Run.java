import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Deck deck = new Deck();
        
        //creating and assigning players
        Scanner newScanner = new Scanner(System.in);
        System.out.print("How many players are there? ");
        int numOfPlayers = newScanner.nextInt();


        ArrayList<Player> playerList = new ArrayList<>();
        boolean gameOn = true;
        
        for (int i = 0; i < numOfPlayers; i++)
        {
            Scanner nameScanner = new Scanner(System.in);
            System.out.print("What is player " + i + "'s name?");
            String playerName = nameScanner.nextLine();

            Player player = new Player(playerName);
            playerList.add(player);
        }

        while (gameOn = true)
        {
            for (Player player : playerList)
            {
                player.setBet();
                player.hit(deck);
                player.hit(deck);
            }
        }

        for (int i = 0; i <= playerList.size(); i++)
        {
           Player currentPlayer = playerList.get(i);
           currentPlayer.playTurn(deck);
          // handleValue(getDealerHandValue());
        }

        

        for(Card card : deck.getCards())
        {
            System.out.println(card);
        }
    }
}
