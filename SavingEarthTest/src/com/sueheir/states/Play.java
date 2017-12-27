package com.sueheir.states;


import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import com.sueheir.map.Map;
import com.sueheir.other.InfoMouse;


public class Play extends BasicGameState {

	public boolean pause = false;
		String string;
	public Play(int state){
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		Map.init(7);
		Map.radomizeMap();
	
		
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Map.render(g);
	
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	
		InfoMouse.updateMouseInfo(gc, sbg, delta);
		Map.update(gc, sbg, delta);
		if(!pause){
			
		
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