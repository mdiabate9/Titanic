package world;

import personages.Personage;
import personages.NeedyCharacter;
import personages.Fiancee;
import items.ChestKey;
import items.CodeHologram;
import items.Item;
import items.Key;
import items.Chest;
import items.Fins;
import items.TeleportationCage;
import items.RescueBoat;
import items.SafetyJacket;
import items.WaterAspirator;


public class Boat extends World{
	private double waterOffset = 0.01;
	private double waterLevel = 0;
	
	/**
	 * getter on the water level
	 * @return the water level in the boat
	 */
	public double getWaterLevel(){
		return this.waterLevel;
	}
	
	/**
	 * getter on the waterOffset
	 * @return the waterOffset of the game
	 */
	public double getWaterOffset(){
		return this.waterOffset;
	}
	
	/**
	 * setter on the waterOffset
	 * @param a is the new waterOffset that we want
	 */
	public void setWateroffset(double a){
		this.waterOffset = a;
	}
	
	/**
	 * decrease the water level in the boat
	 */
	public void decreaseWaterLevel(){
		this.waterLevel = this.waterLevel - (this.waterOffset*10.0);
		if (this.waterLevel < 0.0) {
			this.waterLevel = 0.0;
		}	
	}
	
	/**
	 * increase the water level in the boat
	 */
	public void increaseWaterLevel(){
		this.waterLevel += this.waterOffset;
	}
	
	/**
	 * Initialize all places of the boat
	 */
	public void initializePlaces(){
		//Creating the rooms
				Place office = new Place("office");
				Place kitchen = new Place("kitchen");
				Place hall1 = new Place("hall1");
				Place hall2 = new Place("hall2");
				Place hall3 = new Place("hall3");
				Place livingroom = new Place("livingroom");
				Place wc1 = new Place("wc1");
				Place wc2 = new Place("wc2");
				Place wc3 = new Place("wc3");
				Place wc4 = new Place("wc4");
				Place bedroom1 = new Place("bedroom1");
				Place bedroom2 = new Place("bedroom2");
				Place restaurant = new Place("restaurant");
				Place front = new Place("front");
				Place back = new Place("back");
				Place emergency1 = new Place("emergency1");
				Place emergency2 = new Place("emergency2");
				Place emergency3 = new Place("emergency3");
				Place emergency4 = new Place("emergency4");
				
				//Adding the centralRoom
				this.addPlace(office);
				
				//Adding all the rooms to the boat
				this.addPlace(kitchen);
				this.addPlace(hall1);
				this.addPlace(hall2);
				this.addPlace(hall3);
				this.addPlace(livingroom);
				this.addPlace(wc1);
				this.addPlace(wc2);
				this.addPlace(wc3);
				this.addPlace(wc4);
				this.addPlace(bedroom1);
				this.addPlace(bedroom2);
				this.addPlace(restaurant);
				this.addPlace(front);
				this.addPlace(back);
				this.addSensitivePlace(emergency1);
				this.addSensitivePlace(emergency2);
				this.addSensitivePlace(emergency3);
				this.addSensitivePlace(emergency4);
	}
	
	/**
	 * Initialize all exits of the boat
	 */
	public void initializeExits(){
				//add exits to office
				Item c = new CodeHologram("CODEhall1", "rictus7");
				addObject("office",c);
				this.addExitCode("office", "hall1", ((CodeHologram)c).getPassword(), Status.LOCK);
				Key k = new Key("KEYwc3"); 
				this.addObject("office", k); 
				this.addExitKey("office", "wc3", k, Status.LOCK);
				
				//Add the exits to kitchen
				this.addExit("kitchen", "livingroom", Status.OPEN);
				Key k2 = new Key("KEYhall3");
				this.addObject("kitchen", k2);
				this.addExitKey("kitchen", "hall3", k2, Status.LOCK);
				
				//Add the exits to hall1
				Item c2 = new CodeHologram("CODEemergency1", "abcd");
				this.addObject("hall1", c2);
				this.addExitCode("hall1", "emergency1", ((CodeHologram)c2).getPassword(), Status.LOCK);
				Key k3 = new Key("KEYemergency2");
				this.addObject("hall1", k3);
				this.addExitKey("hall1", "emergency2", k3, Status.LOCK);
				this.addExit("hall1", "office", Status.OPEN);
				this.addExit("hall1", "bedroom1", Status.OPEN);
				this.addExit("hall1", "hall2", Status.OPEN);
				this.addExit("hall1", "livingroom", Status.OPEN);
				this.addExit("hall1", "restaurant", Status.OPEN);
				
				//Add chest into hall1 with Front Key
				Key key6 = new Key("KEYfront");
				Key key5 = new Key("KEYchest");
				this.addObject("hall1", key5);
				Chest chesthall1 = new ChestKey("chest", key5, Status.LOCK);
				chesthall1.addItemIntoChest(key6);
				this.addObject("hall1", chesthall1);
				
				
				//Add the exits to hall2
				this.addExit("hall2", "restaurant", Status.OPEN);
				this.addExit("hall2", "hall1", Status.OPEN);
				this.addExit("hall2", "hall3", Status.OPEN);
				this.addExit("hall2", "bedroom1", Status.OPEN);
				this.addExit("hall2", "bedroom2", Status.OPEN);

				//Add the exits to hall3
				this.addExitKey("hall3", "front", key6, Status.LOCK);
				Item c3 = new CodeHologram("CODEemergency3", "abcd");
				this.addObject("hall3", c3);
				this.addExitCode("hall3", "emergency3", ((CodeHologram)c3).getPassword(), Status.LOCK);
				Key k4 = new Key("KEYemergency4");
				this.addObject("hall3", k4);
				this.addExitKey("hall3", "emergency4", k4, Status.LOCK);
				this.addExit("hall3", "kitchen", Status.OPEN);
				this.addExit("hall3", "back" , Status.OPEN);
				
				this.addExit("hall3", "bedroom2", Status.OPEN);
				this.addExit("hall3", "hall2", Status.OPEN);
				
				//Add the exits to livingroom
				this.addExit("livingroom", "hall1" , Status.OPEN);
				this.addExit("livingroom", "kitchen", Status.OPEN);		
				
				//Add the exits to wc1
				this.addExit("wc1", "bedroom1", Status.OPEN);
				
				//Add the exits to wc2
				this.addExit("wc2", "bedroom2", Status.OPEN);

				//Add the exits to wc3
				this.addExit("wc3", "office", Status.OPEN);
				
				//Add the exits to wc4
				this.addExit("wc4", "restaurant", Status.OPEN);
				
				//Add the exits to bedroom1
				this.addExit("bedroom1", "hall1", Status.OPEN);
				this.addExit("bedroom1", "wc1", Status.OPEN);
				this.addExit("bedroom1", "hall2", Status.OPEN);
						
				//Add the exits to bedroom2
				this.addExit("bedroom2", "hall3", Status.OPEN);
				this.addExit("bedroom2", "wc2", Status.OPEN);
				this.addExit("bedroom2", "hall2", Status.OPEN);
				
				//Add the exits to restaurant
				this.addExit("bedroom2", "hall1", Status.OPEN);
				this.addExit("restaurant", "wc4", Status.OPEN);
				this.addExit("restaurant", "hall2", Status.OPEN);
				
				//Add the exit to front
				this.addExit("front", "hall3", Status.OPEN); 
				
				//Add the exit to back
				this.addExit("back", "hall3", Status.OPEN);
				
				//Add the exit to emergency1
				this.addExit("emergency1", "hall1", Status.OPEN);
				
				//Add the exit to emergency2
				this.addExit("emergency2","hall1", Status.OPEN);
				
				//Add the exit to emergency3
				this.addExit("emergency3", "hall3", Status.OPEN);
				
				//Add the exit to emergency4
				this.addExit("emergency4", "hall3", Status.OPEN);
	}
	
