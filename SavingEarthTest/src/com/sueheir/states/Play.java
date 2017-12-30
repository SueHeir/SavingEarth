package com.sueheir.states;



import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import com.sueheir.Window;

import com.sueheir.other.InfoMouse;
import com.sueheir.world.World;


public class Play extends BasicGameState {

	//** Debug mode shows extra information, press escape to enter debug mode
	public static boolean DebugMode = false;
	
	//** Play game state constructor (idk why we need them)
	public Play(int state){
	}
	
	//** MapSize defines length and width of map (keep 7 until changing mapsize is implimented)
	public static int mapsize = 7;
	
	//** Player count defines number of players (keep 4 for now)
	public static int PlayerCount = 6;
	
	// Size of Board, hexagon, circle, player, and monsters are based off this valve
		public static int tileSize = 80;
	
	//* Mouse coords used in debug mode
	int xpos; 
	int ypos;
	
	/*
	 *  Play Initialization 
	 */
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		//* Initialization of World (Includes map, players, enemies, background images 
		World.init(mapsize,PlayerCount);
		// Initialization of GUI would go here

	}

	/*
	 * Play Render  
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		//Font used to get width of text 
		Font f = g.getFont();
		//* Rendering of World (Includes map, players, enemies, background images)
		World.render(g);
		// Rendering of GUI would go here
		
		
		/*
		 * Debug mode (found in other classes too)
		 * This displays mouse position 
		 */
		if(DebugMode) {
			
		g.drawString("X: "+ xpos + " Y: " + ypos, Window.width-f.getWidth("X: 1111 Y: 1111" )-5, 10);
		}
	
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	/*
	 * Handles Mouse information *Note that Mouse and graphics Coordinate systems are Different (see mouse class)
	 */
		InfoMouse.updateMouseInfo(gc, sbg, delta);
		
		//**used in debugmode to display mouse position
		xpos = InfoMouse.getX();
		ypos = InfoMouse.getY();
		
		//* Updating of World (Includes map, players, enemies, background images)
		World.update(gc, sbg, delta);

		
		
		/*
		 * Debug mode (found in other classes too)
		 * This updates mouse position 
		 */
		if(!DebugMode){
			xpos= Mouse.getX();
			ypos = Mouse.getY();
		
		}
		
		
	}
	
	
	/*
	 * Changes debug mode on via escape button press  
	 */
	public void keyPressed(int key, char code){
		if(key == Input.KEY_ESCAPE){
			DebugMode = !DebugMode;
			
		}
		
	}
	
	// returns state of play (IDK)
	public int getID() {
	
		return States.PLAY;
	}

}