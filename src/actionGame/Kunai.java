package actionGame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Kunai {

	private String weapon = "kunai.png";
	
	private int x;
	private int y;
	private Image image;
	private int width, height;
	Boolean visible;
	
	private final int BOARD_WIDTH = 800;
    private final int MISSILE_SPEED = 4;
    
    public Kunai(int x, int y) {

        ImageIcon star = new ImageIcon(this.getClass().getResource(weapon));
        image = star.getImage();
        visible = true;
        width = image.getWidth(null);
        height = image.getHeight(null);
        this.x = x;
        this.y = y;
    }
    
    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }
    
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 14);
    }

    public void move() {
        x += MISSILE_SPEED;
        if (x > BOARD_WIDTH)
            visible = false;
    }

}
