
/**
 * GuessingGameAdvanced -- second part of assignment 2 in 2ip90
 * @author Tom Sijbers
 * @ID 1709208
 * @author IPEK DEGER
 * @id 1578006
 * @date 20/09/2021
 */
import java.util.Scanner;
import java.util.Random;

class GuessingGameAdvanced {
    Scanner scanner = new Scanner(System.in);
    Random randomGenerator = new Random();

    void run() {
        boolean notRunning = true;
        System.out.println("Think of a secret number not smaller than 0 and not greater than 1000. Type 'go' when you have one.");
        while (notRunning) {
            String startCommand = scanner.nextLine();
            if (startCommand.toLowerCase().equals("go")) {
                notRunning = false;
            }
        }
        boolean notGuessed = true;
        int counter = 0;
        int min = 0;
        int max = 1001;
        while (notGuessed && counter < 10) {
            int guess = randomGenerator.nextInt(max - min) + min;
            System.out.println(guess);
            String response = scanner.nextLine();
            if (response.toLowerCase().equals("higher")) {
                min = guess;
            } else if (response.toLowerCase().equals("lower")) {
                max = guess;
            } else if (response.toLowerCase().equals("good guess! you won.")) {
                notGuessed = false;
            }
            counter++;
        }
        if (counter == 10 && notGuessed) {
            System.out.println("I give up.");
        }
    }

    public static void main(String[] args) {
        (new GuessingGameAdvanced()).run();
    }
}