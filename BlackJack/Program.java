package BlackJack;

import BlackJack.model.Game;
import BlackJack.view.*;
import BlackJack.controller.*;

public class Program {

    public static void main(String[] args) {

        Game game = new Game();
        IView view = new SwedishView();
        GameController gameController = new GameController(game, view);

        game.register(gameController);

        while (gameController.Play());
    }
}