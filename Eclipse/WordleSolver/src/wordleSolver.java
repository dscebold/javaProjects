import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class wordleSolver {

    private ArrayList<String> remainingWords;
    private ArrayList<Character> excludedLetters;
    private String correctLetters;
    private Dictionary<Integer, ArrayList<Character>> rightLettersWrongSpot;
    private Scanner scan;

    public wordleSolver() throws IOException{
        String[] temp = readFile("wordleWords.txt").split(",");
        for (String word : temp){
            this.remainingWords.add(word);
        }
        this.correctLetters = "*****";
        this.scan = new Scanner(System.in);
    }

    private void addCorrectLetters(String newCorrectLetters) {
        this.correctLetters = newCorrectLetters;
    }

    private void addLettersInWord() {
        
    }


    private String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }




}
