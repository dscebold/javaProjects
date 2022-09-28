import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DrewBookAnalytics extends BookAnalytics {

	private String master, noPunct;

	public DrewBookAnalytics(String aTextFile, String outputFile) {
		super(aTextFile, outputFile);
		master = convert();
		noPunct = reomvePunc();
	}

	private String reomvePunc() {
		String message = master;
		message = message.toLowerCase();
		String[] punc = { ".", ",", "?", "!", "\"", "’", "\\", "/" };
		for (String per : punc) {
			message = message.replace(per, "");
		}
		return message;
	}

	private String convert() {
		String allText = "";
		while (scan.hasNextLine()) {
			String temp = scan.nextLine();
			allText += temp + "\n";
		}
		return allText;
	}

	@Override
	public String mostFrequentWord() {
		String message = master;
		message = message.toLowerCase();
		String[] punc = { ".", ",", "?", "!", "\"", "’", "\\", "/" };
		for (String per : punc) {
			message = message.replace(per, "");
		}

		String[] most = message.split(" ");
		String max = "";
		int count = 0;
		int maxCount = 0;
		for (String word : most) {
			count = 0;
			for (String check : most) {
				if (check.equals(word)) {
					count++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				max = word;
			}
		}

		return max;
	}

	

	@Override
	public String mostFrequentWordWithCapitalFirstLetter() {
		String message = master;
		String[] punc = { ".", ",", "?", "!", "\"", "’", "\\", "/" };
		for (String per : punc) {
			message = message.replace(per, "");
		}

		String[] most = message.split(" ");
		String max = "";
		int count = 0;
		int maxCount = 0;
		for (String word : most) {
			count = 0;
			for (String check : most) {
				String upper = "" + word.charAt(0);
				if (check.equals(word) && (upper.toUpperCase().equals(upper))) {
					count++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				max = word;
			}
		}

		return max;
	}

	@Override
	public char mostFrequentLetter() {
		String message = master;
		int count = 0;
		int maxCount = 0;
		String letter = "";
		String maxLetter = "";
		message = message.replace(" ", "");

		for (int i = 0; i < message.length(); i++) {
			letter = "" + message.charAt(i);
			letter.toLowerCase();
			count = 0;
			for (int k = 0; k < message.length(); k++) {
				String check = "" + message.charAt(k);
				if (check.equalsIgnoreCase(letter)) {
					count++;
					if (count > maxCount) {
						maxCount = count;
						maxLetter = letter;
					}
				}
			}

		}
		char bee = maxLetter.charAt(0);

		return bee;
	}

	@Override
	public int wordCount() {
		String message = master;
		message = message.toLowerCase();
		String[] punc = { ".", ",", "?", "!", "\"", "’", "\\", "/" };
		for (String per : punc) {
			message = message.replace(per, "");
		}

		String[] most = message.split(" ");

		return most.length;
	}

	@Override
	public int characterCount() {
		String message = master;
		message = message.toLowerCase();
		String[] punc = { ".", ",", "?", "!", "\"", "’", "\\", "/" };
		for (String per : punc) {
			message = message.replace(per, "");
		}
		message.replace("\n", "");
		return message.length();
	}

	@Override
	public int vowelCount() {
		String message = master;
		message = message.toLowerCase();
		String[] punc = { ".", ",", "?", "!", "\"", "’", "\\", "/" };
		for (String per : punc) {
			message = message.replace(per, "");
		}
		int count = 0;
		char[] vowel = { 'a', 'e', 'i', 'o', 'u', 'y' };
		for (int i = 0; i < message.length(); i++) {
			for (char blue : vowel) {
				if (message.charAt(i) == blue) {
					count++;
				}
			}
		}
		return count;
	}

	@Override
	public int consonantCount() {
		String message = master;
		message = message.toLowerCase();
		String[] punc = { ".", ",", "?", "!", "\"", "’", "\\", "/" };
		for (String per : punc) {
			message = message.replace(per, "");
		}
		int count = 0;
		char[] vowel = { 'a', 'e', 'i', 'o', 'u', 'y', ' ' };
		for (int i = 0; i < message.length(); i++) {
			for (char blue : vowel) {
				if (!(message.charAt(i) == blue)) {
					count++;
				}
			}
		}
		return count;
	}

	@Override
	public double averageWordLength() {
		String message = master;
		message = message.toLowerCase();
		String[] punc = { ".", ",", "?", "!", "\"", "’", "\\", "/" };
		for (String per : punc) {
			message = message.replace(per, "");
		}
		double count = 0.0;

		String[] most = message.split(" ");
		for (String aver : most) {
			count += aver.length();
		}

		return count / most.length;
	}

	@Override
	public int sentenceCount() {
		String message = master;
		message = message.toLowerCase();
		String[] most = message.split(" ");
		String[] titles = { "Mrs.", "Mr.", "Dr.", "Sr.", "Jr.", "..." };
		for (String boat : most) {
			for (String bubb : titles) {
				if (boat.equalsIgnoreCase(bubb)) {
					message = message.replace(bubb, "");
				}
			}
		}
		int count = 0;

		String[] punc = { ",", "\"", "’", "\\", "/" };
		for (String per : punc) {
			message = message.replace(per, "");
		}
		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(i) == '.') {
				count++;
			}
		}
		return count;
	}

	@Override
	public double averageWordsPerSentance() {
		double words = wordCount();
		double sentences = sentenceCount();
		return words / sentences;

	}

	@Override
	public int numberOfDifferentWords() {
		String message = master;
		message = message.toLowerCase();
		String[] punc = { ".", ",", "?", "!", "\"", "’", "\\", "/" };
		for (String per : punc) {
			message = message.replace(per, "");
		}

		String[] most = message.split(" ");
		ArrayList<String> checked = new ArrayList<>();
		int count = 0;
		for (String word : most) {
			if (!(checked.contains(word))) {
				count++;
				checked.add(word);
			}

		}

		return count;
	}

	@Override
	public String alphabetizeAllByChar() {
		String message = master;
		message = message.toLowerCase();
//		String[] punc = { ".", ",", "?", "!", "\"", "’", "\\", "/" };
//		for (String per : punc) {
//			message = message.replace(per, "");
//		}
		message = message.replace(" ", "");
		message = message.replace("\n", "");
		String[] most = message.split("");

		Arrays.sort(most);
		message = "";
		for (int i = 0; i < most.length; i++) {
			message += most[i];
		}
		return message;
	}

	@Override
	public String alphabetizeAllByWord() {
		String message = master;
		message = message.toLowerCase();
//		String[] punc = { ".", ",", "?", "!", "\"", "’", "\\", "/" };
//		for (String per : punc) {
//			message = message.replace(per, "");
//		}
		message = message.replace("\n", "");
		String[] most = message.split(" ");
		Arrays.sort(most);
		message = "";
		for (int i = 0; i < most.length; i++) {
			message += " " + most[i];
		}
		return message;
	}

	@Override
	public String replaceWordAndPreserveCase(String aLine, String wordOne, String wordTwo) {
		String message = aLine;
		String upper = "" + wordOne.charAt(0);
		upper = upper.toUpperCase();
		upper += "" + wordOne.substring(1, wordOne.length());
		String lower = wordOne.toLowerCase();
		String replic = "" + wordTwo.charAt(0);
		replic = replic.toUpperCase();
		replic += "" + wordTwo.substring(1, wordTwo.length());
		String rupple = wordTwo.toLowerCase();

		message = message.replaceAll(upper, replic);
		message = message.replaceAll(lower, rupple);

		return message;
	}

	@Override
	public String toString() {
		String allText = "mostFrequentWord(): " + mostFrequentWord() + "\n"
				+ "mostFrequentWordWithCapitalFirstLetter(): " + mostFrequentWordWithCapitalFirstLetter() + "\n"
				+ "mostFrequentLetter(): " + mostFrequentLetter() + "\n" + "wordCount(): " + wordCount() + "\n"
				+ "characterCount(): " + characterCount() + "\n" + "vowelCount(): " + vowelCount() + "\n"
				+ "consonantCount(): " + consonantCount() + "\n" + "averageWordLength(): " + averageWordLength() + "\n"
				+ "sentenceCount(): " + sentenceCount() + "\n" + "averageWordsPerSentance(): "
				+ averageWordsPerSentance() + "\n" + "numberOfDifferentWords(): " + numberOfDifferentWords() + "\n"
				+ "alphabetizeAllByChar(): " + alphabetizeAllByChar() + "\n" + "alphabetizeAllByWord(): "
				+ alphabetizeAllByWord() /*
											 * + "\n" +"replaceWordAndPreserveCase(): " + replaceWordAndPreserveCase() +
											 * "\n" +"replaceWordsAndWriteToFile(): " + replaceWordsAndWriteToFile()
											 */;
		return allText;
	}

	@Override
	public void replaceWordsAndWriteToFile(String[] wordsToBeReplaced, String[] wordsToReplaceWith) {
		String message = master;
		message = message.toLowerCase();
		String[] punc = { ".", ",", "?", "!", "\"", "’", "\\", "/" };
		for (String per : punc) {
			message = message.replace(per, "");
		}

		String[] most = message.split(" ");
		for (int i = 0; i < most.length; i++) {
			for (int k = 0; k < wordsToBeReplaced.length; k++) {
				if (most[i].equals(wordsToBeReplaced[k])) {
					most[i] = wordsToReplaceWith[k];
				}
			}
		}
		message = "";
		for (int i = 0; i < most.length; i++) {
			message += most[i];
		}
		write.write(message);
	}

	public void printFile() {
		String allText = "";
		while (scan.hasNextLine()) {
			String temp = scan.nextLine();
			allText += temp + "\n";
			System.out.println(nukeLetterA(temp));
		}
		System.out.println(allText);
		write.write(allText); // use a textWriter to output a string to a new file\
		write.flush(); // clears the writer for the next use
	}

	private String nukeLetterA(String nextLine) {
//		String anOutput = "";
//		for (int i = 0; i < nextLine.length(); i++) {
//			if (nextLine.charAt(i) == 'a') {
//				anOutput += "*";
//			} else {
//				anOutput += nextLine.charAt(i);
//			}
//		}
//		return anOutput;
		return nextLine.replace("a", "*");
	}

}
