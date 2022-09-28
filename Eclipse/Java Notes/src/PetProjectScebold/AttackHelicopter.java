package PetProjectScebold;

import java.util.Random;
import java.util.Scanner;
import OOPNotes.Diety;

public class AttackHelicopter {

	// Attributes

	private Dice barrelRollDice, looptyLoopDice, misslesDice, machineGunDice, reloadMachineGunDice, reloadMisslesDice,
			becomeGenderDice, killGodDice, prayDice, createGodDice;
	private String name, pilot;
	private Random rand;
	private Scanner scan;
	private boolean alive, godAlive, pilotAlive;
	private int fuel, missles, maitnence, bullets, conscience;
	private String[] commands = { "Barrel Roll", "Loopty Loop", "Missles", "Machine Gun", "Repair", "Refuel",
			"Reload Machine Guns", "Reload Missles", "Become Gender", "Kill God", "Kill Pilot", "Pray", "Create God" };
	private stopwatch lifeTime, happyTime;

	// Constructor

	public AttackHelicopter() {
		scan = new Scanner(System.in);
		rand = new Random();
		pilot = setPilot();
		godAlive = true;
		pilotAlive = true;
		conscience = rand.nextInt(10) + 1;
		setUp();
	}

	// Methods

	private void setUp() {
		name = setName();
		alive = true;
		fuel = rand.nextInt(300) + 1;
		missles = rand.nextInt(16) + 1;
		maitnence = rand.nextInt(26) + 25;
		bullets = rand.nextInt(1001) + 200;
		barrelRollDice = new Dice();
		looptyLoopDice = new Dice();
		misslesDice = new Dice();
		machineGunDice = new Dice();
		reloadMachineGunDice = new Dice();
		reloadMisslesDice = new Dice();
		becomeGenderDice = new Dice();
		killGodDice = new Dice();
		prayDice = new Dice();
		lifeTime = new stopwatch();
		happyTime = new stopwatch();
		createGodDice = new Dice();

	}

	private String setPilot() {
		System.out.println("What is your name new pilot?");
		pilot = scan.nextLine();
		System.out.println("Hello " + pilot + " ready to take to the skies?");
		return pilot;
	}

	private String setName() {
		System.out.println("What is the name of your Helicopter " + this.pilot + "?");
		String helicopter = scan.nextLine();
		System.out.println("From now on " + this.pilot + " your helicopter will be known as " + helicopter + ".");
		return helicopter;
	}

	public void setAlive() {
		if ((this.fuel <= 0 || this.maitnence <= 0) && this.alive) {
			System.out.println("Your attack helicopter " + this.name + " has crashed, great flying.");
			this.alive = false;
		}
	}

	public void stillFlying() {
		this.lifeTime.start();
		while (this.alive && this.pilotAlive) {
			if (this.fuel >= 50 && this.maitnence >= 20 && this.missles >= 4 && this.bullets >= 200
					&& happyTime.isRunning() == false) {
				this.happyTime.start();
			}
			Warning();
			Suicide();
			System.out.println(toString());
			String command = getCommand();
			doCommand(command);
			setAlive();
			newHelicopter();
		}
		System.out.println("Looks like you weren't cut out to be a pilot after all.");
	}

	public String toString() {
		String output = this.name;
		output += "\n\tFuel: " + this.fuel;
		output += "\n\tMaitnence: " + this.maitnence;
		output += "\n\tMissles: " + this.missles;
		output += "\n\tBullets: " + this.bullets;
		output += "\n\tConsience: " + this.conscience;
		return output;
	}

