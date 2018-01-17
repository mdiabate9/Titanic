package items;

public class RescueBoat extends UmpregnableItem{
	
	/**
	 * Build a new RecueBoat
	 */
	public RescueBoat() {
		super("rescueBoat");
	}
	
	/**
	 * Display a description of the item
	 */
	public void descriptive(){
		System.out.println("Will be automatically used to escape once you will be here with your fiancee ");
	}
	
}
