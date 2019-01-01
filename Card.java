//Nicholas Koeppen
//Class for single card
public class Card {
    private String type;
    private String number;
    private int value;
    
    public Card() {
        type = "spades";
        number = "ace";
        value = 11;
    }
    
    public Card(String t, String n) {
        type = t;
        number = n;
        if (number.equals("queen") || number.equals("king") || number.equals("jack")) {
            value = 10;
        } else if (number.equals("ace")) {
            value = 11;
        } else {
            value = Integer.parseInt(number);
        }
    }
    
    public int getvalue() {
        return (value);
    }
    
    public String toString() {
        String statement = number + " of " + type;
        return statement;
    }
}