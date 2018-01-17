package personages;

import world.Place;

public class NeedyCharacter extends SecondaryCharacters{

	/**
	 * NeedyCharacter constructor that super the name and the place to SecondaryCharacters
	 * @param name is the personage
	 * @param p is the place where he will be created
	 */
	public NeedyCharacter(String name, Place p) {
		super(name, p);
	}
	
	/**
	 * Description of the needy character
	 */
	public void descriptive(){
		System.out.println("Needy character looking for help");
	}
}
