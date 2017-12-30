package com.sueheir.map;


import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.StateBasedGame;

import com.sueheir.Window;
import com.sueheir.other.InfoMouse;
import com.sueheir.states.Play;
import com.sueheir.world.World;


	public class BasicTile extends Tile{
		
		private int Value, XCoord, YCoord, ID;
		private float XIntial,YIntial,XCenter,YCenter,R; 
		private boolean hover = false, selected = false, screenIsCentered = false;
		private String Name = "", Type = "";
		private Polygon hex;
		private Color color;
		Font font;
		
		/*
		 * Basic Tile Constructor Sets (x,y) coordinates
		 */
		public BasicTile(int j, int i) {
			XCoord = j;
			YCoord = i;
		}

		/*
		 * Sets Paramaters for Tile
		 */
		public void setParamaters(float x, float y, int ID, int tileSize){
			//sets valves to private class
			XCenter=x;
			YCenter=y;
			this.ID=ID;
			R= tileSize*0.84f;
			//creates new hexagon
			hex = new Polygon();
			//sets points of hexagon based off tileSize
			hex.addPoint(-tileSize*1.15f,0);
			hex.addPoint(-0.5f*tileSize*1.15f,-0.866f*tileSize*1.15f);
			hex.addPoint(0.5f*tileSize*1.15f,-0.866f*tileSize*1.15f);
			hex.addPoint(tileSize*1.15f,0);
			hex.addPoint(0.5f*tileSize*1.15f,0.866f*tileSize*1.15f);
			hex.addPoint(-0.5f*tileSize*1.15f,0.866f*tileSize*1.15f);
			//sets default map
			configureType(ID);
			
			
		}
		
		private void configureType(int iD2) {
			//Type Water: you can't walk on
			this.setType("WATER");
			this.color = Color.blue;
			
			if(iD2 == 10  || (iD2 >14 && iD2<20) || (iD2 >21 && iD2<27) || (iD2 >28 && iD2<34) || (iD2 >36 && iD2<40) ) {
				//Type Land, you can walk on 
				this.setType("LAND");	
				
				//Default Catan Map colors, type and Values
				if(iD2==10) {this.setColor(MapConditions.stone);this.setName("STONE"); this.setValue(10); }
				if(iD2==15) {this.setColor(MapConditions.wheat);this.setName("WHEAT"); this.setValue(9);}
				if(iD2==16) {this.setColor(MapConditions.wheat);this.setName("WHEAT"); this.setValue(12);  }
				if(iD2==17) {this.setColor(MapConditions.brick);this.setName("BRICK"); this.setValue(6);  }
				if(iD2==18) {this.setColor(MapConditions.sheep);this.setName("SHEEP"); this.setValue(2);  }
				if(iD2==19) {this.setColor(MapConditions.wood);this.setName("WOOD"); this.setValue(9);  }
				if(iD2==22) {this.setColor(MapConditions.wood);this.setName("WOOD"); this.setValue(8);  }
				if(iD2==23) {this.setColor(MapConditions.wood);this.setName("WOOD"); this.setValue(11);  }
				if(iD2==24) {this.setColor(MapConditions.desert);this.setName("DESERT"); this.setValue(0);  }
				if(iD2==25) {this.setColor(MapConditions.sheep);this.setName("SHEEP"); this.setValue(4);  }
				if(iD2==26) {this.setColor(MapConditions.brick);this.setName("BRICK"); this.setValue(10);  }
				if(iD2==29) {this.setColor(MapConditions.brick);this.setName("BRICK"); this.setValue(5);  }
				if(iD2==30) {this.setColor(MapConditions.stone);this.setName("STONE"); this.setValue(3); }
				if(iD2==31) {this.setColor(MapConditions.wheat);this.setName("WHEAT"); this.setValue(4);  }
				if(iD2==32) {this.setColor(MapConditions.wood);this.setName("WOOD"); this.setValue(3);  }
				if(iD2==33) {this.setColor(MapConditions.stone);this.setName("STONE"); this.setValue(8);  }
				if(iD2==37) {this.setColor(MapConditions.wheat);this.setName("WHEAT"); this.setValue(6);  }
				if(iD2==38) {this.setColor(MapConditions.sheep);this.setName("SHEEP"); this.setValue(11);  }
				if(iD2==39) {this.setColor(MapConditions.sheep);this.setName("SHEEP"); this.setValue(5);  }
			}
		}
		
		/*
		 * Draws Tile
		 */
		public void render(Graphics g) {
			
			// Draws Colored Circle in Center of Hexagon
			g.setColor(color);
			g.fillOval(XCenter-R +World.screenslidex, YCenter-R +World.screenslidey, R*2, R*2);
			g.setColor(Color.white);
	
			// Draws Value number in center of Circle
			font = g.getFont();
			font.drawString(XCenter-font.getWidth(""+Value)/2 +World.screenslidex,YCenter-font.getHeight(""+Value)/2 +World.screenslidey,""+Value,Color.black);
			
			//Draw Hexagon
			hex.setLocation(XCenter +World.screenslidex, YCenter +World.screenslidey);
			g.draw(hex);
			
			// Draws Debug Mode information
			if(Play.DebugMode) {
			font.drawString(XCenter-font.getWidth(XCoord+", "+YCoord)/2 +World.screenslidex,YCenter-font.getHeight(XCoord+", "+YCoord)/2 + 16 +World.screenslidey,XCoord+", "+YCoord,Color.black);
			font.drawString(XCenter-font.getWidth(Name)/2 +World.screenslidex,YCenter-font.getHeight(Name)/2 + 32 +World.screenslidey,Name,Color.black);
			}
				
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
		public  BasicTile getBasicTile() {
			return this;
		}
		public boolean getIsSelected(){
			return selected;
		}
		public float getX(){
			return XCenter;
		}
		public float getY(){
			return YCenter;
		}
		public int getXCoord(){
			return XCoord;
		}
		public int getYCoord(){
			return YCoord;
		}
		public float getR(){
			return R;
		}
		public int getID(){
			return (int) ID;
		}
		public String getType() {
			return Type;
		}
		public String getName() {
			return Name;
		}
		/*
		 * SETTERS 
		 */	
		public void setIsSelected(boolean check){
			selected=check;
		}
		public void setX(float x){
			XCenter=x;
		}
		public void setY(float y){
			YCenter=y;
		}
		public void setR(int r){
			R= r;
		}
		public void setID(int id){
			ID=id;
		}
		public void setValue(int val) {
			this.Value = val;
		}
		public void setName(String Name) {
			this.Name = Name;
		}
		public void setColor(Color color) {
			this.color = color;
		}
		public void setType(String Type) {
			this.Type=Type;
		}
}
	


