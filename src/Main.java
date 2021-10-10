import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // declare static variables here
    static String inputText;
    static String[] wordsArray;

    static int totalA = 0;
    static int totalE = 0;
    static int totalI = 0;
    static int totalO = 0;
    static int totalU = 0;

    static int totalPeriod = 0;
    static int totalComma = 0;
    static int totalExclamation = 0;
    static int totalQuestionMark = 0;

    static int numCharacters = 0;
    static int numWords = 0;
    static String longestWord = "";
    static String shortestWord = "";
    static String[] lastThreeWords = new String[3];

    // create countLetters(Char c, String str) method

    public static int countLetter(char c, String str) {
        int counter = 0;
        for (int index = 0; index < str.length(); index++) {
            if (Character.toLowerCase(str.charAt(index)) == Character.toLowerCase(c)) {
                counter++;
            }
        }
        return counter;
    }

    // create countWords(String word, String str) method

    public static int countWords(String word, String str) {
        int counter = 0;
        for (String words : inputText.replaceAll("([.,!?:;\"-]|\\s)+"," ").split(" ")) {
            counter++;
        }
        return counter;
    }

    public static void scanInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter string to analyze");
        inputText = scan.nextLine();
        wordsArray = inputText.replaceAll("([.,!?:;\"-]|\\s)+"," ").split(" ");
    }

    public static void calculateResults() {

        longestWord = wordsArray[0];
        shortestWord = wordsArray[0];
        totalA = countLetter('a', inputText);
        totalE =  countLetter('e', inputText);
        totalI = countLetter('i', inputText);
        totalO = countLetter('o', inputText);
        totalU = countLetter('u', inputText);
        totalPeriod = countLetter('.', inputText);
        totalComma = countLetter(',', inputText);
        totalExclamation = countLetter('!', inputText);
        totalQuestionMark = countLetter('?', inputText);
        numCharacters = inputText.length();
        numWords = wordsArray.length;

        for (String str : wordsArray) {
            if (str.length() > longestWord.length()) {
                longestWord = str;
            }
            if (str.length() < shortestWord.length()) {
                shortestWord = str;
            }
        }

        // static String[] lastThreeWords = new String[3];

        lastThreeWords[0] = wordsArray[wordsArray.length - 3];
        lastThreeWords[1] = wordsArray[wordsArray.length - 2];
        lastThreeWords[2] = wordsArray[wordsArray.length - 1];
    }
    // create displayResults() method to print the output to the screen.

    public static void displayResults() {

        System.out.println("Analyzer found: ");
        System.out.println("Total [a]: " + totalA);
        System.out.println("Total [e]: " + totalE);
        System.out.println("Total [i]: " + totalI);
        System.out.println("Total [o]: " + totalO);
        System.out.println("Total [u]: " + totalU);
        System.out.println("Total periods: " + totalPeriod);
        System.out.println("Total commas: " + totalComma);
        System.out.println("Total exclamation points: " + totalExclamation);
        System.out.println("Total question marks: " + totalQuestionMark);
        System.out.println("Total characters: " + numCharacters);
        System.out.println("Total words: " + numWords);
        System.out.println("The longest word: " + longestWord);
        System.out.println("The shortest word: " + shortestWord);
        System.out.println("The last three words: " + Arrays.toString(lastThreeWords));
    }

    public static void main(String[] args) {

        System.out.println("****Text Analyzer Program***");
	    // write your code here
        scanInput();
        calculateResults();
        displayResults();
    }
}