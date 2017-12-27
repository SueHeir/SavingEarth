package com.sueheir;

import java.io.File;
import java.util.HashMap;
import org.newdawn.slick.particles.ConfigurableEmitter;

import org.newdawn.slick.particles.ParticleSystem;

import java.util.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;


public class Resources {

	private static Map<String, Image> images;
	private static Map<String, SpriteSheet> sprites;
	private static Map<String, Sound> sounds;
	private static Map<String, File> xmlFile;
	private static Map<String, ConfigurableEmitter> emitters;
	private static Map<String, ParticleSystem> particleSystems;
	
	public Resources(){
			
		images = new HashMap<String, Image>();
		sprites = new HashMap<String, SpriteSheet>();
		sounds = new HashMap<String, Sound>();
		xmlFile = new HashMap<String, File>();
		particleSystems = new HashMap<String, ParticleSystem>();
		
		
		try {

			//** sprites.put("grassTiles", loadSprite("res/GrassSprite.png",32,32));
			
			images.put("test_particle", loadImage("res/test_particle.png"));
			images.put("particle_plus", loadImage("res/particle_plus.png"));
			images.put("torch", loadImage("res/particle.png"));
			
			xmlFile.put("test_emitter", loadFile("res/test_emitter.xml"));
			xmlFile.put("healing", loadFile("res/healing.xml"));
			xmlFile.put("torch", loadFile("res/torch.xml"));
			
			particleSystems.put("test", loadPS(getImage("test_particle"), 1000));
			
			
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
	public static Image loadImage(String path) throws SlickException{
		return new Image(path, false, Image.FILTER_NEAREST);
		
	}
	
	public static SpriteSheet loadSprite(String path, int tw, int th) throws SlickException{
		return new SpriteSheet(loadImage(path), tw, th);
		
	}
	
	public static Sound loadSound(String path) throws SlickException{
		return new Sound(path);
		
	}
	public static File loadFile(String path) throws SlickException{
		return new File(path);
		
	}
	
	public static ParticleSystem loadPS(Image image, int maxParticles) throws SlickException{
		return new ParticleSystem(image, maxParticles);
		
	}
	public static ConfigurableEmitter loadConfigurableEmitter(String path, int maxParticles) throws SlickException{
		return new ConfigurableEmitter(path);
		
	}
	
	
	
	
	public static Image getImage(String getter){
		return images.get(getter);
		
	}
	
	public static Image getSpriteImage(String getter,int x, int y){
		return sprites.get(getter).getSubImage(x, y);
		
	}
	public static Image getSprite(String getter){
		return sprites.get(getter);
		
	}
	
	public static Sound getSound(String getter){
		return sounds.get(getter);
		
	}
	
	public static File getFile(String getter){
		return xmlFile.get(getter);
		
	}
	
	public static ParticleSystem getParticleSystem(String getter){
		return particleSystems.get(getter);
		
	}
	
	public static ConfigurableEmitter getConfigurableEmitter(String getter){
		return emitters.get(getter);
		
	}
	
	
	
	
	
}
