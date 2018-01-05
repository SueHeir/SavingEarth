package com.sueheir.map;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public abstract class Tile {
	
	
	public abstract void setParamaters(float d, float e, int ID, int tileSize);
	public abstract void render(Graphics g);
	

	public abstract void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException;
	
	
	public abstract boolean getIsSelected();
	
	public abstract float getX();
	public abstract float getY();
	public abstract int getXCoord();
	public abstract int getYCoord();
	public abstract float getR();
	public abstract int getID();
	public abstract String getType();
	public abstract String getName();
	public abstract int getValue();
	public abstract Boolean checkIfVertexIsAdjacent(int X, int Y);
	
	
	public abstract void setIsSelected(boolean check);
	public abstract void setX(float f);
	public abstract void setY(float f);
	public abstract void setR(int r);
	public abstract void setID(int ID);
	public abstract void setType(String type);
	public abstract void setColor(Color color);
	public abstract void setName(String string);
	public abstract void setValue(int value);
	public abstract ArrayList getAdjacentVertex();
	
}
