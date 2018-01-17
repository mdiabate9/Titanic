package items;

import java.util.HashSet;
import java.util.Set;

import personages.Hero;
import world.Status;
import interfaces.Openable;
import interfaces.Usable;

public class Chest extends UmpregnableItem implements Openable, Usable{

	protected Status status; // Status of the chest (LOCK or CLOSE)
	private Set<Item> itemsList = new HashSet<Item>();  // Items that are in the chest
	
	/**
	 * Build a new Chest 
	 * @param n is the name of the chest
	 * @param p is the place where the chest will be in
	 * @param s represents the status of the chest at his creation(LOCK or OPEN)
	 */
	public Chest(String n, Status s) {
		super(n);
		this.status = s;
	}
	
	/**
	 * Display the name of the chest
	 */
	public String toString(){
		return this.getName();
	}

	/**
	 *Display the description of the chest
	 */
	public void descriptive() {
		System.out.println("Chest, may contains some items. You can use it");
	}
	
	/**
	 * Tell if the status of chest equals OPEN  
	 * @return a boolean: true if the chest is open if not, false
	 */
	public boolean isOpenable(){
		return (this.status == Status.OPEN);
	}
	
	/**
	 * Open a chest. change its status to OPEN.
	 */
	public void open(){
		if(!this.isOpenable()){
			this.status = Status.OPEN;
			System.out.println("Opening " + this);
			System.out.println(this + " open");
		}
		else{
			System.out.println("Chest already open");
		}
	}
	
	/**
	 * Add an item inside the chest
	 * @param i is the item added to the chest
	 */
	public void addItemIntoChest(Item i){
		this.itemsList.add(i);
	}
	
	/**
	 * Add all the items of the chest inside the current room
	 * (the room where the chest is in)
	 * @param h is the hero. his position will be used as a reference 
	 * for the place we will add items
	 */
	public void addItemsIntoRoom(Hero h){
		for(Item i : this.itemsList){
			h.getPosition().addObject(i);
		}
	}
	
	/**
	 * Usage of the chest made by the hero
	 * If the conditions are met(if the chest is open and contains some items),
	 * put all the items which are inside the chest,
	 * into the current room and destroy the chest from the room
	 */
	public void use(Hero h) {
		if(this.isOpenable()){ 
			if(this.itemsList.isEmpty()){      // if there is no item inside the chest. We add nothing to the current room
				System.out.println("No items in " + this + ". No luck !");
			}
			else{                             // if not, we add all the items to the room and remove the chest from this room
				this.addItemsIntoRoom(h);     
				System.out.println(this.itemsList.size() + " items finded in " + this);
				System.out.println(this.itemsList + " now avalaible in the room");
			}
			h.getPosition().removeObject(this.getName());
			System.out.println(this + " throwed in the sea");
		}
		else{
			System.out.println("Open " + this + " before using it");
		}
	}

	/**
	 * getter of items
	 * @return the list of items in the chest
	 */
	public Set<Item> getItems() {
		return this.itemsList;
	}

	/**
	 * getter of the status
	 * @return the status of the chest
	 */
	public Status getStatus() {
		return this.status;
	}


}
