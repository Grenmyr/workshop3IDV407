package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;

class InternationalNewGameStrategy implements INewGameStrategy {

    public boolean NewGame(Deck deck, Dealer dealer, Player player) {

        dealer.dealTo(player, true);
        dealer.dealTo(dealer, true);
        dealer.dealTo(player, true);

//        Card c;
//
//        c = deck.GetCard();
//        c.Show(true);
//        player.DealCard(c);
//
//        c = deck.GetCard();
//        c.Show(true);
//        dealer.DealCard(c);
//
//        c = deck.GetCard();
//        c.Show(true);
//        player.DealCard(c);

        return true;
    }
}