import java.awt.Graphics;
import java.awt.Rectangle;

import org.w3c.dom.css.Rect;

public class GameObject {
int x;
int y;
int width;
int height;
public boolean isAlive= true;
Rectangle collisionBox = new Rectangle();
public GameObject(int x, int y, int width, int height) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
}

void update() {

	collisionBox.setBounds(x, y, width, height);
}

void draw(Graphics g) {
	
}




}
