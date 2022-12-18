/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maud
 */
public abstract class BloomFilter{
    
    // nombre k de hash utilisés
    protected int k;
    // m taille de notre filtre
    protected int m; 
    // n nombre elements dans le filtre
    protected int n;
    // nos hashs
    protected HashMethodes myHash;
    
    /**
     * Constructeur
     * 
     * @param k nombre de hash utilisé
     * @param m taille de notre filtre
     */
    public BloomFilter(int k, int m) {
        if ( k < 1 ){
            k = 1;
        } else if ( k > 5 ){
            k = 5;
        }
        this.k = k;
        this.m = m;
        this.myHash = new HashMethodes(m);
    }
    
    /**
    * Ajoute un élément dans notre filtre
    * 
    * @param o élément à ajouter
    */
    public abstract void addAObject(Object o);
    
    /**
    * Vérifie si l'élément est possiblement dans le filtre
    * 
    * @param o élément à vérifié
    * @return Boolean vrai si il y est sinon faux
    */
    public abstract Boolean isInFilter(Object o);
 
}
