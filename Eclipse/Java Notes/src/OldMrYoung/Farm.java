package OldMrYoung;

import java.util.ArrayList;
import java.util.Random;

public class Farm {
	
	//Attributes
	private Random rand;
	private ArrayList<Animal> animals, song;
	
	//Constructor
		public Farm() {
			rand = new Random();
			animals = new ArrayList<>();
			song = new ArrayList<>();
			addAnimals();
			makeSong();
			runSong();
		}
		
		private void runSong() {
			while(this.song.size() > 0) {
				Animal singer = song.remove(this.song.size() - 1); 
						// removes the last animal from the song ArrayList<>
				singer.runSong(); //make the singer sing the song.
			}
		}

		private void makeSong() {
		for( int i = 1 ; 0 < animals.size() ; i ++) {
			int index = rand.nextInt(animals.size()); // a random animal index from remaining animals
			Animal temp = this.animals.remove(index); // Did you know .remove can return the thing it returns
			temp.setNumber(i);
			this.song.add(temp);
		}
		
	}

		//Methods

	private void addAnimals() {
		this.animals.add(new DracoMalfoy());
		this.animals.add(new FloridaMan());
		this.animals.add(new Karen());
		this.animals.add(new Manager());
		this.animals.add(new Markiplier());
		this.animals.add(new Minion());
		this.animals.add(new ScoobyDoo());
		this.animals.add(new Shreck());
		this.animals.add(new Teacher());
		this.animals.add(new TwitterUser());		
	}
}
