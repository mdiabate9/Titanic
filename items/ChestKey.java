package items;

import world.Status;

public class ChestKey extends Chest{
	
	private Key key; // key of the chest 
	
	/**
	 * Build a new ChestCode
	 * @param n is the name of the chest
	 * @param p is the place where the chest will be in
	 * @param k is the key of the ChestCode
	 * @param s represents the status of the chest at his creation(LOCK or OPEN)
	 */
	public ChestKey(String n, Key k, Status s) {
		super(n, s);
		this.key = k;
	}
	
	/**
	 * While trying to open the chest without a key,
	 * this function tell you either the chest is already open,
	 * either you have to enter a key in order to open this Chest
	 */
	public void open(){
		if(this.isOpenable()){
			System.out.println(this + " already open");
		}
		else{
			System.out.println("Need a key to open " + this);
		}
	}
	
	/**
	 * Try to open the chest, depending on the given parameter 
	 * @param k represents the key used to open the chest
	 */
	public void open(Key k){
		this.status = Status.LOCK; // To prevent that he opens with the right code once
							  		  // and when he try with another wrong code, the door remains
							 		 // open.
		if(k.equals(this.key)){
			super.open();
		}
		else{
			System.out.println("Wrong key to open " + this + ". Open it with the right key");
		}
	}

}
