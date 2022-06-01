
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key,  x, y, lives;
	private ImageIcon  background,map, mapimage,  weaponImage, endline, heart;
	public boolean startscreen, gamescreen, gamescreen2;
	private Weapons wobject;
	private Boolean homeMusic, p1up, p1down,p1left,p1right;
	private Zombies player;

	
	
	
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
		wobject = new Weapons(1449,(int)(( Math.random() * 768)+1),0,0);
		weaponImage = new ImageIcon(wobject.getWeaponImage());
		player= new Zombies (0, 800);
		p1up=false;
		p1down=false;
		p1left=false;
		p1right=false;
		lives=3;
	}

public void movement() {
		
		if (p1up) {
			player.moveUp();
		}
		if (p1down) {
			player.moveDown();
		}
		if (p1left) {
			player.moveLeft();
		}
		if (p1right) {
			player.moveRight();
		}
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
		Player play = new Player();
		
		
		
		
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
				
				play.playmusic("radioerror.wav");
				homeMusic=false;
			} else if (gamescreen==true || gamescreen2==true) {
				
				play.playmusic("stop");
			}
		
		}
		
		if (gamescreen == true) {
			map = new ImageIcon("background comp sci game.jpg");
			g2d.drawImage(map.getImage(),0,0,getWidth(),getHeight(),this);
			drawLives(g2d);
			wobject.move();
			g2d.drawImage(weaponImage.getImage(),wobject.getX(),wobject.getY(),wobject.getW(),wobject.getH(),this);
			endline = new ImageIcon("finish line.png");
			g2d.drawImage(endline.getImage(),1600,0,1700,1500,this);
			g2d.drawImage(player.getZombieImage().getImage(),player.getX(),player.getY(),player.getW(),player.getH(),this);
		}
		
		if (gamescreen2 == true) {
			map = new ImageIcon("map2.jpg");
			g2d.drawImage(map.getImage(),0,0,getWidth(),getHeight(),this);
			drawLives(g2d);
			wobject.move();
			g2d.drawImage(weaponImage.getImage(),wobject.getX(),wobject.getY(),wobject.getW(),wobject.getH(),this);
			endline = new ImageIcon("finish line.png");
			g2d.drawImage(endline.getImage(),1600,0,1700,1500,this);
			g2d.drawImage(player.getZombieImage().getImage(),player.getX(),player.getY(),player.getW(),player.getH(),this);
		}
	
		
		movement();
		collision();
		
		
		if (lives==0) {
			loseScreen(g2d);
		}
		
		if(player.getX()>=1500) {
			winScreen(g2d);
		}
		twoDgraph.drawImage(back, null, 0, 0);

	}
	
	public void drawLives(Graphics g2d) 
	{
		switch(lives) {
	
		case 3:
			heart = new ImageIcon("heart.png");	
			g2d.drawImage(heart.getImage(),50,50,100,100,this);
			g2d.setColor(Color.white);
			g2d.drawString("x3",150,100);
			break;
		case 2:
			heart = new ImageIcon("heart.png");	
			g2d.drawImage(heart.getImage(),50,50,100,100,this);
			g2d.setColor(Color.white);
			g2d.drawString("x2",150,100);
			break;
		
		case 1:
			heart = new ImageIcon("heart.png");	
			g2d.drawImage(heart.getImage(),50,50,100,100,this);
			g2d.setColor(Color.white);
			g2d.drawString("x1",150,100);
			
		}
	}
	
	
	public void loseScreen(Graphics g2d) {
		g2d.clearRect(0,0,getSize().width, getSize().height);
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, 10000, 10000);
		g2d.setColor(Color.red);
		g2d.setFont(new Font("Forte", Font.PLAIN, 50));
		g2d.drawString("You Lost", 850, 500);
		
	}
	
	public void winScreen(Graphics g2d) {
		g2d.clearRect(0,0,getSize().width, getSize().height);
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, 10000, 10000);
		g2d.setColor(Color.white);
		g2d.setFont(new Font("Forte", Font.PLAIN, 50));
		g2d.drawString("You've Escaped!", 800, 500);
		
	}
	
	

	
	public void collision() {
		if(player.Collision(wobject)&& lives>0) {
			lives--;
			player.reset();
			wobject.reset();
			
		}
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
		if (key==87) {
			p1up=true;
		}
		if (key==83) {
			p1down=true;
		}
		if (key==65) {
			p1left=true;
		}
		if (key==68) {
			p1right=true;
		}
		if (key==32) {
			wobject.setDX(wobject.getDX()+12);
			wobject.setDY(wobject.getDY()+12);
		}
			
		
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode()==87) {
			p1up=false;
		}
		if (e.getKeyCode()==83) {
			p1down=false;
		}
		if (e.getKeyCode()==65) {
			p1left=false;
		}
		if (e.getKeyCode()==68) {
			p1right=false;
		}
		
		
		
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
