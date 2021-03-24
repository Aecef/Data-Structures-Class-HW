import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.awt.*;

/**author acleofe */

public class Planet extends JPanel implements Runnable{

    public static ExecutorService eS =  Executors.newFixedThreadPool(2);// Can Have 2 moons
    private Moon[] moons = new Moon[2];

    private static int existingPlanets = 0;
    private int sunPos = 600;
    private int radius = 200;
    private float angle = 0;
    private int x, y, moonAmount =  0;
    private int xLast, yLast = 0; // Saves the previous coordinates in order to paint over
    private boolean isFirstPaint = true;


    Planet(int sunPos) {
        setFocusable(true);
        System.out.println();
        for (int i = 0; i < existingPlanets; i++) {
            this.x += 20;
            this.y += 20;
            this.radius += 100;
        }
        this.sunPos = sunPos;

    }

    /**
     * MethodName: addMoon
     * Purpose: Add a new moon if there is less than 2 already
     */
    public void addMoon(){
        if(moonAmount < 2){
            moons[moonAmount] = new Moon(this.x, this.y);
            moonAmount++;
        }
    }

    /**
     * MethodName: setXY
     * Purpose: Alters the x and y coordinates of the planet.
     */
    public void setXY() {
        this.x = (int) (Math.cos(angle) * (radius / 3) + (600 / 2));
        this.y = (int) (Math.sin(angle) * (radius / 3) + (600 / 2));
    }

    /**
     * MethodName: changeAngle
     * Purpose: Changes the angle to alter position of the planet and helps determine the new x and y coordinates.
     */
    public void changeAngle(){
        this.angle += 0.1;
        if(this.angle > ( 2* Math.PI))
            this.angle = 0.0f;
    }

    public void firstPaint(){
        setXY();
        changeAngle();
        newExistingPlanet();
    }

    /**
     * MethodName: paintComponent
     * Purpose: First fills the previous position of the planet with the color of the background. Afterwords it fills
     * the new position with the planets color and executes and paints any moons attached to it. Finally the current
     * position is saved for future use.
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(xLast , yLast, 10, 10);
        try {
            Thread.sleep(0,1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(this.isFirstPaint){
            firstPaint();
            g.setColor(Color.BLACK);
            g.fillOval(this.xLast , this.yLast, 10, 10);
            this.isFirstPaint = false;
        }
        else {
            g.setColor(Color.CYAN);
            g.fillOval(this.x, this.y, 10, 10);
        }
        for(Moon m : moons) {
            if (m != null) {
                eS.execute(m);
                m.paintComponent(g);
            }
        }
        this.xLast = this.x;
        this.yLast = this.y;
    }

    /**
     * MethodName: run
     * Purpose: When this Runnable is executed it will update the position of the planet and any moons then repaints.
     */
    @Override
    public void run() {
        changeAngle();
        setXY();
        for (Moon moon : moons){
            if(moon != null){
                moon.newPlanetPos(this.xLast, this.yLast);
                eS.execute(moon);
            }
        }
        repaint();

    }

    public int getX() {return x; }
    public int getSunPos() {return sunPos;}
    public int getR() { return radius;}
    public int getY() {return y;}
    public int getRadius() {return radius;}
    private static void newExistingPlanet() { existingPlanets++; }

}
