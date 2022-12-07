
import java.io.FileWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maud
 */
public class Benchmark {
    
    int nbElem;
    
    public Benchmark(int nbElements){
        this.nbElem = nbElements;
    }

    public void timeCalculationM(){

        String DELIMITER = ",";
        String SEPARATOR = "\n";
        String HEADER = "Title,Author,Year";
        FileWriter file = null;

        try
        {
          file = new FileWriter("time.csv");
          //Ajouter l'en-tête
          file.append("coucou");
          //Ajouter une nouvelle ligne après l'en-tête
          file.append(SEPARATOR);
          

          file.close();
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
        
        long startTime = System.currentTimeMillis();
       
        long endTime = System.currentTimeMillis();
        
    }
    
    public void mBasedErrorTest(int n, int k){
        
        int nbExecution = 100000;

        // Creation of benchmark
        int nbError;
        BloomFilter f;

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
            System.out.println("With n = "+n+" "+i+"% of m, m = "+m+" and k = "+(k+1)
                    +" we have a percentage of "+(nbError*100/nbExecution)+"% of errors");
        }
    }
    
    public void kBasedErrorTest(int n, int m){
        
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
}
