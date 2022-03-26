/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.handon_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author luisjimenezmendoza
 */
public class Population {
    private ArrayList<Chromosome> Dna;
    private int generation;
    
    public Population(){
        Dna = new ArrayList<>();
        generation = 0;
    }
    
    
    public Population(ArrayList<Chromosome> _Dna,int _generation){
        Dna = new ArrayList<>(_Dna);
        generation = _generation;
    }
    
    public void pushChromosome(Chromosome chromosome){
        Dna.add(chromosome);
    }
    
    public Chromosome getChromosome(int index){
        return Dna.get(index);
    }
    
    public void setChromosome(int index, Chromosome chromosome){
        Dna.add(index, chromosome);
    }
    
    public void setGeneration(int _generation){
        generation = _generation;
    }
    
    public void sortByFitness(){
        Collections.sort(Dna, new Comparator<Chromosome>() {
	@Override
	public int compare(Chromosome p1, Chromosome p2) {
            return new Integer(p1.getFitness()).compareTo(new Integer(p2.getFitness()));
            }
        });
    }
}
