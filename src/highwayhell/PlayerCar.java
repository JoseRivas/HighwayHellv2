package highwayhell;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class PlayerCar {

    Image img = null;
    Rectangle rect = null;
    int x, y, dx, dy;

    public PlayerCar(Image _img, int _x, int _y) {
        this.x = _x;
        this.y = _y;
        this.img = _img;
        this.rect = new Rectangle(x, y, img.getWidth(null), img.getHeight(null));

    }

    public Rectangle getRect() {
        return this.rect;
    }

    public Image getImg() {
        return this.img;
    }

    public void move() {
        x += dx;
        y += dy;
        this.rect.setLocation(x, y);
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(img, rect.x, rect.y, rect.width, rect.height, null);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }
        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
