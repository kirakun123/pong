package com.lonewolfgames.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.lonewolfgames.main.Game;
import com.lonewolfgames.main.Inimigo;

public class Menu {
	/***
	 * Sistema de Menu
	 * @author Igor
	 * @date 01/06/2020
	 * 
	 * O Sistema de Navegação do menu foi criado para iniciar o jogo e sair.
	 * Uma seta indica a opção que o jogador está e pressionando a tecla ENTER. a opção é selecionada
	 * @param VK_ENTER
	 * 
	 * Entra na opção.
	 **/
	public String[] opcoes = {"Novo Jogo", "Sair"};
	public int currentOption =0;
	public int maxOption = opcoes.length-1;
	public boolean up, down, enter, right, left;
	
	public void tick() {
		if(up) {
			up = false;
			currentOption--;
			if(currentOption <0) {
				currentOption = maxOption;
			}
		}
		if(down){
			down=false;
			currentOption++;
			if(currentOption > maxOption) {
				currentOption = 0;
			}
		}
		/*if(right) {
			if(opcoes[currentOption] == "Configuracao") {
				Game.gameState = "MENU";
				if(Inimigo.getDificuldade() == 1) {
					Inimigo.setDificuldade(2);
					right = false;
					
				}
				else if(Inimigo.getDificuldade() == 2) {
					Inimigo.setDificuldade(3);
					right = false;
				}
				else if(Inimigo.getDificuldade() == 3) {
					Inimigo.setDificuldade(4);
					right = false;
				}
				else if(Inimigo.getDificuldade() == 4) {
					Inimigo.setDificuldade(5);
					right = false;
				}
				Game.gameState = "MENU";
			}
		}
		if(left){
			if(opcoes[currentOption] == "Configuracao") {
				Game.gameState = "MENU";
				if(Inimigo.getDificuldade() == 5) {
					Inimigo.setDificuldade(4);
					left = false;
				}
				else if(Inimigo.getDificuldade() == 4) {
					Inimigo.setDificuldade(3);
					left = false;
				}
				else if(Inimigo.getDificuldade() == 3) {
					Inimigo.setDificuldade(2);
					left = false;
				}
				else if(Inimigo.getDificuldade() == 2) {
					Inimigo.setDificuldade(1);
					left = false;
				}
			}
		}*/
		if(enter) {
			enter = false;
			if(opcoes[currentOption] == "Novo Jogo") {
				Game.gameState = "NORMAL";
			}
			else if(opcoes[currentOption] == "Sair") {
				System.exit(1);
			}
			else {
				
			}
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 36));
		g.drawString("PONG", (Game.WIDTH * Game.SCALE) / 2 - 135, (Game.HEIGHT * Game.SCALE) / 2 -100);
		g.setFont(new Font("arial", Font.BOLD, 18));
		g.drawString("Novo Jogo", (Game.WIDTH * Game.SCALE) / 2 - 75, (Game.HEIGHT * Game.SCALE - 50) / 2);
		/*g.drawString("Configuracao", (Game.WIDTH * Game.SCALE) / 2 - 75, (Game.HEIGHT * Game.SCALE - 0) / 2);
		g.drawString("+", (Game.WIDTH * Game.SCALE) / 2 + 75, (Game.HEIGHT * Game.SCALE - 0) / 2);
		if(Inimigo.getDificuldade()==2) {
			g.drawString("+", (Game.WIDTH * Game.SCALE) / 2 + 85, (Game.HEIGHT * Game.SCALE - 0) / 2);
		}
		else if(Inimigo.getDificuldade()==3) {
			g.drawString("+", (Game.WIDTH * Game.SCALE) / 2 + 85, (Game.HEIGHT * Game.SCALE - 0) / 2);
			g.drawString("+", (Game.WIDTH * Game.SCALE) / 2 + 95, (Game.HEIGHT * Game.SCALE - 0) / 2);
		}
		else if(Inimigo.getDificuldade()==4) {
			g.drawString("+", (Game.WIDTH * Game.SCALE) / 2 + 85, (Game.HEIGHT * Game.SCALE - 0) / 2);
			g.drawString("+", (Game.WIDTH * Game.SCALE) / 2 + 95, (Game.HEIGHT * Game.SCALE - 0) / 2);
			g.drawString("+", (Game.WIDTH * Game.SCALE) / 2 + 105, (Game.HEIGHT * Game.SCALE - 0) / 2);
		}
		else if(Inimigo.getDificuldade()==5) {
			g.drawString("+", (Game.WIDTH * Game.SCALE) / 2 + 85, (Game.HEIGHT * Game.SCALE - 0) / 2);
			g.drawString("+", (Game.WIDTH * Game.SCALE) / 2 + 95, (Game.HEIGHT * Game.SCALE - 0) / 2);
			g.drawString("+", (Game.WIDTH * Game.SCALE) / 2 + 105, (Game.HEIGHT * Game.SCALE - 0) / 2);
			g.drawString("+", (Game.WIDTH * Game.SCALE) / 2 + 115, (Game.HEIGHT * Game.SCALE - 0) / 2);
		}*/
		g.drawString("Sair", (Game.WIDTH * Game.SCALE) / 2 - 75, (Game.HEIGHT * Game.SCALE + 50) / 2);
		
		if(opcoes[currentOption] == "Novo Jogo") {
			g.drawString(">", (Game.WIDTH * Game.SCALE) / 2 - 90, (Game.HEIGHT * Game.SCALE - 50) / 2);
		}
		/*else if(opcoes[currentOption] == "Configuracao") {
			g.drawString(">", (Game.WIDTH * Game.SCALE) / 2 - 90, (Game.HEIGHT * Game.SCALE - 0) / 2);
		}*/
		else if(opcoes[currentOption] == "Sair") {
			g.drawString(">", (Game.WIDTH * Game.SCALE) / 2 - 90, (Game.HEIGHT * Game.SCALE +50) / 2);
		}
	}
}
