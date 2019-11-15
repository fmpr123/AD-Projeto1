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

    public void create() {
        int armySize = 100;
        String slotsChoice = "";
        Scanner scanner = new Scanner(System.in);
        int catapultChoice = 0, infantryChoice = 0, cavalryChoice = 0, splitChoice = 0;

        while (armySize > 0) {
            if (armySize > 0) {
                System.out.println("You have " + armySize + " slots available.");
                System.out.println("Choose ammount of Catapult: ");
                catapultChoice = scanner.nextInt();
                while (catapultChoice > armySize) {
                    System.out.println("You only have " + armySize + " slots available, choose another ammount: ");
                    catapultChoice = scanner.nextInt();
                }
                armySize -= catapultChoice;
            }
            if (armySize > 0) {
                System.out.println("You have " + armySize + " slots available.");
                System.out.println("Choose ammount of Infantry: ");
                infantryChoice = scanner.nextInt();
                while (infantryChoice > armySize) {
                    System.out.println("You only have " + armySize + " slots available, choose another ammount: ");
                    infantryChoice = scanner.nextInt();
                }
                armySize -= infantryChoice;
            }
            if (armySize > 0) {
                System.out.println("You have " + armySize + " slots available.");
                System.out.println("Choose ammount of Cavalry: ");
                cavalryChoice = scanner.nextInt();
                while (cavalryChoice > armySize) {
                    System.out.println("You only have " + armySize + " slots available, choose another ammount: ");
                    cavalryChoice = scanner.nextInt();
                }
                armySize -= cavalryChoice;
            }
            if (armySize > 0) {
                System.out.println("You still have " + armySize + " slots available. Do you wish to USE or LEAVE them?");
                slotsChoice = scanner.next();
                if (slotsChoice.contains("LEAVE") || slotsChoice.contains("leave")) {
                    break;
                }
            }
        }
        
        System.out.println("How do you want to split your army: (%)");
        splitChoice = scanner.nextInt();
        player = new Army(catapultChoice, infantryChoice, cavalryChoice, splitChoice);
    }

    private void inspect() {
        System.out.println("Attack Force: ");
        System.out.println(player.attackForce.toString());
        System.out.println("Defense Force: ");
        System.out.println(player.defenseForce.toString());
    }

    private void play() {
        int attackPowerTotal = 0, defensePowerTotal = 0;
        System.out.println("You are about to attack!");
        System.out.println("Your attack force is: ");

        for (int i = 0; i < player.attackPower.size(); i++) {
            attackPowerTotal = attackPowerTotal + player.attackPower.get(i);
        }

        System.out.println(attackPowerTotal);
        System.out.println("Your defense power is: ");

        for (int i = 0; i < player.defensePower.size(); i++) {
            defensePowerTotal = defensePowerTotal + player.defensePower.get(i);
        }

        System.out.println(defensePowerTotal);
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
                    game.play();
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
