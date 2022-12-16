
import java.io.FileWriter;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maud
 */
public class Benchmark {
        
    public Benchmark(){
    }

    public void timeCalculationBench(int mTotal, int k, int nbExecution, int intervalle){

        String DELIMITER = ",";
        String SEPARATOR = "\n";
        String HEADER = "TailleM,DuréeArrayList(milisecondes),DuréeTab(milisecondes),DuréeLinkedList(milisecondes)";
        FileWriter fileTemps;

        try
        {
          fileTemps = new FileWriter("TempsK"+k+".csv");
          //Ajouter l'en-tête
          fileTemps.append(HEADER);
          
          for(int m = 1; m <= mTotal/intervalle; m++){
              fileTemps.append(SEPARATOR);
              BloomFilter bA = new ArrayListFilter(m*intervalle,k);
              BloomFilter bT = new TabFilter(m*intervalle,k);
              BloomFilter bL = new LinkedListFilter(m*intervalle,k);
              /*for(int n=0; n<m*intervalle/2; n++){
                bA.addAObject(n);
                bT.addAObject(n);
                bL.addAObject(n);
              }*/
              /*
              bA = ajoutElementsDansLeFiltre(bA);
              bT = ajoutElementsDansLeFiltre(bT);
              bL = ajoutElementsDansLeFiltre(bL);
              */
              int[] testList = creationBancDeTest(nbExecution, m*intervalle);
              fileTemps.append(""+m*intervalle+DELIMITER+calculDuTemps(bA, testList)+
                      DELIMITER+calculDuTemps(bT, testList)+DELIMITER+calculDuTemps(bL, testList));
          }
          
          fileTemps.close();
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
    }
    
    /*
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
    */
    
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
    
    private ArrayList<Integer> creationBancDeTest2(int nbExecution, int m){
        ArrayList<Integer> testList = new ArrayList<>();
        for(int i = 0; i<nbExecution; i++){
            testList.add((int)(Math.random()*m));
        }
        return testList;
    }
    
    private int[] creationBancDeTest(int nbExecution, int m){
        int[] testList = new int[nbExecution];
        for(int i = 0; i<nbExecution; i++){
            testList[i]=(int)(Math.random()*m);
        }
        return testList;
    }

    private String calculDuTemps2(BloomFilter b, ArrayList<Integer> testList) {
        for( int n = 0; n<b.m/2; n++){
            b.addAObject(n);
        }
        long startTime = System.currentTimeMillis();
        for(int i : testList){
            b.isInFilter(i);
        }
        long endTime = System.currentTimeMillis();
        return ""+(endTime-startTime);
    }
    
    private BloomFilter ajoutElementsDansLeFiltre(BloomFilter bf){
        /*for(int n=0; n<bf.m/2; n++){
            bf.addAObject(n);
        }*/
        return bf;
    }
    
    private String calculDuTemps(BloomFilter bf, int[] test){
        int nbExecution = test.length;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < nbExecution; i++) {
            bf.isInFilter(test[i]);
        }
        long endTime = System.currentTimeMillis();
        return (endTime-startTime)+"";
    }
}
