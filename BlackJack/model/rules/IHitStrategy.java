package BlackJack.model.rules;

import BlackJack.model.Player;

public interface IHitStrategy {
    boolean ShouldHit(Player dealer);
}