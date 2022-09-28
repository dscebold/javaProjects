package OOPNotes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DiseaseRunner {

	public static void printPops() {
		System.out.println("Infected Population: " + Animal.infectedPopulation);
		System.out.println("Healthy Population: " + (Animal.population - Animal.infectedPopulation));
		System.out.println("Total Population: " + Animal.population + "\n");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		ArrayList<Animal> animals = new ArrayList<>();

		// set up environment

		while (true) {
			try {
				System.out.println("How many animsls should b in this environment?");
				int pop = Integer.parseInt(scan.nextLine());

				System.out.println("Out of every 100, how many animals are infected?");
				int numInfected = Math.abs(Integer.parseInt(scan.nextLine()) % 100);

				for (int i = 0; i < pop; i++) {
					if (rand.nextInt(101) > numInfected) {
						animals.add(new Animal(false));
					} else {
						animals.add(new Animal(true));
					}
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("You must type a number.");
			}
		}
		printPops();
		
		// run the simulation
		
		while(Animal.population > 0) {
			for(int i = 0, startPop = animals.size(); i < animals.size() && i < startPop; i++ ) {
				Animal current = animals.get(i); // current animals in order in the ArrayList
				Animal randAnimal = animals.get(rand.nextInt(animals.size())); //A random animal
				if(current.isAlive() && randAnimal.isAlive()) {
					Animal baby = current.animalLife(randAnimal);
					if(baby != null) {
						animals.add(baby);
					}
					if(current.isAlive() == false) {
						animals.remove(current);
						i--;
					}
				}
			} // for
			printPops();
		} // while
		scan.close();
	} // main
}// class
