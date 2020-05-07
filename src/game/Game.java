package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import game.Bola;
import game.Inimigo;
import game.Player;

public class Game extends Canvas implements Runnable, KeyListener{
	
	/**
	 * @param WIDTH
	 * 
	 * Esta constante foi criada para deixar uma dimensão pré-estabelecida da janela do jogo.
	 * 
	 * @param HEIGHT
	 * 
	 * Esta constante foi criada para deixar uma dimensão pré-estabelecida da janela do jogo.
	 * 
	 * @param SCALE
	 * 
	 * Uma constante para aumentar a escala da resolução e deixar a aplicação mais leve.
	 */
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 160;
	public static int HEIGHT = 120;
	public static int SCALE = 3;
	public BufferedImage layer = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	
	public Game() {
		this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));//Dimensões * Scale
		this.addKeyListener(this);//Adiciona o metodo KeyListiner ao jogo
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Pong");
		frame.setResizable(false); // Utilizador não pode redimensionar a Janela
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Função que deixa o botão padrão do Java para fechar, assim sendo a única maneira de fechar a aplicação.
		frame.add(game);//Adiciona o Canvas.
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void tick(){
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();//Renderiza o jogo
		if(bs == null) {//Se for null
			this.createBufferStrategy(3);//BS é definido como 3
			return;
		}
		Graphics g = layer.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g=bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
		bs.show();//Mostrar jogador
	}

	@Override
	public void run() {
		requestFocus();//Foca automaticamente na janela do jogo
		while(true) {
			tick();
			render();
			try {
					Thread.sleep(1000/60);
				}
			catch (InterruptedException e) {
				e.printStackTrace();
				
			 }
			}
		}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
	}
		
	}