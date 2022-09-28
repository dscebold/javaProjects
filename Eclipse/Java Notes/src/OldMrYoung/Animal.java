package OldMrYoung;

public class Animal {
	
	//Attributes
		protected int number;
		protected String sound, type;
		
		//Constructor
		
		
		//Methods
		
		public int getNumber() {
			return number;
		}
		
		public void setNumber(int number) {
			this.number = number;
		}
		
		public String getSound() {
			return sound;
		}
		
		public String getType() {
			return type;
		}
		
		public void runSong() {
			
			if(this.number == 1 && this.type.charAt(this.type.length() - 1) == 's') {
				this.type = this.type.substring(0, this.type.length()-1);
			}
			
			System.out.println("Old Mr. Young has a farm. E-I-E-I-O.");
			System.out.println("And on his farm he has " + this.number + " " + this.type + " E-I-E-I-O.");
			System.out.println("With a " + this.sound + ", " + this.sound + " here.");
			System.out.println("And a " + this.sound + ", " + this.sound + " there.");
			System.out.println("Here a " + this.sound + ", " + this.sound + ".");
			System.out.println("There a " + this.sound + ", " + this.sound + ".");
			System.out.println("Everywhere a " + this.sound + ", " + this.sound + ".");
			System.out.println("Old Mr. Young has a farm. E-I-E-I-O.\n");
			
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}


		}
		
}
