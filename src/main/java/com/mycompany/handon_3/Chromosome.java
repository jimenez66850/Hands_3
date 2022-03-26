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
    private int fitness=0;
    private String content;
    
    
    public Chromosome(String _content){
        content = _content;
        setFitness();
    }
    
    
    public void setFitness(){
        int _fitness=0;
        for(int i=0; i<content.length(); i++)
            if(content.charAt(i)=='1')
                _fitness++;
        fitness = _fitness;
    }
    
    
    public void mutate(){
        String _content="";
        for(int i=0;i<content.length();i++){
            int numero = (int)(Math.random()*100);
            if(numero<5){
                if(content.charAt(i)=='1')
                    _content+='0';
                else
                    _content+='1';
            }
            else
                _content+=content.charAt(i);
        }
        content = _content;
    }

    
    public int getFitness() {
        return fitness;
    }

    
    public String getContent() {
        return content;
    }


    
}
