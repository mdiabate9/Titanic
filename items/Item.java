package items;

import interfaces.Describable;

public abstract class Item implements Describable{
	
	private String name; // name of the item
	
	/**
	 * Item Constructor to set the name of the item
	 * @param n the name of the item
	 */
	public Item(String n){
		this.name = n;
	}
	
	/**
	 * Set the name of the item into its own name while displaying it
	 */
	public String toString(){
		return(this.name);
	}
	
	/**
	 * Getter on the name of the item
	 * @return the name of the item
	 */
	public String getName(){
		return this.name;
	}
}
