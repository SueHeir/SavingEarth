package com.sueheir.states;


import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import com.sueheir.GameEngine;
import com.sueheir.Window;
import com.sueheir.other.Button;
import com.sueheir.other.InfoMouse;

public class Menu extends BasicGameState {
	
	public static Font myFont;
	Button playButton = new Button();
	Button quitButton = new Button();
	int xpos= Mouse.getX();
	int ypos = Mouse.getY();
	
	
//** Menu Constructor
	public  Menu(int state){
		
	}

//** Menu Initialization  
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		/*
		 * Sets Parameters for Menu Buttons (X-pos,Y-pos, width, height, text on button)
		 */
		playButton.setParamaters(Window.width/2-100, Window.height/2-80, 200, 40, "play");
		quitButton.setParamaters(Window.width/2-100, Window.height/2-20, 200, 40, "quit");
		
	}
	

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
	//** gets font from graphics
	Font f = g.getFont();
	//** Draws Game Title/Name
	g.drawString(GameEngine.gamename, Window.width/2-f.getWidth(GameEngine.gamename)/2, 10);
	//** Draws Play and quit buttons
	playButton.box(g);
	quitButton.box(g);
	
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		//*Handles Mouse information *Note that Mouse and graphics Coordinate systems are Different (see mouse class)
		
		InfoMouse.updateMouseInfo(gc, sbg, delta);
		
		/*
		 * Updates menu buttons, (see button classes)
		 */
		playButton.updateButton(gc, sbg, delta);
		quitButton.updateButton(gc, sbg, delta);
		
		//* changes Game state if play button is pressed
		if(playButton.getIsPressed()){
			sbg.enterState(States.PLAY);
		}
		
		//* Ends game if quit button is pressed
		if(quitButton.getIsPressed()){
			System.exit(0);
		}
		
	}

	@Override
	public int getID() {
		return States.MENU;
	}

	

	


}


