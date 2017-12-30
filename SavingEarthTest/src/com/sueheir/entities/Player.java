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
import com.sueheir.world.World;
import com.sueheir.map.*;

public class Player extends Entity {

	private boolean hover = false, selected = false, screenIsCentered = false, Alive;
	private float XIntial,YIntial,XCenter,YCenter,R;
	private int ID;
	private String Name;
	Font font;
	
	
	public void setParamaters( int ID, String name, int tilesize ) {
		int spawnX=Map.spawnlocation[0];
		int spawnY=Map.spawnlocation[1];
		if((spawnX & 1)==1) {
			if(ID==1) {
				XCenter=Map.vertexes[spawnX*2-1][spawnY+1].getX();
				YCenter=Map.vertexes[spawnX*2-1][spawnY+1].getY();
			}
			if(ID==2) {
				XCenter=Map.vertexes[spawnX*2][spawnY].getX();
				YCenter=Map.vertexes[spawnX*2][spawnY].getY();
			}
			if(ID==3) {
				XCenter=Map.vertexes[spawnX*2+1][spawnY].getX();
				YCenter=Map.vertexes[spawnX*2+1][spawnY].getY();
			}
			if(ID==4) {
				XCenter=Map.vertexes[spawnX*2+2][spawnY+1].getX();
				YCenter=Map.vertexes[spawnX*2+2][spawnY+1].getY();
			}
			if(ID==5) {
				XCenter=Map.vertexes[spawnX*2+1][spawnY+1].getX();
				YCenter=Map.vertexes[spawnX*2+1][spawnY+1].getY();
			}
			if(ID==6) {
				XCenter=Map.vertexes[spawnX*2][spawnY+1].getX();
				YCenter=Map.vertexes[spawnX*2][spawnY+1].getY();
			}
		}else {
			if(ID==1) {
				XCenter=Map.vertexes[spawnX*2-1][spawnY].getX();
				YCenter=Map.vertexes[spawnX*2-1][spawnY].getY();
			}
			if(ID==2) {
				XCenter=Map.vertexes[spawnX*2][spawnY].getX();
				YCenter=Map.vertexes[spawnX*2][spawnY].getY();
			}
			if(ID==3) {
				XCenter=Map.vertexes[spawnX*2+1][spawnY].getX();
				YCenter=Map.vertexes[spawnX*2+1][spawnY].getY();
			}
			if(ID==4) {
				XCenter=Map.vertexes[spawnX*2+2][spawnY].getX();
				YCenter=Map.vertexes[spawnX*2+2][spawnY].getY();
			}
			if(ID==5) {
				XCenter=Map.vertexes[spawnX*2+1][spawnY+1].getX();
				YCenter=Map.vertexes[spawnX*2+1][spawnY+1].getY();
			}
			if(ID==6) {
				XCenter=Map.vertexes[spawnX*2][spawnY+1].getX();
				YCenter=Map.vertexes[spawnX*2][spawnY+1].getY();
			}
		}
		
			
		
		R= tilesize*.18f;
		this.ID=ID;
		Name = name;

	}

	@Override
	public void draw(Graphics g, Color color) {
		font = g.getFont();
		font.drawString(XCenter-font.getWidth(Name)/2 +World.screenslidex,YCenter-font.getHeight(Name)/2 +World.screenslidey,Name+" "+(ID),Color.white);

		g.setColor(color);
		g.drawOval(XCenter-R +World.screenslidex, YCenter-R +World.screenslidey, R*2, R*2);
		g.setColor(Color.white);
		
		if(hover){
			g.setColor(Color.yellow);
			g.drawOval(XCenter-2-R +World.screenslidex, YCenter-2-R +World.screenslidey, R*2+4, R*2+4);
			g.setColor(Color.white);
		}else if(selected){
			
			g.setColor(Color.green);
			g.drawOval(XCenter-2-R +World.screenslidex, YCenter-2-R +World.screenslidey, R*2+4, R*2+4);
			g.setColor(Color.white);
			
		}
		
	}

	@Override
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
