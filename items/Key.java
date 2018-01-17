package items;

public class Key extends PregnableItem{

	/**
	 * Create a new Key
	 * @param n represents the name of the key
	 */
	public Key(String n) {
		super(n);
	}

	/**
	 * Display the description of this item
	 */
	public void descriptive() {
		System.out.println("Key, Allow to open a locked door or a locked chest");
	}
	
}
