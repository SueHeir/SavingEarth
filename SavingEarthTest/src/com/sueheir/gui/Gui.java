package com.sueheir.gui;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.sueheir.Window;
import com.sueheir.entities.Player;
import com.sueheir.other.Button;
import com.sueheir.states.Menu;
import com.sueheir.world.World;

public class Gui {
	static Button NextTurnButton = new Button();
	
	public static Player currentPlayer;
	public static int currentPlayerID = 1;
	public static int DiceValue = rollDice() + rollDice();
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
		
		
		g.drawString(" Wood: "+ currentPlayer.getWood(), 150, Window.height-110);
		g.drawString("Wheat: "+ currentPlayer.getWheat(), 150, Window.height-90);
		g.drawString("Sheep: "+ currentPlayer.getSheep(), 150, Window.height-70);
		g.drawString("Brick: "+ currentPlayer.getBrick(), 150, Window.height-50);
		g.drawString("Stone: "+ currentPlayer.getStone(), 150, Window.height-30);
		
		g.drawString("Dice: "+ DiceValue, 300, Window.height-110);
		
		
	}
	public static void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		
		NextTurnButton.updateButton(gc, sbg, delta);
		if(NextTurnButton.getIsPressed() || input.isKeyPressed(Input.KEY_ENTER)){
			DiceValue = rollDice() + rollDice();
			Player.setFirstPass(true); 
			if(DiceValue==7) {}else {
				World.count=0;
				World.spawnMonster(DiceValue);
			}
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
	
	public static int rollDice() {
		Random rand = new Random();
		int valve= rand.nextInt(6)+1;
		return valve;
	}

	

	
}
