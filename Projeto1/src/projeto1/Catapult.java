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
public class Catapult extends FightingForce {

    public Catapult() {
        super(100, 1, 0);
    }
    
    @Override
    public String toString() {
        return "Catapult - Attack: " + getAttack() + " Defense: "+getDefense();
    }

}
