package com.sueheir.other;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.lwjgl.input.Mouse;

import com.sueheir.Window;



public class Button {
	
	
	private  boolean hover = false;
	private boolean pressed = false;
	private int X,Y,Width,Height,R;
	private String string;
	private Font font;

	
	public void setParamaters(int x, int y, int width, int height){
		
		X=x;
		Y=y;
		Width=width;
		Height=height;
	}
	
	
	public void box(Graphics g, String string) throws SlickException {
		Font f = g.getFont();
		font = f;
		
		if(!hover){
			
			g.drawRect(X, Y,Width, Height);
			font.drawString(X+Width/2-font.getWidth(string)/2, Y+Height/2-font.getHeight(string)/2, string);
		}
		
		if(hover){
			g.setColor(Color.yellow);
			g.drawRect(X, Y,Width, Height);
			font.drawString(X+Width/2-font.getWidth(string)/2, Y+Height/2-font.getHeight(string)/2, string, Color.yellow);
			g.setColor(Color.white);
			}
	}
	
	
	public void boxCurvedCorners(Graphics g,int r) throws SlickException {
		Font f = g.getFont();
		font = f;
		R = r;
		if(!hover){
			
			g.drawRoundRect(X, Y,Width, Height, R);
			font.drawString(X+Width/2-font.getWidth(string)/2, Y+Height/2-font.getHeight(string)/2, string);
		}
		
		if(hover){
			g.setColor(Color.yellow);
			g.drawRoundRect(X, Y,Width, Height,R);
			font.drawString(X+Width/2-font.getWidth(string)/2, Y+Height/2-font.getHeight(string)/2, string, Color.yellow);
			g.setColor(Color.white);
			}
	}
	

	public void updateButton(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();

		
		if((xpos>X && xpos<X+Width) && (ypos>Window.height-(Y+Height) && ypos<Window.height-Y)){
			hover = true;
			if(InfoMouse.getWasPressed()){	
				pressed= true;
			}else{
				pressed = false;
			}
			
		}else{
			hover = false;
		}
		
		
		
	}
	
	
	public boolean getIsPressed(){
		return pressed;
	}
	
	public boolean getIsHovered(){
		return hover;
	}

	
	
	
}
