package letsDoThis;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {

	// Attributes

	Character person;
	Random rand;
	Scanner scan, scanNum;
	ArrayList<Enemy> ants;
	Room foyer, hall, corner, trap, lead, ante, boss;
	ArrayList<Room> rooms;
	private int curRoom;
	item axe, armor, medallion, cloak, crossbow, boots, potion;
	ArrayList<item> items, inventory;

	// Constructor

	public GameLogic() {
		curRoom = 0;
		person = new Character();
		rand = new Random();
		scan = new Scanner(System.in);
		scanNum = new Scanner(System.in);
		ants = new ArrayList<>();
		foyer = new Room(true, false, false, false, "foyer");
		hall = new Room(true, true, false, false, "hall");
		corner = new Room(false, true, true, false, "corner");
		trap = new Room(false, false, true, true, "trap");
		lead = new Room(true, false, false, true, "lead");
		ante = new Room(true, true, false, false, "ante");
		boss = new Room(false, true, false, false, "boss");
		axe = new item(1, "Axe", "barbarian");
		armor = new item(5, "Armor", "barbarian");
		medallion = new item(1, "Medallion", "wizard");
		cloak = new item(5, "Cloak", "wizard");
		crossbow = new item(1, "Crossbow", "archer");
		boots = new item(5, "Boots", "archer");
		potion = new item(0, "Potion", person.getType());
		rooms = new ArrayList<>();
		items = new ArrayList<>();
		inventory = new ArrayList<>();
		add();
		build();
	}

	// Methods

	private void add() {
		items.add(axe);
		items.add(armor);
		items.add(medallion);
		items.add(cloak);
		items.add(crossbow);
		items.add(boots);

	}

	private void build() {
		rooms.add(foyer);
		rooms.add(hall);
		rooms.add(corner);
		rooms.add(trap);
		rooms.add(lead);
		rooms.add(ante);
		rooms.add(boss);
	}

	public void run() {
		foyer.setEntered(false);
		System.out.println("You enter the first room ready to fight.");
		Enemy joe = new Enemy();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You see a " + joe.getType() + " in front of you\nType: " + joe.getType() + "\nHealth: "
				+ joe.getHealth());
		while (person.checkAlive() && joe.checkAlive()) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("What would you like to do?\n1.Attack\n2.Give Up");
			String first = scan.nextLine().toLowerCase();
			if (first.equals("attack") || first.equals("1")) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("You attack " + joe.getType());
				if ((rand.nextInt(20) + 1) + person.getHit() >= joe.getArmor()) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("You Hit " + joe.getType());
					joe.setHealth((joe.getHealth() - rand.nextInt(person.getDamage())));
					if (joe.checkAlive() == false) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("You killed " + joe.getType() + "!");
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("That battle is now over.");
						afterBattle();
					}
				} else {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("You missed " + joe.getType());
				}

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Type: " + joe.getType() + "\nHealth: " + joe.getHealth());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(joe.getType() + " Attacks You!");
				if ((rand.nextInt(20) + 1) + joe.getHit() > person.getArmor()) {
					System.out.println(joe.getType() + " hit you");
					person.setHealth((person.getHealth() - rand.nextInt(joe.getDamage())));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Class: " + person.getType() + "\nTotal Health: " + person.getTotHealth()
							+ "\nCurrent Health: " + person.getHealth() + "\nArmor: " + person.getArmor());
					if (person.checkAlive() == false) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Game Over");
					}

				} else {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(joe.getType() + " missed you");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Class: " + person.getType() + "\nHealth: " + person.getHealth() + "\nArmor: "
							+ person.getArmor());
				}

			} else if (first.equals("give up") || first.equals("2")) {
				person.setAlive(false);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("You gave up and died. Game Over.");

			} else {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("That is not an accepted command");
			}
		}
		if (person.checkAlive() == true) {
			afterBattle();
		}
	}

	private void afterBattle() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You are in the " + rooms.get(curRoom).getName() + " room");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(
				"What would you like to do?\n1.Search Room\n2.Check Inventory\n3.Move to Next Room\n4.Move to Previous Room");
		String choice = scan.nextLine().toLowerCase();
		if (choice.equals("1") || choice.equals("search room")) {
			if (rooms.get(curRoom).isSearched() == false) {
				rooms.get(curRoom).setSearched(true);
				search();
			} else {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("You already searched this room");
				afterBattle();
			}

		} else if (choice.equals("2") || choice.equals("check inventory")) {
			if (inventory.size() > 0) {
				for (int i = 0; i < inventory.size(); i++) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println((i + 1) + "." + inventory.get(i).getName());
				}
				afterBattle();
			} else {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("You're Inventory is Empty");
				afterBattle();
			}

		} else if (choice.equals("3") || choice.equals("move to next room")) {
			if (curRoom < 6) {
				curRoom++;
				rooms.get(curRoom).setEntered(false);
				battle();
			} else {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("There are no rooms beyond this");
			}

		} else if (choice.equals("4") || choice.equals("move to previous room")) {
			if (curRoom > 0) {
				curRoom--;
				afterBattle();
			} else {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("You are in the first room and can't leave");
				afterBattle();
			}

		}

		else if (choice.equals("5") || choice.equals("use item")) {
			if (inventory.size() > 0) {
				useItem();
			} else {
				System.out.println("You're Inventory is Empty");
			}
		} else {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("That is not an accepted command");
			afterBattle();
		}

	}

	private void useItem() {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println((i + 1) + ". " + inventory.get(i).getName());
		}
		System.out.println("Which item would you like to use? Hint type the name");
		String used = scan.nextLine().toLowerCase();
		if (used.equals("axe") && person.getType().equals("barbarian")) {
			person.setDamage(person.getDamage() + 2);
			person.setHit(person.getHit() + 2);
			inventory.remove(axe);
		} else if (used.equals("armor") && person.getType().equals("barbarian")) {
			person.setArmor(person.getArmor() + 2);
			inventory.remove(armor);
		} else if (used.equals("medallion") && person.getType().equals("wizard")) {
			person.setDamage(person.getDamage() + 2);
			person.setHit(person.getHit() + 2);
			inventory.remove(medallion);
		} else if (used.equals("cloak") && person.getType().equals("wizard")) {
			person.setArmor(person.getArmor() + 2);
			inventory.remove(cloak);
		} else if (used.equals("crossbow") && person.getType().equals("archer")) {
			person.setDamage(person.getDamage() + 2);
			person.setHit(person.getHit() + 2);
			inventory.remove(crossbow);
		} else if (used.equals("boots") && person.getType().equals("archer")) {
			person.setArmor(person.getArmor() + 2);
			inventory.remove(boots);
		} else {
			System.out.println("That is not an item you have");
			useItem();
		}
		afterBattle();
	}

	private void search() {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getRoom() == curRoom && items.get(i).getType().equals(person.getType())) {
				inventory.add(items.get(i));
				items.remove(i);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("You found a " + items.get(i).getName());
			}
		}
		int heal = rand.nextInt(10) + 10;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You found a health potion that healed you for " + heal + " hitpoints");
		person.setHealth(person.getHealth() + heal);
		if (person.getHealth() > person.getTotHealth()) {
			person.setHealth(person.getTotHealth());
		}
		afterBattle();

	}

	private void battle() {

		int numEn = rand.nextInt(5);
		for (int k = 0; k < numEn; k++) {
			Enemy bob = new Enemy();
			if (bob.getType().equals("nonNewtonian")) {
				k = numEn;
			}
			ants.add(bob);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You see " + ants.size() + " enemies in front of you");
		for (int i = 0; i < ants.size(); i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out
					.println((i + 1) + ". " + "Type: " + ants.get(i).getType() + "\n" + "Health: " + ants.get(i).getHealth());
		}

		while (person.checkAlive() && ants.size() > 0) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("What would you like to do?\n1.Attack\n2.Give Up");
			String fight = scan.nextLine().toLowerCase();
			if (fight.equals("attack") || fight.equals("1")) {
				if (ants.size() > 1) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("which one would you like to attack? Hint type number");
					for (int i = 0; i < ants.size(); i++) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println((i + 1) + ". " + "Type: " + ants.get(i).getType() + "\n" + "Health: "
								+ ants.get(i).getHealth());
					}
				}
				int comb = scanNum.nextInt();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("You attack " + ants.get(comb - 1).getType());
				if ((rand.nextInt(20) + 1) + person.getHit() >= ants.get(comb - 1).getArmor()) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("You hit " + ants.get(comb - 1).getType());
					ants.get(comb - 1).setHealth((ants.get(comb - 1).getHealth() - rand.nextInt(person.getDamage())));
					if (ants.get(comb - 1).checkAlive() == false) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("You killed " + ants.get(comb - 1).getType() + "!");
						ants.remove(comb - 1);
					}
				} else {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("You missed " + ants.get(comb - 1).getType());
				}

				if (ants.size() > 0) {
					for (int i = 0; i < ants.size(); i++) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println((i + 1) + "Type: " + ants.get(i).getType() + "\n" + "Health: "
								+ ants.get(i).getHealth());
					}
					for (int i = 0; i < ants.size(); i++) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(ants.get(i).getType() + " Attacks You!");
						if ((rand.nextInt(20) + 1) + ants.get(i).getHit() > person.getArmor()) {
							person.setHealth((person.getHealth() - rand.nextInt(ants.get(i).getDamage())));
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("Class: " + person.getType() + "\nTotal Health: " + person.getTotHealth()
									+ "\nCurrent Health: " + person.getHealth() + "\nArmor: " + person.getArmor());
							if (person.checkAlive() == false) {
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println("Game Over");
							}

						} else {
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println(ants.get(i).getType() + " missed you");
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("Class: " + person.getType() + "\nHealth: " + person.getHealth()
									+ "\nArmor: " + person.getArmor());
						}
					}
				}

			} else if (fight.equals("give up") || fight.equals("2")) {
				person.setAlive(false);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("You gave up and died. Game Over.");

			} else {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("That is not an accepted command");
			}
		}
		if (person.checkAlive() == true) {
			afterBattle();
		}
	}

}
