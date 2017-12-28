package com.sueheir.world;

import java.util.ArrayList;
import java.util.Arrays;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.sueheir.entities.Entity;
import com.sueheir.entities.Player;
import com.sueheir.map.Map;
import com.sueheir.states.Play;

public class World {
	
	//array list of entites, NewEntityList will be used for adding enemies onto current entity list
	public static ArrayList<Entity> EntityList, NewEntityList;
	
	// Used for moving camara position;
	public static int screenslidex = 0;
	public static int screenslidey = 0;
		
	
	public static void init(int worldsize, int playerCount) {
		
		//map includes Tiles, vertexes not done, edges not done, 
		Map.init(worldsize);
	
		
		// all players monsters should extend entity class, and should be included in this array for handling
		Entity[] entity = new Entity[Play.PlayerCount];
		
		for(int i=0;i<Play.PlayerCount;++i){
			entity[i] = new Player();
		}
		
		EntityList = new ArrayList<Entity>(Arrays.asList(entity));
		int i=0;
		for(Entity x: EntityList){
			//X and Y set locations, this should be set up for players to spawn at spawn tile vertexes
			int X = 100*i;
			int Y = 10;
			x.setParamaters(X, Y, i, "PLAYER"+(i+1), Play.tileSize);
			i++;
		}
	}
	

	public static void render(Graphics g) throws SlickException {
		
		//draws map includes Tiles, vertexes not done, edges not done. 
		Map.render(g);
		
		// draws entities 
		for(Entity x: EntityList){
			x.draw(g,Color.white);	
		}
	}
	
	
	public static void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_UP)){
			screenslidey += 5;
		}
		if(input.isKeyDown(Input.KEY_DOWN)){
			screenslidey -= 5;
		}
		if(input.isKeyDown(Input.KEY_RIGHT)){
			screenslidex-= 5;
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			screenslidex+= 5;
		}
		// updates Maps includes Tiles, vertexes not done, edges not done.
		Map.update(gc, sbg, delta);
		
		// draws entities 
		for(Entity x: EntityList){	
			x.update(gc, sbg, delta);
		}
	}
}
