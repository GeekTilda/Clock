import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        start();
    }
    public static void start() {
        int size = 250;
        //Basic frame setup
        JFrame myFrame = new JFrame("CLOCK <3"); //Starts the frame which everything will happen on.
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets the frame to exit when closed.
        myFrame.setSize(new Dimension(size, size)); //Size of the frame
        myFrame.setResizable(false);
        //Sets the clockface (clockfaze) to the frame
        myFrame.add(new ClockFaze(size));
        //Packages the frame
        myFrame.pack();
        myFrame.setVisible(true);
        ImageIcon image = new ImageIcon("download.jpg"); // crates a imageicon
        myFrame.setIconImage(image.getImage()); //Changes the icon in the top left corner to this picture.

    }
}