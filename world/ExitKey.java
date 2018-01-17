package world;

import items.Key;

public class ExitKey extends Exit{
	private Key key;
	
	/**
	 * ExitKey constructor that set the key and super the name, place and status to Exit
	 * @param n is the name of the exit
	 * @param d is the destination
	 * @param k is the key of the exit
	 * @param s is the status of the exit
	 */
	public ExitKey(String n, Place d, Key k, Status s) {
		super(n, d, s);
		this.key = k;
	}
	
	/**
	 * don't open an exit if it is already passable or if it need a key 
	 */
	public void open(){
		if(this.isPassable()){
			System.out.println(this + " already open");
		}
		else{
			System.out.println("Need a key to open " + this);
		}
	}
	
	/**
	 * open an exit with the right key
	 */
	public void open(Key k){
		this.status = Status.LOCK; //To prevent that he opens with the right code once
							  		  //and when he try with another wrong code, the door remains
							 		 //open.
		if(k.equals(this.key)){
			super.open();
		}
		else{
			System.out.println("Wrong key to open " + this + ". Open it with the right key");
		}
	}
}
