package com.sueheir.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.sueheir.Window;
import com.sueheir.entities.Player;
import com.sueheir.other.Button;
import com.sueheir.states.Menu;

public class Gui {
	static Button NextTurnButton = new Button();
	public static Player currentPlayer;
	public static int currentPlayerID = 1;
	public static void init() {
		NextTurnButton.setParamaters(10, Window.height-90, 100, 18);
		
	}
	public static void render(Graphics g) throws SlickException {
		g.setColor(Color.lightGray);
		g.fillRect(0, Window.height-120, Window.width, 120);
		g.setColor(Color.white);
		
		
		g.drawString("Turn: Player "+ currentPlayerID , 10, Window.height-110);
		NextTurnButton.box(g, "Next Turn");
		g.drawString("Energy "+ currentPlayer.getCurrentEnergy(), 10, Window.height-70);
		g.drawString("Mana "+ currentPlayer.getCurrentMana(), 10, Window.height-50);
		g.drawString("Health "+ currentPlayer.getCurrentHealth(), 10, Window.height-30);
		
		
	}
	public static void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		NextTurnButton.updateButton(gc, sbg, delta);
		if(NextTurnButton.getIsPressed()){
			Player.setFirstPass(true); 
			if(currentPlayerID==Menu.players) {
				currentPlayerID=1;
			} else {
				currentPlayerID++;
			}
			
		}
		
	}
	public static void loadPlayerInfo(Player player) {
		currentPlayer= player;
		currentPlayer.setCurrentEnergy(currentPlayer.getMaxEnergy());
		currentPlayer.setCurrentMana(currentPlayer.getMaxMana());
		currentPlayer.setCurrentHealth(currentPlayer.getMaxHealth());
	}

	

	
}
