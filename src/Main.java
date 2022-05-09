import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	
	public Main () {
		super("Zombies SMH");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		Game play = new Game();
		((Component) play).setFocusable(true);
		
		Color RoyalBlue = new Color(22,13,193);
		
		
		setBackground(RoyalBlue);
		
		
		getContentPane().add(play);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	public static void main(String[] args) {
		Main run = new Main();
		

	}


}
