/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MaxonProblem;

import jade.core.behaviours.Behaviour;

/**
 *
 * @author luisjimenezmendoza
 */
public class MaxonBehaviour extends Behaviour {

    @Override
    public void action() {
        Gas algoritmogenetico = new Gas();
        algoritmogenetico.runGas();
    }

    @Override
    public boolean done() {
        return true;
    }


}
