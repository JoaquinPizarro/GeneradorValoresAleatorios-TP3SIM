/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generador;

import java.util.ArrayList;

/**
 *Clase encargada de generar series de números aleatorios según el método
 * especificado
 */
public class Generador {
    int seed;
    int a;
    int c;
    int m;
    int método;

    public Generador() {
    }

    public Generador(int seed, int a, int c, int m, int método) {
        this.seed = seed;
        this.a = a;
        this.c = c;
        this.m = m;
        this.método = método;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getMétodo() {
        return método;
    }

    public void setMétodo(int método) {
        this.método = método;
    }
    
    /**
     * método que genera series de números aleatorios
     * @param cantidad
     * @return lista de números aleatorios
     */
    public ArrayList generarNúmero(int cantidad){
        ArrayList <Integer> lista = new ArrayList<>();
        int rdm = seed;
        
        //Si está seleccionado el método multiplicativo, hace c=0
        if(método==1){
            c=0;
        }
        
        //aplica la fórmula para generar números aleatorios y los agrega a 
        //una lista
            for (int i = 0; i < cantidad; i++) {
                rdm=(a*rdm+c)%m;
                lista.add(rdm);
            }
        
        return lista;
    }
    /**
     * Método que genera un único numero aleatorio tomando como semilla
     * el último numero generado en la serie y sus parámetros
     * @param numero
     * @return 
     */
    public int generarSiguiente(int numero){
        numero=(a*numero+c)%m;
        return numero;
    }
    
    /**
     * Método que genera una serie de números aleatorios utilizando la función
     * Math.random() de java
     * @param número cantidad de números a generar
     * @return Lista de numeros aleatorios generados con Math.random()
     */
    public ArrayList generarMathRandom(int número){
        ArrayList <Integer> lista = new ArrayList<>();
        for (int i = 0; i < número; i++) {
            lista.add((int) (Math.random() * 10000));
        }
        return lista;
    }
}
