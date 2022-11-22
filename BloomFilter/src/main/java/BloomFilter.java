/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maud
 */
public abstract class BloomFilter extends HashMethodes{
    
    protected int k;
    protected int m; 
    protected int n;
    
    public BloomFilter(int k, int m) {
        if ( k < 1 ){
            k = 1;
        } else if ( k > 5 ){
            k = 5;
        }
        this.k = k;
        this.m = m;
    }
    
    public abstract void addAObject(Object o);
    
    public abstract Boolean isInFilter(Object o);
 
}
