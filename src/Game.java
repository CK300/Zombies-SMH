
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key,  x, y;
	private ImageIcon weapon, background,map, mapimage, finish, weaponImage;
	public boolean startscreen, gamescreen, gamescreen2, homeMusic;
	private Weapons wobject;
	

	
	
	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		key =-1; 
		x=0;
		y=0;
		startscreen=true;
		gamescreen=false;
		gamescreen2=false;
		homeMusic=true;
		wobject = new Weapons(250,250,2,2);
		weaponImage = new ImageIcon(wobject.getWeaponImage());
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
		
		
		if (startscreen == true) {
			background = new ImageIcon("Screenshot 2022-05-11 151516.jpg");
			g2d.drawImage(background.getImage(),0,0,getWidth(),getHeight(),this);
			g2d.setColor(Color.red);
			g2d.setFont(new Font("Forte", Font.PLAIN, 100));
			g2d.drawString("ZOMBIES SMH", getWidth()/4+100, getHeight()/4);
			g2d.setFont(new Font("Forte", Font.PLAIN, 50));
			g2d.drawString("Choose Map", getWidth()/3+150, getHeight()-500);
			map = new ImageIcon("background comp sci game.jpg");
			g2d.drawImage(map.getImage(),600,700,300,300,this);
			mapimage = new ImageIcon("map2.jpg");
			g2d.drawImage(mapimage.getImage(),1000,700,300,300,this);
			if(homeMusic) {
				Player play = new Player();
				play.playmusic("radioerror.wav");
				homeMusic=false;
			} else if (gamescreen==true || gamescreen2==true) {
				Player play = new Player();
				play.playmusic("stop");
			}
		
		}
		
		if (gamescreen == true) {
			map = new ImageIcon("background comp sci game.jpg");
			g2d.drawImage(map.getImage(),0,0,getWidth(),getHeight(),this);
			wobject.move();
			g2d.drawImage(weaponImage.getImage(),wobject.getX(),wobject.getY(),wobject.getW(),wobject.getH(),this);
			
		}
		
		if (gamescreen2 == true) {
			map = new ImageIcon("map2.jpg");
			g2d.drawImage(map.getImage(),0,0,getWidth(),getHeight(),this);
			wobject.move();
			g2d.drawImage(weaponImage.getImage(),wobject.getX(),wobject.getY(),wobject.getW(),wobject.getH(),this);
		
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
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()>500 && e.getX()<800 && e.getY()>700 && e.getY()<1000) {
			gamescreen=true;
			}
		
		if(e.getX()>900 && e.getX()<1200 && e.getY()>700 && e.getY()<1000) {
			gamescreen2=true;
			}
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
