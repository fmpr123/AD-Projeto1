/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Turma A
 */
public class Army {
  ArrayList<FightingForce> attackForce;
  ArrayList<FightingForce> defenseForce;
  ArrayList<Integer> attackPower = new ArrayList<Integer>();
  ArrayList<Integer> defensePower = new ArrayList<Integer>();
    
    public Army() {
        attackForce = new ArrayList<>();
        defenseForce=new ArrayList<>();
    }

    public Army(int catapult, int infantry, int cavalry,int side) {
        attackForce = new ArrayList<>();
        defenseForce=new ArrayList<>();
        
        for (int i = 1; i < catapult; i++) {
            if(new Random().nextInt()*100<side){
                attackForce.add(new Catapult());
                attackPower.add(70);
            }else{
                defenseForce.add(new Catapult());
                defensePower.add(1);
            }
        }
        for (int i = 1; i < infantry; i++) {
            if(new Random().nextInt()*100<side){
                attackForce.add(new Infantry());
                attackPower.add(25);
            }else{
                defenseForce.add(new Infantry());
                defensePower.add(75);
            }
        }
        for (int i = 1; i < cavalry; i++) {
            if(new Random().nextInt()*100<side){
                attackForce.add(new Cavalry());
                attackPower.add(50);
            }else{
                defenseForce.add(new Cavalry());
                defensePower.add(50);
            }
        }
    }

    @Override
    public String toString() {
        return attackForce.get(0).toString();
    }
}
