package BlackJack.model;

import BlackJack.model.rules.RulesFactory;

public class Game {

    private Dealer dealer;
    private Player player;

    public Game() {
        dealer = new Dealer(new RulesFactory());
        player = new Player();
    }


    public boolean IsGameOver() {
        return dealer.IsGameOver();
    }

    public boolean IsDealerWinner() {
        return dealer.IsDealerWinner(player);
    }

    public boolean NewGame() {
        return dealer.NewGame(player);
    }

    public boolean Hit() {
        return dealer.Hit(player);
    }

    public boolean Stand() {
        dealer.Stand();
        // TODO: Implement this according to Game_Stand.sequencediagram
        return true;
    }

    public Iterable<Card> GetDealerHand() {
        return dealer.GetHand();
    }

    public Iterable<Card> GetPlayerHand() {
        return player.GetHand();
    }

    public int GetDealerScore() {
        return dealer.CalcScore();
    }

    public int GetPlayerScore() {
        return player.CalcScore();
    }


}