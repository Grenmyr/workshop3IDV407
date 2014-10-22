package BlackJack.view;

public class SwedishView implements IView {
    public void DisplayWelcomeMessage() {

        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        }

        System.out.println("Hej Black Jack Världen");
        System.out.println("----------------------");
        System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
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
            System.out.println("" + e);
            return MenuItem.InvalidChoice;
        }
    }

    public void DisplayCard(BlackJack.model.Card card) {
        if (card.GetColor() == BlackJack.model.Card.Color.Hidden) {
            System.out.println("Dolt Kort");
        } else {
            String colors[] =
                    {"Hjärter", "Spader", "Ruter", "Klöver"};
            String values[] =
                    {"två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess"};
            System.out.println("" + colors[card.GetColor().ordinal()] + " " + values[card.GetValue().ordinal()]);
        }
    }

    public void DisplayPlayerHand(Iterable<BlackJack.model.Card> hand, int score) {
        DisplayHand("Spelare", hand, score);
    }

    public void DisplayDealerHand(Iterable<BlackJack.model.Card> hand, int score) {
        DisplayHand("Croupier", hand, score);
    }

    public void DisplayGameOver(boolean dealerIsWinner) {
        System.out.println("Slut: ");
        if (dealerIsWinner) {
            System.out.println("Croupiern Vann!");
        } else {
            System.out.println("Du vann!");
        }
    }

    private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> hand, int score) {
        System.out.println(a_name + " Har: " + score);
        for (BlackJack.model.Card c : hand) {
            DisplayCard(c);
        }
        System.out.println("Poäng: " + score);
        System.out.println("");
    }
}