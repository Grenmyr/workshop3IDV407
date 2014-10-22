package BlackJack.model.rules;

import BlackJack.model.Player;

public class PlayerWinsOnEqualScore implements IWinStrategy {
    @Override
    public Player GetWinner(Player dealer, Player player) {
        if (dealer.CalcScore() > player.CalcScore()) {
            return dealer;
        } else {
            return player;
        }
    }
}
