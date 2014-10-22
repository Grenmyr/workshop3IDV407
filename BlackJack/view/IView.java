package BlackJack.view;

public interface IView {
    void DisplayWelcomeMessage();

    MenuItem GetInput();

    void DisplayCard(BlackJack.model.Card card);

    void DisplayPlayerHand(Iterable<BlackJack.model.Card> hand, int score);

    void DisplayDealerHand(Iterable<BlackJack.model.Card> hand, int score);

    void DisplayGameOver(boolean a_dealerIsWinner);
}