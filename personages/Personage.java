package personages;

import interfaces.Describable;
import world.Exit;
import world.Place;

public abstract class Personage implements Describable{
	
	protected Place position;
	protected String name;
	
	/**
	 * Create a personage with a name and a place
	 * @param name is personage name
	 * @param p is the place where he will be created
	 */
	public Personage(String name, Place p) {
		this.name = name;
		this.position = p;
	}
	
	/**
	 * Display the name of the personage
	 */
	public String toString() {
		return(this.name);
	}

	/**
	 * Go to a new room followed by the team
	 * @param e is the exit used to go to the new room
	 */
	public void goTo(Exit e) {
		if (this.position.hasExit(e.getName())) {
			if (e.isPassable()) {
				this.position = e.getDestination();
				if (this instanceof Hero) {
					System.out.println("You are now in the " + e.getDestination());
				}
			}else {
				if (this instanceof Hero) {
					System.out.println(e + " is closed");
				}
			}
		}
		else {
			System.out.println(e + " is not a neighbour room of " + this.position);
		}
	}
	
	/**
	 * getter on the position
	 * @return the position of the personage
	 */
	public Place getPosition() {
		return position;
	}
	
	/**
	 * getter on the name
	 * @return the position of the name
	 */
	public String getName() {
		return this.name;
	}
	
}
