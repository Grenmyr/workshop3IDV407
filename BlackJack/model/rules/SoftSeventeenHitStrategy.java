package BlackJack.model.rules;

import BlackJack.model.Player;

class SoftSeventeenHitStrategy implements IHitStrategy {
    private final int hitLimit = 17;

    public boolean ShouldHit(Player dealer) {
        int score = dealer.CalcScore();
        return score < hitLimit ||
               dealer.HaveSoftHand() && score == hitLimit;
    }
}