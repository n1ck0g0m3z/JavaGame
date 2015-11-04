package actionGame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy {
	private String weapon = "dragon.jpg";
	
	private int x;
	private int y;
	private Image image;
	private int width, height;
	Boolean visible;
	
	public Enemy(int x, int y)
	{
		ImageIcon enemy = new ImageIcon(this.getClass().getResource(weapon));
		image = enemy.getImage();
		height = image.getHeight(null);
		width = image.getWidth(null);
		visible = true;
		this.x = x;
		this.y = y;
	}
	
	public void move()
	{
		if(x<0)
			x=800;
		x -= 2;
	}
	
	public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Image getImage() {
        return image;
    }
    
    public Rectangle getBounds()
    {
    	return new Rectangle(x, y, width/10, height/10);
    }
}
