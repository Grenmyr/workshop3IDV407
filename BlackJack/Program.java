package BlackJack;

import BlackJack.view.*;
import BlackJack.controller.*;

public class Program {

    public static void main(String[] args) {

        BlackJack.model.Game game = new BlackJack.model.Game();
        IView view = new SwedishView();
        GameController playGame = new GameController();

        while (playGame.Play(game, view));
    }
}