/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1;

/**
 *
 * @author Turma A
 */
public class FightingForce {
   private int attack;
   private int defense;
   private int luck;

    public FightingForce() {
    }

    public FightingForce(int attack, int defense, int luck) {
        this.attack = attack;
        this.defense = defense;
        this.luck = luck;
    }
    
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public int getLuck() {
        return luck;
    }

    public int getDefense() {
        return defense;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }
    
    
   
}
