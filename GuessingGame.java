/**
 * GuessingGame -- first part of assignment 2 in 2ip90
 * @author Tom Sijbers
 * @ID 1709208
 * @author IPEK DEGER
 * @id 1578006
 * @date 20/09/2021
 */
import java.util.Scanner;
import java.util.Random;

class GuessingGame {
    Scanner scanner = new Scanner(System.in);
    Random randomGenerator;

    void run() {
        boolean notAnswered = true;
        int code = 0;
        System.out.println("Do you want to enter the secret code yourself?");
        while (notAnswered) {
            String answer = scanner.nextLine();
            if (answer.toLowerCase().equals("yes")) {
                boolean numberOutsideRange = true;
                while (numberOutsideRange) {
                    System.out.println("Secretly type the code");
                    code = scanner.nextInt();
                    if (0 <= code && 99 >= code) {
                        numberOutsideRange = false;
                        notAnswered = false;
                    }
                }
            } else if (answer.toLowerCase().equals("no")) {
                System.out.println("Type an arbitrary number");
                long seed = scanner.nextLong();
                Random randomGenerator = new Random(seed);
                code = randomGenerator.nextInt(100);
                notAnswered = false;
            }
        }
        System.out.println("Start guessing!");
        boolean notGuessed = true;
        int count = 0;
        int[] guesses = new int[7];
        int guess;
        while (notGuessed && count < 7) {
            guess = scanner.nextInt();
            guesses[count] = guess;
            count++;
            if (guess == code) {
                System.out.println("Good guess! You won.");
                notGuessed = false;
            } else if (guess > code) {
                System.out.println("lower");
            } else if (guess < code) {
                System.out.println("higher");
            }
        }
        if (notGuessed) {
            System.out.println("No more guesses, you lost.");
        }
        System.out.println(count + " guesses:");
        int counter = 0;
        String[] guessesVisualized = new String[100];
        while (counter < count) {
            for (int i = 0; i < guessesVisualized.length; i++) {
                if (i == guesses[counter]) {
                    guessesVisualized[i] = "X";
                } else if (i == code) {
                    guessesVisualized[i] = "|";
                } else {
                    guessesVisualized[i] = ".";
                }
            }
            String visualizedGuesses = java.util.Arrays.toString(guessesVisualized).replace(",","");

            System.out.println(visualizedGuesses);
            counter++;
        }
        scanner.close();
    }
    public static void main(String[] args) {
        (new GuessingGame()).run();
    }
}