import java.util.Scanner;

public class Hangman {

    private static final String [] words = {"code", "world", "hello", "burrito", "eggs", "waterparks"};
    private static final String chosenWord = words [(int) (Math.random() * words.length)];
    private static String hiddenWord = new String(new char[chosenWord.length()]).replace("\0", "?");
    private static int numberOfGuesses = 0;

    public static void main (String [] args) {

        Scanner input = new Scanner(System. in);

        while (numberOfGuesses < 7 && hiddenWord.contains("?")) {
            System.out.println("Guess a letter!");
            System.out.println(hiddenWord);
            String guess = input.next().toLowerCase();
            checkWord(guess);
        }
    }

    public static void checkWord(String guess) {

        String hold = "";

        for (int i = 0; i < chosenWord.length(); i++) {
            if (chosenWord.charAt(i) == guess.charAt(0)) {

                hold += guess.charAt(0);

            }
            else if (hiddenWord.charAt(i) != '?') {

                hold += chosenWord.charAt(i);

            }
            else {

                hold += "?";

            }
        }

        if (hiddenWord.equals(hold)) {

            numberOfGuesses++;
            hangman();

        }

        else {

            hiddenWord = hold;
        }

        if (hiddenWord.equals(chosenWord)) {
            System.out.println("Correct! You win! The word was " + chosenWord);
        }


    }

    public static void hangman() {

        switch(numberOfGuesses) {
            case 1: System.out.println("O");
            break;
            case 2: System.out.println("O");
            System.out.println("|");
                break;
            case 3: System.out.println("O");
                    System.out.println("|/");
                break;
            case 4: System.out.println("O");
                    System.out.println("/|/");
                break;
            case 5: System.out.println("O");
                    System.out.println("/|/");
                    System.out.println("<");
                break;
            case 6: System.out.println("O");
                    System.out.println("/|/");
                    System.out.println("<   >");
                break;
           case 7: System.out.println("Game over!");
           System.exit(0);
           break;


        }

    }


}
