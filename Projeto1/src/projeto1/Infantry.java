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
public class Infantry extends FightingForce{

    public Infantry() {
        super(25, 75, 0);
    }

    @Override
    public String toString() {
        return "Infantry - " + super.toString();
    }
    
}
