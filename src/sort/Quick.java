package sort;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by ruanqx on 2015/7/22.
 */
public class Quick extends SortBase{
    public static void sort(Comparable[] a){
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static void sortAdvance(Comparable[] a, int lo, int hi, int M){
        if(hi <= lo + M){
            Insertion.sort(a, lo, hi);
            return;
        }
        int j = partition(a, lo, hi);
        sortAdvance(a, lo, j - 1, M);
        sortAdvance(a, j + 1, hi, M);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i], v)) if(i == hi) break;
            while(less(v, a[--j])) if(j == lo) break;
            if(i >= j) break;
            exch(a, i, j);
            show(a);
        }
        exch(a, lo, j);
        return j;
    }

    private static void sort3way(Comparable[] a, int lo, int hi){
        if(hi < lo) return;
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while(i <= gt){
            int cmp = a[i].compareTo(v);
            if(cmp < 0)
                exch(a, lt++, i++);
            else if(cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }
        sort3way(a, lo, lt-1);
        sort3way(a, gt+1, hi);
    }
}
