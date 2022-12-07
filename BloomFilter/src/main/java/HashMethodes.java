
import static java.lang.Math.abs;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maud
 */
public class HashMethodes{
    
    int tailleTab;
    
    public HashMethodes(int m){
        this.tailleTab = m;
    }
    
    /*
    * HashCode de base avec juste modulo de la taille du tableau en plus
    * 
    */
    public int hash0(Object o){
        return o.hashCode()%this.tailleTab;
    }

    public int hash1(Object o){
        return abs(o.hashCode()*3%this.tailleTab);
    }
    
    public int hash2(Object o){
        /*
        int hash = 0;
        String s = o.toString();
        for (int i = 0; i<s.length(); i++) {
            hash += s.codePointAt(i);
        }
        */
        return abs(o.hashCode()*7%this.tailleTab);
    }
    
    public int hash3(Object o){
        return abs(o.hashCode()*13%this.tailleTab);
    }
    
    public int hash4(Object o){
        String hash = "";
        int tmp;
        String s = o.toString();
        for (int i = 0; i<s.length(); i++) {
            hash += "" + Integer.parseInt(""+abs(s.codePointAt(i)));
        }
        return abs(o.hashCode()*17%this.tailleTab);
    }    
}
