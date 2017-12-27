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



	public class BasicTile extends Tile{

		private static final String Type = "WATER";
		private float XIntial,YIntial,XCenter,YCenter,R, ID ; 
		private boolean hover = false;
		private boolean selected = false;
		private boolean screenIsCentered = false;
		private Polygon hex;
		private Color color;
		private String Name;
		Font font;
		private int Value;


		
		public void setParamaters(float x, float y, int ID, int tileSize){
			
			XCenter=x;
			YCenter=y;
			this.ID=ID;
			Name=""+ID;
			R= tileSize*0.82f;
			
			hex = new Polygon();
			
			hex.addPoint(-tileSize*1.15f,0);
			hex.addPoint(-0.5f*tileSize*1.15f,-0.866f*tileSize*1.15f);
			hex.addPoint(0.5f*tileSize*1.15f,-0.866f*tileSize*1.15f);
			hex.addPoint(tileSize*1.15f,0);
			hex.addPoint(0.5f*tileSize*1.15f,0.866f*tileSize*1.15f);
			hex.addPoint(-0.5f*tileSize*1.15f,0.866f*tileSize*1.15f);
			
			configureType(ID);
			
			
			
			
		}
		
		private void configureType(int iD2) {
			
			this.setType("WATER");
			this.color = Color.blue;
			if(iD2 == 10  || (iD2 >14 && iD2<20) || (iD2 >21 && iD2<27) || (iD2 >28 && iD2<34) || (iD2 >36 && iD2<40) ) {
				
				this.setType("LAND");
				
				Color wood = new Color(153, 76, 0);
				Color wheat = new Color(255,255,0);
				Color stone = new Color(128,128,128);
				Color sheep = new Color(0,204,0);
				Color brick = new Color(204,0,0);
				Color desert = new Color(204,170,0);
				
				
				if(iD2==10) {this.setColor(stone); this.setValue(10); }
				if(iD2==15) {this.setColor(wheat); this.setValue(9);}
				if(iD2==16) {this.setColor(wheat); this.setValue(12);  }
				if(iD2==17) {this.setColor(brick); this.setValue(6);  }
				if(iD2==18) {this.setColor(sheep); this.setValue(2);  }
				if(iD2==19) {this.setColor(wood); this.setValue(9);  }
				if(iD2==22) {this.setColor(wood); this.setValue(8);  }
				if(iD2==23) {this.setColor(wood); this.setValue(11);  }
				if(iD2==24) {this.setColor(desert); this.setValue(0);  }
				if(iD2==25) {this.setColor(sheep); this.setValue(4);  }
				if(iD2==26) {this.setColor(brick); this.setValue(10);  }
				if(iD2==29) {this.setColor(brick); this.setValue(5);  }
				if(iD2==30) {this.setColor(stone); this.setValue(3); }
				if(iD2==31) {this.setColor(wheat); this.setValue(4);  }
				if(iD2==32) {this.setColor(wood); this.setValue(3);  }
				if(iD2==33) {this.setColor(stone); this.setValue(8);  }
				if(iD2==37) {this.setColor(wheat); this.setValue(6);  }
				if(iD2==38) {this.setColor(sheep); this.setValue(11);  }
				if(iD2==39) {this.setColor(sheep); this.setValue(5);  }
				
				
				
				
			}
			
		}


		public void draw(Graphics g) {
			
				g.setColor(color);
				g.fillOval(XCenter-R +Map.screenslidex, YCenter-R +Map.screenslidey, R*2, R*2);
				g.setColor(Color.white);
			
	
			font = g.getFont();
			font.drawString(XCenter-font.getWidth(Name)/2 +Map.screenslidex,YCenter-font.getHeight(Name)/2 +Map.screenslidey,""+Value,Color.black);
			font.drawString(XCenter-font.getWidth(Name)/2 +Map.screenslidex,YCenter-font.getHeight(Name)/2 +Map.screenslidey,""+Value,Color.black);

				
				
				hex.setLocation(XCenter +Map.screenslidex, YCenter +Map.screenslidey);
				g.draw(hex);

			
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
				
				
			}else {
					screenIsCentered=false;
				}
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
		public float getR(){
			return R;
		}

		public int getID(){
			return (int) ID;
		}
	
		
		
		
		
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

		
		
		
		public String getType() {
			// TODO Auto-generated method stub
			return Type;
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

		@Override
		public void setType(String Type) {
			// TODO Auto-generated method stub
			
		}


		



}
	


