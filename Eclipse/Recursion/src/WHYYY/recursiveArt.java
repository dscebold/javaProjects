package WHYYY;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Scanner;

public class recursiveArt {

	public static String box(String output, int size) {
		String hold = "";
		for (int i = 0; i < size; i++) {
			for (int q = 0; q < size; q++) {
				hold += output;
			}
			hold += "\n";
		}
		return hold;
	}

	public static void printLine(String thing, int length) {
		if (length > 0) {
			System.out.print(thing + " ");
			printLine(thing, --length);
		}
	}

	public static void printRows(String thing, int rows, int end) {
		if (end > 0) {
			printLine(thing, rows);
			System.out.println();
			printRows(thing, rows, --end);
		}
	}

	public static void diamondSpacesTop(int width) {
		if (width > 0) {
			System.out.print(" ");
			diamondSpacesTop(--width);
		}
	}

	public static void diamondRowsTop(String thing, int start) {
		if (start > 0) {
			System.out.print(thing);
			diamondRowsTop(thing, --start);
		}
	}

	public static void diamondRowsBot(String thing, int end) {
		if (end > 0) {
			System.out.print(thing);
			diamondRowsBot(thing, --end);
		}
	}

	public static void printDiamond(String thing, int width,int changeWidth, int start, int end) {
		if (start < width -1) {
			diamondSpacesTop(changeWidth);
			diamondRowsTop(thing, start);
			System.out.println();
			printDiamond(thing, width, --changeWidth, start +2, end);
		} 
		else if (end < width) {
			diamondSpacesBot(changeWidth);
			diamondRowsBot(thing, (width - end));
			System.out.println();
			printDiamond(thing, width, ++changeWidth, start, end +2);
		}
	}

	private static void diamondSpacesBot(int end) {
		if (end > 0) {
			System.out.print(" ");
			diamondSpacesBot(--end);
		}
	}

	private static void hollowBox(String thing, int height, int width) {
		if (height == 1) {
			fulls(thing, width);
			System.out.println();
			hollowBox(thing, --height, width);
		} else if (height > 1) {
			sides(thing, width, true);
			System.out.println();
			hollowBox(thing, --height, width);
		}
	}

	private static void fulls(String thing, int width) {
		if (width > 0) {
			System.out.print(thing);
			fulls(thing, --width);
		}
	}

	private static void sides(String thing, int width, boolean first) {
		if (first || width == 1) {
			System.out.print(thing);
			sides(thing, --width, false);
		} else if (width > 1) {
			System.out.print(" ");
			sides(thing, --width, false);
		}
	}

	public static void hollowDiamondSpacesTop(int width) {
		if (width > 0) {
			System.out.print(" ");
			hollowDiamondSpacesTop(--width);
		}
	}

	public static void hollowDiamondRowsTop(String thing, int start, boolean first) {
		if (start > 0) {
			if (first || start ==1) {
				System.out.print(thing);
			}
			else {
				System.out.print(" ");
			}
			hollowDiamondRowsTop(thing, --start, false);
		}
	}

	public static void hollowDiamondRowsBot(String thing, int end, boolean first) {
		if (end > 0) {
			if(first || end == 1) {
			System.out.print(thing);
			}
			else {
				System.out.print(" ");
			}
			hollowDiamondRowsTop(thing, --end, false);
		}
	}

	public static void hollowPrintDiamond(String thing, int width, int changeWidth, int start, int end) {
		if (start < width -1) {
			hollowDiamondSpacesTop((changeWidth) );
			hollowDiamondRowsTop(thing, start, true);
			System.out.println();
			hollowPrintDiamond(thing, width,--changeWidth, start + 2, end);
		} else if (end < width) {
			hollowDiamondSpacesBot(changeWidth); 
			hollowDiamondRowsBot(thing, (width - end), true);
			System.out.println();
			hollowPrintDiamond(thing, width,++changeWidth, start, end + 2);
		}
	}

	private static void hollowDiamondSpacesBot(int end) {
		if (end > 0) {
			System.out.print(" ");
			hollowDiamondSpacesBot(--end);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		System.out.println("what should it be made of");
//		String input = scan.nextLine();
//		System.out.println("How Big?");
//		int size = Integer.parseInt(scan.nextLine()); 
//		printDiamond(input, size*2, size, 1, 1); 
//		System.out.println(box("+", 10));
//		System.out.println("what should it be made of");
//		String input1 = scan.nextLine();
//		System.out.println("height?");
//		int height = Integer.parseInt(scan.nextLine());
//		System.out.println("Width?");
//		int width = Integer.parseInt(scan.nextLine());
//		fulls(input, --width);
//		System.out.println();
//		hollowBox(input1, height, width); 
		System.out.println("what should it be made of");
		String input2 = scan.nextLine();
		System.out.println("How Big?");
		int size1 = Integer.parseInt(scan.nextLine());
		hollowPrintDiamond(input2, size1*2, size1, 1, 1);
	}

}
