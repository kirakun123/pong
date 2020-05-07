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
/***
 * 
 * @author Igor
 * @version 1
 * Classe principal do jogo pong, contendo parte gráfica do Java utilizando alguns metodos e parametros utilizados nas aulas.
 * 
 * @param Runnable  
 * 
 * Runnable é um método que deixa o jogo rodando em loop, assim o utilizador poderá continuar jogando ate fechar o jogo.
 * 
 * @param JFrame
 * 
 * JFrame é uma função do java para abrir uma nova janela no Java.
 * 
 * @PARAM setResizable 
 * Este parametro não deixa o utilizador redimensionar a janela.
 * 
 * @param setDefaultCloseOperation
 * 
 * Esta função, deixa o botão padrão do Java para fechar, assim sendo a única maneira de se fechar a aplicação. 
 * E não deixando a aplicação rodando após isso.
 *
 */
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
	public static Player player;
	public static Inimigo inimigo;
	public static Bola bola; //Bola precisou ficar como static para poder ser acessada atraves da classe Inimigo para definir taticas e velocidade da bola.
	
	public BufferedImage layer = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	
	public Game() {
		this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));//Dimensões * Scale
		this.addKeyListener(this);//Adiciona o metodo KeyListiner ao jogo
		player = new Player(100,HEIGHT-5);
		inimigo = new Inimigo(100,0);
		bola = new Bola(100,HEIGHT/2 - 1);
	}
	
	public static void main(String[] args) {
		
		Game game = new Game();
		JFrame frame = new JFrame("Pong");
		frame.setResizable(false); // Utilizador não pode redimensionar a Janela
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Função que deixa o botão padrão do Java para fechar, assim sendo a única maneira de fechar a aplicação.
		frame.add(game);//Adiciona o Canvas.
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		new Thread(game).start();
	}
	
	public void tick(){
		player.tick();
		inimigo.tick();
		bola.tick();
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
		player.render(g);
		inimigo.render(g);
		bola.render(g);
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
