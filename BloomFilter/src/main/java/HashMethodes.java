
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
        int hash = 0;
        String s = o.toString();
        for (int i = 0; i<s.length(); i++) {
            hash += s.codePointAt(i);
        }
        return abs(hash);
    }
    
    public int hash4(Object o){
        String hash = "";
        int tmp;
        String s = o.toString();
        for (int i = 0; i<s.length(); i++) {
            hash += "" + abs((s.codePointAt(i)-48));
            tmp = Integer.parseInt(hash)%10000000;
            hash = "" + tmp;
            System.out.println(hash);
        }
        return abs(Integer.parseInt(hash)%10000000);
    }    
}
