package com.sueheir.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Entity {
	
	
	public abstract void setParamaters(int ID, String string, int tilesize);
	public abstract void draw(Graphics g, Color color);
	public abstract void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException;
	
	
	public abstract boolean getIsSelected();

	
	public abstract float getX();
	public abstract float getY();
	public abstract float getR();
	public abstract int getXCoord();
	public abstract int getYCoord();
	public abstract int getCurrentHealth();
	public abstract int getMaxHealth();
	public abstract String getName();
	
	
	public abstract void setIsSelected(boolean check);
	public abstract void setX(float f);
	public abstract void setY(float f);
	public abstract void setXCoord(int XCoord);
	public abstract void setYCoord(int YCoord);
	public abstract void setR(int R);
	public abstract void setCurrentHealth(int health); 
	public abstract void setMaxHealth(int maxHealth);
	
	public abstract boolean isAlive();
	
}
		
	