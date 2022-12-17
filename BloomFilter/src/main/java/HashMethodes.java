
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
    
    /**
     * Constructeur
     * 
     * @param m taille de notre filtre
     */
    public HashMethodes(int m){
        this.tailleTab = m;
    }
    
    /**
    * hashage d'un Object
    * 
    * @param o object à hasher
    * @return int notre hash
    */
    public int hash0(Object o){
        return o.hashCode()%this.tailleTab;
    }

    /**
    * hashage d'un Object
    * 
    * @param o objet à hasher
    * @return int notre hash
    */
    public int hash1(Object o){
        return abs((o.hashCode()+1)*3%this.tailleTab);
    }
    
    /**
    * hashage d'un Object
    * 
    * @param o objet à hasher
    * @return int notre hash
    */
    public int hash2(Object o){
        return abs((o.hashCode()+33)*7%this.tailleTab);
    }
    
    /**
    * hashage d'un Object
    * 
    * @param o objet à hasher
    * @return int notre hash
    */
    public int hash3(Object o){
        return abs((o.hashCode()+11*13)%this.tailleTab);
    }
    
    /**
    * hashage d'un Object
    * 
    * @param o objet à hasher
    * @return int notre hash
    */
    public int hash4(Object o){
        return abs((o.hashCode()+17)*17%this.tailleTab);
    }    
}
