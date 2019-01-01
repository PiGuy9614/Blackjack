//Nicholas Koeppen
//Used to play Black Jack
import javax.swing.*;
import java.util.*;
public class BlackJack {
    static int playerTally = 0;
    static int computerTally = 0;
    static int pcount = -1;
    static int ccount = -1;
    static boolean playerOver = false;
    static boolean computerOver = false;
    static boolean playerContinue = true;
    static DeckOfCards main = new DeckOfCards();
    static ArrayList<Card> player = new ArrayList<Card>();
    static ArrayList<Card> computer = new ArrayList<Card>();
    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("SantaSeaver.jpg");
        JOptionPane.showMessageDialog(null, "Let's play some Black Jack! *Aces will equal 11 points* Maybe this time I'll win a home...", "Black Jack", JOptionPane.INFORMATION_MESSAGE, icon);
        main.shuffle();
        main.shuffle();
        main.shuffle();
        while(playerContinue) {
            addCard(true);
            JOPM("You drew a(n) " + (player.get(pcount).toString()));
            String[] options = {"Draw Another Card", "View Cards", "Yield to the Computer"};
            int response = JOptionPane.showOptionDialog(null, "What would you like to do now?", "Gambing Lives with Nick",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
            while (response == 1) {
                System.out.println("Cards in your hand: \n");
                for (int i = 0; i < player.size(); i++) {
                    System.out.println(player.get(i).toString());
                }
                System.out.println("");
                response = JOptionPane.showOptionDialog(null, "What would you like to do now?", "Gambing Lives with Nick",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
            }
            if (response == 0) {
                playerContinue = true;
            } else if (response == 2) {
                playerContinue = false;
                break;
            } else {
                System.exit(0);
            }
        }
        JOPM("It is now the computers turn");
        boolean computerContinue = true;
        while (computerContinue) {
            addCard(false);
            JOPM("The computer drew a(n) " + computer.get(ccount).toString());
            if (computerTally <= 10) {
                if (((int)(Math.random() * 5 + 1)) != 1) {
                    addCard(false);
                    JOPM("The computer drew a(n) " + computer.get(ccount).toString());
                } else {
                    computerContinue = false;
                    break;
                }
            } else if (computerTally > 10 && computerTally < 18) {
                if (((int)(Math.random() * 3 + 1)) != 1) {
                    addCard(false);
                    JOPM("The computer drew a(n) " + computer.get(ccount).toString());
                } else {
                    computerContinue = false;
                    break;
                }
            }else if (computerTally >= 18 && computerTally < 21) {
                if (((int)(Math.random() * 2 + 1)) != 1) {
                    addCard(false);
                    JOPM("The computer drew a(n) " + computer.get(ccount).toString());
                } else {
                    computerContinue = false;
                    break;
                }
            } else {
                computerContinue = false;
                break;
            }
        }
        JOPM("The computer is done with its turn");
        if (computerTally > 21) {
            computerOver = true;
        }
        if (playerTally > 21) {
            playerOver = true;
        }
        if ((playerTally == computerTally) || (playerOver && computerOver)) {
            if (computerOver) {
                JOPM("Huh. It seems we tied!\nI had " + computerTally + " points along with your " + playerTally + " points.\nMaybe I shouldn't have drew that last card...");
            } else {
                JOPM("Huh. It seems we tied!\nI had " + computerTally + " points along with your " + playerTally + " points.");
            }
        } else if ((playerOver && computerTally <= 21) || (((playerTally < computerTally) && computerTally <= 21))) {
            JOPM("HAHA! I WON! GIVE ME YOUR MONEY NOW!!!\nI had " + computerTally + " points against your " + playerTally + " points.");
        } else {
            JOPM("Oh darn. It seems I lost.\nI had " + computerTally + " points against your " + playerTally + " points.");
        }
    }

    public static void addCard(boolean isPlayer) {
        if (main.getcardsLeft() <= 0) {
            JOPM("You are out of cards!!! Click \"OK\" to exit the game...");
            System.exit(0);
        } else {
            if (isPlayer) {
                player.add(main.dealCard());
                pcount++;
                playerTally += player.get(pcount).getvalue();
            } else {
                computer.add(main.dealCard());
                ccount++;
                computerTally += computer.get(ccount).getvalue();
            }
        }
    }

    public static String JOPI(String m) {
        String s = JOptionPane.showInputDialog(null, m);
        return s;
    }

    public static void JOPM(String m) {
        JOptionPane.showMessageDialog(null, m);
    }
}
