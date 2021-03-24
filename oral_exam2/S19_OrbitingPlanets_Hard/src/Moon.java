import javax.swing.*;
import java.awt.*;
/**author acleofe */

public class Moon extends JPanel implements Runnable{

    private int pPosX, pPosY;
    private int x, y, xLast, yLast, existingMoons = 0;
    private int radius = 175;
    private float angle = 0;
    private boolean isFirstPaint = false;

    Moon(int pPosX, int pPosY) {

        for (int i = 0; i < existingMoons; i++) {
            this.x += 10;
            this.y += 10;
            this.radius += 50;
        }
        this.pPosX = pPosX;
        this.pPosY = pPosY;
    }
    public void changeAngle(){
        this.angle += 0.1;
        if(this.angle > ( 2* Math.PI))
            this.angle = 0.0f;
    }


    public void setXY() {
        this.x = (int) (Math.cos(angle) * (150 / 3) + ((pPosX+300) / 2));
        this.y = (int) (Math.sin(angle) * (150 / 3) + ((pPosY+300) / 2));

/*        this.x = (int) (Math.cos(angle) * (pPosX / 3) + (pPosY / 2));
        this.y = (int) (Math.sin(angle) * (pPosY / 3) + (pPosX / 2));*/
    }

    public void paintComponent(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillOval(xLast , yLast, 5, 5);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(this.isFirstPaint){
            firstPaint();
            g.setColor(Color.BLACK);
            g.fillOval(this.xLast , this.yLast, 5, 5);
            this.isFirstPaint = false;
        }
        else {
            g.setColor(Color.GRAY);
            g.fillOval(this.x, this.y, 5, 5);
        }
        this.xLast = this.x;
        this.yLast = this.y;
    }
    public void newPlanetPos(int x, int y){
        this.pPosX = x;
        this.pPosY = y;
    }

    public void firstPaint(){
        setXY();
        changeAngle();
        existingMoons++;
    }
    public void run() {
        changeAngle();
        setXY();
        repaint();
    }
}
