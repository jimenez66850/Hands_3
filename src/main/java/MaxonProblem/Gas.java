/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MaxonProblem;

import java.util.ArrayList;

/**
 *
 * @author luisjimenezmendoza
 */
public class Gas {

    private ArrayList<Population> populationArray;
    private int mutationRate = 5, crossOverRate = 95, populationSize = 10, chromosomeSize = 9, elitismRate = 2,generation = 0, iterations = 1000;
    
    public Gas() {
        populationArray = new ArrayList<>();
    }
    
    public Gas(int _mutationRate,int _crossOverRate,int _populationSize,int _chromosomeSize,int _elitismRate,int _iterations){
        populationArray = new ArrayList<>();
        mutationRate = _mutationRate;
        crossOverRate = _crossOverRate;        
        populationSize = _populationSize;
        chromosomeSize = _chromosomeSize;
        elitismRate = _elitismRate;
        iterations = _iterations;
    }

    private Population setInitialPopulation() {
        Population individual = new Population();
        String _chromosome = "";
        for (int i = 0; i < populationSize; i++) {
            for (int j = 0; j < chromosomeSize; j++) {
                _chromosome += String.valueOf((int) ((Math.random() * 2)));
            }
            individual.pushChromosome(new Chromosome(_chromosome,mutationRate));
            _chromosome = "";
        }
        individual.setFitness();
        individual.setGeneration(0);
        return individual;
    }

    private void setParents(Population newPopulation) {
        for (int i = elitismRate; i < populationSize; i++) {
            newPopulation.pushChromosome(populationArray.get(generation).getChromosome(populationSize - i-1));
        }
    }

    private Chromosome selectParent(Population parents) {
        int roulettePersentage = (int) (Math.random() * parents.getRoulettePersentage()) + 1;
        for (int i = 0; i < parents.size(); i++) {
            if (roulettePersentage <= parents.getChromosome(i).getRoulettePersentage()) {
                return parents.getChromosome(i);
            }
        }
        return null;
    }

    private Chromosome crossOver(Chromosome parent1, Chromosome parent2) {
        int crossOverCut = (int) (Math.random() * (chromosomeSize - 2) + 2);
        return new Chromosome(parent1.getContent().substring(0, crossOverCut) + parent2.getContent().substring(crossOverCut, chromosomeSize),mutationRate);

    }

    private void crossOver(Population Parents, Population newPopulation) {
        for (int i = 0; i < Parents.size(); i++) {
            if (crossOverRate > (int) (Math.random() * 100) + 1) {
                newPopulation.pushChromosome(crossOver(Parents.getChromosome(i), selectParent(Parents)));
            } else {
                newPopulation.pushChromosome(Parents.getChromosome(i));
            }
        }

    }

    public void runGas() {
        int _iterations = 0;
        Population newPopulation;
        Population parents;
        populationArray.add(setInitialPopulation());
        System.out.println(populationArray.get(generation).toString());
        while (!populationArray.get(generation).isTheAnswer() && _iterations < iterations) {
            populationArray.get(generation).sortByFitness();
            newPopulation = new Population();
            parents = new Population();
            for (int i = 0; i < elitismRate; i++) {
                newPopulation.pushChromosome(populationArray.get(generation).getChromosome(populationSize - 1 - i));
            }
            setParents(parents);
            parents.setFitness();
            parents.setRoulettePersentageValues();
            crossOver(parents, newPopulation);
            newPopulation.mutatePopulation();
            newPopulation.setFitness();
            populationArray.add(new Population(newPopulation, generation + 1));
            generation++;
            System.out.println(populationArray.get(generation).toString());
            _iterations++;
        }
        if (_iterations >= iterations) {
            System.out.println("El programa ha alcanzado su maximo de iteraciones, arrojando los siguientes resultados");
            System.out.println("Generacion: " + String.valueOf(generation));
            System.out.println("Poblacion: ");
            System.out.println(populationArray.get(generation).toString());
        } else {
            System.out.println("El programa dio los siguientes resultados");
            System.out.println("Generacion: " + String.valueOf(generation));
            System.out.println("Poblacion: ");
            System.out.println(populationArray.get(generation).toString());
        }

    }

}
