package com.sueheir.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends Entity {

	
	private float XIntial,YIntial,XCenter,YCenter,R;
	private int ID;
	private String Name;
	private boolean hover = false;
	private boolean selected = false;
	private boolean screenIsCentered = false;
	Font font;
	
	
	@Override
	public void setParamaters(int x, int y, int ID, int tilesize ) {
		XCenter=x;
		YCenter=y;

	}

	@Override
	public void draw(Graphics g, Color color) {
		// TODO Auto-generated method stub
		
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
	public boolean collision(Entity entity) {
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
	public void setR(int r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resolveCollision(Entity entity) {
		// TODO Auto-generated method stub
		
	}

}
