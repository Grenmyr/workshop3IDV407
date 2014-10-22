package BlackJack.model.rules;

import BlackJack.model.Player;

public interface IWinStrategy {
    public Player GetWinner(Player dealer, Player player);
}
