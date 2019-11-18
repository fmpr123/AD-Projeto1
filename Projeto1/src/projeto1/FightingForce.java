/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1;

import java.util.Objects;

/**
 *
 * @author Turma A
 */
public class FightingForce implements Comparable<FightingForce>{
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
    
    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getAttack() {
        return attack;
    }
    
    public int getDefense() {
        return defense;
    }

    public int getLuck() {
        return luck;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        final FightingForce other = (FightingForce) obj;
        
        return attack == other.attack && defense == other.defense;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attack, defense);
    }

    @Override
    public int compareTo(final FightingForce another) {
        return getAttack() - another.getAttack();
    }

    @Override
    public String toString() {
        return "Attack: " + this.attack + " | Defense: " + this.defense;
    }
    
    
}
