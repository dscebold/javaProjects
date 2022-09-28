package OOPNotes;

import java.util.Random;

public class Human {
	
	//Attributes - instance variables - field 
		/*
		 * The parts of an object 	(variables it is made up of)
		 * always lowercase variables
		 * They typically use the private access modifier
		 * You typically do not initialize a value
		 */
		private String name; 
		private int age;
		private Random rand;
	//Constructor
		/*
		 * Constructors assign the values to attributes
		 * They run automatically when a new instance of a class is made
		 * Always public access modifier
		 * Always named the same as the class name
		 */
		public Human(String name) {
			rand = new Random(); //if this class includes an object-make that first in your constructor
			this.name = name;
			age = 0;
			
		}
	//Methods
		/*
		 * Are functions that belong to a class
		 * They are the stuff a class can do
		 * They are also the only way to get to a private variable
		 * --get/set methods are designed to get and change attributes
		 */
		
		public String getName() {
			return this.name;
		}
		
		public int getAge() {
			return this.age;
		}
		
		public void setAge() {
			this.age += rand.nextInt(4);
		}
		
		public String toString() {
			return this.name + "\n" + this.age;
		}

}
