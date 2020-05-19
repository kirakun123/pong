package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bola {
	public double x,y;
	public int width, height;
	
	public double dx,dy;
	public double speed = 1.7;
	
	public Bola(int x, int y) {
		/**
		 * Função Bola() define as dimensões da bola e a posição que ela vai iniciar no angulo
		 */
		this.x = x;
		this.y = y;
		this.width = 4;
		this.height = 4;
		
		int angle = new Random().nextInt(120-45);//Gerar um numero aleatorio entre 120 e 45, se der 0 somar +45
		dx = Math.acos(Math.toRadians(angle));
		dy = Math.acos(Math.toRadians(angle));
	}
	
	public void tick() {
		/**
		 * Aqui definimos a velocidade da bola e testamos a colisão
		 */
		
		if(x+(dx*speed) + width >= Game.WIDTH) {
			dx*=-1;
		}
		else if(x+(dx*speed) <0) {
			dx*=-1;
		}
		if(y >= Game.HEIGHT) {
			//Ponto do Inimigo
			System.out.println("Ponto para a máquina");
			new Game();
			return;
		}
		else if(y < 0) {
			//Ponto do Jogador
			System.out.println("Ponto para o Jogador");
			new Game();
			return;
		}
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)), width, height); //Classe nativa do java para testar colisões
		
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.inimigo.x, (int)Game.inimigo.y, Game.inimigo.width, Game.inimigo.height);
		
		if(bounds.intersects(boundsPlayer)) {
			int angle = new Random().nextInt(120-45)+45+1;//Gerar um numero aleatorio entre 120 e 45, se der 0 somar +45
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy > 0) {
				dy*=-1;
			}
		}
		else if(bounds.intersects(boundsEnemy)) {
			int angle = new Random().nextInt(120-45)+45+1;//Gerar um numero aleatorio entre 120 e 45, se der 0 somar +45
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy <0) {
				dy*=-1;
			}
		}
		x+=dx*speed;
		y+=dy+speed;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, width, height);
	}
}
