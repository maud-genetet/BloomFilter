
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maud
 */
public class ArrayListFilter extends ListGenericFilter{
    
    public ArrayListFilter(int k, int m) {
        super(k, m, new ArrayList<Boolean>());
    }
    
    @Override
    public String toString() {
        return "ArrayList";
    }
}
