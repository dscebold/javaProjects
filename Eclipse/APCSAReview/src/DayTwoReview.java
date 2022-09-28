import java.util.ArrayList;

public class DayTwoReview {

	public static void main(String[] args) {

		// Array
		int[] nums = new int[7]; // default for all num data types is to fill with a 0
		boolean[] bools = new boolean[3]; // default false
		String[] words = new String[6]; // default null

		String[] wordsTwo = { "word", "bird", "stuff", "things" }; // declare with known values

		// limitations of arrays - they do not change size once created

		words = wordsTwo; // you can assign the values of one array to another (Pointer)

		// indexing
		System.out.println(words[0]);

		// ArrayList (Must contain Objects)
		ArrayList<String> moreWords = new ArrayList<String>();

		moreWords.add("more birds"); // add an item to an arraylist

		moreWords.add("even more birds");
		moreWords.add("extra birds");
		moreWords.add("have you ever played Wingspan?");

		System.out.println(moreWords.remove("A"));

		// String thing = moreWords.remove("more birds"); you cannot do this because
		// .remove is returning a boolean

		// size
		System.out.println(moreWords.size());

		// array.length
		// ArrayList.size()
		// String.length()

		// index of arraylist
		System.out.println(moreWords.get(2) + "\n");
		/*
		 * \is an escape character inside of strings \n does a newline \t does a tab \"
		 * is how you print a quote without terminating the string \\ is how you print a
		 * \
		 */

		// Looping
		// for
		// for( initialized variable ; termination point ; increment ) { do stuff }
		for (int i = 0; i < moreWords.size(); i++) {
			System.out.println(moreWords.get(i));
			if (moreWords.get(i).contains("bird")) {
				moreWords.remove(i);
				i--;
			}
		}
		for (;;) { // just like a while true
			break;
		}

		for (int i = 0, t = 1, x = 7; i < 5 && x > 0; i++, t--, x--) {

		}

		// enhanced for loop
		for (String wordy : moreWords) {
			System.out.println(wordy);
//				if(wordy.contains("span")) {
//					moreWords.remove(wordy);
//				}
		}

		for (String wordy : wordsTwo) {

		}

		// while (boolean) { do stuff }

		boolean yup = true;
		while (yup) {
			System.out.println("Stuff");
			yup = false;
		}

		int z = 0;
		while (z < wordsTwo.length) {
			System.out.println(wordsTwo[z]);
			z++;
		}

	}

}
