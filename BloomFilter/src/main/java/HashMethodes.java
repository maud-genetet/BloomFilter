
import static java.lang.Math.abs;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maud
 */
public abstract class HashMethodes{

    public int hash1(Object o){
        return abs(o.hashCode()+1526*1989679617%95647853);
    }
    
    public int hash2(Object o){
        return abs(o.toString().hashCode());
    }
    
    public int hash3(Object o){
        return abs(o.toString().length()+569875143*575654756*o.hashCode());
    }
    
    public int hash4(Object o){
        Integer hash = 0;
        String s = o.toString();
        for (int i = 0; i<s.length(); i++) {
            hash += (s.charAt(i)*1000*(i+1));
        }
        System.out.println(hash);
        hash *= o.toString().length()*546984697;
        String h = hash.toString();
        for(char c : h.toCharArray()){
            if (c%2 != 0){
                hash *= 13;
            }
        }
        return abs(hash+42457*95693215);
    }    
}
