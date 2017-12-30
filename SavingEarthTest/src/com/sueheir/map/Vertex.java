package com.sueheir.map;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.sueheir.Window;
import com.sueheir.other.InfoMouse;
import com.sueheir.states.Play;
import com.sueheir.world.World;

public class Vertex {

	private int XCoord, YCoord;
	private float XIntial,YIntial,XCenter,YCenter,R;
	private boolean hover = false, selected = false, screenIsCentered = false, isFilled = false;
	private Color color;
	Font font;
	
	public Vertex(int i, int j) {
		XCoord = i;
		YCoord = j;
	}
	
	public void setParamaters(float x, float y, int tileSize){
		
		XCenter=x;
		YCenter=y;
		R = tileSize*0.25f;
		
	}

	public void render(Graphics g) {
		// Draws Value number in center of Circle
		font = g.getFont();
		
		// Draws Colored Circle in Center of Vertex
		g.setColor(color);
		g.drawOval(XCenter-R +World.screenslidex, YCenter-R +World.screenslidey, R*2, R*2);
		g.setColor(Color.white);
		
		//Draw Hover yellow circle
		if(hover){
			g.setColor(Color.yellow);
			g.drawOval(XCenter-2-R +World.screenslidex, YCenter-2-R +World.screenslidey, R*2+4, R*2+4);
			g.setColor(Color.white);
		}else if(selected){
		//Draws green Selected circle
			g.setColor(Color.green);
			g.drawOval(XCenter-2-R +World.screenslidex, YCenter-2-R +World.screenslidey, R*2+4, R*2+4);
			g.setColor(Color.white);
		}
		if(isFilled) {
			g.fillOval(XCenter-2-R +World.screenslidex, YCenter-2-R +World.screenslidey, R*2-5, R*2-5);
		}
		
		// Draws Debug Mode information
		if(Play.DebugMode) {
			font.drawString(XCenter-font.getWidth(XCoord+", "+YCoord)/2 +World.screenslidex,YCenter-font.getHeight(XCoord+", "+YCoord)/2 + 16 +World.screenslidey,XCoord+", "+YCoord,Color.white);
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		XIntial = XCenter+World.screenslidex;
		YIntial = YCenter+World.screenslidey;
		
		int xpos = InfoMouse.getX();
		int ypos = InfoMouse.getY();
		Input input = gc.getInput();
		
		float xd = XIntial-xpos;
		float yd = YIntial-ypos;
		
		float distanceSquared = (xd * xd) + (yd * yd);
		float radiusSquared = R*R ;
		
		if(selected && InfoMouse.getWasPressed() && distanceSquared>radiusSquared){
			selected=false;
			if(input.isKeyDown(Input.KEY_LSHIFT) || input.isKeyDown(Input.KEY_RSHIFT))
				selected=true;
		}
		
		if(distanceSquared<radiusSquared){
			hover=true;
			if(InfoMouse.getWasPressed()){
				if(selected==false){
					selected = true;
				}else{
					selected = false;
				}
			}
		}else{
			hover=false;
		}
		if(selected){
			if(input.isKeyDown(Input.KEY_C)){
				screenIsCentered = true;
			}		
			if(screenIsCentered == true){
				World.screenslidex= (int) -XCenter + Window.width/2;
				World.screenslidey= (int) -YCenter + Window.height/2;
			}
		}else {
				screenIsCentered=false;
		}
	}
	
	Vertex getThisVertex() {
		return this;
	}
	public void setIsSelected(boolean check){
		selected=check;
	}
	public float getX(){
		return XCenter;
	}
	public float getY(){
		return YCenter;
	}

	public void setIsFilled(boolean b) {
		this.isFilled=b;
		
	}

	public boolean getIsFilled() {
		
		return this.isFilled;
	}

	
}

	