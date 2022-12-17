
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maud
 */
public abstract class ListGenericFilter extends BloomFilter{

    List<Boolean> filterList;
    
    /**
     * Constructeur
     * 
     * @param k nombre de hash utilisé
     * @param m taille de notre filtre
     */
    protected ListGenericFilter(int k, int m, List<Boolean> l) {
        super(k, m);
        this.filterList = l;
        for (int i = 0; i < m; i++) {
            this.filterList.add(false);
        }
    }

    /**
    * Vérifie si l'élément est possiblement dans le filtre
    * 
    * @param o élément à vérifié
    * @return Boolean vrai si il y est sinon faux
    */
    @Override
    public Boolean isInFilter(Object o) {
        Boolean b = filterList.get(super.myHash.hash0(o));
        if ( 2 <= super.k && b){
            b = b && this.filterList.get(super.myHash.hash1(o));
            if ( 3 <= super.k && b){
                b = b && this.filterList.get(super.myHash.hash2(o));
                if ( 4 <= super.k && b){
                    b = b && this.filterList.get(super.myHash.hash3(o));
                    if ( 5 <= super.k && b){
                        b = b && this.filterList.get(super.myHash.hash4(o));
                    }
                }
            }
        }
        return b;
    }

    /**
    * Ajoute un élément dans notre filtre
    * 
    * @param o élémnet à ajouter
    */
    @Override
    public void addAObject(Object o) {
        filterList.add(super.myHash.hash0(o), true);
        if ( 2 <= super.k ){
            this.filterList.set(super.myHash.hash1(o), true);
            if ( 3 <= super.k ){
                this.filterList.set(super.myHash.hash2(o), true);
                if ( 4 <= super.k ){
                    this.filterList.set(super.myHash.hash3(o), true);
                    if ( 5 <= super.k ){
                        this.filterList.set(super.myHash.hash4(o), true);
                    }
                }
            }
        }
        super.n ++;
    }
    
}
