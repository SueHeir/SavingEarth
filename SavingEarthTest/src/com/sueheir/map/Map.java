package com.sueheir.map;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.sueheir.states.Play;
import com.sueheir.world.World;




public class Map {

	public static Tile[][] tiles;
	public static ArrayList<Tile> TileList;
	
	
	public static void init(int ws) {
		int worldSize = ws;
		tiles = new Tile[worldSize][worldSize];
		TileList = new ArrayList<Tile>();
		
		for(int i=0;i<worldSize;++i){
			for(int j=0;j<worldSize;++j){
				tiles[j][i] = new BasicTile(j,i);
				TileList.add(tiles[j][i]);
				
			}
		}
		
		
		int k=0;
		int j=0;
		int i=0;
		for(Tile x: TileList) {
			if((k & 1) == 0) {
			x.setParamaters(1.73f*Play.tileSize*k, 2.01f*Play.tileSize*j,  i , Play.tileSize);
			} else {
			x.setParamaters(1.73f*Play.tileSize*k, Play.tileSize*1f + 2.01f*Play.tileSize*j, i , Play.tileSize);
			}
		
			k++;
			i++;
			if(k==worldSize) {
				k=0;
				j++;
			}
		}
	}
	
	public static void render(Graphics g) throws SlickException {
		
		for(Tile x: TileList){
			x.draw(g);
		}
	}

	public static void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_UP)){
			World.screenslidey += 5;
		}
		if(input.isKeyDown(Input.KEY_DOWN)){
			World.screenslidey -= 5;
		}
		if(input.isKeyDown(Input.KEY_RIGHT)){
			World.screenslidex-= 5;
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			World.screenslidex+= 5;
		}
	
		if(input.isKeyPressed(Input.KEY_R)){
			radomizeMap();
		}
		
		for(Tile x: TileList){
			x.update(gc, sbg, delta);
		}
	}
	
	public static void radomizeMap() {
	
		MapConditions.reset();
		
		for(Tile x: TileList){
			if(x.getID() == 10  || (x.getID() >14 && x.getID()<20) || (x.getID() >21 && x.getID()<27) || (x.getID() >28 && x.getID()<34) || (x.getID() >36 && x.getID()<40) ) {
				x.setType("LAND");
				x.setColor(MapConditions.createmap(x,-1));
			}
		}
	}
}
