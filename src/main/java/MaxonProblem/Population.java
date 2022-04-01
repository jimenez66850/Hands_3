/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MaxonProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author luisjimenezmendoza
 */
public class Population {

    private ArrayList<Chromosome> dna;
    private int generation, fitness, roulette;

    public Population() {
        dna = new ArrayList<>();
        generation = 0;
        fitness = 0;
        roulette = 0;
    }

    public Population(Population _population, int _generation) {
        dna = new ArrayList<>(_population.getDna());
        generation = _generation;
        setFitness();
    }

    public ArrayList<Chromosome> getDna() {
        return dna;
    }

    public void setRoulettePersentageValues() {
        int _roulette = 0;
        float division;
        for (int i = 0; i < dna.size(); i++) {
            division = ((float) dna.get(i).getFitness() / (float) fitness);
            _roulette += (int) (division * 100);
            dna.get(i).setRoulettePersentage(_roulette);
        }
        roulette = _roulette;

    }

    public int getRoulettePersentage() {
        return roulette;
    }

    public void mutatePopulation() {
        for (int i = 0; i < dna.size(); i++) {
            dna.get(i).mutate();
        }
    }

    public int size() {
        return dna.size();
    }

    public void pushChromosome(Chromosome chromosome) {
        dna.add(chromosome);
    }

    public Chromosome getChromosome(int index) {
        return dna.get(index);
    }

    public void setChromosome(int index, Chromosome chromosome) {
        dna.add(index, chromosome);
    }

    public void setGeneration(int _generation) {
        generation = _generation;
    }

    public int getGeneration() {
        return generation;
    }

    public void sortByFitness() {
        Collections.sort(dna, new Comparator<Chromosome>() {
            @Override
            public int compare(Chromosome p1, Chromosome p2) {
                return new Integer(p1.getFitness()).compareTo(new Integer(p2.getFitness()));
            }
        });
    }

    public boolean isTheAnswer() {
        for (int i = 0; i < dna.size(); i++) {
            if (dna.get(i).isTheAnswer()) {
                return true;
            }
        }
        return false;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness() {
        int _fitness = 0;
        for (int i = 0; i < dna.size(); i++) {
            _fitness += dna.get(i).getFitness();
        }
        fitness = _fitness;
    }

    @Override
    public String toString() {
        String _content = "";
        for (int i = 0; i < dna.size(); i++) {
            _content += dna.get(i).toString() + "\n";
        }
        _content += "Population fitness = " + String.valueOf(fitness);
        return _content;
    }

}
