import java.util.*;

class Timer extends Thread {
    private long startTime;
    private boolean running;

    // Start the timer
    public void begin() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }

    // Stop the timer
    public void end() {
        this.running = false;
    }

    // Get elapsed time in seconds
    public long elapsedTime() {
        return (System.currentTimeMillis() - startTime) / 1000;
    }

    // Continuously print elapsed time every second
    public void run() {
        while (running) {
            
            System.out.print("\rTime elapsed: " + elapsedTime() + " seconds");
            try {
                Thread.sleep(1000);  // Update every second
            } catch (InterruptedException e) {
                System.out.println("Timer interrupted");
            }
        }
    }
}

public class Game {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String mystery_word = "password";
        String guess = "";

        // Display the intro and wait for the user to start the game
        System.out.println("░██████╗░██╗░░░██╗███████╗░██████╗░██████╗██╗███╗░░██╗░██████╗░  ░██████╗░░█████╗░███╗░░░███╗███████╗");
        System.out.println("██╔════╝░██║░░░██║██╔════╝██╔════╝██║████╗░██║██╔════╝░  ██╔════╝░██╔══██╗████╗░████║██╔════╝");
        System.out.println("██║░░██╗░██║░░░██║█████╗░░╚█████╗░██║██╔██╗██║██║░░██╗░  ██║░░██╗░███████║██╔████╔██║█████╗░░");
        System.out.println("██║░░╚██╗██║░░░██║██╔══╝░░░╚═══██╗██║██║╚████║██║░░╚██╗  ██║░░╚██╗██╔══██║██║╚██╔╝██║██╔══╝░░");
        System.out.println("╚██████╔╝╚██████╔╝███████╗██████╔╝██║██║░╚███║╚██████╔╝  ╚██████╔╝██║░░██║██║░╚═╝░██║███████╗");
        System.out.println("░╚═════╝░░╚═════╝░╚══════╝╚═════╝░╚═╝╚═╝░░╚══╝░░╚═════╝░  ░╚═════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝");
        System.out.println("Press Enter to begin the game.");
        in.nextLine();

        // Start the timer
        Timer timer = new Timer();
        timer.begin();
        timer.start();
        System.out.println("");

        // Run the guessing game loop
        while (!mystery_word.equals(guess)) {
            System.out.println("Enter your guess:");
            guess = in.nextLine();
            
            if (!mystery_word.equals(guess)) {
                System.out.println("Incorrect guess, try again!");
            }
        }

        // End the timer when the correct word is guessed
        timer.end();
        System.out.println("\nCongratulations! You've guessed the word.");
        System.out.println("Total time taken: " + timer.elapsedTime() + " seconds");
    }
}
