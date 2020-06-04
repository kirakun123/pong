package com.lonewolfgames.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Inimigo {
	/**
	 * @author Igor Silva
	 * @version 1
	 * 
	 * Classe inimigo, possui apenas @param width e @param height
	 * Classe para determinar o tamanho da paleta da máquina.
	 * 
	 *  Possui a classe render() e a função tick()
	 */
	public double x,y;
	public int width, height;
	public static int dificuldade = 3;
	public static double dific = 0.07;
	
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
	
	
	public int dificuldade(int num) {
		if(num ==1) {
			dific = 0.03;
			dificuldade = 1 ;
		}
		if(num ==2) {
			dific = 0.05;
			dificuldade = 2;
		}
		if(num ==3) {
			dific = 0.07;
			dificuldade = 3;
		}
		if(num ==4) {
			dific = 0.09;
			dificuldade = 4;
		}
		if(num ==5) {
			dific = 0.1;
			dificuldade = 5;
		}
		return num;
	}
	public static int getDificuldade() {
		return dificuldade;
	}
	public static void setDificuldade(int numero) {
		dific = numero;
		System.out.println("Dificuldade Ajustada para " + numero);
	}
	
	
	public void tick() {
		/**
		 * Função Tick() do Inimigo faz o inimigo acompanhar a bola
		 * 
		 * Modos de jogo são definidos pela velocidade do Inimigo.
		 * Velocidade 0.03 -> Super Easy
		 * Velocidade 0.05 -> Easy
		 * Velocidade 0.07 -> Medio
		 * Velocidade 0.3 -> Hard
		 * Velocidade 0.5 -> Very Hard
		 * 
		 */
		//Toda a logica do jogo
		//x+=(Game.bola.x-x-6)*0.03;
		x+=(Game.bola.x-x-6)*dific; // Calculo para o inimigo acompanhar a bola
	}
	
	public void render(Graphics g) {
		/**
		 * Na função render definimos a cor do inimigo como vermelho e a posição onde ele vai iniciar usando fillRect
		 */
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, width, height);
	}
}