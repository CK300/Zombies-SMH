
public class Weapons {



	private int x,y,w,h;
	private int dx,dy;
	private String weaponImage;
	
	public Weapons(int posx, int posy, int velx, int vely) {
		
		x=posx;
		y=posy;
		w=150;
		h=150;
		weaponImage = "TN_viking-weapon-clipart-removebg-preview.png";
		dx=velx;
		dy=vely;
	}

	public String getWeaponImage() {
		return weaponImage;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	public int getDX() {
		return dx;
	}
	public int getDY() {
		return dy;
	}
	public void setDX(int xx) {
		dx=xx;
	}
	public void setDY(int yy) {
		dy=yy;
	}
	
	public void setX(int xV) {
		 x=xV;
	}
	
	public void vert() {
		dy*=-1;
	}
	public void horz() {
		dx*=-1;
	}
	
	


	
	public void move() {
		x+=dx;
		y+=dy;
		if (y<=0 || y>=920) {
			vert();
		} if (x<=0 || x>=1450) {
			horz();
		}
		
		
	}
	public void reset() {
		x=1449;
		y=(int)(( Math.random() * 768)+1);
		dx=0;
		dy=0;
	}
}


