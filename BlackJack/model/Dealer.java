package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

    private Deck deck;
    private INewGameStrategy newGameStrategy;
    private IHitStrategy hitRule;
    private IWinStrategy winStrategy;

    public Dealer(RulesFactory rulesFactory) {

        newGameStrategy = rulesFactory.GetNewGameRule();
        hitRule = rulesFactory.GetHitRule();
        winStrategy = rulesFactory.GetWinStrategy();
    
    /*for(Card c : deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
    }


    public boolean NewGame(Player player) {
        if (deck == null || IsGameOver()) {
            deck = new Deck();
            ClearHand();
            player.ClearHand();
            return newGameStrategy.NewGame(deck, this, player);
        }
        return false;
    }

    public boolean Hit(Player player) {
        if (deck != null && player.CalcScore() < MAX_SCORE && !IsGameOver()) {
            dealTo(player, true);
//            Card card;
//            card = deck.GetCard();
//            card.Show(true);
//            player.DealCard(card);

            return true;
        }
        return false;
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
//                Card card = deck.GetCard();
//                card.Show(true);
//                DealCard(card);
                dealTo(this, true);
            }
        }
    }

    public void dealTo(Player player, boolean visible) {
        Card card = deck.GetCard();
        card.Show(visible);
        player.DealCard(card);
    }
}