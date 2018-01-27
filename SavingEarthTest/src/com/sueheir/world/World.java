package com.sueheir.world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.sueheir.entities.Entity;
import com.sueheir.entities.Monster;
import com.sueheir.entities.Player;
import com.sueheir.map.Map;
import com.sueheir.map.Tile;
import com.sueheir.map.Vertex;
import com.sueheir.states.Play;

public class World {
	
	//array list of entites, NewEntityList will be used for adding enemies onto current entity list
	public static ArrayList<Entity> EntityList, NewEntityList;
	
	// Used for moving camara position;
	public static int screenslidex = 385;
	public static int screenslidey = -135;
		
	
	public static void init(int worldsize) {
		
		//map includes Tiles, vertexes not done, edges not done, 
		Map.init(worldsize);
	
		
	
	}
	
	
	public static void initalizePlayers(int playerCount) {
		// all players monsters should extend entity class, and should be included in this array for handling
		Entity[] entity = new Entity[playerCount];
		
		for(int i=0;i<playerCount;++i){
			entity[i] = new Player();
		}
		
		EntityList = new ArrayList<Entity>(Arrays.asList(entity));
		int i=0;
		for(Entity x: EntityList){
			//X and Y set locations, this should be set up for players to spawn at spawn tile vertexes
			x.setParamaters( i+1, "PLAYER", Play.tileSize);
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
			if(!x.isAlive()) {
				if(x.getName()=="MONSTER") {
					EntityList.remove(x);
				} 
				if(x.getName()=="PLAYER") {
					x.setCurrentHealth(x.getMaxHealth());
				}
				
			}
		}
	}

	public static int count;
	public static void spawnMonster(int diceValue) {
		ArrayList<Vertex> list = new ArrayList();
		Random rand = new Random();
		
		
		for(Tile x: Map.TileList) {
			if(diceValue==x.getValue()) {
				list.addAll(x.getAdjacentVertex());
			}
		}
		int num = rand.nextInt(list.size());
		if(!list.get(num).getIsFilled()) {
			EntityList.add(new Monster(list.get(num).getXCoord(),list.get(num).getYCoord(),Play.tileSize ));
			return;
		} else {
			count++;
			if(count>12)return;
			spawnMonster(diceValue);
			
		}
		
	}
	
	public static Entity getEntityAtVertex(int x,int y) {
		for(Entity x1: EntityList) {
			if(x1.getXCoord()==x && x1.getYCoord()==y) {
				return x1;
			}
			
		}
		return null;
		
	}
}
