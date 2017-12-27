package com.sueheir.other;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import com.sueheir.Window;

public class InfoMouse {
	
	private static int XPOS;
	private static int YPOS;
	private static boolean wasPressed;
	

	public static void updateMouseInfo(GameContainer gc, StateBasedGame sbg,
			int delta) {
		XPOS = Mouse.getX();
		YPOS = Mouse.getY();
		Input input = gc.getInput();
		
		if(input.isMousePressed(0)){
			wasPressed = true;
		}else{
			wasPressed = false;
		}
		
		
		
		
	}
	
	public static int getX(){
		return XPOS;
	}
	
	public static int getY(){
		return Window.height-YPOS;
		
	}
	
	public static boolean getWasPressed(){
		return wasPressed;
	}
	
}
