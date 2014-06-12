package highwayhell;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

public class Obstacle {

    Image img = null;
    Rectangle rect = null;

    public Obstacle(Image _img, int x, int y) {
        this.img = _img;
        this.rect = new Rectangle(x, y, img.getWidth(null), img.getHeight(null));

    }

    public Rectangle getRect() {
        return this.rect;
    }

    public Image getImg() {
        return this.img;
    }

    public void move(int x, int y) {
        this.rect.setBounds(x, y, rect.width, rect.height);
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(img, rect.x, rect.y, rect.width, rect.height, null);
    }

    public boolean intersects(Rectangle r) {
        return rect.intersects(r);
    }

    public Rectangle intersection(Rectangle r) {
        return rect.intersection(r);
    }
}
