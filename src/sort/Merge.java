package sort;

/**
 * Created by ruanqx on 2015/7/13.
 */
public class Merge extends SortBase{
    private static Comparable[] aux;
    private static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo;
        int j = mid+1;
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        for(int k = lo; k <= hi; k++){
            if(i > mid)
                a[k] = aux[j++];
            else if(j >hi)
                a[k] = aux[i++];
            else if(less(aux[i], aux[j]))
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }
    }

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }

    public static void sortByLoop(Comparable[] a){
        int N = a.length;
        int[] stake = new int[100];
        int top = 0;
        for(int i = 0; i < N; i += 2){
        }
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo)
            return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        //数组以mid下标为界，如果左边的最后一个比右边的第一个小，则不需归并。如是，任意有序的字数组算法的运行时间变为线性
        if(less(a[mid], a[mid+1]))
            return;
        merge(a, lo, mid, hi);
    }
}
