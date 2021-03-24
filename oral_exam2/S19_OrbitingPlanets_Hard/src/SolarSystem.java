import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**author acleofe */

public class SolarSystem extends JFrame{

    public static ExecutorService executorService =  Executors.newFixedThreadPool(8);
    private Planet[] planets = new Planet[8];
    private int planetAmount = 0;
    private int mainPosX = 280;
    private int mainPosY = 280;
    private boolean isPlanetThere = false;


    SolarSystem(){

        setTitle("Orbiting Planets");
        setSize(600,600);
        setVisible(true);
        setBackground(Color.black);
        addMouseListener(new mouseHandler());
        addKeyListener(new keyHandler());
        setResizable(false);

    }

    public void setIsPlanetThere(boolean x){ this.isPlanetThere = x;  }

    /**
     * MethodName: paint
     * Purpose: Paints the sun and executes the amount of planets within the executor
     */
    public void paint(Graphics circle){
        circle.setColor(Color.YELLOW);
        circle.fillOval(mainPosX, mainPosY, 50, 50);

        for(Planet p : planets) {
            if (p != null) {
                executorService.execute(p);
                p.paintComponent(circle);
            }
        }
        try{
            Thread.sleep(20);
            repaint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SolarSystem sun = new SolarSystem();
        sun.setVisible(true);
        sun.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * MethodName: mouseHandler
     * Purpose: Detects if the mouse has been clicked in order to add a new planet
     */
    public class mouseHandler implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {
            if(planetAmount <= 7) {
                planets[planetAmount] = new Planet(600);
                planetAmount++;
                setIsPlanetThere(true);
            }

        }
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    }
    /**
     * MethodName: keyHandler
     * Purpose: Detects if the a key has been pressed and if it is within the key code range for the keys 1-8 in
     * order to attach moons to the corresponding planets
     */
    public class keyHandler implements KeyListener {
        @Override
        public void keyTyped(KeyEvent event) {}
        @Override
        public void keyPressed(KeyEvent event) {}
        @Override
        public void keyReleased(KeyEvent event) {
            if(event.getKeyCode() >= 49 && event.getKeyCode() <= 56){
                if(planets[event.getKeyCode() - 49] != null ){
                    planets[event.getKeyCode() - 49].addMoon();
                }
            }
        }
    }
}