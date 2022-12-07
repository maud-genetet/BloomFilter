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
        Boolean b = this.filterTab[super.myHash.hash0(o)];
        if ( 2 <= super.k && b){
            b = b && this.filterTab[super.myHash.hash1(o)];
            if ( 3 <= super.k && b){ 
                b = b && this.filterTab[super.myHash.hash2(o)];
                if ( 4 <= super.k && b){
                    b = b && this.filterTab[super.myHash.hash3(o)];
                    if ( 5 <= super.k && b){
                        b = b && this.filterTab[super.myHash.hash4(o)];
                    }
                }
            }
        }
        return b;
    }

    @Override
    public void addAObject(Object o) {
        filterTab[super.myHash.hash0(o)] = true;
        if ( 2 <= super.k ){
            this.filterTab[super.myHash.hash1(o)] = true;
            if ( 3 <= super.k ){
                this.filterTab[super.myHash.hash2(o)] = true;
                if ( 4 <= super.k ){
                    this.filterTab[super.myHash.hash3(o)] = true;
                    if ( 5 <= super.k ){
                        this.filterTab[super.myHash.hash4(o)] = true;
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
