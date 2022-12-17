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

        int m = 10000;
        int k = 1;
        int nbExecution = 100000;  //100000
        int intervalles = 100;
        
        bench.timeCalculationBench(m,k,nbExecution,intervalles);
        
        m = 10000; 
        nbExecution = 10000; 
       
        bench.ErrorBench(m, nbExecution);
    }
}
