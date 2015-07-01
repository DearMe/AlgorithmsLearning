package sort;

/**
 * Created by ruanqx on 2015/7/1.
 */
public class SortBase implements SortImp{
    @Override
    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    @Override
    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @Override
    public void show(Comparable[] a) {
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    @Override
    public boolean isSorted(Comparable[] a) {
        for(int i = 1; i < a.length; i++)
            if(less(a[i], a[i - 1]))
                return false;
        return true;
    }
}
