package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Inimigo {
	
	public double x,y;
	public int width, height;
	
	public Inimigo(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 5;
	}
	
	public void tick() {
		//Toda a logica do jogo
		
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, width, height);
	}
}