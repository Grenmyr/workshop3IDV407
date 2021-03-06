package BlackJack.model;

import java.util.List;
import java.util.LinkedList;

public class Deck {

    private List<Card> cards;

    public Deck() {
        cards = new LinkedList<Card>();

        for (int cIx = 0; cIx < Card.Color.Count.ordinal(); cIx++) {
            for (int vIx = 0; vIx < Card.Value.Count.ordinal(); vIx++) {
                Card c = new Card(Card.Color.values()[cIx], Card.Value.values()[vIx]);
                AddCard(c);
            }
        }

        Shuffle();
    }


    public void AddCard(Card cardToAdd) {
        cards.add(cardToAdd);
    }

    public Card GetCard() {
        Card card = cards.get(0);
        cards.remove(0);

        return card;
    }

    private void Shuffle() {
        for (int i = 0; i < 1017; i++) {
            int index = (int) (Math.random() * 171717.0) % cards.size();
            Card c = cards.get(index);
            cards.remove(index);
            AddCard(c);
        }
    }

}