package items;

import world.Status;

public class ChestCode extends Chest{
	
	private String code;  // security code of the Chest
	
	/**
	 * Build a new ChestCode
	 * @param n is the name of the chest
	 * @param p is the place where the chest will be in
	 * @param code is the secured code of the ChestCode
	 * @param s represents the status of the chest at his creation(LOCK or OPEN)
	 */
	public ChestCode(String n, String code, Status s) {
		super(n,s);
		this.code = code;
	}
	
	/**
	 * While trying to open the chest without a secured code,
	 * this function tell you either the chest is already open,
	 * either you have to enter a code in order to open this Chest
	 */
	public void open(){
		if(this.isOpenable()){
			System.out.println(this + " already open");
		}
		else{
			System.out.println("Need a code to open " + this);
		}
	}
	
	/**
	 * Try to open the chest, depending on the given parameter 
	 * @param s represents the code used to open the chest
	 */
	public void open(String s){
		this.status = Status.LOCK; // To prevent that he opens with the right code once
							  		  // and when he try with another wrong code, the chest remains
							         // open.
		if(s.contentEquals(this.code)){
			super.open();
		}
		else{
			System.out.println("Wrong code to open " + this + ". Open it with the right code");
		}
	}

}