	/**
	 * Initialize all items of the boat
	 */
	public void initializeObjects(){
		
		/**********************************/
		/*Putting Teleportation Cages     */
		/**********************************/
		TeleportationCage t = new TeleportationCage();
		this.addObject("office",t);
		TeleportationCage t2 = new TeleportationCage();
		this.addObject("back",t2);
		TeleportationCage t3 = new TeleportationCage();
		this.addObject("front",t3);
		
		/***********************************************/
		/*Putting rescueBoats into the emergency rooms */
		/***********************************************/
		RescueBoat r1 = new RescueBoat();
		RescueBoat r2 = new RescueBoat();
		RescueBoat r3 = new RescueBoat();
		RescueBoat r4 = new RescueBoat();
		this.addObject("emergency1", r1);
		this.addObject("emergency2", r2);
		this.addObject("emergency3", r3);
		this.addObject("emergency4", r4);
		
		/**********************************/
		/*Putting WaterAspirators         */
		/**********************************/
		WaterAspirator w = new WaterAspirator();
		this.addObject("restaurant", w);
		WaterAspirator w2 = new WaterAspirator();
		this.addObject("kitchen", w2);
		WaterAspirator w3 = new WaterAspirator();
		this.addObject("back", w3);
		
		/**********************************/
		/*Putting Fins into Living room   */
		/**********************************/
		Fins f = new Fins();
		this.addObject("livingroom",f);
		
		/**********************************/
		/*Putting SafetyJacket into hall2 */
		/**********************************/
		SafetyJacket s = new SafetyJacket();
		this.addObject("hall2", s);
		
		/**********************************/
		/*Putting items into BedR1 & BedR2*/
		/**********************************/
		Key key7 = new Key("KEYchest1");
		this.addObject("bedroom1", key7);
		Chest chestWC1 = new ChestKey("chest1", key7, Status.LOCK);
		this.addObject("bedroom1", chestWC1);
		Key key8 = new Key("KEYchest2");
		this.addObject("bedroom2", key8);
		Chest chestWC2 = new ChestKey("chest2", key8, Status.LOCK);
		this.addObject("bedroom2", chestWC2);

	}
	
	/**
	 * Initialize fiancee and needy characters
	 */
	public void initializeCharacters(){
		Personage ch = new Fiancee(this.getPlace("front"));
		this.addCharacter("front", ch);	
		
		Personage ch2 = new NeedyCharacter("Daniel",this.getPlace("livingroom"));
		this.addCharacter("livingroom", ch2);	
		
		Personage ch3 = new NeedyCharacter("Jean",this.getPlace("hall3"));
		this.addCharacter("hall3", ch3);
		
		Personage ch4 = new NeedyCharacter("Samuel",this.getPlace("wc3"));
		this.addCharacter("wc3", ch4);
		
		Personage ch5 = new NeedyCharacter("Sylvie",this.getPlace("restaurant"));
		this.addCharacter("restaurant", ch5);
		
		Personage ch6 = new NeedyCharacter("Gilles",this.getPlace("hall2"));
		this.addCharacter("hall2", ch6);
		
		Personage ch7 = new NeedyCharacter("Antoine",this.getPlace("back"));
		this.addCharacter("back", ch7);
		
		Personage ch8 = new NeedyCharacter("Pascal",this.getPlace("kitchen"));
		this.addCharacter("kitchen", ch8);
		
		
	}

}

