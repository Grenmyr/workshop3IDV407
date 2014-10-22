package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

class InternationalNewGameStrategy implements INewGameStrategy {

    public boolean NewGame(Dealer dealer, Player player) {

        dealer.dealTo(player, true);
        dealer.dealTo(dealer, true);
        dealer.dealTo(player, true);

        return true;
    }
}