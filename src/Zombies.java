import java.awt.Color;

import javax.swing.ImageIcon;

	
public class Zombies {
		
		private int x, y, dx, dy, width, height;
		private int score;
		private ImageIcon zombieImage;
		
		
		public Zombies() {
			x=0;
			y=0;
			width=0;
			height=0;
			score=0;
			dx=0;
			dy=0;
			zombieImage = new ImageIcon("download-removebg-preview.png");
		}
		
		public Zombies(int xV, int yV) {
			x=xV;
			y=yV;
			width=100;
			height=100;
			dx=0;
			dy=0;
			score=0;
			zombieImage = new ImageIcon("download-removebg-preview.png");
		}
		
		
		public ImageIcon getZombieImage() {
			return zombieImage;
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public int getW() {
			return width;
		}
		public int getH() {
			return height;
		}
		public int getDX() {
			return dx;
		}
		public int getDY() {
			return dy;
		}
		public int getScore() {
			return score;
		}
		
		
		public void setDY(int uu) {
			dy=uu;
		}
		
		
		public void setX(int xV) {
			x+=xV;
		}
		public void setY(int yV) {
			y+=yV;
		}
		public void setW(int dw) {
			width+=dw;
		}
		public void setH(int dh) {
			height=dh;
		}
		public void setScore(int ds) {
			score+=ds;
		}
		
		
		
		
		
		public void moveUp() {
			y=y-7;
		}
		public void moveDown() {
			y=y+7;
		}
		
		public void moveLeft() {
			x=x-7;
		}
		
		public void moveRight() {
			x=x+7;
		}
		
		public boolean Collision (Weapons wobject) {
			if(x<=wobject.getX()+wobject.getW() && x+getW()>=wobject.getX() && y<wobject.getY()+wobject.getH() && y+getH()>=wobject.getY()) {				
			reset();
			return true;
			}
			return false;
			}

		public void reset() {
			x=0;
			y=800;
		}
		
	}
		