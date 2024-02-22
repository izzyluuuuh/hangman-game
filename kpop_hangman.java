import java.util.Scanner;

public class KPOPHangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess the K-POP Group!" + "\n");
        System.out.println("Input the correct letter only." + "\n");
        System.out.println("Attempts left: 6");
        System.out.println("-----------------------------------------------" + "\n");

        String[] words = {"blackpink", "enhypen", "straykids", "stayc", "aespa", "itzy", "seventeen"};
        String word = words[(int) (Math.random() * words.length)];
        char[] hiddenWord = new char[word.length()];
        for (int i = 0; i < hiddenWord.length; i++) {
            hiddenWord[i] = '_';
        }
        int attempts = 0;
        boolean guessedWord = false;

        while (!guessedWord && attempts < 6) {
            System.out.print("Guess a letter in the word: ");
            for (char c : hiddenWord) {
                System.out.print(c + " ");
            }
            System.out.println();
            System.out.println("Attempts left: " + (6 - attempts) + "\n");

            char guess;
            do {
                System.out.print("Enter your guess: ");
                guess = scanner.next().charAt(0);
                if (!Character.isAlphabetic(guess)) {
                    System.out.println("Invalid input. Please enter a letter.");
                }
            } while (!Character.isAlphabetic(guess));

            boolean correctGuess = false;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    hiddenWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                attempts++;
            }

            if (word.equals(String.valueOf(hiddenWord))) {
                guessedWord = true;
            }
        }

        if (guessedWord) {
            System.out.println("Congratulations! You guessed the word: " + word);
        } else {
            System.out.println("Sorry, you ran out of attempts. The word was: " + word);
        }

        scanner.close();
    }
}