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

//** Menu Initalization  
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		playButton.setParamaters(Window.width/2-100, Window.height/2-80, 200, 40, "play");
		quitButton.setParamaters(Window.width/2-100, Window.height/2-20, 200, 40, "quit");
		
	}
	

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
	Font f = g.getFont();
	g.drawString(GameEngine.gamename, Window.width/2-f.getWidth(GameEngine.gamename)/2, 10);
	playButton.box(g);
	quitButton.box(g);
	
	g.drawString("X: "+ xpos + " Y: " + ypos, Window.width-f.getWidth("X: 1111 Y: 1111" )-5, 10);
	
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		InfoMouse.updateMouseInfo(gc, sbg, delta);
		
		
		xpos= Mouse.getX();
		ypos = Mouse.getY();
		
		playButton.updateButton(gc, sbg, delta);
		quitButton.updateButton(gc, sbg, delta);
		
		if(playButton.getIsPressed()){
			sbg.enterState(States.PLAY);
		}
		if(quitButton.getIsPressed()){
			System.exit(0);
		}
		
	}

	@Override
	public int getID() {
		return States.MENU;
	}

	

	


}


