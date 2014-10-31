package BlackJack.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    protected final static int MAX_SCORE = 21;
    private final static int[] CARD_SCORES = {
            2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11
    };

    private List<Card> hand;

    public Player() {
        assert (CARD_SCORES.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";

        hand = new ArrayList<Card>();
    }

    public void DealCard(Card addToHand) {
        hand.add(addToHand);
    }

    public Iterable<Card> GetHand() {
        return hand;
    }

    public int CalcScore() {
        int score = 0;

        for (Card c : hand) {
            if (c.GetValue() != Card.Value.Hidden) {
                score += CARD_SCORES[c.GetValue().ordinal()];
            }
        }

        if (score > MAX_SCORE) {
            for (Card card : hand) {
                if (card.GetValue() == Card.Value.Ace && score > MAX_SCORE) {
                    score -= 10;
                }
            }
        }

        return score;
    }

    public boolean HaveSoftHand() {
        int score = 0;

        for (Card c : hand) {
            if (c.GetValue() != Card.Value.Hidden) {
                score += CARD_SCORES[c.GetValue().ordinal()];
            }
        }

        if (score < MAX_SCORE) {
            for (Card card : hand) {
                if (card.GetValue() == Card.Value.Ace) {
                    return true;
                }
            }
        }

        return false;
    }

    public void ClearHand() {
        hand.clear();
    }

    public void ShowHand() {
        for (Card card : hand) {
            card.Show(true);
        }
    }
}