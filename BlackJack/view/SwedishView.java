package BlackJack.view;

import BlackJack.model.Card;

public class SwedishView implements IView {
    public void DisplayWelcomeMessage() {

//        for (int i = 0; i < 50; i++) {
//            System.out.print("\n");
//        }

        System.out.println("Hej Black Jack Världen");
        System.out.println("----------------------");
        System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
    }

    public MenuItem GetInput() {
        String input = System.console().readLine();

        if (input.equals("p")) {
            return MenuItem.Play;
        } else if (input.equals("h")) {
            return MenuItem.Hit;
        } else if (input.equals("s")) {
            return MenuItem.Stand;
        } else if (input.equals("q")) {
            return MenuItem.Quit;
        } else {
            return MenuItem.InvalidChoice;
        }
    }

    public void DisplayCard(Card card) {
        if (card.GetColor() == Card.Color.Hidden) {
            System.out.println("Dolt Kort");
        } else {
            String colors[] =
                    {"Hjärter", "Spader", "Ruter", "Klöver"};
            String values[] =
                    {"två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess"};
            System.out.println("" + colors[card.GetColor().ordinal()] + " " + values[card.GetValue().ordinal()]);
        }
    }

    public void DisplayPlayerHand(Iterable<Card> hand, int score) {
        DisplayHand("Spelare", hand, score);
    }

    public void DisplayDealerHand(Iterable<Card> hand, int score) {
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

    private void DisplayHand(String a_name, Iterable<Card> hand, int score) {
        System.out.println(a_name + " Har: " + score);
        for (Card card : hand) {
            DisplayCard(card);
        }
        System.out.println("Poäng: " + score);
        System.out.println("");
    }
}