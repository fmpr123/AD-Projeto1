/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Turma A
 */
public class Army {
    ArrayList<FightingForce> attackForce;
    ArrayList<FightingForce> defenseForce;
    
    ArrayList<Integer> attackPower = new ArrayList<>();
    ArrayList<Integer> defensePower = new ArrayList<>();
    
    public Army() {
        attackForce = new ArrayList<>();
        defenseForce = new ArrayList<>();
    }

    public Army(int catapult, int infantry, int cavalry, int side) {
        attackForce = new ArrayList<>();
        defenseForce = new ArrayList<>();

        for (int i = 0; i < catapult; i++) {
            if (new Random().nextInt(101) < side) {
                attackForce.add(new Catapult());
                attackPower.add(70);
            } else {
                defenseForce.add(new Catapult());
                defensePower.add(1);
            }
        }
        for (int i = 0; i < infantry; i++) {
            if (new Random().nextInt(101) < side) {
                attackForce.add(new Infantry());
                attackPower.add(25);
            } else {
                defenseForce.add(new Infantry());
                defensePower.add(75);
            }
        }
        for (int i = 0; i < cavalry; i++) {
            if (new Random().nextInt(101) < side) {
                attackForce.add(new Cavalry());
                attackPower.add(50);
            } else {
                defenseForce.add(new Cavalry());
                defensePower.add(50);
            }
        }
    }
}
