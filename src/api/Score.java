package api;

import java.awt.Color;
import java.awt.Graphics2D;

import game.Bola;
import game.Game;

public class Score extends Bola {
	String scoreText = "Score";
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

	public void drawscore(Graphics2D g) {

		g.setColor(Color.white);
		g.fillRect(0, 0, 0, 0);
		g.drawString(String.valueOf(Bola.playerscore), Game.WIDTH / 2 - 45, 50);
		g.drawString(String.valueOf(Bola.inimigoscore), Game.WIDTH / 2 + 45, 50);

	}

	public static void reset() {
		playerscore = 0;
		inimigoscore = 0;
	}

}