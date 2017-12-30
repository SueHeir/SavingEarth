package com.sueheir.map;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.Random;

public class MapConditions {
	
	public static int maxWood = 4, maxWheat = 4, maxStone = 3, maxSheep = 4, maxBrick = 3, maxDesert = 1;
	public static int currentWood = 0, currentWheat = 0, currentStone = 0, currentSheep = 0, currentBrick = 0, currentDesert = 0;
	
	static Color wood = new Color(153, 76, 0);
	static Color wheat = new Color(255,255,0);
	static Color stone = new Color(128,128,128);
	static Color sheep = new Color(0,204,0);
	static Color brick = new Color(204,0,0);
	static Color desert = new Color(204,170,0);
	
	static Random rand = new Random();
	
	
	static int[] listofints = new int[] {2,3,3,4,4,5,5,6,6,8,8,9,9,10,10,11,11,12};
	static Boolean[] listofbools = new Boolean[18];
	
	MapConditions(){
		for(int i=0;i<18;i++) {
			listofbools[i]=false;
		}
		
	}
	

	public static Color randomizeMapType(Tile x, int help) {
		int Num = help;
		
		if(Num==-1) {
				Num = rand.nextInt(6);
		}
		if(Num==0) {
			if(getcurrentWood()<getmaxWood()) {
				setcurrentWood(getcurrentWood()+1);
				x.setName("WOOD");
				return wood;
			} else {
				Num++;
			}
		}
		if(Num==1) {
			if(getcurrentWheat()<getmaxWheat()) {
				setcurrentWheat(getcurrentWheat()+1);
				x.setName("WHEAT");
				return wheat;
			} else {
				Num++;
			}
		}
		if(Num==2) {
			if(getcurrentStone()<getmaxStone()) {
				setcurrentStone(getcurrentStone()+1);
				x.setName("STONE");
				return stone;
			} else {
				Num++;
			}
		}
		if(Num==3) {
			if(getcurrentSheep()<getmaxSheep()) {
				setcurrentSheep(getcurrentSheep()+1);
				x.setName("SHEEP");
				return sheep;
			} else {
				Num++;
			}
		}
		if(Num==4) {
			if(getcurrentBrick()<getmaxBrick()) {
				setcurrentBrick(getcurrentBrick() +1);
				x.setName("BRICK");
				return brick;
			} else {
				Num++;
			}
		}
		if(Num==5){
			if(getcurrentDesert()<getmaxDesert()) {
				setcurrentDesert(getcurrentDesert()+1);
				x.setName("DESERT");
				Map.setSpawn(x.getXCoord(), x.getYCoord());
				return desert;
			} else {
				Num=0;
			}
		} else {
			return randomizeMapType(x,-1);
		}
		return randomizeMapType(x,-1);	
	}
	
	public static void randomizeMapValues(Tile x) {
		if(x.getType()=="WATER") {
			return;
		} else if(x.getName()=="DESERT") {
			x.setValue(0);
			return;
		} else {
			int Num = rand.nextInt(18);
			if(listofbools[Num]==false) {
				x.setValue(listofints[Num]);
				listofbools[Num]= true;
			} else {
				randomizeMapValues(x);
				return;
			}
		}
	}
		
	public static void reset() {
		setcurrentWood(0);
		setcurrentWheat(0);
		setcurrentStone(0);
		setcurrentSheep(0);
		setcurrentBrick(0);
		setcurrentDesert(0);
		
		for (int i=0; i<18;i++) {
			listofbools[i]=false;
		}
		
	}
	/*
	 * GETTERS
	 */
	public static int getcurrentWood(){
		return currentWood;
	}
	public static int getcurrentWheat(){
		return currentWheat;
	}
	public static int getcurrentStone(){
		return currentStone;
	}
	public static int getcurrentSheep(){
		return currentSheep;
	}
	public static int getcurrentBrick(){
		return currentBrick;
	}
	public static int getcurrentDesert(){
		return currentDesert;
	}
	
	public static int getmaxWood(){
		return maxWood;
	}
	public static int getmaxWheat(){
		return maxWheat;
	}
	public static int getmaxStone(){
		return maxStone;
	}
	public static int getmaxSheep(){
		return maxSheep;
	}
	public static int getmaxBrick(){
		return maxBrick;
	}
	public static int getmaxDesert(){
		return maxDesert;
	}
	
	/*
	 * SETTERS
	 */
	public static void setcurrentWood(int set){
		 currentWood = set;
	}
	public static void setcurrentWheat(int set){
		 currentWheat = set;
	}
	public static void setcurrentStone(int set){
		 currentStone = set;
	}
	public static void setcurrentSheep(int set){
		 currentSheep = set;
	}
	public static void setcurrentBrick(int set){
		 currentBrick = set;
	}
	public static void setcurrentDesert(int set){
		 currentDesert = set;
	}

}
