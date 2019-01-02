//Nicholas Koeppen
//Used to learn more about JFrame, etc
import java.util.*;
import javax.swing.*; //For prompts
import java.awt.*; //For normal graphics
import java.awt.event.*; //For Listeners
import java.io.File; //For Music
import javafx.scene.media.*; //For Music
import sun.audio.*; //For Music
import java.io.*; //For Music
public class BlackjackGUI extends JPanel { //Extends JPanel class
    static int playerTally;
    static int computerTally;
    static int pcount;
    static int ccount;
    static boolean playerOver;
    static boolean computerOver;
    static boolean playerContinue;
    static DeckOfCards main;
    static ArrayList<Card> player;
    static ArrayList<Card> computer;

    public BlackjackGUI (){
        playerTally = 0;
        computerTally = 0;
        pcount = -1;
        ccount = -1;
        playerOver = false;
        computerOver = false;
        playerContinue = true;
        main = new DeckOfCards();
        player = new ArrayList<Card>();
        computer = new ArrayList<Card>();
    }

    //This method is very special in Java since is automatically called by the JVM (Java Virtual Machine)
    //This is an example of over-riding a method (it is already in JPanel but now we are over-riding it by writing our own like the toString method)
    public void paintComponent(Graphics g) {
        //Calling the JPanel paintComponents method
        super.paintComponent(g);
        //The code succeeding this is NOT in JPanel's paintComponent method     
        repaint();
    }

    public void JOPM(String m) {
        JOptionPane.showMessageDialog(null, m);
    }

    public Color rColor() {
        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);
        Color color = new Color(r,g,b);
        return color;
    }

    public class EndGame extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            // uriString = new File("Crane.mp3").toURI().toString();
            // music = new MediaPlayer(new Media(uriString));
            // music.play();
            // try {
            // Thread.sleep(158000);
            // } catch (Exception except) {
            // JOptionPane.showMessageDialog(null, "Oh No! I crashed...");
            // }
            System.exit(0);
        }
    }

}