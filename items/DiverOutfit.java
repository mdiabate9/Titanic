package items;

import personages.Hero;
import interfaces.Usable;

public abstract class DiverOutfit extends PregnableItem implements Usable{

	/**
	 * DiverOutfit Constructor to set the name of the outfit
	 * @param n is the name given to the outfit
	 */
	public DiverOutfit(String n) {
		super(n);
	}
	
	/**
	 * Usage made for this item by the hero.
	 * If all the condition are met(the item must be in the hero's backPack), 
	 * the current item is deleted from the hero's backPack 
	 * and added to his outfit 
	 */
	public void use(Hero h) {
		if(h.getBackPack().hasItem(this.getName())){ // if the item is in the hero's backPack
			h.getOutfit().add(this);                // Adding it to the hero's outfit
			h.getBackPack().remove(this.getName());		   // Removing it from the hero's backPack
			System.out.println(this + " used ");
		}
		else{
			System.out.println("You don't own " + this +" Take it first, before using it");
		}
	}
	

}
