package BlackJack.view;

import BlackJack.model.Card;

public interface IView {
    void DisplayWelcomeMessage();

    MenuItem GetInput();

    void DisplayPlayerHand(Iterable<Card> hand, int score);

    void DisplayDealerHand(Iterable<Card> hand, int score);

    void DisplayGameOver(boolean a_dealerIsWinner);
}