/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.handon_3;

import java.util.ArrayList;

/**
 *
 * @author luisjimenezmendoza
 */
public class Gas {
    private ArrayList<Population> populationArray = new ArrayList<>();
    private int populationSize,chromosomeSize;
    
    private void setInitialPopulation(){
        Population individual = new Population();
        String _chromosome="";
        for(int i=0;i<populationSize;i++){
            for(int j=0;j<chromosomeSize;j++)
                _chromosome+= String.valueOf((int)(Math.random()*2));
            individual.pushChromosome(new Chromosome(_chromosome));
            _chromosome="";
        }
        populationArray.add(individual);
    }
}
