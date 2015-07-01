package sort;

/**
 * Created by ruanqx on 2015/7/1.
 */
public class Selection extends SortBase{
    public void sort(Comparable[] a){
        int N = a.length;
        for(int i = 0; i < N; i++) {
            int min = i;
            for(int j = i + 1; j < N; j++){
                if(less(a[j], a[min]))
                    min = j;
            }
            exch(a, i, min);
        }
    }
}
