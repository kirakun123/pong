package com.lonewolfgames.api;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import com.lonewolfgames.main.Bola;
import com.lonewolfgames.main.Game;

public class Score extends Bola {
	
	/**
	 * @author Igor Silva
	 * @version 1
	 * 
	 * Classe Score possui apenas um construtor determinando o score do jogador e do inimigo.
	 * Possui o método get e set dos mesmos, assim facilitando o acesso das váriaveis.
	 * 
	 * A classe Score possui também um método reset() que reinicia todos os pontos dos jogadores a 0.
	 */
	String scoreText = "Score\n";
	static int playerscore = 0;
	static int inimigoscore = 0;
	public int width, height;

	public Score() {
		this.width = 40;
		this.height = 10;
	}

	public Score(int x, int y) {
		// super(x, y);
		playerscore = x;
		inimigoscore = y;
	}

	public static int getPlayerscore() {
		return playerscore;
	}

	public static void setPlayerscore(int playerscores) {
		playerscore += playerscores;
	}

	public static int getInimigoscore() {
		return inimigoscore;
	}

	public static void setInimigoscore(int inimigoscores) {
		inimigoscore += inimigoscores;
	}

	public static void reset() {
		playerscore = 0;
		inimigoscore = 0;
	}

}