package actionGame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

//http://zetcode.com/tutorials/javagamestutorial/collision/
import javax.swing.Timer;

public class World extends Applet implements ActionListener {

	private Timer timer;
	private Ninja ninja;
	private boolean inGame;
	private ArrayList enemys;
	private int [] pos;
	
	public World()
	{
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.LIGHT_GRAY);
		
		Random rnd = new Random();
		pos = new int[(int)(rnd.nextDouble() * 100 + 0)];
		
		for(int i=0 ; i<pos.length ;i++){
			pos[i] = (int)(rnd.nextDouble() * 550 + 10) ;
		}
		
		inGame = true;

		ninja = new Ninja();

		initAliens();
		
		timer = new Timer(6, this);
		timer.start();
	}
	
	public void initAliens()
	{
		enemys = new ArrayList();
		
		Random rnd = new Random();
		
		for(int i=0; i < pos.length ;i++){
			enemys.add(new Enemy((int)(rnd.nextDouble() * 2000 + 600), pos[i]));
		}
	}
	
	public void actionPerformed(ActionEvent e) {
	    ArrayList ks = ninja.getKunais();
	    
	    if(enemys.size()==0){
	    	inGame = true;
	    }
	
	    for (int i = 0; i < ks.size(); i++) {
	        Kunai k = (Kunai) ks.get(i);
	        if (k.isVisible()) 
	            k.move();
	        else ks.remove(i);
	    }
	    
	    for (int i = 0; i < enemys.size(); i++) {
            Enemy a = (Enemy)enemys.get(i);
            if (a.isVisible()) 
                a.move();
            else enemys.remove(i);
        }
	    
		ninja.move();
		checkCollisions();
		repaint();
	}
		
	public void checkCollisions(){
		Rectangle recNin = ninja.getBounds();
		
		for (int i=0 ; i < enemys.size() ; i++){
			Enemy ene = (Enemy)enemys.get(i);
			Rectangle recEne = ene.getBounds();
			
			if(recNin.intersects(recEne)){
				ene.setVisible(false);
				ninja.setVisible(false);
				inGame = false;
			}
		}
		
		ArrayList kunais = ninja.getKunais();
		
		for(int i=0 ; i<kunais.size() ;i++){
			Kunai kun = (Kunai)kunais.get(i);
			
			Rectangle recKun = kun.getBounds();
			
			if(kun.getBounds().width==getSize().height){
				kun.setVisible(false);
			}
			
			for(int j=0 ; j < enemys.size() ;j++ ){
				
				Enemy enes = (Enemy)enemys.get(j);
				Rectangle recEnes = enes.getBounds();
				
				if(recKun.intersects(recEnes)){
					enes.setVisible(false);
					kun.setVisible(false);
				}
			}
		}
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		
		if(inGame){
		
			Graphics2D g2d = (Graphics2D)g;
			g2d.drawImage(ninja.getImage(), ninja.getX(), ninja.getY(),80, 131,this);
			
			ArrayList ks = ninja.getKunais();
			
			for (int i = 0; i < ks.size(); i++ ) {
		        Kunai kunai = (Kunai) ks.get(i);
		        if(kunai.isVisible()){
		        	g2d.drawImage(kunai.getImage(), kunai.getX(), kunai.getY(),16,14 ,this);
		        }
			}
		        
		    for (int i = 0; i < enemys.size(); i++) {
	             Enemy a = (Enemy)enemys.get(i);
	             if (a.isVisible())
	                 g2d.drawImage(a.getImage(), a.getX(), a.getY(),a.getWidth()/10,a.getHeight()/10,this);
	        }

	        g2d.setColor(Color.WHITE);
	        g2d.drawString("Enemies left: " + enemys.size(), 5, 15);


	        } else {
	            String msg = "Game Over";
	            Font small = new Font("Helvetica", Font.BOLD, 14);
	            FontMetrics metr = this.getFontMetrics(small);

	            g.setColor(Color.white);
	            g.setFont(small);
	            g.drawString(msg, (800 - metr.stringWidth(msg)) / 2,
	                         600 / 2);
			}
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	private class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
	            ninja.keyReleased(e);
	      }
	
	       public void keyPressed(KeyEvent e) {
	           ninja.keyPressed(e);
	       }
	}

	
}
