package sort;

/**
 * Created by ruanqx on 2015/7/6.
 */
public class Shell extends SortBase{
    public static void sort(Comparable[] a, int startGap){
        int N = a.length;
        int h = 1;
        while(h < N / startGap)
            h = h * startGap + 1;
        while(h >= 1){
            for(int i = h; i < N; i++){
                for(int j = i; j > h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            h /= 3;
        }
    }
}
