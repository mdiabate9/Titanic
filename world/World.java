package world;


import items.Item;
import items.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import personages.Personage;


public abstract class World {
	private Place centralPlace;
	private Map<String,Place> places= new HashMap<String,Place>();
	private Map<String,Place> sensitivePlaces= new HashMap<String,Place>();
	
	/**
	 * Word constructor that initialize places, exits, objects and characters
	 */
	public World(){
		this.initializePlaces();
		this.initializeExits();
		this.initializeObjects();
		this.initializeCharacters();
	}
	
	/**
	 * Draw the map of the world
	 */
	public void drawMap(){
		for(String name : this.places.keySet()){
			System.out.print(name + "---->   ");
			this.places.get(name).displayExits();
			System.out.println();
		}
	}
	
	/**
	 * getter on CentralPlace
	 * @return the place where we are going to start
	 */
	public Place getCentralPlace(){
		return this.centralPlace;
	}
	
	/**
	 * Add a place to the world
	 * @param p is the place to be added
	 */
	public void addPlace(Place p){
		p.setWorld(this);
		if(centralPlace == null){
			this.centralPlace = p;
		}
		this.places.put(p.getName(),p);
	}
	
	/**
	 * add  a sensitive place
	 * @param p is the place to be added
	 */
	public void addSensitivePlace(Place p){
		p.setWorld(this);
		if(centralPlace == null){
			this.centralPlace = p;
		}
		this.places.put(p.getName(),p);
		this.sensitivePlaces.put(p.getName(),p);
	}
	
	/**
	 * getter on sensitive places
	 * @return sensitive places of the world
	 */
	public Map<String,Place> getSensitivePlaces(){
		return this.sensitivePlaces;
	}
	
	/**
	 * Remove a place of the world 
	 * @param p is place to be removed
	 */
	public void removePlace(Place p){
		this.places.remove(p);
	}

	/**
	 * Generate an exit in the world
	 * @param destination is the destination place
	 * @param s is the status of the exit
	 * @return the exit
	 */
	public Exit generateExit(Place destination, Status s){
		return new Exit(destination.getName(), destination, s);
	}
	
	/**
	 * Add an exit to the world
	 * @param origin is the the origin place
	 * @param destination is the destination place
	 * @param s is the exit status
	 */
	public void addExit(String origin, String destination, Status s){
		this.places.get(origin).addExit(this.generateExit(this.places.get(destination), s));
	}
	
	/**
	 * Generate a code exit in the world
	 * @param destination is the destination place
	 * @param code is the code of the exit
	 * @param s is the status of the exit
	 * @return the exit
	 */
	public Exit generateExitCode(Place destination, String code, Status s){
		return (new ExitCode(destination.getName(), destination, code, s));
	}
	
	/**
	 * Add a code exit to the world
	 * @param origin is the the origin place
	 * @param destination is the destination place
	 * @param code is the code of the exit
	 * @param s is the exit status
	 */
	public void addExitCode(String origin, String destination, String code, Status s){
		this.places.get(origin).addExit(this.generateExitCode(this.places.get(destination), code, s));
	}
	
	/**
	 * Generate an key exit in the world
	 * @param destination is the destination place
	 * @param k is the key of the exit
	 * @param s is the status of the exit
	 * @return the exit
	 */
	public Exit generateExitKey(Place destination, Key k, Status s){
		return (new ExitKey(destination.getName(), destination, k, s));
	}
	
	/**
	 * Add a key exit to the world
	 * @param origin is the the origin place
	 * @param destination is the destination place
	 * @param k is the key of the exit
	 * @param s is the exit status
	 */
	public void addExitKey(String origin, String destination, Key k, Status s){
		this.places.get(origin).addExit(this.generateExitKey(this.places.get(destination), k, s));
	}
	
	/**
	 * Add item to the world
	 * @param place is the place
	 * @param i is the item to be added
	 */
	public void addObject(String place, Item i){
		this.places.get(place).addObject(i);
	}
	
	/**
	 * Add a character to the world
	 * @param place is the place
	 * @param p is the character
	 */
	public void addCharacter(String place, Personage p){
		this.places.get(place).addCharacter(p);
	}
	
	/**
	 * getter in a random place
	 * @return the random place
	 */
	public Place getRandomPlace(){
		Random rand = new Random();
		Object[] values = this.places.values().toArray();
		Object place = values[rand.nextInt(values.length)];
		return (Place)place;
	}
	
	/**
	 * getter on the place
	 * @param place is the place that we want
	 * @return the place
	 */
	public Place getPlace(String place){
		return this.places.get(place);
	}
	
	
	public abstract void initializePlaces();
	public abstract void initializeExits();
	public abstract void initializeObjects();
	public abstract void initializeCharacters();
	
}
