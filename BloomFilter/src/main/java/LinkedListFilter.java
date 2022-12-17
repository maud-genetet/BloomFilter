
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maud
 */
public class LinkedListFilter extends ListGenericFilter{
    
    /**
     * Constructeur
     * 
     * @param k nombre de hash utilisé
     * @param m taille de notre filtre
     */
    public LinkedListFilter(int k, int m) {
        super(k, m, new LinkedList<>());
    }
}
