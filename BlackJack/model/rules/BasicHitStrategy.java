package BlackJack.model.rules;

import BlackJack.model.Player;

class BasicHitStrategy implements IHitStrategy {
    private final int hitLimit = 17;

    public boolean ShouldHit(Player dealer) {
        return dealer.CalcScore() < hitLimit;
    }
}