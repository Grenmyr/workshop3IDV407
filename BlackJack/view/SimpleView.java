package BlackJack.view;

public class SimpleView implements IView {

    public void DisplayWelcomeMessage() {
        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        }
        ;
        System.out.println("Hello Black Jack World");
        System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
    }

    public MenuItem GetInput() {
        try {
            int input = System.in.read();

            switch (input) {
                case 'p':
                    return MenuItem.Play;
                case 'h':
                    return MenuItem.Hit;
                case 's':
                    return MenuItem.Stand;
                case 'q':
                    return MenuItem.Quit;
                default:
                    return MenuItem.InvalidChoice;
            }
        } catch (java.io.IOException e) {
            System.out.println(e.toString());
            return MenuItem.InvalidChoice;
        }
    }

    public void DisplayCard(BlackJack.model.Card card) {
        System.out.println("" + card.GetValue() + " of " + card.GetColor());
    }

    public void DisplayPlayerHand(Iterable<BlackJack.model.Card> hand, int score) {
        DisplayHand("Player", hand, score);
    }

    public void DisplayDealerHand(Iterable<BlackJack.model.Card> hand, int score) {
        DisplayHand("Dealer", hand, score);
    }

    private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> hand, int score) {
        System.out.println(a_name + " Has: ");
        for (BlackJack.model.Card c : hand) {
            DisplayCard(c);
        }
        System.out.println("Score: " + score);
        System.out.println("");
    }

    public void DisplayGameOver(boolean dealerIsWinner) {
        System.out.println("GameOver: ");
        if (dealerIsWinner) {
            System.out.println("Dealer Won!");
        } else {
            System.out.println("You Won!");
        }

    }
}