package BlackJack.model;

import BlackJack.model.rules.RulesFactory;

public class Game {

    private Dealer dealer;
    private Player player;

    public Game() {
        dealer = new Dealer(new RulesFactory());
        player = new Player();
    }

    public void register(CardDealtSubscriber subscriber) {
        dealer.register(subscriber);
    }

    public boolean IsGameOver() {
        return dealer.IsGameOver();
    }

    public boolean IsDealerWinner() {
        return dealer.IsDealerWinner(player);
    }

    public void NewGame() {
        dealer.NewGame(player);
    }

    public void Hit() {
        dealer.Hit(player);
    }

    public void Stand() {
        dealer.Stand();
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