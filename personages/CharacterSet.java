package personages;

import java.util.HashMap;
import java.util.Map;


import world.Exit;


public class CharacterSet {
	
	private Map<String,Personage> team = new HashMap<String,Personage>();
	private String name;
	
	/**
	 * Creating a new CharacterSet
	 * @param n is the name of the CharacterSet 
	 */
	public CharacterSet(String n){
		this.name = n;
	}
	
	/**
	 * Add character to the character set
	 * @param c is the character to add
	 */
	public void addCharacter(Personage c) {
		this.team.put(c.getName(), c);
	}
	
	/**
	 * Remove a character from the character set
	 * @param ch is the character to remove
	 */
	public void removeCharacter(String ch) {
		this.team.remove(ch);
	}
	
	/**
	 * Return true if there is a character corresponding to the given name
	 * in the character set, if not false.
	 * @param ch is the name of the character tested
	 * @return the membership of a character with the same given name
	 */
	public boolean hasCharacter(String ch){
		return this.team.containsKey(ch);
	}
	
	/**
	 * @return true if the Fiance is in this character Set, if not false
	 */
	public boolean hasFiancee(){
		boolean bool = false;
		for(Personage a : this.team.values()){
			if (a instanceof Fiancee) bool = true;
		}
		return bool;
	}
	
	/**
	 * get a character from the character set
	 * @param name the name of the character to get
	 * @return the character corresponding to the named entered 
	 */
	public Personage getCharacter(String name){
		return this.team.get(name);
	}
	
	/**
	 * Display all the charactter set
	 */
	public void display(){
		String charac;
		charac = this.name + " : ";
		if(this.team.isEmpty()){
			charac = charac.concat("none");
		}
		else{
			for(String o : this.team.keySet()) {
				charac = charac.concat(o + " -| ");
			}
		}
		System.out.println(charac);
	}
	
	/**
	 * cross all the character set through an exit
	 * @param e is the exit that the character set will cross
	 */
	public void moveAllTo(Exit e) {
		for(Personage c : this.team.values()) {
			c.goTo(e);
		}
	}
	
	/**
	 * Determine the number of characters in the team
	 * @return the character number
	 */
	public int numberOfCharacters(){
		return this.team.size();
	}
	
}
