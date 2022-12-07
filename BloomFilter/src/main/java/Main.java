/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maud
 */
public class Main {
    
    public static void main(String[] args) {
        
        
        int nbElement = 5000;
        
        Benchmark bench = new Benchmark(nbElement);
        
        bench.timeCalculationM();
        
         /*
        // nombre de filtre
        int k = 1;
        // taille du tableau
        int m = 10000;
        // nombre d'élements dans le tableau
        int n = 5000;
        
        // Création de différents type de filtre avec les mêmes propriétés
        BloomFilter fT = new TabFilter(k,m);
        BloomFilter fA = new ArrayListFilter(k,m);
        BloomFilter fL = new LinkedListFilter(k, m);
        for (int i = 0; i < n; i++) {
            fT.addAObject(i);
            fA.addAObject(i);
            fL.addAObject(i);
        }
        
        // Création d'une liste d'éléments à tester pour le temps d'exécution
        int nbExecution = 100000;
        int[] elementsTest = new int[nbExecution];
        for (int i = 0; i < nbExecution; i++) {
            elementsTest[i] = ((int)(Math.random()*m*2));
        }
        
        // Appel de la fonction qui test si c'est élements sont là 
        // et qui retourne le temps que cela met
        Benchmark bench = new Benchmark();
        
        bench.timeCalculation(fT,elementsTest);
        bench.timeCalculation(fA, elementsTest);
        bench.timeCalculation(fL, elementsTest);
        
        System.out.println("");
        
        
        // Pour chaque k de 1 à 5 regarde le pourcentage d'erreur
        for (int i = 0; i < 5; i++) {
            bench.mBasedErrorTest(1000, i);
            System.out.println("");
        }*/
    }
}
