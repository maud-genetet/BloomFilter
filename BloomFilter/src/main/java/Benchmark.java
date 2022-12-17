
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

    public void timeCalculationBench(int mMax, int k, int nbExecution, int intervalle){

        String DELIMITER = ",";
        String SEPARATOR = "\n";
        String HEADER = "TailleM,DuréeArrayList(milisecondes),DuréeTab(milisecondes),DuréeLinkedList(milisecondes)";
        FileWriter fileTemps;

        try
        {
          fileTemps = new FileWriter("TempsK"+k+"nbExec"+nbExecution+"mMax"+mMax+"intervalle+"+intervalle+"enMillisecondes.csv");
          //Ajouter l'en-tête
          fileTemps.append(HEADER);
          
          for(int m = 1; m <= mMax/intervalle; m++){
              fileTemps.append(SEPARATOR);
              BloomFilter bA = new ArrayListFilter(k,m*intervalle);
              BloomFilter bT = new TabFilter(k,m*intervalle);
              BloomFilter bL = new LinkedListFilter(k,m*intervalle);
             
              bA = ajoutElementsDansLeFiltre(bA);
              bT = ajoutElementsDansLeFiltre(bT);
              bL = ajoutElementsDansLeFiltre(bL);
              
              int[] testList = creationBancDeTest(nbExecution, m*intervalle);
              fileTemps.append(m*intervalle+DELIMITER+calculDuTemps(bA, testList)+
                      DELIMITER+calculDuTemps(bT, testList)+DELIMITER+calculDuTemps(bL, testList));
          }
          
          fileTemps.close();
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
    }
    
    public void ErrorBench(int mTotal, int nbExecution){

        String DELIMITER = ",";
        String SEPARATOR = "\n";
        String HEADER = "PourcentageNdansM,nbErrorK1,nbErrorK2,nbErrorK3,nbErrorK4,nbErrorK5";
        FileWriter fileError;

        try
        {
          fileError = new FileWriter("ErrorM"+mTotal+"nbExec"+nbExecution+"En%.csv");
          //Ajouter l'en-tête
          fileError.append(HEADER);
          
          int[] test = creationBancDeTest(nbExecution, (mTotal*100-mTotal+1)+mTotal);
          for(int i=1; i<=100; i++){
              fileError.append(SEPARATOR);
              String s = ""+i;
              for(int K = 1; K<=5; K++){
                  BloomFilter bf = new ArrayListFilter(K,mTotal);
                  bf = ajoutPourcentageElementsAleatoire(bf, i);
                  s += DELIMITER+nbErrorCalcul(bf,test);
              }
              fileError.append(s);
          }
          
          
          fileError.close();
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
    }
    
    private int[] creationBancDeTest(int nbExecution, int m){
        int[] testList = new int[nbExecution];
        for(int i = 0; i<nbExecution; i++){
            testList[i]=(int)(Math.random()*m);
        }
        return testList;
    }
    
    private BloomFilter ajoutElementsDansLeFiltre(BloomFilter bf){
        for(int n=0; n<bf.m/2; n++){
            bf.addAObject(n);
        }
        return bf;
    }
    
    private BloomFilter ajoutPourcentageElementsAleatoire(BloomFilter bf, int pourcentage){
        for(int n=0; n<pourcentage; n++){
            bf.addAObject(n);
        }
        return bf;
    }
    
    private int calculDuTemps(BloomFilter bf, int[] test){
        int nbExecution = test.length;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < nbExecution; i++) {
            bf.isInFilter(test[i]);
        }
        long endTime = System.currentTimeMillis();
        return (int)(endTime-startTime);
    }

    private int nbErrorCalcul(BloomFilter bf, int[] test) {
        int nbError = 0;
        for(int i = 0; i<test.length; i++){
            if (bf.isInFilter(test[i])){
                nbError++;
            }
        }
        return nbError/100;
    }
    
}
