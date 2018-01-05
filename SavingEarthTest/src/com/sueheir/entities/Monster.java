package com.sueheir.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.sueheir.map.Map;
import com.sueheir.world.World;

public class Monster extends Entity {
	
	private boolean hover = false, selected = false, screenIsCentered = false;
	private boolean Alive;
	private float XIntial,YIntial,XCenter,YCenter,R;
	private int ID, XCoord, YCoord, currentHealth;
	private String Name = "Monster";
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
		
		
	}

	

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getIsSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getR() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getXCoord() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYCoord() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setIsSelected(boolean check) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setX(float f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(float f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setXCoord(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setYCoord(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setR(int r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

}