package com.lonewolfgames.api;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class UI {
	/**
	 * @author Igor Silva
	 * @version 1
	 * 
	 * Classe implementada para organizar a UI e o Score String, esta classe possui apenas a função render()
	 */

	public void render(Graphics g) {
		/**
		 * A função render() foi colocada com cor branca, fonte arial em tamanho 12, mostrando apenas no ecrã o Score do Inimigo e do Jogador.
		 * Em posição fixa na tela do jogo.
		 */

		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 12));
		g.drawString(" " + Score.getPlayerscore() + " - " + Score.getInimigoscore(), 5, 20);

	}
}
