package main.java;

import java.util.Scanner;

/**
 * Manages the exchange of user input and program output.
 */
public class Ui {
    public static final String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    protected Scanner sc;
    protected TaskList tasks;

    Ui(Scanner sc) {
        this.sc = sc;
        this.tasks = null;
    }

    /**
     * Initialises the user interface on startup.
     *
     * @param tasks List of tasks.
     */
    public void initialise(TaskList tasks) {
        this.tasks = tasks;
        System.out.println("Hello from\n" + logo);
        System.out.println("Please input a command.");
    }

    /**
     * Continuously takes in user input and passes it to a parser to get program output.
     * Stops when given a specific input by user.
     */
    public void run() {
        while (true) {
            String input = sc.nextLine();
            System.out.println("  ~~~");
            String output = "";
            try {
                output = Parser.process(input, this.tasks);
            } catch (DukeException ex) {
                System.out.println(ex);
            }
            if (output == null) {
                System.out.println("  See you next time.");
                System.out.println("  ~~~");
                break;
            }
            System.out.print(output);
            System.out.println("  ~~~");
        }
    }
}