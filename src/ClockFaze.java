import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class ClockFaze extends JPanel { //Yes, I can apperently not gammar.
    private int size;
    private int middle;
    final double angle = (2*Math.PI)/12;
    private int cirkSize;
    private int dx,dy;
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

        drawSecond(g);
        drawMinute(g);
        drawHour(g);
        repaint(); //??
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
            g.setColor(Color.PINK);
            g.fillOval(dx,dy,7,7);
        }
    }

    public void drawSecond(Graphics g) {
        double v = angle/5;
        int dist = 100;
        LocalTime time = LocalTime.now();
        int second = time.getSecond();
        dx = (int) (dist * Math.sin(v*second)) + middle;
        dy = (int) (-dist * Math.cos(v*second)) + middle;
        g.setColor(Color.PINK);
        g.drawLine(middle,middle,dx,dy);
    }

    public void drawMinute(Graphics g) {
        double v = angle/5;
        int dist = 75;
        LocalTime time = LocalTime.now();
        int minute = time.getMinute();
        dx = (int) (dist * Math.sin(v*minute)) + middle;
        dy = (int) (-dist * Math.cos(v*minute)) + middle;
        g.setColor(Color.BLACK);
        g.drawLine(middle,middle,dx,dy);
    }
    public void drawHour(Graphics g) {
        int dist = 50;
        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        dx = (int) (dist * Math.sin(angle*hour)) + middle;
        dy = (int) (-dist * Math.cos(angle*hour)) + middle;
        g.setColor(Color.BLACK);
        g.drawLine(middle,middle,dx,dy);
    }
}
