package com.sueheir;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import com.sueheir.states.Menu;
import com.sueheir.states.Play;
import com.sueheir.states.States;

public class GameEngine extends StateBasedGame{
	

//**  Sets Name of Game
	public static final String gamename = "Testing";
	
//** I Don't Remember
	public static boolean _APPLET = true;
	
	
//**  Location for adding Different states of the game (levels)
	public GameEngine(String name) {
		super(name);
		this.addState(new Menu(States.MENU));
		this.addState(new Play(States.PLAY));
	}

//** Window Settings (see Window Class)
	public void initStatesList(GameContainer gc) throws SlickException{
		gc.setMaximumLogicUpdateInterval(Window.TargetUpdateInterval);
		gc.setTargetFrameRate(Window.TargetFPS);
		gc.setAlwaysRender(true);
		gc.setShowFPS(Window.ShowFPS);
		gc.setVSync(Window.VSYNC);

//** Object to handle files (Pictures,Sounds,Sprites,etc.)
		new Resources();
		
//** Initalization of states within Game
		this.getState(States.MENU).init(gc, this);
		this.getState(States.PLAY).init(gc, this);
		
//** IDK
		this.enterState(States.DEFAULT);
		
	}
	
	
	public static void main(String[] arg){
		
//** is it an Applet? No IDK
		_APPLET = false;
		
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new GameEngine(gamename));
			
//**  More Window Settings, see Windows Class
			appgc.setDisplayMode(Window.width, Window.height, Window.FULLSCREEN);
			appgc.start();
			
		}catch(SlickException e){
			e.printStackTrace();
		}
		
	}
	
	
}
