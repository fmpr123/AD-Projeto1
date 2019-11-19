/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Fabrício and Pedro Malho
 */
public class Game {

    private Army player;
    private Army enemy;

    public void create() {

        int armySize = 100, enemyArmySize = 100;
        int cycleControl = 0;
        String slotsChoice = null;
        Scanner scanner = new Scanner(System.in);
        int catapultChoice = 0, infantryChoice = 0, cavalryChoice = 0, splitChoice = 0;
        int enemyCatapultChoice = 0, enemyInfantryChoice = 0, enemyCavalryChoice = 0, enemySplitChoice = 0;

        //CPU Army
        while (enemyArmySize > 0 && cycleControl == 0) {
            enemyCatapultChoice = new Random().nextInt(101);
            enemyArmySize -= enemyCatapultChoice;

            enemyInfantryChoice = new Random().nextInt(enemyArmySize);
            enemyArmySize -= enemyInfantryChoice;

            enemyCavalryChoice = new Random().nextInt(enemyArmySize);
            enemyArmySize -= enemyCavalryChoice;

            enemySplitChoice = new Random().nextInt(101);

            enemy = new Army(enemyCatapultChoice, enemyInfantryChoice, enemyCavalryChoice, enemySplitChoice);

            cycleControl = 1;
        }

        //PLAYER
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
                        System.out.println("Wrong input, please insert a number: ");
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
                    System.out.println("Invalid choice, do you wish to USE or LEAVE them?");
                    slotsChoice = scanner.next();
                }
                if (slotsChoice.contentEquals("LEAVE") || slotsChoice.contentEquals("leave")) {
                    break;
                }
            }
        }

        System.out.println("How do you want to split your army: (1~100(%))");
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
        if (!player.attackForce.isEmpty()) {

            //PLAYER Inspect
            System.out.println("Player Attack Force: ");
            Collections.sort(player.attackForce);
            System.out.println(player.attackForce.toString());

            System.out.println("Player Defense Force: ");
            Collections.sort(player.defenseForce);
            System.out.println(player.defenseForce.toString());

            System.out.println(" ");

            //CPU Inspect
            System.out.println("Enemy Attack Force: ");
            Collections.sort(enemy.attackForce);
            System.out.println(enemy.attackForce.toString());

            System.out.println("Enemy Defense Force: ");
            Collections.sort(enemy.defenseForce);
            System.out.println(enemy.defenseForce.toString());

        } else {
            System.out.println("You have just finished a fight, please create a new army.");
        }
    }
    
    private void play() {
        if (player.attackForce.isEmpty()==false || player.defenseForce.isEmpty()==false) {

            Scanner scanner = new Scanner(System.in);
            String line = null;
            
            Collections.sort(player.defenseForce);
            Collections.sort(enemy.defenseForce);

            int playerAttack = Combat.attackSizeOf(player.attackForce);
            int playerHealth = Combat.defenseSizeOf(player.defenseForce);
            int enemyAttack = Combat.attackSizeOf(enemy.attackForce);
            int enemyHealth = Combat.defenseSizeOf(enemy.defenseForce);
            int roundCounter = 1;

            System.out.println("The game is about to begin!");
            System.out.println("You have a theoretical attack force of " + playerAttack + ", and a defensive force of " + playerHealth);
            System.out.println("You will be fighting an enemy that has a theoretical attack force of " + enemyAttack + ", and a defensive force of " + enemyHealth);
            System.out.println(" ");

            while (playerHealth > 0 && enemyHealth > 0) {

                int playerRoundForce = Combat.attackForceRound(player.attackForce);
                int enemyRoundForce = Combat.attackForceRound(enemy.attackForce);
                playerHealth = Combat.defenseSizeOf(player.defenseForce);
                enemyHealth = Combat.defenseSizeOf(enemy.defenseForce);

                if (enemyHealth <= 0) {

                    System.out.println("Congratulations! You have won!");
                    System.out.println("Do you wish to play again? YES/NO");

                    line = scanner.next();
                    line = line.replaceAll("[0-9]", "");
                    line = line.toUpperCase();

                    while (line.contentEquals("YES") == false && line.contentEquals("NO") == false) {
                        
                        System.out.println("Invalid choice, do you wish to play again? YES/NO");

                        line = scanner.next();
                        line = line.replaceAll("[0-9]", "");
                        line = line.toUpperCase();
                    }

                    if (line.contentEquals("YES") == true) {
                        break;
                    } else if (line.contentEquals("NO")) {
                        System.exit(0);
                    }

                } else if (playerHealth <= 0) {
                    
                    System.out.println("Your enemy has bested you.");
                    System.out.println("Do you wish to play again? YES/NO");

                    line = scanner.next();
                    line = line.replaceAll("[0-9]", "");
                    line = line.toUpperCase();

                    while (line.contentEquals("YES") == false && line.contentEquals("NO") == false) {
                        
                        System.out.println("Wrong choice, do you wish to play again? YES/NO");

                        line = scanner.next();
                        line = line.replaceAll("[0-9]", "");
                        line = line.toUpperCase();
                    }

                    if (line.contentEquals("YES") == true) {
                        break;
                    } else if (line.contentEquals("NO")) {
                        System.exit(0);
                    }
                }

                System.out.println("Round " + roundCounter + " begins!");
                System.out.println("You will be attacking with a force of " + playerRoundForce + " and your enemy has " + enemyHealth + " of defensive forces!");
                Combat.attackStart(playerRoundForce, enemy.defenseForce);
                System.out.println("The enemy retaliates with a force of " + enemyRoundForce + " and you're defending with " + playerHealth + " of defensive forces!");
                Combat.attackStart(enemyRoundForce, player.defenseForce);

                roundCounter++;
                System.out.println(" ");
            }

            player.attackForce.clear();
            player.defenseForce.clear();
            enemy.attackForce.clear();
            enemy.defenseForce.clear();
            
        } else {
            System.out.println("You don't units in your army, please create a new one.");
        }
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
            line = line.replaceAll("[0-9]", "");
            line = line.toUpperCase();

            while (line.contentEquals("CREATE") == false && line.contentEquals("INSPECT") == false
                    && line.contentEquals("PLAY") == false && line.contentEquals("EXIT") == false) {

                scanner.nextLine();

                System.out.println("Wrong choice, do you want to Create, Inspect, Play or Exit");

                line = scanner.nextLine();
                line = line.replaceAll("[0-9]", "");
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
