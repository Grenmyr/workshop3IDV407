package BlackJack.controller;

import BlackJack.model.CardDealtSubscriber;
import BlackJack.view.IView;
import BlackJack.model.Game;
import BlackJack.view.MenuItem;

public class GameController implements CardDealtSubscriber {
    private Game game;
    private IView view;

    public GameController(Game game, IView view) {
        this.game = game;
        this.view = view;
    }

    public boolean Play() {
        view.DisplayWelcomeMessage();


        if (game.IsGameOver()) {
            view.DisplayPlayerHand(game.GetPlayerHand(), game.GetPlayerScore());
            view.DisplayDealerHand(game.GetDealerHand(), game.GetDealerScore());
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

    @Override
    public void CardDealt(boolean toDealer) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (toDealer) {
            view.DisplayDealerHand(game.GetDealerHand(), game.GetDealerScore());
        } else {
            view.DisplayPlayerHand(game.GetPlayerHand(), game.GetPlayerScore());
        }
    }
}