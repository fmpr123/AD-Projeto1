/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1;

import java.util.*;

/**
 *
 * @author Pedro Malho
 */
public class Combat {

    public static int defenseSizeOf(ArrayList<FightingForce> army) {
        int total = 0;

        for (int i = 0; i < army.size(); i++) {
            total += army.get(i).getDefense();
        }

        return total;
    }

    public static int attackSizeOf(ArrayList<FightingForce> army) {
        int total = 0;

        for (int i = 0; i < army.size(); i++) {
            total += army.get(i).getAttack();
        }

        return total;
    }

    public static int attackForceRound(ArrayList<FightingForce> army) {
        int total = 0;

        for (int i = 0; i < army.size(); i++) {
            int luck = new Random().nextInt(2);
            army.get(i).setLuck(luck);
            if (army.get(i).getLuck() == 1) {
                total += army.get(i).getAttack();
            }
        }

        return total;
    }

    public static ArrayList attackStart(int attack, ArrayList<FightingForce> army) {
        int defenseValue = 0;

        while (defenseValue < attack) {
            if (army.size() == 0) {
                break;
            }
            defenseValue += army.get(0).getDefense();
            army.remove(0);
        }

        return army;
    }
}
