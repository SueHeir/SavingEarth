package com.sueheir.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.sueheir.Window;
import com.sueheir.gui.Gui;
import com.sueheir.map.Map;
import com.sueheir.other.InfoMouse;
import com.sueheir.world.World;

public class Monster extends Entity {
	
	private boolean hover = false, selected = false, screenIsCentered = false;
	private boolean Alive;
	private float XIntial,YIntial,XCenter,YCenter,R;
	private int ID, XCoord, YCoord, currentHealth, maxHealth;
	private String Name = "MONSTER";
	Font font;
	

	public Monster(int xCoord, int yCoord, int tilesize) {
		XCoord=xCoord;
		YCoord=yCoord;
		XCenter=Map.vertexes[XCoord][YCoord].getX();
		YCenter=Map.vertexes[XCoord][YCoord].getY();
		Map.vertexes[XCoord][YCoord].setIsFilled(true);
		R= tilesize*.18f;
		this.ID=ID;
		Name = "Monster";
		
	}
	@Override
	public void setParamaters(int ID, String string, int tilesize) {
		
	}
	@Override
	public void draw(Graphics g, Color color) {
		font = g.getFont();
		font.drawString(XCenter-font.getWidth(Name)/2 +World.screenslidex,YCenter-font.getHeight(Name)/2 +World.screenslidey,Name+" "+(ID),Color.white);
		
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
		}else {
				screenIsCentered=false;
		}
		
		
	}
	
	/*
	 * GETTERS
	 */
	public boolean getIsSelected() {
		return selected;
	}
	public float getX() {
		return XCenter;
	}
	public float getY() {
		return YCenter;
	}
	public int getXCoord() {
		return XCoord;
	}
	public int getYCoord() {
		return YCoord;
	}
	public float getR() {
		return R;
	}
	public int getCurrentHealth() {
		return currentHealth;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public String getName() {
		return Name;
	}
	
	
	
	/*
	 * SETTERS
	 */
	public void setIsSelected(boolean check) {
		selected=check;
	}
	public void setX(float x) {
		XCenter=x;
	}
	public void setY(float y) {
		YCenter=y;
	}
	public void setR(int r) {
		R=r;
	}
	public boolean isAlive() {
		return Alive;
	}
	public void setXCoord(int x) {
		this.XCoord=x;
	}
	public void setYCoord(int y) {
		this.YCoord=y;
	}
	
	public void setCurrentHealth(int i) {
		currentHealth=i;
	}
	public void setMaxHealth(int i) {
		maxHealth=i;
	}
	

}
