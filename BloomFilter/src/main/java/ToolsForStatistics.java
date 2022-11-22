/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maud
 */
public abstract class ToolsForStatistics {

    public static void timeCalculation(BloomFilter bf, int[] test){
        int nbExecution = test.length;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < nbExecution; i++) {
            bf.isInFilter(test[i]);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total time elapsed for "+nbExecution+" execution for a "
                +bf.toString()+ " with k = "+bf.k+" m = "+bf.m+" and n = "+bf.n+" is : "
                + (endTime-startTime) + " millisecondes");
    }
    
    public static void mBasedErrorTest(int n, int k){
        
        int nbExecution = 100000;

        // Creation of benchmark
        int nbError;
        BloomFilter f;
        /*
        int m1 = n*100; // n is 1% of m
        int m5 = n*20; // n is 5% of m
        int m10 = n*10; // n is 10% of m
        int m[] = {m1,m5,m10};
        */
        for (int i = 1; i <= 10; i++) {
            
            int m = (int)(n*100/i);
            f = new ArrayListFilter(k,m);
            for (int a = 0; a < n; a++) {
                f.addAObject(a);
            }
            
            // Test 
            nbError = 0;
            for (int j = 0; j < nbExecution; j++) {
                if (f.isInFilter((int)(Math.random()*(n*100-n+1)+n))){
                    nbError ++;
                }
            }
            System.out.println("With n = "+n+" "+i+"% of m, m = "+m+" and k = "+k
                    +" we have a percentage of "+(nbError*100/nbExecution)+"% of errors");
        }
    }
    
    public static void kBasedErrorTest(int n, int m){
        
        int nbExecution = 100000;

        // Creation of benchmark
        int nbError;
        BloomFilter f;
        
        for (int k = 0; k < 5; k++) {
            
            f = new ArrayListFilter(k,m);
            for (int a = 0; a < n; a++) {
                f.addAObject(a);
            }
            
            // Test 
            nbError = 0;
            for (int j = 0; j < nbExecution; j++) {
                if (f.isInFilter((int)(Math.random()*(n*100-n+1)+n))){
                    nbError ++;
                }
            }
            System.out.println("With m = "+m +" n = "+n+" and k = "+k
                    +" we have a percentage of "+(nbError*100/nbExecution)+"% of errors");
        }
    }
    
    /*public void test(){
        int tab[] = new int[10000];
        for (int i = 0; i < 5000; i++) {
            tab[i]=i;
        }
        int nbExecution = 100000;
        long startTime = System.currentTimeMillis();
        Boolean t;
        int a;
        int mystere;
        for (int i = 0; i < nbExecution; i++) {
            t = false;
            a = 0;
            mystere = (int)(Math.random()*10000);
            while (!t && a < 10000){
                if (tab[a]==mystere){
                    t = true;
                }
                a++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime) + " millisecondes");
    }*/
}
