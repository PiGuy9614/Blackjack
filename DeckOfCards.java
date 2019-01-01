//Nicholas Koeppen
//Class for the deck of cards
public class DeckOfCards {
    private Card[] deck = new Card[52];
    private int cardsLeft;
    public DeckOfCards() {
        int count = 0;
        for (int x = 2; x < 11; x++) {
            deck[count] = new Card("spades", x + "");
            count++;
        }
        deck[count] = new Card("spades", "jack");
        count ++;
        deck[count] = new Card("spades", "queen");
        count ++;
        deck[count] = new Card("spades", "king");
        count ++;
        deck[count] = new Card("spades", "ace");
        count ++;
        for (int x = 2; x < 11; x++) {
            deck[count] = new Card("diamonds", x + "");
            count++;
        }
        deck[count] = new Card("diamonds", "jack");
        count ++;
        deck[count] = new Card("diamonds", "queen");
        count ++;
        deck[count] = new Card("diamonds", "king");
        count ++;
        deck[count] = new Card("diamonds", "ace");
        count ++;
        for (int x = 2; x < 11; x++) {
            deck[count] = new Card("hearts", x + "");
            count++;
        }
        deck[count] = new Card("hearts", "jack");
        count ++;
        deck[count] = new Card("hearts", "queen");
        count ++;
        deck[count] = new Card("hearts", "king");
        count ++;
        deck[count] = new Card("hearts", "ace");
        count ++;
        for (int x = 2; x < 11; x++) {
            deck[count] = new Card("clubs", x + "");
            count++;
        }
        deck[count] = new Card("clubs", "jack");
        count ++;
        deck[count] = new Card("clubs", "queen");
        count ++;
        deck[count] = new Card("clubs", "king");
        count ++;
        deck[count] = new Card("clubs", "ace");
        count ++;
        cardsLeft = 52;
    }

    public void shuffle() {
        for (int i = 0; i < 100; i++) {
            int pos1 = (int)(Math.random() * cardsLeft);
            int pos2 = (int)(Math.random() * cardsLeft);
            Card temp = deck[pos1];
            deck[pos1] = deck[pos2];
            deck[pos2] = temp;
        }
    }

    public String dealCards(int amount) {
        String statement = "Cards\n\n";
        if (amount > cardsLeft) {
            amount = cardsLeft;
        }
        for (int i = 0; i < amount; i++) {
            statement += (i+1) + "\t" + deck[i].toString() + "\n";
        }
        cardsLeft -= amount;
        return statement;
    }

    public Card dealCard() {
        Card card = deck[cardsLeft - 1];
        cardsLeft--;
        return card;
    }

    public int getcardsLeft() {
        return cardsLeft;
    }
    
    public String showAllCards() {
        String statement = "Cards\n\n";
        for (int i = 0; i < 52; i++) {
            statement += (i+1) + "\t" + deck[i].toString() + "\n";
        }
        return statement;
    }

}