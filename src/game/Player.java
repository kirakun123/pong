package game;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	public boolean right, left;
	public static int x;
	public static int y;
	public int width, height;

	public Player(int x, int y) {
		/**
		 * O metodo player cria a posi��o inicial do jogador e define o tamanho da palheta utilizada por ele, valores fixos
		 * 
		 */
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 5;
	}

	public void tick() {
		/**
		 * Na fun��o tick, pegamos a posi��o do jogador e diminuimos com a posi��o da tela.
		 */
		
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
		/**
		 * Na fun��o render definimos a cor do jogador como azul e a posi��o onde ele vai iniciar usando fillRect
		 */
		g.setColor(Color.blue);// Define a cor do jogador como azul
		g.fillRect(x, y, 40, 10);// Define a posi��o na tela onde o jogador vai iniciar.
	}
}
