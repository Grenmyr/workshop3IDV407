package BlackJack.model;

import BlackJack.model.rules.*;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player {

    private Deck deck;
    private INewGameStrategy newGameStrategy;
    private IHitStrategy hitRule;
    private IWinStrategy winStrategy;
    private List<CardDealtSubscriber> subscribers;

    public Dealer(RulesFactory rulesFactory) {
        subscribers = new ArrayList<CardDealtSubscriber>();

        newGameStrategy = rulesFactory.GetNewGameRule();
        hitRule = rulesFactory.GetHitRule();
        winStrategy = rulesFactory.GetWinStrategy();
    
    /*for(Card c : deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
    }

    public void register(CardDealtSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void NewGame(Player player) {
        if (deck == null || IsGameOver()) {
            deck = new Deck();
            ClearHand();
            player.ClearHand();
            newGameStrategy.NewGame(this, player);
        }
    }

    public boolean Hit(Player player) {
        if (deck != null && player.CalcScore() < MAX_SCORE && !IsGameOver()) {
            dealTo(player, true);

            return true;
        }
        return true;
    }

    public boolean IsDealerWinner(Player player) {
        if (player.CalcScore() > MAX_SCORE) {
            return true;
        } else if (CalcScore() > MAX_SCORE) {
            return false;
        }

        return winStrategy.GetWinner(this, player) instanceof Dealer;
    }

    public boolean IsGameOver() {
        return deck != null && !hitRule.ShouldHit(this);
    }

    public void Stand() {
        if (deck != null) {
            ShowHand();

            while (hitRule.ShouldHit(this)) {
                dealTo(this, true);
            }
        }
    }

    public void dealTo(Player player, boolean visible) {
        Card card = deck.GetCard();
        card.Show(visible);
        player.DealCard(card);

        for (CardDealtSubscriber subscriber : subscribers) {
            subscriber.CardDealt(player instanceof Dealer);
        }
    }
}