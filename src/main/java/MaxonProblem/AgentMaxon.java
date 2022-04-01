/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MaxonProblem;

import jade.core.Agent;

/**
 *
 * @author luisjimenezmendoza
 */
public class AgentMaxon extends Agent{
    @Override
    protected void setup() {
    System.out.println("Hola, soy "+getAID().getName()+" y he iniciado");
    addBehaviour(new MaxonBehaviour());
    }
}
