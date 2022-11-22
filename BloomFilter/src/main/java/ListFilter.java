
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maud
 */
public abstract class ListFilter extends BloomFilter{

    List<Boolean> filterList;
    
    public ListFilter(int k, int m, List<Boolean> l) {
        super(k, m);
        this.filterList = l;
        for (int i = 0; i < m; i++) {
            this.filterList.add(false);
        }
    }

    @Override
    public Boolean isInFilter(Object o) {
        Boolean b = filterList.get(o.hashCode()%super.m);
        if ( 2 <= super.k ){
            b = b && this.filterList.get(hash1(o)%super.m);
            if ( 3 <= super.k ){
                b = b && this.filterList.get(hash2(o)%super.m);
                if ( 4 <= super.k ){
                    b = b && this.filterList.get(hash3(o)%super.m);
                    if ( 5 <= super.k ){
                        b = b && this.filterList.get(hash4(o)%super.m);
                    }
                }
            }
        }
        return b;
    }

    @Override
    public void addAObject(Object o) {
        filterList.add(o.hashCode()%super.m, true);
        if ( 2 <= super.k ){
            this.filterList.set(hash1(o)%super.m, true);
            if ( 3 <= super.k ){
                this.filterList.set(hash2(o)%super.m, true);
                if ( 4 <= super.k ){
                    this.filterList.set(hash3(o)%super.m, true);
                    if ( 5 <= super.k ){
                        this.filterList.set(hash4(o)%super.m, true);
                    }
                }
            }
        }
        super.n ++;
    }
    
}
