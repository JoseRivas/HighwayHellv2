package highwayhell;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PanDisp extends JPanel // panel definition
{

    PanOut panOut;
    private int nScore, nHighScore;
    int Road1xPos, Road2xPos, xPos, xPos2, xPos3, yPos, yPos2, yPos3, nCrash, nSpeed;
    Timer timer;
    Image road, Explosion;
    private Obstacle obs1, obs2, obs3;
    private PlayerCar car;

    public PanDisp(PanOut _panOut) {
        panOut = _panOut;
        addKeyListener(new AL());
        setFocusable(true);
        timer = new Timer(1, drive);
        road = getImage("road.jpg");
        Explosion = getImage("explosion.png");
        car = new PlayerCar(getImage("yellowcar.png"), 0, 350);
        obs1 = new Obstacle(getRandImg(), xPos, yPos);
        obs2 = new Obstacle(getRandImg(), xPos2, yPos2);
        obs3 = new Obstacle(getRandImg(), xPos3, yPos3);
        // this Panel will contain all of the output, therefore called PanDisp for display
        // It will be in the CENTRE of PanMain
        nHighScore = 0;
        this.setVars();
        timer.start();

    }

    void setVars() {
        xPos = 1200;
        yPos = (int) (Math.random() * 700) + 1;
        xPos2 = 600;
        yPos2 = (int) (Math.random() * 700) + 1;
        xPos3 = 900;
        yPos3 = (int) (Math.random() * 700) + 1;
        Road1xPos = 0;
        Road2xPos = 800;
        nCrash = 0;
        nScore = 0;
        nSpeed = -1;
    }
    ActionListener drive = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (xPos < -120) {
                xPos = getWidth() + 120;
                yPos = (int) (Math.random() * (getHeight() - 60)) + 1;
                obs1 = new Obstacle(getRandImg(), xPos, yPos);
            }
            if (xPos2 < -120) {
                xPos2 = getWidth() + 120;
                yPos2 = (int) (Math.random() * (getHeight() - 60)) + 1;
                obs2 = new Obstacle(getRandImg(), xPos2, yPos2);
            }
            if (xPos3 < -120) {
                xPos3 = getWidth() + 120;
                yPos3 = (int) (Math.random() * (getHeight() - 60)) + 1;
                obs3 = new Obstacle(getRandImg(), xPos3, yPos3);
            }
            if (Road1xPos < (-road.getWidth(null))) {
                Road1xPos = road.getWidth(null);
            }
            if (Road2xPos < (-road.getWidth(null))) {
                Road2xPos = road.getWidth(null);
            }
            if (isCrash()) {
                repaint();
                Delay(1000);
                setVars();
                car.x = 0;
                car.y = 350;
            }
            Road1xPos += nSpeed;
            Road2xPos += nSpeed;
            xPos += nSpeed;
            xPos2 += nSpeed;
            xPos3 += nSpeed;
            nScore++;
            repaint();
            if (nScore > nHighScore) {
                nHighScore = nScore;
            }
            if (nScore % 2000 == 0 && nSpeed < 8) {
                nSpeed -= 1;//every 2000 score increase speed by 1, maximum is 8
            }
            panOut.UpdateLabel("Score:" + nScore, "Highscore:" + nHighScore,"Speed:"+Math.abs(nSpeed));

        }
    };

    boolean isCrash() {
        return obs1.intersects(car.getRect()) || obs2.intersects(car.getRect()) || obs3.intersects(car.getRect());
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paint(g2);
        g2.drawImage(road, Road1xPos, 0, 810, getHeight(), null);
        g2.drawImage(road, Road2xPos, 0, 810, getHeight(), null);
        CheckBounds();
        car.move();
        obs1.move(xPos, yPos);
        obs2.move(xPos2, yPos2);
        obs3.move(xPos3, yPos3);
        car.draw(g2);
        obs1.draw(g2);
        obs2.draw(g2);
        obs3.draw(g2);
        if (isCrash()) {
            g2.drawImage(Explosion, car.x - 30, car.y - 120, null);
        }

    }

    void Delay(int nTime) {
        try {
            Thread.sleep(nTime);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    void CheckBounds() {
        if (car.x <= 0 && car.dx == -1) {
            car.dx = 0;
        }
        if (car.y <= 0 && car.dy == -1) {
            car.dy = 0;
        }
        if (car.x >= getWidth() - 120 && car.dx == 1) {
            car.dx = 0;
        }
        if (car.y >= getHeight() - 60 && car.dy == 1) {
            car.dy = 0;
        }
    }

    public Image getImage(String path) {
        Image tempImage = null;
        try {
            tempImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return tempImage;
    }

    public Image getRandImg() {
        Image img = null;
        int nRand;
        String sFilename;
        nRand = (int) (Math.random() * 5) + 1;
        if (nRand == 1) {
            sFilename = "yellowcar.png";
        } else if (nRand == 2) {
            sFilename = "greycar.png";
        } else if (nRand == 3) {
            sFilename = "police.png";
        } else if (nRand == 4) {
            sFilename = "bluecar.png";
        } else {
            sFilename = "whitecar.png";
        }
        try {
            img = ImageIO.read(new File(sFilename));
        } catch (IOException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return img;
    }

    private class AL extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            car.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            car.keyReleased(e);
        }
    }
}
