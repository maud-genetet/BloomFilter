/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maud
 */
public class Main extends ToolsForStatistics {
    
    public static void main(String[] args) {
               
        int k = 1;
        int m = 10000;
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
        timeCalculation(fT,elementsTest);
        timeCalculation(fA, elementsTest);
        timeCalculation(fL, elementsTest);
        
   
        
        
        // Pour chaque k de 1 à 5 regarde le pourcentage d'erreur
        for (int i = 0; i < 5; i++) {
            mBasedErrorTest(1000, i);
        }
    }
}
