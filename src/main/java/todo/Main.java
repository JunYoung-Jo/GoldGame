package todo;

import env.GameMap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean isEnd = false;  // for termination conditions.
        boolean isWin = false;  // for winner conditions.

        char command;   // for user input.

        /**
         * @todo Initialize Gold, Hero, and Monster objects.
         *
         * @code
         *  Gold gold = new Gold();
         *  ....
         *
         */

        while (true) {
            GameMap.drawMapWith(
                    /**
                     * @todo Input the Sprite objects here
                     *
                     * @code
                     * gold, ....
                     */
            );

            if (isEnd) break; // terminate game
            command = getCommandFrom(scanner);
            if (command == 'q') { // terminate command
                break;
            } else if (command == 'r') { // wrong command
                System.out.println("\u001B[31m" + "Please enter the correct command." + "\u001B[0m");
            } else {
                /*
                 * @todo write your code
                 *      1. Move the Hero and Monster.
                 *      2. Check the termination conditions.
                 *          2-1. if Current Gold location == Current Hero location
                 *              then win
                 *          2-2. if Current Monster location == Current Hero location
                 *              then lose
                 *          2-3. if win or lose condition is true
                 *              then isEnd = true or false, isWin = true or false
                 */
            }
        }
        if (isWin) {
            System.out.println("You Win!");
        } else {
            System.out.println("You Lose!");
        }
    }

    /**
     * Do not modify this method.
     */
    public static char getCommandFrom(Scanner scanner) {

        System.out.print("left(a), up(w), down(s), right(d), terminate(q): ");

        String input = scanner.nextLine();
        char command;

        if (input.length() != 1) {
            command = ' ';
        } else {
            command = input.toLowerCase().charAt(0);
            if ("qwasd".indexOf(command) == -1) {
                command = 'r';
            }
        }
        return command;
    }
}
