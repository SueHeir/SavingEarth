package com.sueheir.states;



import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import com.sueheir.Window;

import com.sueheir.other.InfoMouse;
import com.sueheir.world.World;


public class Play extends BasicGameState {

	public boolean pause = false;
		String string;
	public Play(int state){
		
	}
	
	static int mapsize = 7;
	static int PlayerCount = 4;
	int xpos= Mouse.getX();
	int ypos = Mouse.getY();
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		World.init(mapsize,PlayerCount);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Font f = g.getFont();
		World.render(g);
		
		if(!pause) {
			
		g.drawString("X: "+ xpos + " Y: " + ypos, Window.width-f.getWidth("X: 1111 Y: 1111" )-5, 10);
		}
	
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	
		InfoMouse.updateMouseInfo(gc, sbg, delta);
		World.update(gc, sbg, delta);

		
		
		
		if(!pause){
			xpos= Mouse.getX();
			ypos = Mouse.getY();
		
		}
		
		
	}
	
	public void keyPressed(int key, char code){
		if(key == Input.KEY_ESCAPE){
			pause = !pause;
			
		}
		
	}
	

	@Override
	public int getID() {
	
		return States.PLAY;
	}

}