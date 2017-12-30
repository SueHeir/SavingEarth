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

	//2d array of tile classes
	public static Tile[][] tiles;
	public static Vertex[][] vertexes;
	
	//added to 1d array for handling
	public static ArrayList<Tile> TileList;
	public static ArrayList<Vertex> VertexList;
	
	public static int[] spawnlocation = {3,3};
	
	
	public static void init(int ws) {
		
		int worldSize = ws;
		tiles = new Tile[worldSize][worldSize];
		vertexes = new Vertex[worldSize*2][worldSize*2];
		TileList = new ArrayList<Tile>();
		VertexList = new ArrayList<Vertex>();
	
	//FOR TILES 2D array size of MapSize (see play class)	
		for(int i=0;i<worldSize;++i){
			for(int j=0;j<worldSize;++j){
				tiles[j][i] = new BasicTile(j,i);
				TileList.add(tiles[j][i]);
			}
		}
		
	//FOR VERTEXES 2D array size of MapSize
		for(int i=0;i<worldSize+1;++i){
			for(int j=0;j<worldSize*2;++j){
				vertexes[j][i] = new Vertex(j,i);
				VertexList.add(vertexes[j][i]);
			}
		}
		
		//FOR TILES Sets Location, ID tag, passes tileSize (from play class to basicTile class)
		int k=0, j=0, i=0;
		for(Tile x: TileList) {
			if((k & 1) == 0) {
			x.setParamaters(1.73f*Play.tileSize*k, 2.01f*Play.tileSize*j,  i , Play.tileSize);
			} else {
			x.setParamaters(1.73f*Play.tileSize*k, Play.tileSize*1f + 2.01f*Play.tileSize*j, i , Play.tileSize);
			}

			k++;i++;
			if(k==worldSize) {
				k=0;
				j++;
			}
		}
		/*
		 * FOR VERTEXES 
		 */
		
		k=0; j=0; i=0;
		boolean rotate = true;
		for(Vertex x: VertexList) {
			if(rotate) {
				if((k & 1) == 0) {
					x.setParamaters(1.73f*Play.tileSize*k-0.5f*Play.tileSize*1.15f, 2.01f*Play.tileSize*j-0.866f*Play.tileSize*1.15f,  Play.tileSize);
				} else {
					x.setParamaters(1.73f*Play.tileSize*k-0.5f*Play.tileSize*1.15f, Play.tileSize*1f + 2.01f*Play.tileSize*j-0.866f*Play.tileSize*1.15f, Play.tileSize);
				}
				rotate = false;
				
			} else {
				if((k & 1) == 0) {
					x.setParamaters(1.73f*Play.tileSize*k+0.5f*Play.tileSize*1.15f, 2.01f*Play.tileSize*j-0.866f*Play.tileSize*1.15f,  Play.tileSize);
				} else {
					x.setParamaters(1.73f*Play.tileSize*k+0.5f*Play.tileSize*1.15f, Play.tileSize*1f + 2.01f*Play.tileSize*j-0.866f*Play.tileSize*1.15f, Play.tileSize);
				}
				rotate = true;
				k++;i++;
				if(k==worldSize) {
					k=0;
					j++;
					
				}
			}
		}
	}
	
	public static void render(Graphics g) throws SlickException {
		// Draws tile class
		for(Tile x: TileList){
			x.render(g);
		}
		for(Vertex x: VertexList) {
			x.render(g);
		}
	}

	public static void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		//gets Input for events
		Input input = gc.getInput();
		
		//When R is pressed, map tiles get randomized (error in wheat count)
		if(input.isKeyPressed(Input.KEY_R)){
			radomizeMap();
		}
		
		//Update Tiles 
		for(Tile x: TileList){
			x.update(gc, sbg, delta);
		}
		
		//Update Tiles 
		for(Vertex x: VertexList){
			x.update(gc, sbg, delta);
		}
	}

	
	/*
	 * Radomize map method, doesn't randomize Values yet
	 */
	
	public static void radomizeMap() {
	
		MapConditions.reset();
		
	
		for(Tile x: TileList){
			if(x.getID() == 10  || (x.getID() >14 && x.getID()<20) || (x.getID() >21 && x.getID()<27) || (x.getID() >28 && x.getID()<34) || (x.getID() >36 && x.getID()<40) ) {
				x.setType("LAND");
				x.setColor(MapConditions.randomizeMapType(x,-1));
				MapConditions.randomizeMapValues(x);
				
			}
		}
	}
	
	
	public static void setSpawn(int x, int y) {
		spawnlocation[0] = x;
		spawnlocation[1] = y;
	}
	
	public static Tile[] getTilesTouchingVertex(int xcoord,int ycoord) {
		
		
		
		return null;
		
	}
}
