package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;

class AmericanNewGameStrategy implements INewGameStrategy {

    public boolean NewGame(Deck deck, Dealer dealer, Player player) {
        //Card c;

//        c = deck.GetCard();
//        c.Show(true);
//        player.DealCard(c);

        dealer.dealTo(player, true);
        dealer.dealTo(dealer, true);
        dealer.dealTo(player, true);
        dealer.dealTo(dealer, false);

//        c = deck.GetCard();
//        c.Show(true);
//        dealer.DealCard(c);

//        c = deck.GetCard();
//        c.Show(true);
//        player.DealCard(c);

//        c = deck.GetCard();
//        c.Show(false);
//        dealer.DealCard(c);

        return true;
    }
}