package actionGame;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Ninja {
	
	private String ninja = "ninja.gif" ;
	
	private int dx;
	private int dy;
	private int x;
	private int y;
	private Image image;
	private boolean visible;
	private int height;
	private int width;
	private ArrayList kunais;
	
	public Ninja()
	{
		ImageIcon nin = new ImageIcon(this.getClass().getResource(ninja));
		image = nin.getImage();
		kunais = new ArrayList<>();
		visible = true;
		height = 131;
		width =  80;
		x=40;
		y=60;
		
	}
	
	public void move()
	{
		x += dx ;
		y += dy ;
		
		if(x<0){
			x=0;
		}
		if(y<-10){
			y=-10;
		}
		if(x>720){
			x=720;
		}
		if(y>530){
			y=530;
		}
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Image getImage()
	{
		return image;
	};
	
	public ArrayList getKunais()
	{
		return kunais;
	}
	
	public void setVisible(boolean visible)
	{
		this.visible=visible;
	}
	
	public boolean isVisible()
	{
		return visible;
	}
	
	public Rectangle getBounds() {
        return new Rectangle(x, y, width, height/2);
    }
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_SPACE)
		{
			attack();
		}
		
		if(key == KeyEvent.VK_LEFT)
		{
			dx = -3;
		}
		
		if(key == KeyEvent.VK_RIGHT)
		{
			dx = 3;
		}
		
		if(key == KeyEvent.VK_DOWN)
		{
			dy = 3;
		}
		
		if(key == KeyEvent.VK_UP)
		{
			dy = -3;
		}
	}
	
	public void attack()
	{
		kunais.add(new Kunai(x + 40,y + 15));
	}

	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT)
		{
			dx = 0;
		}
		
		if(key == KeyEvent.VK_RIGHT)
		{
			dx = 0;
		}
		
		if(key == KeyEvent.VK_DOWN)
		{
			dy = 0;
		}
		
		if(key == KeyEvent.VK_UP)
		{
			dy = 0;
		}
	}
		
}
