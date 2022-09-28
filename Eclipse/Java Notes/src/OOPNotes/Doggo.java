package OOPNotes;

import java.util.Random;

public class Doggo {
	
	//Attributes
	private Random rand; 
	private String name; 
	private int age, cuteScore;
	private boolean cute; 
	private String[] traits; 
	private String[] dogThings = {"cuddle", "roll", "sit", "bite", "pee on rug", "eat cat poop", "chase tail", "eat carpet", "love you", "finds drugs in the school", "makes viral video", "saves Timmy from the well", "puts a Timmy in the Well", "liberate Medici", "Burn down the orphanage", "invent communism"}; 
	private int[] scores = {1,1,1,-10, -5, -3, 1, -10,2, 5, 10, -5, 20, 10, 30, -10};
	private int[] traitScores= {10, 7, 5, 2, -4}; 
	
	//Constructor
	
	public Doggo(String name) {
		rand = new Random(); 
		this.name = name;
		age = 0; 
		cuteScore = 10; 
		cute = true; 
		setTraits(); 
	}


	
	//Methods

	private void setTraits() {
		this.traits = new String[5];
		this.traits[0] = setColor();
		this.traits[1] = setMood();
		this.traits[2] = setFur();
		this.traits[3] = setBreed(); 
		this.traits[4] = setSmart(); 
		
	}



	private String setSmart() {
		String[] smarts = {"As smart as a human child", "smart", "just ok", "dumb but still cute", "runs at full speed into walls"};
		int i = rand.nextInt(smarts.length);
		this.cuteScore += traitScores[i];
		return smarts[i];
	}



	private String setBreed() {
		String[] breeds = {"collie", "lab", "mutt", "pug", "chihuahau" };
		int i = rand.nextInt(breeds.length);
		if(i == 4) {
			this.cuteScore += -99999999;	
		}
		this.cuteScore += traitScores[i];
		return breeds[i];
	}



	public int getAge() {
		return age;
	}



	public void setAge() {
		this.age++;
		this.cuteScore -= this.age;
	}



	public int getCuteScore() {
		return cuteScore;
	}



	public void setCuteScore(String thing) {
		int index = 0;
		for(int i = 0; i < dogThings.length; i++) {
			if(dogThings[i].equals(thing)) {
				index = i;
				break; 
			}
		}
		this.cuteScore += scores[index];
		setCute(); 
	}



	public boolean isCute() {
		return cute;
	}



	public void setCute() {
		setAge(); 
		if(this.cute && this.cuteScore < -9) {
			this.cute = false; 
			System.err.println(this.name + " has gone to live with grandma.");
		}
	}
	
	public void runDog() {
		while(this.cute) {
			System.out.println(toString());
			String thing = doDogStuff(); 
			setCuteScore(thing); 
		}
	}



	private String doDogStuff() {
		String thing = dogThings[rand.nextInt(dogThings.length)];
		System.out.println(this.name + "just decided to " + thing + ".");
		return thing; 
	}



	private String setFur() {
		String[] furs = {"soft as silk", "fluffy", "too long", "bald", "patchy with skin shreds hanging down"};
		int i = rand.nextInt(furs.length);
		this.cuteScore += traitScores[i];
		return furs[i];
	}



	private String setMood() {
		String[] moods = {"friendly", "playful", "indifferent", "derpy", "hyper aggressive killing machine" };
		int i = rand.nextInt(moods.length);
		this.cuteScore += traitScores[i];
		return moods[i];
	}



	private String setColor() {
		String[] colors = {"gold", "black", "brown", "spotted", "so dirty who can tell? blood... dirt... idk?" };
		int i = rand.nextInt(colors.length);
		this.cuteScore += traitScores[i];
		return colors[i];
	}
	
	@Override
	public String toString() {
		String myTraits = "";
		for(String trait : traits) {
			myTraits += "\n\t" + trait; 
		}
		return this.name + "\n\tAge: " + this.age + "\n\tCuteScore: " + this.cuteScore + myTraits + "\n"; 
	}
	
}
