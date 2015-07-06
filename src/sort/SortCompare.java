package sort;

import myuitl.Stopwatch;

/**
 * Created by ruanqx on 2015/7/2.
 */
public class SortCompare {
    public static double time(String alg, Double[] a){
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion")) Insertion.sort(a);
        if(alg.equals("Selection")) Selection.sort(a);
        return timer.getTime();
    }

    public static double timeRandomInput(String alg, int N, int T){
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t = 0; t < T; t++){
            for(int i = 0; i < N; i++)
                a[i] = Math.random();
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args){
        int N = 1000;
        int T = 100;
        double t1 = timeRandomInput("Insertion", N, T);
        double t2 = timeRandomInput("Selection", N, T);
        System.out.println(t2 / t1);
    }
}
