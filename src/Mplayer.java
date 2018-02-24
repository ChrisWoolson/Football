import java.awt.Color;
import java.awt.Graphics;

public class Mplayer extends GameObject{
public int speed;
public boolean up;
public boolean down;
public boolean left;
public boolean right;
	public Mplayer(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = -5;
		
	}
		void update() {
			super.update();
if(up) {
	this.y = this.y +speed;
}

if(down) {
	this.y = this.y -speed;
}

if(left) {
	this.x = this.x +speed;
}

if(right) {
	this.x = this.x -speed;
}
			
		}

		void draw(Graphics g) {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
		
	}

