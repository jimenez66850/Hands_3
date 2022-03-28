/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.handon_3;

/**
 *
 * @author luisjimenezmendoza
 */
public class Chromosome {

    private int fitness = 0,roulettePersentage,mutationRate;
    private String content;

    public Chromosome(String _content,int _mutationRate) {
        content = _content;
        setFitness();
        roulettePersentage = 0;
        mutationRate = _mutationRate;
    }

    public void setRoulettePersentage(int roulettePersentage) {
        this.roulettePersentage = roulettePersentage;
    }

    public int getRoulettePersentage() {
        return roulettePersentage;
    }

    public void setFitness() {
        int _fitness = 0;
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '1') {
                _fitness++;
            }
        }
        fitness = _fitness;
    }

    public void mutate() {
        String _content = "";
        for (int i = 0; i < content.length(); i++) {
            int numero = (int) (Math.random() * 100);
            if (numero < mutationRate) {
                if (content.charAt(i) == '1') {
                    _content += '0';
                } else {
                    _content += '1';
                }
            } else {
                _content += content.charAt(i);
            }
        }

        content = _content;
        setFitness();
    }

    public int getFitness() {
        return fitness;
    }

    public String getContent() {
        return content;
    }

    public boolean isTheAnswer() {
        for (int i = 0; i < content.length(); i++) {
            if (fitness == content.length()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "[ " + content + " ] ---> " + String.valueOf(fitness);
    }
}
