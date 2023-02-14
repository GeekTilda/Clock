import javax.swing.*;
import java.awt.*;

public class ClockFaze extends JPanel { //Yes, I can apperently not gammar.
    private int size;
    private int middle;
    final double angle = (2*Math.PI)/12;
    private int cirkSize;
    private Dimension dim = new Dimension(size,size);

    public ClockFaze(int size) {
        this.size = size;
        middle = size/2;
        this.setBackground(Color.pink); //Sets the background color
        this.setPreferredSize(new Dimension(size,size));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        face(g);
        drawNum(g);
    }

    public void face(Graphics g) {
        int x = (int) (size*0.1);
        int y = x;
        cirkSize = size - x*2;
        g.setColor(Color.gray);
        g.fillOval(x,y,cirkSize,cirkSize);
    }

    public void drawNum(Graphics g) {
        int dx,dy;
        int dist = (int) (cirkSize*0.9)/2;
        for (int i = 1; i <= 12; i++) {
            double v = angle*i;
            dx = (int) (dist * Math.sin(v)) + middle;
            dy = (int) (-dist * Math.cos(v)) + middle;
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(i),dx,dy);
            g.fillOval(dx,dy,7,7);
        }
    }
}
