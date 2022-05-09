
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key,  x, y;
	private ImageIcon weapon, background;
	public boolean weapon1, weapon2; 


	
	
	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		key =-1; 
		x=0;
		y=0;
		weapon1=true;
		weapon2=false;
		
	}

	
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		background = new ImageIcon("background comp sci game.jpg");
		g2d.drawImage(background.getImage(),0,0,getWidth(),getHeight(),this);
		
		
		if (weapon1 == true) {
			weapon = new ImageIcon("TN_viking-weapon-clipart-removebg-preview.png");
			g2d.drawImage(weapon.getImage(),x,y,200,200,this);
		}
		
		if (weapon2 == true) {
			weapon = new ImageIcon("spas-12-mw2-fps-football-gun-shooter-3d-2018-115636114214p3idikd3r-removebg-preview.png");
			g2d.drawImage(weapon.getImage(),x,y,200,200,this);
		}

		twoDgraph.drawImage(back, null, 0, 0);

	}
	
	



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		
		if (e.getKeyCode() == 49) {
			weapon1=true;
			weapon2=false;
		}
		
		if (e.getKeyCode() == 50) {
			weapon2=true;
			weapon1=false;
		} 
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
	
		
		
		
	}



	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub\\
		
		
	}



	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x=arg0.getX();
		y=arg0.getY();
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
}
