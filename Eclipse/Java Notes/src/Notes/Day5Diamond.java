package Notes;

import java.util.Scanner;

public class Day5Diamond {

	public static void main(String[] args) {

		Scanner numScan = new Scanner(System.in);
		Scanner textScan = new Scanner(System.in);

		System.out.println("How large of a diamond?");
		int size = numScan.nextInt();

		System.out.println("What character should the diamond be made of?");
		String thing = textScan.nextLine();

		// top
		for (int row = 0; row < size; row++) {
			String left = "";
			for (int i = row; i < size; i++) { // start big get smaller
				left += " ";
			}
			left += thing;
			for (int i = size - row; i < size; i++) {
				left += "  ";
			}
			System.out.println(left + thing);

		}
		// bottom

		for (int row = 0; row < size; row++) {
			String left = " ";
			for (int i = size - row; i < size; i++) {
				left += " ";
			}
			left += thing;
			for (int i = row + 1; i < size; i++) {
				left += "  ";
			}
			System.out.println(left + thing);

		}

		numScan.close();
		textScan.close();

	}

}
