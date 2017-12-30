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
import com.sueheir.other.InfoMouse;
import com.sueheir.world.World;
import com.sueheir.map.*;

public class Player extends Entity {

	private boolean hover = false, selected = false, screenIsCentered = false;
	private static boolean firstPass=true;
	private boolean Alive;
	private float XIntial,YIntial,XCenter,YCenter,R;
	private int ID, XCoord, YCoord, currentEnergy, maxEnergy=3, currentMana, maxMana=3, currentHealth, maxHealth=5;
	private String Name;
	Font font;
	
	
	public void setParamaters( int ID, String name, int tilesize ) {
		int spawnX=Map.spawnlocation[0];
		int spawnY=Map.spawnlocation[1];
		if((spawnX & 1)==1) {
			if(ID==1) {
				XCenter=Map.vertexes[spawnX*2-1][spawnY+1].getX();
				YCenter=Map.vertexes[spawnX*2-1][spawnY+1].getY();
				Map.vertexes[spawnX*2-1][spawnY+1].setIsFilled(true);
				XCoord=spawnX*2-1;
				YCoord=spawnY+1;
			}
			if(ID==2) {
				XCenter=Map.vertexes[spawnX*2][spawnY].getX();
				YCenter=Map.vertexes[spawnX*2][spawnY].getY();
				Map.vertexes[spawnX*2][spawnY].setIsFilled(true);
				XCoord=spawnX*2;
				YCoord=spawnY;
			}
			if(ID==3) {
				XCenter=Map.vertexes[spawnX*2+1][spawnY].getX();
				YCenter=Map.vertexes[spawnX*2+1][spawnY].getY();
				Map.vertexes[spawnX*2+1][spawnY].setIsFilled(true);
				XCoord=spawnX*2+1;
				YCoord=spawnY;
			}
			if(ID==4) {
				XCenter=Map.vertexes[spawnX*2+2][spawnY+1].getX();
				YCenter=Map.vertexes[spawnX*2+2][spawnY+1].getY();
				Map.vertexes[spawnX*2+2][spawnY+1].setIsFilled(true);
				XCoord=spawnX*2+2;
				YCoord=spawnY+1;
			}
			if(ID==5) {
				XCenter=Map.vertexes[spawnX*2+1][spawnY+1].getX();
				YCenter=Map.vertexes[spawnX*2+1][spawnY+1].getY();
				Map.vertexes[spawnX*2+1][spawnY+1].setIsFilled(true);
				XCoord=spawnX*2+1;
				YCoord=spawnY+1;
			}
			if(ID==6) {
				XCenter=Map.vertexes[spawnX*2][spawnY+1].getX();
				YCenter=Map.vertexes[spawnX*2][spawnY+1].getY();
				Map.vertexes[spawnX*2][spawnY+1].setIsFilled(true);
				XCoord=spawnX*2;
				YCoord=spawnY+1;
			}
		}else {
			if(ID==1) {
				XCenter=Map.vertexes[spawnX*2-1][spawnY].getX();
				YCenter=Map.vertexes[spawnX*2-1][spawnY].getY();
				Map.vertexes[spawnX*2-1][spawnY].setIsFilled(true);
				XCoord=spawnX*2-1;
				YCoord=spawnY;
			}
			if(ID==2) {
				XCenter=Map.vertexes[spawnX*2][spawnY].getX();
				YCenter=Map.vertexes[spawnX*2][spawnY].getY();
				Map.vertexes[spawnX*2][spawnY].setIsFilled(true);
				XCoord=spawnX*2;
				YCoord=spawnY;
			}
			if(ID==3) {
				XCenter=Map.vertexes[spawnX*2+1][spawnY].getX();
				YCenter=Map.vertexes[spawnX*2+1][spawnY].getY();
				Map.vertexes[spawnX*2+1][spawnY].setIsFilled(true);
				XCoord=spawnX*2+1;
				YCoord=spawnY;
			}
			if(ID==4) {
				XCenter=Map.vertexes[spawnX*2+2][spawnY].getX();
				YCenter=Map.vertexes[spawnX*2+2][spawnY].getY();
				Map.vertexes[spawnX*2+2][spawnY].setIsFilled(true);
				XCoord=spawnX*2+2;
				YCoord=spawnY;
			}
			if(ID==5) {
				XCenter=Map.vertexes[spawnX*2+1][spawnY+1].getX();
				YCenter=Map.vertexes[spawnX*2+1][spawnY+1].getY();
				Map.vertexes[spawnX*2+1][spawnY+1].setIsFilled(true);
				XCoord=spawnX*2+1;
				YCoord=spawnY+1;
			}
			if(ID==6) {
				XCenter=Map.vertexes[spawnX*2][spawnY+1].getX();
				YCenter=Map.vertexes[spawnX*2][spawnY+1].getY();
				Map.vertexes[spawnX*2][spawnY+1].setIsFilled(true);
				XCoord=spawnX*2;
				YCoord=spawnY+1;
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
		XCenter = Map.vertexes[XCoord][YCoord].getX();
		YCenter = Map.vertexes[XCoord][YCoord].getY();
		
		XIntial = XCenter+World.screenslidex;
		YIntial = YCenter+World.screenslidey;
		
		int xpos = InfoMouse.getX();
		int ypos = InfoMouse.getY();
		Input input = gc.getInput();
		
		
		float xd = XIntial-xpos;
		float yd = YIntial-ypos;
		
		float distanceSquared = (xd * xd) + (yd * yd);
		float radiusSquared = R*R ;
		
		if(Gui.currentPlayerID==ID) {
			this.setIsSelected(true);
				if (firstPass) {
					Gui.loadPlayerInfo(this);
					firstPass=false;
				}
			
		} else {
			this.setIsSelected(false);
		}
	
		
		
		if(selected){
			
			if(input.isKeyDown(Input.KEY_C)){
				screenIsCentered = true;
			}
			if(screenIsCentered == true){
				World.screenslidex= (int) -XCenter + Window.width/2;
				World.screenslidey= (int) -YCenter + Window.height/2;
			}
			
			
			
			if(input.isKeyPressed(Input.KEY_W) &&  currentEnergy>0){
				if((XCoord & 2)==0) {
					if((XCoord & 1)==0 &! Map.vertexes[XCoord-1][YCoord-1].getIsFilled()) {
						Map.vertexes[XCoord][YCoord].setIsFilled(false);
						XCoord--;
						YCoord--;
						Map.vertexes[XCoord][YCoord].setIsFilled(true);
						currentEnergy--;
					} else if (!((XCoord & 1)==0) &! Map.vertexes[XCoord+1][YCoord-1].getIsFilled() ){
						Map.vertexes[XCoord][YCoord].setIsFilled(false);
						XCoord++;
						YCoord--;
						Map.vertexes[XCoord][YCoord].setIsFilled(true);
						currentEnergy--;
					}
				} else {
					if((XCoord & 1)==0 &! Map.vertexes[XCoord-1][YCoord].getIsFilled()) {
						Map.vertexes[XCoord][YCoord].setIsFilled(false);
						XCoord--;
						Map.vertexes[XCoord][YCoord].setIsFilled(true);
						currentEnergy--;
					} else if (!((XCoord & 1)==0) &! Map.vertexes[XCoord+1][YCoord].getIsFilled()){
						Map.vertexes[XCoord][YCoord].setIsFilled(false);
						XCoord++;
						Map.vertexes[XCoord][YCoord].setIsFilled(true);
						currentEnergy--;
					}
				}
			}
			if(input.isKeyPressed(Input.KEY_S)&& currentEnergy>0){
				if((XCoord & 2)==0) {
					if((XCoord & 1)==0 &! Map.vertexes[XCoord-1][YCoord].getIsFilled()) {
						Map.vertexes[XCoord][YCoord].setIsFilled(false);
						XCoord--;
						Map.vertexes[XCoord][YCoord].setIsFilled(true);
						currentEnergy--;
					} else if (!((XCoord & 1)==0) &! Map.vertexes[XCoord+1][YCoord].getIsFilled()){
						Map.vertexes[XCoord][YCoord].setIsFilled(false);
						XCoord++;
						Map.vertexes[XCoord][YCoord].setIsFilled(true);
						currentEnergy--;
					}
				} else {
					if((XCoord & 1)==0 &! Map.vertexes[XCoord-1][YCoord+1].getIsFilled()) {
						Map.vertexes[XCoord][YCoord].setIsFilled(false);
						XCoord--;
						YCoord++;
						Map.vertexes[XCoord][YCoord].setIsFilled(true);
						currentEnergy--;
					} else if (!((XCoord & 1)==0) &! Map.vertexes[XCoord+1][YCoord+1].getIsFilled()){
						Map.vertexes[XCoord][YCoord].setIsFilled(false);
						XCoord++;
						YCoord++;
						Map.vertexes[XCoord][YCoord].setIsFilled(true);
						currentEnergy--;
					}
				}
			
			}
			if(input.isKeyPressed(Input.KEY_D)&& currentEnergy>0){
				if((XCoord & 1)==0 &!  Map.vertexes[XCoord+1][YCoord].getIsFilled()) {
					Map.vertexes[XCoord][YCoord].setIsFilled(false);
					XCoord++;
					Map.vertexes[XCoord][YCoord].setIsFilled(true);
					currentEnergy--;
				} 
				
			}
			if(input.isKeyPressed(Input.KEY_A)&& currentEnergy>0){
				if(!((XCoord & 1)==0) &!  Map.vertexes[XCoord-1][YCoord].getIsFilled()) {
					Map.vertexes[XCoord][YCoord].setIsFilled(false);
					XCoord--;
					Map.vertexes[XCoord][YCoord].setIsFilled(true);
					currentEnergy--;
				}
			}
			
			
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
	public int getXCoord() {
		
		return XCoord;
	}

	@Override
	public int getYCoord() {
		
		return YCoord;
	}

	@Override
	public float getR() {
		
		return R;
	}
	public int getCurrentEnergy() {
		return currentEnergy;
	}
	
	public int getCurrentMana() {
		return currentMana;
	}
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	public int getMaxEnergy() {
		return maxEnergy;
	}
	
	public int getMaxMana() {
		return maxMana;
	}
	public int getMaxHealth() {
		return maxHealth;
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

	@Override
	public void setXCoord(int x) {
		this.XCoord=x;
		
	}

	@Override
	public void setYCoord(int y) {
		this.YCoord=y;
		
	}
	
	public void setCurrentEnergy(int i) {
		currentEnergy=i;
	}
	
	public void setCurrentMana(int i) {
		currentMana=i;
	}
	public void setCurrentHealth(int i) {
		currentHealth=i;
	}
	
	public void setMaxEnergy(int i) {
		maxEnergy=i;
	}
	
	public void setMaxMana(int i) {
		maxMana=i;
	}
	public void setMaxHealth(int i) {
		maxHealth=i;
	}

	public static void setFirstPass(boolean b) {
		firstPass = b;
		
	}

	

	

}
