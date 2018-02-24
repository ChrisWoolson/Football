import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer time;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	GameObject object;
	Font titleFont;
	Font enter;
	Font instruct;
	Font gameo;
	Font Kill;
	Font restart;
	Mplayer player = new Mplayer(250, 700, 50, 50);

	ObjectManager manager = new ObjectManager(player);
	
	
	public GamePanel() {
		time = new Timer(1000 / 120, this);
		titleFont = new Font("Arial", Font.PLAIN, 40);
		enter = new Font("Arial", Font.PLAIN, 25);
		instruct = new Font("Arial", Font.PLAIN, 25);

		gameo = new Font("Arial", Font.PLAIN, 40);
		Kill = new Font("Arial", Font.PLAIN, 25);
		restart = new Font("Arial", Font.PLAIN, 25);
	}

	public void startGame() {
		time.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else

		if (currentState == GAME_STATE) {
			updateGameState();
		} else

		if (currentState == END_STATE) {
			updateEndState();
		}

	}

	@Override

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else

		if (currentState == GAME_STATE) {
			drawGameState(g);
		} else

		if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("type");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			
			if (currentState == END_STATE) {
				
			player = new Mplayer(250, 700, 50, 50);
		player.isAlive= true;
		}
		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
			player.isAlive = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			// .y=.y + .speed;
			player.up = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// .y=.y + .speed;
			player.down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// .y=.y + .speed;
			player.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// .y=.y + .speed;
			player.right = true;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("release");

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			// .y=.y;
			player.up = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// .y=.y;
			player.down = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// .y=.y;
			player.left = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// .y=.y;
			player.right = false;
		}

		
		
		
		
		
		
	}

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
		manager.checkCollison();
		manager.purgeObjects();
		
		//if(player.isAlive == false) {
	//currentState = END_STATE;
	//	}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Football.width, Football.height);
		g.setColor(Color.WHITE);

		g.setFont(titleFont);
		g.drawString("FOOOTBALL", 50, 100);
		g.setFont(enter);
		g.drawString("PRESS ENTER TO START", 100, 300);

		g.setFont(instruct);
		g.drawString("PRESS SPACE FOR INSTRUCTIONS", 60, 450);

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);

		g.fillRect(0, 0, Football.width, Football.height);

		manager.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, Football.width, Football.height);

		g.setColor(Color.WHITE);

		g.setFont(gameo);
		g.drawString("Game Over", 50, 100);
		g.setFont(Kill);
		g.drawString("You killed + enemies", 100, 300);

		g.setFont(restart);
		g.drawString("Press ENTER to restart", 60, 450);

	}

}
