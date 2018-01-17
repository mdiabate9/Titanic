package personages;

import world.Exit;
import world.Place;
import world.World;

import items.*;
import command.Instruction;


public class Hero extends MainCharacters{

	private final float size = 2; 
	private Pack backPack = new Pack("backPack");
	private Pack outfit = new Pack("outfit");
	private CharacterSet team = new CharacterSet("team");
	
	/**
	 * create the hero in a place
	 * @param p is the place where the hero is made
	 */
	public Hero(Place p){
		super("Leonardo", p);
	}
	
	/**
	 * getter on the world
	 * @return the world where we are currently 
	 */
	public World getWorld(){
		return this.getPosition().getWorld();
	}
	
	/**
	 * Check if the place has neighbours
	 * @param e is the exit which we want to know if it exists
	 * @return the boolean that tell if place has neighbours
	 */
	public boolean hasNeighbour(String e){
		return(this.getPosition().hasExit(e));
	}
	
	/**
	 * getter on the exit
	 * @param e is the neighbour exit
	 * @return the exit
	 */
	public Exit getNeighbourExit(String e){
		return this.position.getExit(e);
	}
	
	/**
	 * take a pregnable item by adding it to the backpack and deleting it to the current room
	 * @param i is the item that must been taken
	 */
	public void take(PregnableItem i){
		this.backPack.add((PregnableItem)i); //adding this item into the backpack
		this.getPosition().removeObject(i.getName()); //deleting this item from the current room
		System.out.println(i + " added to the backpack");
	}
	
	/**
	 * getter on the siwze
	 * @return the size of the hero
	 */
	public float getSize(){
		return this.size;
	}
	
	/**
	 * execute the instruction by the hero
	 * @param f is the instruction that must be executed
	 * @param tab represents the sentence entered by the player
	 */
	public void execute(Instruction f, String[] tab){
		f.instructionManager(this, tab);
	}

	/**
	 * getter on the backPack
	 * @return the backPack of the hero
	 */
	public Pack getBackPack() {
		return backPack;
	}

	/**
	 * getter on the outfit
	 * @return the outfit of the hero
	 */
	public Pack getOutfit() {
		return outfit;
	}
	
	/**
	 * getter on the character collection which is the team of the hero
	 * @return the team of the hero
	 */
	public CharacterSet getTeam(){
		return this.team;
	}
	
	/**
	 * Check if the room has an object
	 * @param s is the the name of the object
	 * @return the boolean that say if the room has an object
	 */
	public boolean hasObjectInRoom(String s){
		return this.getPosition().hasObject(s);
	}
	
	/**
	 * getter on the room item
	 * @param s is the the name of the object
	 * @return the item in the room
	 */
	public Item getObjectInRoom(String s){
		return this.getPosition().getObject(s);
	}
	
	/**
	 * Check if the backpack has an object
	 * @param s is the the name of the object
	 * @return the boolean that say if the backpack has an object
	 */
	public boolean hasObjectInBackPack(String s){
		return this.backPack.hasItem(s);
	}
	
	 /** getter on the backpack item
	 * @param s is the the name of the object
	 * @return the item in the backpack
	 */
	public Item getObjectInBackPack(String s){
		return this.backPack.getItem(s);
	}
	
	/**
	 * Check if the outfit has an object
	 * @param s is the the name of the object
	 * @return the boolean that say if the outfit has an object
	 */
	public boolean hasObjectInOutfit(String s){
		return this.outfit.hasItem(s);
	}
	
	 /** getter on the outfit item
	 * @param s is the the name of the object
	 * @return the item in the outfit
	 */
	public Item getObjectInOutfit(String s){
		return this.outfit.getItem(s);
	}
	
	public void addObjectInBackPack(Item i) {
		this.backPack.add(i);
	}
	
	/**
	 * Take the hero to a new random position
	 */
	public void RandomTeleportation(){
		this.position = this.position.getWorld().getRandomPlace();
	}

	/**
	 * description of the hero
	 */
	public void descriptive() {
		System.out.println("Leonardo, the hero");
	}
	
	/**
	 * Check if there is a character in the room
	 * @param ch is the name of the character
	 * @return a boolean that says if the character is in the room
	 */
	public boolean hasCharacterInRoom(String ch){
		return this.getPosition().getCharacters().hasCharacter(ch);
	}
	
	/**
	 * Check if there is a character in the team
	 * @param ch is the name of the character
	 * @return a boolean that says if the character is in the team
	 */
	public boolean hasCharacterInTeam(String ch) {
		return this.team.hasCharacter(ch);
	}
	
	/**
	 * Check if fiancee is in the team
	 * @returna boolean that says if fiancee is in the team
	 */
	public boolean hasFianceeInTeam() {
		return this.team.hasFiancee();
	}
	
	/**
	 * getter on personage
	 * @param ch is the name of the personage
	 * @return the personage in the room
	 */
	public Personage getCharacterInRoom(String ch){
		return this.getPosition().getCharacters().getCharacter(ch);
	}
	
	/**
	 * getter on personage
	 * @param ch is the name of the personage
	 * @return the personage in the team
	 */
	public Personage getCharacterInTeam(String ch){
		return this.team.getCharacter(ch);
	}
	
	/**
	 * remove the personage in the room
	 * @param ch is the personage that must be removed
	 */
	public void removeCharacterInRoom(String ch){
		this.getPosition().getCharacters().removeCharacter(ch);		
	}
	
	/**
	 * add a personage to the team
	 * @param ch is the personage that must be added 
	 */
	public void addCharacterInTeam(Personage ch){
		this.team.addCharacter(ch);
	}
	
	
	
}
