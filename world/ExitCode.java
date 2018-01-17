package world;


public class ExitCode extends Exit{
	private String code;
	
	/**
	 * ExitCode constructor that set the code and super the name, place and status to Exit
	 * @param n is the name of the exit
	 * @param d is the destination
	 * @param c is the code of the exit
	 * @param s is the status of the exit
	 */
	public ExitCode(String n, Place d, String c, Status s) {
		super(n, d, s);
		this.code = c;
	}
	
	/**
	 * don't open an exit if it is already passable or if it need a code 
	 */
	public void open(){
		if(this.isPassable()){
			System.out.println(this + " already open");
		}
		else{
			System.out.println("Need a code to open " + this);
		}
	}
	
	/**
	 * open an exit with the right code
	 */
	public void open(String s){
		this.status = Status.LOCK; //To prevent that he opens with the right code once
							  		  //and when he try with another wrong code, the door remains
							         //open.
		if(s.contentEquals(this.code)){
			super.open();
		}
		else{
			System.out.println("Wrong code to open " + this + ". Open it with the right code");
		}
	}

}
