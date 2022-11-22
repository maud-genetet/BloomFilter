/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maud
 */
public class TabFilter extends BloomFilter{

    Boolean filterTab[];
    
    public TabFilter(int k, int m) {
        super(k, m);
        this.filterTab = new Boolean[m];
        for (int i = 0; i < m; i++) {
            this.filterTab[i] = false;
        }
    }

    @Override
    public Boolean isInFilter(Object o) {
        Boolean b = this.filterTab[o.hashCode()%super.m];
        if ( 2 <= super.k ){
            b = b && this.filterTab[hash1(o)%super.m];
            if ( 3 <= super.k ){
                b = b && this.filterTab[hash2(o)%super.m];
                if ( 4 <= super.k ){
                    b = b && this.filterTab[hash3(o)%super.m];
                    if ( 5 <= super.k ){
                        b = b && this.filterTab[hash4(o)%super.m];
                    }
                }
            }
        }
        return b;
    }

    @Override
    public void addAObject(Object o) {
        filterTab[o.hashCode()%super.m] = true;
        if ( 2 <= super.k ){
            this.filterTab[hash1(o)%super.m] = true;
            if ( 3 <= super.k ){
                this.filterTab[hash2(o)%super.m] = true;
                if ( 4 <= super.k ){
                    this.filterTab[hash3(o)%super.m] = true;
                    if ( 5 <= super.k ){
                        this.filterTab[hash4(o)%super.m] = true;
                    }
                }
            }
        }
        super.n ++;
    }
    
    @Override
    public String toString() {
        return "List";
    }
}
