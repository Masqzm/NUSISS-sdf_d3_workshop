package cards;

public class Card {
    protected final String suit;  // ♤♧♡◇
    protected final String name;  // card's rank
    protected final int value;
    
    // Makes it a requirement to create Card with the following params
    public Card(String suit, String name, int value) {
        this.suit = suit;
        this.name = name;
        this.value = value;
    }

    public String getSuit() { return suit; }
    public String getName() { return name; }
    public int getValue() { return value; }

    @Override
    public String toString() {
        return "Suit: %s, Name: %s, Value: %d".formatted(this.suit, this.name, this.value);
    }
}
