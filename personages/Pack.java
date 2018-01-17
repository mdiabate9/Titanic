package personages;

import items.Item;

import java.util.HashMap;
import java.util.Map;

public class Pack{
	private Map <String, Item> pack = new HashMap<String, Item>();
	private String name;
	
	/**
	 * Create a new Pack
	 * @param n is the name of the Pack
	 */
	public Pack(String n){
		this.name = n;
	}
	
	/**
	 * Adding an item into the pack
	 * @param i is the item that will be add
	 */
	public void add(Item i){
		this.pack.put(i.getName(), i);
	}
	
	/**
	 * Removing an item from the pack
	 * @param i is the name of the item to be removed
	 */
	public void remove(String name){
		this.pack.remove(name);
	}
	
	/**
	 * Display all the items contained in the pack
	 */
	public void display(){
		System.out.print(this.name + " : ");
		for(String s : this.pack.keySet()){
			System.out.print(s);
			System.out.print(" - ");
		}
		System.out.println();
	}
	
	/**
	 * Get an item from the pack
	 * @param s is the name of the item to get
	 * @return the item corresponding to the given name
	 */
	public Item getItem(String s){
		return this.pack.get(s);
	}

	/**
	 * Return true if the pack has an item with the same name, if not false
	 * @param i is the name of the item 
	 * @return if this name belongs to an item in the pack
	 */
	public boolean hasItem(String i) {
		return (this.pack.get(i) != null);
	}
	
	/**
	 * @return true if the pack is empty, if not false
	 */
	public boolean isEmpty(){
		return this.pack.isEmpty();
	}

}
