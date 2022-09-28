package OldMrYoung;

public class FloridaMan extends Animal{
	
	//Constructor
	public FloridaMan() {
		this.type = "Florida Men";
		this.sound = "meth";
	}
	
	@Override		//special comment to make sure you are overriding the parent 
	public void runSong() {
		if(this.number == 1) {
			this.type = "Florida Man";
		}	
		super.runSong(); // calls the parent class version of this method
	}
}
