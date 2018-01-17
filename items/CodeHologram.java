package items;

import personages.Hero;
import interfaces.Usable;

public class CodeHologram extends PregnableItem implements Usable{

	private String code;  // Represents the code which is inside this item
	
	/**
	 * Create a new CodeHologram
	 * @param n The name of the created item
	 * @param code the code that will be put into the item
	 */
	public CodeHologram(String n, String code) {
		super(n);
		this.code = code;
	}

	/**
	 * Display a descriptive of this item
	 */
	public void descriptive() {
		System.out.println("Contains a password");
	}

	/**
	 * Usage of this item made by the hero.
	 * Display the code contained into the Hologram 
	 * only if the hero own the hologram in his backPack
	 */
	public void use(Hero h) {
		if(h.getBackPack().hasItem(this.getName())){
			System.out.println("Hologram display : " + this.code);
		}
		else{
			System.out.println("You don't own " + this +" Take it first, before using it");
		}
	}
	
	/**
	 * Getter on the code of the hologram
	 * @return the code contained in the Hologram 
	 */
	public String getPassword(){
		return this.code;
	}

}