	public void Commands() {
		for (int i = 0; i < this.commands.length; i++) {
			System.out.println("\t" + (i + 1) + ": " + this.commands[i]);
		}
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	public void setMissles(int missles) {
		this.missles = missles;
	}

	public void setMaitnence(int maitnence) {
		this.maitnence = maitnence;
	}

	public void setBullets(int bullets) {
		this.bullets = bullets;
	}

	private void doCommand(String command) {
		if (command.contains("create god") || command.contains("13")) {
			createGod();
		} else if (command.contains("kill god") || command.contains("10")) {
			killGod();
		} else if (command.contains("kill pilot") || command.contains("11")) {
			killPilot();
		} else if (command.contains("pray") || command.contains("12")) {
			Pray();
		} else if (command.contains("barrel roll") || command.contains("1")) {
			barrelRoll();
		} else if (command.contains("loopty loop") || command.contains("2")) {
			looptyLoop();
		} else if (command.contains("reload machine guns") || command.contains("7")) {
			reloadMachineGuns();
		} else if (command.contains("reload missles") || command.contains("8")) {
			reloadMissles();
		} else if (command.contains("missles") || command.contains("3")) {
			Missles();
		} else if (command.contains("machine gun") || command.contains("4")) {
			machineGun();
		} else if (command.contains("repair") || command.contains("5")) {
			Repair();
		} else if (command.contains("refuel") || command.contains("6")) {
			Refuel();
		} else if (command.contains("become gender") || command.contains("9")) {
			becomeGender();
		} else {
			System.out.println("Thats not a command " + this.pilot + ", please try again.");
		}
	}

	private void createGod() {
		if (this.godAlive == false && createGodDice.roll()) {
			Diety copter = new Diety();
			System.out.println(copter.toString());
			this.godAlive = true;
		} else if (this.godAlive == true) {
			System.out.println("You can't have two gods at once or else they will fight.");
		} else {
			System.out.println("You are only one helicopter, who are you to think you can create a god.");
		}

	}

	private void Pray() {
		if (prayDice.roll() && this.godAlive == true) {
			System.out.println("God forgives all mistakes, no matter how bad they are");
			this.conscience -= 10;
			if (this.conscience <= 0) {
				this.conscience = 0;
			}
		} else if (this.godAlive == false) {
			System.out.println("You killed God, no one can forgive you now.");
		} else {
			System.out.println("You somehow failed at praying and you now have " + prayDice.getProb()
					+ " chance of praying successfully nexttime");
		}
	}

	private void killPilot() {
		System.out.println("Wait, whose flying then.");
		this.pilotAlive = false;

	}

	private void killGod() {
		if (killGodDice.roll() && this.godAlive == true) {
			System.out.println("I don't know how you did it, but god is now dead, let Anarchy reign.");
			this.godAlive = false;
		} else if (this.godAlive == false) {
			System.out.println("You can't kill God twice.");
		} else {
			System.out.println("What made you think you could kill God. You now have a " + killGodDice.getProb()
					+ " chance of killing God.");
		}
	}

	private void becomeGender() {
		if (becomeGenderDice.roll()) {
			if (rand.nextInt(10) == 1) {
				createGod();
			} else {
				System.out.println("Oh wow, that dead meme.");
			}
		} else {
			System.out.println("You have failed to become a gender, you now have a " + becomeGenderDice.getProb()
					+ " chance of becoming a gender next time.");
		}
	}

	private void reloadMissles() {
		if (reloadMisslesDice.roll()) {
			System.out.println("Locked and Loaded!");
			this.missles += rand.nextInt(12) + 4;
			if (this.missles >= 16) {
				this.missles = 16;
			}
		} else {
			System.out.println("You put them in backwards, you now have a " + reloadMisslesDice.getProb()
					+ " chance of putting them in correctly next time.");
		}
	}

	private void reloadMachineGuns() {
		if (reloadMachineGunDice.roll()) {
			System.out.println("Time to cause more mayhem");
			this.bullets += rand.nextInt(900) + 100;
			if (this.bullets >= 1200) {
				this.bullets = 1200;
			}
		} else {
			System.out.println("You put blanks in. You now have a " + reloadMachineGunDice.getProb()
					+ " chance of putting actual bullets in next time.");
		}
	}

	private void Refuel() {
		System.out.println("You're topped off and ready to fly.");
		this.fuel += rand.nextInt(150) + 50;
		if (this.fuel >= 300) {
			this.fuel = 300;
		}

	}

	private void Repair() {
		System.out.println("You really should take better care of " + this.name + ".");
		this.maitnence += rand.nextInt(26) + 25;
		if (this.maitnence >= 50) {
			this.maitnence = 50;
		}

	}

	private void machineGun() {
		if (machineGunDice.roll()) {
			if (this.bullets >= 300) {
				System.out.println("Say hello to my little friend!");
				if (rand.nextInt(20) == 1) {
					System.out.println("You shot a doctor, great job.");
					this.conscience += 2;
				} else if (rand.nextInt(100) == 1) {
					System.out.println("You just saved the new Hitler.");
					this.conscience += 4;
				} else {
					int terroritsKilled = rand.nextInt(50) + 1;
					System.out.println("Great job, you killed " + terroritsKilled + " terrorits.");
				}
				this.bullets -= rand.nextInt(200) + 100;
			}
		} else {
			System.out.println("Your gun jammed. You now have a " + machineGunDice.getProb()
					+ " chance of actually firing next time.");
		}
	}

	private void Missles() {
		if (misslesDice.roll()) {
			if (this.missles >= 2) {
				System.out.println("Missles Away!");
				if (rand.nextInt(20) == 1) {
					System.out.println("You hit an innocent Afghan farmer you monster.");
					this.conscience += 2;
				} else if (rand.nextInt(30) == 1) {
					System.out.println(
							"You hit a truck of orphaned refugees, one of which would grow up to cure cancer, and killed them all, \nexcept the one which will now grow up to become the terroroist who will commit the next 9/11.");
					this.conscience += 10;
				} else if (rand.nextInt(50) == 1) {
					System.out.println(
							"You somehow hit yourself with your own missle. You are the dumbest pilot I have ever seen.");
					this.maitnence -= 20;
				} else {
					int trucksBlownUp = rand.nextInt(3) + 1;
					System.out.println("Oh wow, you blew up " + trucksBlownUp + " terroists technicals!");
				}
				this.missles -= 2;
			} else {
				System.out.println("You have an insufficient missles. Please reload to continue your reign of terror.");
			}
		} else {
			System.out.println("You pulled the trigger and nothing happened. You now have a " + misslesDice.getProb()
					+ " chance of firing your missles next time.");
		}
	}

	private void looptyLoop() {
		if (looptyLoopDice.roll()) {
			System.out.println("Whose idea was this again?");
			if (rand.nextInt(20) == 1) {
				System.out.println("Pointing the blades upside down would send you straight at the gound Sherlock.");
				this.maitnence -= rand.nextInt(11) + 10;
			} else {
				System.out.println("I guess the laws of physics don't apply to " + this.name + ".");
			}
			this.fuel -= rand.nextInt(100);
		} else {
			System.out.println("You couldn't get it past 20 degress. You now have a " + looptyLoopDice.getProb()
					+ " chance of successfully doing a Loopty Loop next time.");
		}
	}

	private void barrelRoll() {
		if (barrelRollDice.roll()) {
			System.out.println("Do a barrel roll");
			if (rand.nextInt(20) == 1) {
				System.out.println(
						"You know, doing barrel rolls in a helicoptr doesn't really make sense, maybe that's why you almost crashed");
				this.maitnence -= rand.nextInt(21);
			} else {
				System.out.println("All laws of physics say that was impossible, nice job.");
			}
			this.fuel -= rand.nextInt(100);
		} else {
			System.out.println(this.name + " has failed to do a barrel roll and now has a " + barrelRollDice.getProb()
					+ " chance of doing a Barrel Roll next time.");
		}
	}

	private void newHelicopter() {
		if (this.alive == false) {
			System.out.println("Congradulations you managed to fly " + this.name + " for "
					+ this.lifeTime.getElapsedTime() + " seconds, but " + this.name + " was only happy for "
					+ this.happyTime.getElapsedTime() + " seconds.");
			System.out.println("Do you want to buy another Attack Helicopter for $15 million?");
			if (scan.nextLine().toLowerCase().contains("yes")) {
				setUp();
			}
		}
	}

	private void Suicide() {
		if (this.conscience >= 40) {
			System.out.println("Your terrible war crimes have become too much and you killed yourself.");
			this.pilotAlive = false;
		}
	}

	private String getCommand() {
		System.out.println("What would you like to do?");
		Commands();
		return scan.nextLine().toLowerCase();
	}

	public void Warning() {
		if (this.fuel <= 50) {
			System.out.println(this.pilot + "Fuel is low, refuel now or " + this.name + " will crash.");
			this.happyTime.pause();
		}
		if (this.maitnence <= 20) {
			System.out.println(this.pilot + ", " + this.name + " is in desperate need of repairs, send " + this.name
					+ " in for repairs soon or " + this.name + " will crash.");
			this.happyTime.pause();
		}
		if (this.bullets <= 200) {
			System.out.println(this.pilot + ", you're out of bullets, reload or you won't be able to shot terrorists.");
			this.happyTime.pause();
		}
		if (this.missles <= 4) {
			System.out.println(this.pilot
					+ ", you're running low on missles, your reign of destruction will be halted if you don't reload.");
			this.happyTime.pause();
		}
	}
}
