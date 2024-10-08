package cards;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Card card = deck.getTop();

        //System.out.println(card);     // print top card
        System.out.println(deck);

        System.out.println("Sorted deck");
        for(int i = 0; i < deck.getSize(); i++) {
            card = deck.get(i);
            System.out.println(card);                        
        }

        deck.Shuffle();

        System.out.println("\nShuffled deck");
        for(int i = 0; i < deck.getSize(); i++) {
            card = deck.get(i);
            System.out.println(card);                        
        }
    }
}