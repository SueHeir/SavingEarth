package com.sueheir.world;

import java.util.ArrayList;
import java.util.Arrays;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.sueheir.entities.Entity;
import com.sueheir.entities.Player;
import com.sueheir.map.Map;

public class World {
	
	public static ArrayList<Entity> EntityList, NewEntityList;
	

	public static void init(int worldsize, int playerCount) {
		Map.init(worldsize);
		
		int amountOfplayers = 4;
		Entity[] entity = new Entity[amountOfplayers];
		
		for(int i=0;i<amountOfplayers;++i){
			entity[i] = new Player();
		}
		
		EntityList = new ArrayList<Entity>(Arrays.asList(entity));
		int i=0;
		for(Entity x: EntityList){
			int X = 100*i;
			int Y = 10;
			x.setParamaters(X, Y, i, "PLAYER", Map.tileSize);
			i++;
		}
		
	}

	public static void render(Graphics g) throws SlickException {
		Map.render(g);
		
		for(Entity x: EntityList){
			
			x.draw(g,Color.white);
			
		}
		
		
	}

	public static void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Map.update(gc, sbg, delta);
		
		for(Entity x: EntityList){
			
			x.update(gc, sbg, delta);
			
		}
		
	}

}
