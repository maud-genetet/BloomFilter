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
        
        Benchmark bench = new Benchmark();

        int m = 1000;
        int k = 1;
        int nbExecution = 10000000;
        int intervalles = 1000;
        
        bench.timeCalculationBench(m,k,nbExecution,intervalles);
        
        nbExecution = 10000000; // Mettre minimum 10000000 pour avoir de bon resultats
       
        bench.ErrorBench(m, nbExecution);

        
    }
}
