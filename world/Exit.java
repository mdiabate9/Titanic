package world;

import interfaces.Openable;

public class Exit implements Openable{
					   //=======================//
					  //=======ATTRIBUTS=======//
					 //=======================//
	
	private String name;
	private Place destination;
	protected Status status;	
	
				   //=========================//
				  //=======CONSTRUCTOR=======//
				 //=========================//
	
	/**
	 * Constructor Exit() initialize a locked exit
	 * @param n is the name of the exit
	 * @param d is the destination
	 * @param s is the status of the exit
	 */
	public Exit(String n, Place d, Status s) {
		this.name = n;
		this.destination = d;
		this.status = s;
	}
	
	
			    //===============================//
			   //=======REDEFINED METHODS=======//
			  //===============================//
	
	/**
	 * Set the name of the exit into its own name while displaying it
	 */
	public String toString() {
		return (this.name);
	}
	
	/**
	 * open a normal exit if it is not passable
	 */
	public void open(){
		if(!this.isPassable()){
			this.status = Status.OPEN;
			System.out.println("Opening " + this);
			System.out.println(this + " open");
		}
		else{
			System.out.println(this + " already open");
		}
	}
		
			  //================================//
			 //===========OWN METHODS==========//
		    //================================//
	
	/**
	 * Check if it is passable
	 * @return a boolean that says if it is passable
	 */
	public boolean isPassable() {
		return (this.status == Status.OPEN);
	}
	
	
	/**
	 * getter on the name of the exit
	 * @return
	 */
	public String getName() {
		return (this.name);
	}
	
	
	/**
	 * getter on the destination
	 * @return
	 */
	public Place getDestination() {
		return destination;
	}

		
}
