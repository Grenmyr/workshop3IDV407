package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;
import BlackJack.view.MenuItem;

public class GameController {

    public boolean Play(Game game, IView view) {
        view.DisplayWelcomeMessage();

        view.DisplayDealerHand(game.GetDealerHand(), game.GetDealerScore());
        view.DisplayPlayerHand(game.GetPlayerHand(), game.GetPlayerScore());

        if (game.IsGameOver()) {
            view.DisplayGameOver(game.IsDealerWinner());
        }

        MenuItem input = view.GetInput();

        switch (input) {
            case Play:
                game.NewGame();
                break;
            case Hit:
                game.Hit();
                break;
            case Stand:
                game.Stand();
                break;
            case Quit:
                return false;
        }

        return true;
    }
}