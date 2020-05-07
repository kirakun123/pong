package game;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	public boolean right, left;
	public static int x;
	public static int y;
	public int width, height;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 5;
	}

	public void tick() {
		if(right) {
			x++;
		}
		else if(left) {
			x--;
		}
		if(x+width > Game.WIDTH) {
			x = Game.WIDTH - width;
		}
		else if(x < 0) {
			x = 0;
		}
	}

	public static void render(Graphics g) {
		g.setColor(Color.blue);// Define a cor do jogador como azul
		g.fillRect(x, y, 40, 10);// Define a posição na tela onde o jogador vai iniciar.
	}
}
