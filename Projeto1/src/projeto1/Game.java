/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Game {

    private Army player;
    private Army enemy;

    public void create() {
        int armySize = 100, enemyArmySize = 100;
        int cycleControl = 0;
        int enemySum = 0;
        String slotsChoice = null;
        Scanner scanner = new Scanner(System.in);
        int catapultChoice = 0, infantryChoice = 0, cavalryChoice = 0, splitChoice = 0;
        int enemyCatapultChoice = 0, enemyInfantryChoice = 0, enemyCavalryChoice = 0, enemySplitChoice = 0;
        
        //CPU Army
        while (enemyArmySize > 0 && cycleControl == 0) {
            enemyCatapultChoice = new Random().nextInt(101);
            enemyArmySize -= enemyCatapultChoice;
            //System.out.println("catapultas: " + enemyCatapultChoice);
            System.out.println(enemyArmySize);

            enemyInfantryChoice = new Random().nextInt(enemyArmySize);
            enemyArmySize -= enemyInfantryChoice;
            //System.out.println("infantaria: " + enemyInfantryChoice);
            System.out.println(enemyArmySize);

            enemyCavalryChoice = new Random().nextInt(enemyArmySize);
            enemyArmySize -= enemyCavalryChoice;
            //System.out.println("cavalaria: " + enemyCavalryChoice);
            System.out.println(enemyArmySize);
            
            enemySplitChoice = new Random().nextInt(101);
            
            enemy = new Army(enemyCatapultChoice, enemyInfantryChoice, enemyCavalryChoice, enemySplitChoice);
            
            cycleControl = 1;
            //enemySum = enemyCatapultChoice + enemyInfantryChoice + enemyCavalryChoice;
            //System.out.println("soma exercito inimigo = " + enemySum);
            //System.out.println("split exercito inimigo = " + enemySplitChoice);  
        }
        

        while (armySize > 0) {
            if (armySize > 0) {
                System.out.println("You have " + armySize + " slots available.");
                System.out.println("Choose ammount of Catapult: ");

                while (true) {
                    try {
                        catapultChoice = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        scanner.nextLine();
                        System.out.println("Wrong input, please insert a number: ");
                        continue;
                    }
                }

                while (catapultChoice > armySize) {
                    System.out.println("You only have " + armySize + " slots available, choose another ammount: ");
                    while (true) {
                        try {
                            catapultChoice = scanner.nextInt();
                            break;
                        } catch (Exception e) {
                            scanner.nextLine();
                            System.out.println("Wrong input, please insert a number: ");
                            continue;
                        }
                    }
                }
                armySize -= catapultChoice;
            }
            if (armySize > 0) {
                System.out.println("You have " + armySize + " slots available.");
                System.out.println("Choose ammount of Infantry: ");

                while (true) {
                    try {
                        infantryChoice = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        scanner.nextLine();
                        System.out.println("Wrong input, please insert a number: ");
                        continue;
                    }
                }

                while (infantryChoice > armySize) {
                    System.out.println("You only have " + armySize + " slots available, choose another ammount: ");
                    while (true) {
                        try {
                            infantryChoice = scanner.nextInt();
                            break;
                        } catch (Exception e) {
                            scanner.nextLine();
                            System.out.println("Wrong input, please insert a number: ");
                            continue;
                        }
                    }

                }
                armySize -= infantryChoice;
            }
            if (armySize > 0) {
                System.out.println("You have " + armySize + " slots available.");
                System.out.println("Choose ammount of Cavalry: ");

                while (true) {
                    try {
                        cavalryChoice = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        scanner.nextLine();
                        System.out.println("Wrong ammount, please insert a number: ");
                        continue;
                    }
                }

                while (cavalryChoice > armySize) {
                    System.out.println("You only have " + armySize + " slots available, choose another ammount: ");

                    while (true) {
                        try {
                            cavalryChoice = scanner.nextInt();
                            break;
                        } catch (Exception e) {
                            scanner.nextLine();
                            System.out.println("Wrong input, please insert a number: ");
                            continue;
                        }
                    }
                }
                armySize -= cavalryChoice;
            }

            if (armySize > 0) {
                System.out.println("You still have " + armySize + " slots available. Do you wish to USE or LEAVE them?");
                slotsChoice = scanner.next();

                while (slotsChoice.contentEquals("LEAVE") == false && slotsChoice.contentEquals("leave") == false
                        && slotsChoice.contentEquals("use") == false && slotsChoice.contentEquals("USE") == false) {
                    System.out.println("Wrong choice, do you wish to USE or LEAVE them?");
                    slotsChoice = scanner.next();
                }
                if (slotsChoice.contentEquals("LEAVE") || slotsChoice.contentEquals("leave")) {
                    break;
                }
            }
        }

        System.out.println("How do you want to split your army: (%)");
        while (true) {
            try {
                splitChoice = scanner.nextInt();
                break;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Wrong input, please insert a number: ");
                continue;
            }
        }

        while (splitChoice < 1 || splitChoice > 100) {
            System.out.println("Wrong ammount, please insert a number between 1 and 100: ");

            while (true) {
                try {
                    splitChoice = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    scanner.nextLine();
                    System.out.println("Wrong input, please insert a number: ");
                    continue;
                }
            }
        }
        player = new Army(catapultChoice, infantryChoice, cavalryChoice, splitChoice);
    }

    private void inspect() {
        System.out.println("Player Attack Force: ");
        System.out.println(player.attackForce.toString());
        Collections.sort(player.attackForce);
        System.out.println("Player Attack Force Sorted: ");
        System.out.println(player.attackForce.toString());
        System.out.println("Player Defense Force: ");
        System.out.println(player.defenseForce.toString());
        System.out.println("START: " + player.attackForce + " : END");
        System.out.println("START attack: " + player.attackForce.get(0).getAttack() + " : END");
        
        //CPU Inspect
        System.out.println("Enemy Attack Force: ");
        System.out.println(enemy.attackForce.toString());
        Collections.sort(enemy.attackForce);
        System.out.println("Enemy Attack Force Sorted: ");
        System.out.println(enemy.attackForce.toString());
        System.out.println("Enemy Defense Force: ");
        System.out.println(enemy.defenseForce.toString());
    }

    private void play() {
        int attackPowerTotal = 0, defensePowerTotal = 0, luck = 0;
        System.out.println("You are about to attack!");

        for (int i = 0; i < player.attackPower.size(); i++) {
            luck = new Random().nextInt(2);
            if (luck == 1) {
                attackPowerTotal = attackPowerTotal + player.attackPower.get(i);
            }
        }

        System.out.println("Your attack force is: " + attackPowerTotal);

        for (int i = 0; i < player.defensePower.size(); i++) {
            luck = new Random().nextInt(2);
            if (luck == 1) {
                defensePowerTotal = defensePowerTotal + player.defensePower.get(i);
            }
        }

        System.out.println("Your defense power is: " + defensePowerTotal);
        
        
        //System.out.println(player.attackForce.get(0));
        
        
        
    }

    public enum Command {
        CREATE, INSPECT, PLAY, EXIT;
    }

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        Command choice = Command.CREATE;
        String line = null;
        boolean verification = false;
        System.out.println("Army Game");

        do {
            System.out.println("Choose an option: Create, Inspect, Play, Exit");

            line = scanner.next();
            line = line.toUpperCase();

            while (line.contentEquals("CREATE") == false && line.contentEquals("INSPECT") == false
                    && line.contentEquals("PLAY") == false && line.contentEquals("EXIT") == false) {
                scanner.nextLine();
                System.out.println("Wrong choice, do you want to Create, Inspect, Play or Exit");

                line = scanner.nextLine();
                line = line.toUpperCase();
            }

            if (line.contentEquals("INSPECT") == true && verification == false
                    || line.contentEquals("PLAY") == true && verification == false) {
                System.out.println("You haven't created any army yet, let's CREATE an army first.");
                line = "CREATE";
            }

            choice = Command.valueOf(line);
            switch (choice) {
                case CREATE:
                    verification = true;
                    System.out.println("CREATE");
                    game.create();
                    break;
                case INSPECT:
                    System.out.println("INSPECT");
                    game.inspect();
                    break;
                case PLAY:
                    System.out.println("PLAY");
                    game.play();
                    break;
                case EXIT:
                    System.out.println("EXIT");
                    break;
            }
        } while (choice != Command.EXIT);
    }

}
