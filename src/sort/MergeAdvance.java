package sort;

/**
 * Created by ruanqx on 2015/7/16.
 */
public class MergeAdvance extends SortBase{
    private static Comparable[] aux;
    private static void merge(Comparable[] a, int lo, int mid, int hi){
        for(int i = lo; i <= mid; i++){
            aux[i] = a[i];
        }
        //倒序将右半边复制进aux,如是,内循环则不需判断是否数组溢出
        for(int i = mid+1; i <= hi; i++){
            aux[i] = a[hi-i+mid+1];
        }
        int i = lo;
        int j = hi;
        for(int k = lo; k <= hi; k++)
            if(less(aux[i], aux[j]))
                a[k] = aux[i++];
            else
                a[k] = aux[j--];
    }

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo)
            return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        if(!less(a[mid], a[mid+1]))
            merge(a, lo, mid, hi);
    }
}
