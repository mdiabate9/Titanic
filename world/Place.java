package world;
import items.Item;

import java.util.HashMap;
import java.util.Map;

import personages.CharacterSet;
import personages.Pack;
import personages.Personage;



public class Place {
	
	private String name;
	private Map<String,Exit> exits = new HashMap<String,Exit>();
	private Pack items = new Pack("Items");
	private CharacterSet characters = new CharacterSet("Characters");
	private World world;
	
	/**
	 * Place constructor that set a name
	 * @param n is the name of the place
	 */
	public Place(String n) {
		this.name = n;
	}
	
	/**
	 * Set the name of the place into its own name while displaying it
	 */
	public String toString() {
		return(this.name);
	}	

	/**
	 * getter on the name
	 * @return the name of the place
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Add an exit to the place
	 * @param e is exit that must be added
	 */
	public void addExit(Exit e) {
		this.exits.put(e.getName(), e);
	}
	
	/**
	 * Display all the reachable rooms
	 */
	public void displayExits() {
		String exits = "";
		if(this.exits.isEmpty()){
			exits = "No reachable rooms here";
		}
		else{
			exits = exits.concat("Reachable rooms : ");
			for(String e : this.exits.keySet()) {
				exits = exits.concat(e + " -| ");
			}
		}
		System.out.println(exits);
	}
	
	/**
	 * getter on the exit
	 * @param e is the name of the exit
	 * @return the exit
	 */
	public Exit getExit(String e) {
		return this.exits.get(e);
	}
	
	/**
	 * Check if the place has this exit
	 * @param e the name the exit
	 * @return a is the boolean that says if the place has this exit 
	 */
	public boolean hasExit(String e) {
		if (this.exits.get(e) != null) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * setter on the world
	 * @param w is the world
	 */
	public void setWorld(World w){
		this.world = w;
	}
	
	/**
	 * getter on the world
	 * @return the world
	 */
	public World getWorld(){
		return this.world;
	}
	
	/**
	 * Add an item the place
	 * @param i is the item
	 */
	public void addObject(Item i){
		this.items.add(i);
	}
	
	/**
	 * getter on the item
	 * @param name is the name pof the item
	 * @return the item 
	 */
	public Item getObject(String name){
		return this.items.getItem(name);
	}
	
	/**
	 * Remove the item from the place
	 * @param key is the name of the item to be removed 
	 */
	public void removeObject(String key){
		this.items.remove(key);
	}
	
	/**
	 * Check if the place has the item
	 * @param i is the item
	 * @return a boolean that says if the place has the item
	 */
	public boolean hasObject(String i){
		return this.items.hasItem(i);
	}
	
	/**
	 * getter on CharacterSet
	 * @return characters that are in the place
	 */
	public CharacterSet getCharacters(){
		return this.characters;
	}
	
	/**
	 * Add character to the place
	 * @param c is the character that must be added
	 */
	public void addCharacter(Personage c){
		this.characters.addCharacter(c);
	}
	
	/**
	 * Display the exits, objects and characters of the palce
	 */
	public void display(){
		System.out.print("\t");this.displayExits();  // displaying the Exits of the Room
		System.out.println();
		System.out.print("\t\t");this.items.display(); // displaying the Objects of the Room
		System.out.println();
		System.out.print("\t\t\t");this.characters.display(); // display the avalaible characters in the Room
	}

	/**
	 * getter on the exits
	 * @return the exits of the place
	 */
	public Map<String,Exit> getExits() {
		return this.exits;
	}

}

