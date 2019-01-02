//Nicholas Koeppen
//Class for single card
public class Card {
    private String type;
    private String number;
    private String fileID = "";
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
            fileID += number.toUpperCase().substring(0, 1);
        } else if (number.equals("ace")) {
            value = 11;
            fileID += "A";
        } else {
            value = Integer.parseInt(number);
            fileID += value;
        }
        fileID += type.toUpperCase().substring(0, 1);
    }
    
    public int getvalue() {
        return (value);
    }
    
    public String toString() {
        String statement = number + " of " + type;
        return statement;
    }
    
    public String getImagePath() {
        return "images/" + fileID;
    }
}