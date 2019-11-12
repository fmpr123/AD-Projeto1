/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Game {

    private Army player;
    private Army enemy;

    private void inspect() {
        System.out.println(player.toString());
    }

    public void create() {
        int armySize;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose ammount of Catapult: ");
        int catapultChoice = scanner.nextInt();
        System.out.println("Choose ammount of Infantry: ");
        int infantryChoice = scanner.nextInt();
        System.out.println("Choose ammount of Cavalry: ");
        int cavalryChoice = scanner.nextInt();
        System.out.println("How do you want to split your army: (%)");
        int splitChoice = scanner.nextInt();
        player = new Army(catapultChoice, infantryChoice, cavalryChoice, splitChoice);
    }
    
    public enum Command {
        CREATE, INSPECT, PLAY, EXIT;
    }

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Army Game");
        Scanner scanner = new Scanner(System.in);
        Command choice = Command.CREATE;
        do {
            System.out.println("Choose an option: Create, Inspect, Play, Exit");

            String line = scanner.nextLine();
            choice = Command.valueOf(line);

            switch (choice) {
                case CREATE:
                    System.out.println("create");
                    game.create();
                    break;
                case INSPECT:
                    System.out.println("inspect");
                    game.inspect();
                    break;
                case PLAY:
                    System.out.println("play");
                    break;
                case EXIT:
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (choice != Command.EXIT);
    }

}
