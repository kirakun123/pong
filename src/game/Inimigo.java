package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Inimigo {
	
	public double x,y;
	public int width, height;
	
	public Inimigo(int x, int y) {
		
		/**
		 * O metodo Inimigo cria a posição inicial do inimigo e define o tamanho da palheta utilizada por ele, valores fixos e iguals do player.
		 * 
		 */
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 5;
	}
	
	public void tick() {
		/**
		 * Função Tick() do Inimigo faz o inimigo acompanhar a bola
		 */
		//Toda a logica do jogo
		x+=(Game.bola.x -x - 6)*0.07; // Calculo para o inimigo acompanhar a bola
		
	}
	
	public void render(Graphics g) {
		/**
		 * Na função render definimos a cor do inimigo como vermelho e a posição onde ele vai iniciar usando fillRect
		 */
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, width, height);
	}
}