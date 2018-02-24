import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Mplayer player;
	Long enemyTimer = (long) 0;
	int enemySpawnTime = 1000;

	public ObjectManager(Mplayer player) {
	
		enemyTimer = (Long) System.currentTimeMillis();
	}

	void update() {
		player.update();
		

		for (int i = 0; i < enemy.size(); i++) {
			enemy.get(i).update();

		}
manageEnemies();
	}

	void draw(Graphics g) {
		player.draw(g);
		
		for (int i1 = 0; i1 < enemy.size(); i1++) {
			enemy.get(i1).draw(g);

		}
		System.out.println(enemy.size());
	}

	
	ArrayList<Enemy> enemy = new ArrayList<Enemy>();

	void addEnemy(Enemy enemies) {
		enemy.add(enemies);
	}

	

	void manageEnemies() {
		
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			
			addEnemy(new Enemy(new Random().nextInt(Football.width), 0, 50, 50));

			enemyTimer = (Long) System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i1 = 0; i1 < enemy.size(); i1++) {
			Enemy enemya = enemy.get(i1);

			if (enemya.isAlive == false) {
				this.enemy.remove(enemya);
			}

		}

	}

	void checkCollison() {
		for(Enemy a : enemy){

	       if(player.collisionBox.intersects(a.collisionBox)){

	                player.isAlive = false;

	        }

	}
	}
	
	
	
}
