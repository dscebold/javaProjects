package Biome;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BiomeRunner {
	
	public static void printPops(int plants) {
		System.out.println("Predators: " + Predator.predatorPopulation);
		System.out.println("Prey: " + Prey.preyPopulation);
		System.out.println("_____________________________");
		System.out.println("Total: " + Animal.population);
		System.out.println("Plants: " + plants + "\n");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		//Tools
		
		ArrayList<Animal> biome = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		//Setup our Populations
		
		int pop, plants, predPop;
		String[] responses = {"please type only numbers.", "I said please, just do it." , "Ok, I'm giving you one more chance", "Listen here you little sh*t", "You mother f*cker", "Ok, Ok, just type a number.", "Why do I even f*cking try.", "Alright, please just leave, get the f*ck out of here.", "Why the f*ck are you still here?", };
		int index = 0;
		while(true) {
			try {
				System.out.println("How many animals should be in the biome?");	
				pop = Integer.parseInt(scan.nextLine());
				
				System.out.println("How many plants?");
				plants = Integer.parseInt(scan.nextLine());
				
				System.out.println("How many predators out of 100?");
				predPop = Math.abs(Integer.parseInt(scan.nextLine()) % 100);
				
				break;
			}
			catch(NumberFormatException e) {
				System.out.println(responses[index]);
				index++;
			}
		}
		
		for(int i = 0 ; i < pop ; i ++ ) {
			if(rand.nextInt(101) < predPop) {
				biome.add(new Predator());
			}
			else {
				biome.add(new Prey());
			}
		}
		printPops(plants);
		
		//Run the simulation
		while(Predator.predatorPopulation > 0 && Prey.preyPopulation > 0 && plants > 0) {
			for(int i = 0, curPop = biome.size(); i < biome.size() && i < curPop; i++ ) {
				Animal current = biome.get(i); // next Animal in order
				Animal randAnimal = biome.get(rand.nextInt(biome.size()));
				
				//feeding prey
				int food = 0;
				if(current instanceof Prey) {
					food = rand.nextInt(51);
					if(food > plants) {
						food = 0;
					}
					else {
						plants -= food;
					}
				}
				//Add any babbies that are born
				Animal baby = current.life(randAnimal, food);
				if(baby != null) {
					biome.add(baby);
				}
				//remove dead animals (Carrion clean up (bugs)
				if(!(current.isAlive())) {
					biome.remove(current);
				}
				if(!(randAnimal.isAlive())) {
					biome.remove(randAnimal);
				}
				
			}//for game loop
			printPops(plants);
			if(plants > 2000000) {
				plants = 2000000;
			}
			else if(plants <= 0) {
				plants = 100;
			}
			else {
				plants *= (rand.nextInt(11) + 4); // makes plants grow by factor
			}
			//grow the plants
			
		}//while game loop
		scan.close();
	}//main
}//class