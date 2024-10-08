package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    public static final String[] SUIT = {
        "Spade", "Club", "Hearts", "Diamond"
    };
    public static final String[] NAMES = {
        "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", 
        "Nine", "Ten", "Jack", "Queen", "King"
    };
    public static final int[] VALUES = {
        1, 2, 3, 4, 5, 6, 7, 8,
        9, 10, 10, 10, 10
    };

    protected List<Card> cards = new ArrayList<>();    // btm of deck = 0; top of deck = cards.size()-1

    public Deck() {
        Initialise();
    }

    public int getSize() {
        return this.cards.size();
    }

    private void Initialise() {
        cards.clear();
        for(int s = 0; s < SUIT.length; s++) {
            String suit = SUIT[s];

            for(int n = 0; n < NAMES.length; n++) {
                String name = NAMES[n];
                int value = VALUES[n];
                
                // Assign new card its unique attributes
                Card card = new Card(suit, name, value);
                cards.add(card);
            }
        }
    }

    public void Shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card get(int pos) {
        return this.cards.get(pos);
    }

    public Card getTop() {
        return get(this.cards.size() - 1);
    }

    @Override
    public String toString() {
        return "Number of cards: " + cards.size() + "\n";
    }
}
