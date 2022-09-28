package gamefiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Deal {
	
	//Attributes
	private HashMap<Integer, Integer> cases = new HashMap<Integer, Integer>();  
	private Random rand = new Random(); 
	private Scanner scan = new Scanner(System.in);  
	
	
	//Constructor
	public Deal() {
		setCases(); 
	}


	
	//Methods
	
	private void setCases() {
		int hold = 0;
		int temp = 0; 
		ArrayList<Integer> nums = new ArrayList<Integer>();  
		for(int i = 1; i < 26; i++) {
			nums.add(i); 
		}
		ArrayList<Integer> vals = new ArrayList<Integer>();
		int[] trans = {1,5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000};
		for(int i = 0; i < trans.length; i++) {
			vals.add(trans[i]); 
		}
		while(nums.size() > 0) {
			hold = rand.nextInt(nums.size()); 
			temp = rand.nextInt(vals.size()); 
			cases.put(nums.get(hold), vals.get(temp));
			nums.remove(hold);
			vals.remove(temp); 
		}
	}
	
	public void runGame() {
		ArrayList<Integer> nums = new ArrayList<Integer>();  
		for(int i = 1; i < 26; i++) {
			nums.add(i); 
		}
		int curCase = 0; 
		int choice = 0; 
		int opt = 0; 
		int temp = 0; 
		System.out.println("Remaining Cases: ");
		for(int i = 0; i < nums.size(); i++) {
			System.out.println(nums.get(i));
		}
		while (true) {
			while (true) {
				System.out.println("What case would you like to Start with");
				try {
					choice = Integer.parseInt(scan.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("THAT IS NOT A NUMBER!!!!!!");
				}
			}
			if (nums.contains(choice)) {
				break;
			} else {
				System.out.println("INVALID RESPONSE!!!");
			}
		}
		curCase = choice;
		nums.remove((Integer)curCase); 
		while(nums.size() > 1) {
			System.out.println("Remaining Cases: ");
			for(int i = 0; i < nums.size(); i++) {
				System.out.println(nums.get(i));
			}
				
			while (true) {
				while (true) {
					System.out.println("What case would you like to interact with");
					try {
						choice = Integer.parseInt(scan.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("THAT IS NOT A NUMBER!!!!!!");
					}
				}
				if (nums.contains(choice)) {
					break;
				} else {
					System.out.println("INVALID RESPONSE!!!");
				}
			}
			while (true) {
				while (true) {
					System.out.println("What would you like to do?\n1. Open Case\n2. Switch Cases");
					try {
						opt = Integer.parseInt(scan.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("THAT IS NOT A NUMBER!!!!!!");
					}
				}
				if (opt == 1 || opt == 2) {
					break;
				} else {
					System.out.println("INVALID RESPONSE!!!");
				}
			}
			if(opt == 1) { 
				System.out.println("Case " + choice + " contained $" + cases.get(choice));
				nums.remove((Integer)(choice)); 
				cases.remove(choice); 
			}
			else if(opt == 2) {
				temp = curCase;
				curCase = choice; 
				choice = temp; 
				System.out.println("Case " + choice + " contained $" + cases.get(choice));
				nums.remove((Integer)(choice)); 
				cases.remove(choice);	
			}
			
		}
		while (true) {
			while (true) {
				System.out.println("What would you like to do?\n1. Open Current Case\n2. Switch Cases");
				try {
					opt = Integer.parseInt(scan.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("THAT IS NOT A NUMBER!!!!!!");
				}
			}
			if (opt == 1 || opt == 2) {
				break;
			} else {
				System.out.println("INVALID RESPONSE!!!");
			}
		}
		if(opt == 1) { 
			System.out.println("You had Case " + curCase + " and won $" + cases.get(curCase));
			nums.remove((Integer)(choice)); 
			cases.remove(choice); 
		}
		else if(opt == 2) {
			System.out.println("you chose to switch to Case " + nums.get(0) + " and won $" + cases.get(nums.get(0)));
			nums.remove((Integer)(choice)); 
			cases.remove(choice);
		}
		
	}
	
	
	
	

}
