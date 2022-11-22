
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maud
 */
public class LinkedListFilter extends ListFilter{
    
    public LinkedListFilter(int k, int m) {
        super(k, m, new LinkedList<>());
    }

    @Override
    public String toString() {
        return "LinkedList";
    }
    
}
