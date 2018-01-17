package command;

public enum Command {
	look(new Look()),
	open(new Open()),
	go(new Go()),
	whereami(new WhereAmI()),
	call(new Call()),
	take(new Take()),
	quit(new Quit()),
	level(new Level()),
	use(new Use()),
	inventory(new Inventory()),
	help(new Help());
	

	private Instruction instruction; // instruction launched by a command
	
	/**
	 * Create a new command and
	 * Attach an instruction to the command 
	 * @param i is the instruction joined to the command
	 */
	private Command(Instruction i){
		this.instruction = i;
	}
	
	/**
	 * Getter on the instruction attached to a command 
	 * @return the instruction attached to the command
	 */
	public Instruction getInstruction(){
		return this.instruction;
	}
}

