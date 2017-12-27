package com.sueheir.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.sueheir.Window;
import com.sueheir.other.InfoMouse;
import com.sueheir.map.*;

public class Player extends Entity {

	
	private float XIntial,YIntial,XCenter,YCenter,R;
	private int ID;
	private String Name;
	private boolean hover = false;
	private boolean selected = false;
	private boolean screenIsCentered = false;
	private boolean Alive;
	Font font;
	
	
	public void setParamaters(int x, int y, int ID, String name, int tilesize ) {
		XCenter=x;
		YCenter=y;
		R= tilesize*0.25f;
		this.ID=ID;
		Name = name;

	}

	@Override
	public void draw(Graphics g, Color color) {
		font = g.getFont();
		font.drawString(XCenter-font.getWidth(Name)/2 +Map.screenslidex,YCenter-font.getHeight(Name)/2 +Map.screenslidey,Name+" "+(ID+1),Color.white);

		g.setColor(color);
		g.drawOval(XCenter-R +Map.screenslidex, YCenter-R +Map.screenslidey, R*2, R*2);
		g.setColor(Color.white);

		
		
		if(hover){
			g.setColor(Color.yellow);
			g.drawOval(XCenter-2-R +Map.screenslidex, YCenter-2-R +Map.screenslidey, R*2+4, R*2+4);
			g.setColor(Color.white);
		}else if(selected){
			
			g.setColor(Color.green);
			g.drawOval(XCenter-2-R +Map.screenslidex, YCenter-2-R +Map.screenslidey, R*2+4, R*2+4);
			g.setColor(Color.white);
			
		}
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		XIntial = XCenter+Map.screenslidex;
		YIntial = YCenter+Map.screenslidey;
		
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
				Map.screenslidex= (int) -XCenter + Window.width/2;
				Map.screenslidey= (int) -YCenter + Window.height/2;
			}
			
			
			if(input.isKeyDown(Input.KEY_W)){
				
			}
			if(input.isKeyDown(Input.KEY_S)){
			
			}
			if(input.isKeyDown(Input.KEY_D)){
				
			}
			if(input.isKeyDown(Input.KEY_A)){
				
			}
			
			
		}else{
				screenIsCentered=false;
			}
		
		
		
	}

	@Override
	public boolean getIsSelected() {
	
		return selected;
	}

	
	@Override
	public float getX() {
		
		return XCenter;
	}

	@Override
	public float getY() {
		
		return YCenter;
	}

	@Override
	public float getR() {
		
		return R;
	}

	@Override
	public void setIsSelected(boolean check) {
		selected=check;
		
	}

	@Override
	public void setX(float x) {
		XCenter=x;
		
	}

	@Override
	public void setY(float y) {
		YCenter=y;
		
	}

	@Override
	public void setR(int r) {
		R=r;
		
	}

	@Override
	public boolean isAlive() {
		return Alive;
	}

	

	

}
