import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordleRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	protected File file;
	protected Scanner scan;
	protected Scanner userScan;
	protected PrintWriter write;
	protected String[] words;
	protected String allText;

	public WordleRunner(String aTextFile, String outputFile) {
		userScan = new Scanner(System.in);
		file = new File(aTextFile);
		try {
			scan = new Scanner(file);
			write = new PrintWriter(outputFile, "UTF-8");
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		}
		allText = "";
		while (scan.hasNext()) {
			allText += scan.nextLine().toUpperCase() + " ";
		}
		words = allText.split(" ");
		
	}

	public String chooseWord() {
		int index = (int)(Math.random() * words.length);
		return words[index];
	}

	public String getGuess() {
		while (true) {
			System.out.println("Type you guess");
			String guess = userScan.nextLine().toUpperCase();
			if (containsGuess(guess)) {
				return guess;
			}
			System.out.println("Not a valid Guess");
		}
	}

	private boolean containsGuess(String guess) {
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (word.equals(guess)) {
				words[i] = "NULL";
				return true;
			}
		}
		return false;
	}

	public int playGame() {
		int guessCount = 0;
		String mysteryWord = chooseWord();
		ArrayList<String> wordsGuessed = new ArrayList<>();
		ArrayList<String> letters = getAllLetters();
		while (guessCount < 6) {
			String guess = getGuess();
			String output = processGuess(guess, mysteryWord);
			wordsGuessed.add(guess);
			letters = removeLetters(letters, guess, mysteryWord);
			printGuesses(wordsGuessed);
			System.out.println("Guess: " + guess);
			System.out.println("Result: " + output);
			guessCount++;
			if (output.equals(mysteryWord)) {
				System.out.println("You Win!");
				System.out.println("Count: " + guessCount);
				break;
			}
			System.out.println(letters);
			
		}
		System.out.println("Mystery Word: " + mysteryWord);
		return guessCount;

	}

	private void printGuesses(ArrayList<String> wordsGuessed) {
		for (int i = 0; i < wordsGuessed.size(); i++) {
			System.out.println("#" + (i + 1) + ": " + wordsGuessed.get(i));
		}

	}

	private ArrayList<String> removeLetters(ArrayList<String> letters, String guess, String mysteryWord) {
		for(int i = 0; i < guess.length(); i++) {
			String current = guess.charAt(i) + "";
			if(letters.contains(current) && !(mysteryWord.contains(current))) {
				letters.remove(current); 
			}
			else if(letters.contains(current)) {
				letters.set(letters.indexOf(current), current.toLowerCase());
			}
		}
		return letters;
	}

	private String processGuess(String guess, String mysteryWord) {
		String output = "";
		for (int i = 0; i < guess.length(); i++) {

			if (guess.charAt(i) == mysteryWord.charAt(i)) {
				output += guess.charAt(i);
			} else if (mysteryWord.contains(guess.charAt(i) + "")) {
				String letter = guess.charAt(i) + "";
				output += letter.toLowerCase();
			} else {
				output += "*";
			}

		}
		return output;
	}

	private ArrayList<String> getAllLetters() {
		String[] letters = { "A", "B", "C", "D", "E", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
				"T", "U", "V", "W", "X", "Y", "Z" };
		return new ArrayList<String>(Arrays.asList(letters));
	}

}
