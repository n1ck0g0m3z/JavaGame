package actionGame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends JFrame{
	
	public Game(){
		World newGames = new World();
		add(newGames);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Sh4d0w");
        setResizable(false);
        setVisible(true);
        setIconImage(new ImageIcon(getClass().getResource("ninja1.png")).getImage());
	}
	public static void main(String[] args) {
		
		new Game();

	}

}
