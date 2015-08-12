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
        aux = new Comparable[a.length];
        int N = a.length;
        int n = 1;
        int count = -1;
        //2^n - 1 <= N < 2^(n+1) - 1
        while(N > n - 2){
            n *= 2;
            count++;
        }
        int[] stack = new int[2*count];
        int top = -1;
        int max = top;
        for(int i = 0; i < N; i += 2){
            if(i == N-1 && N%2 != 0){
                stack[++top] = i;
                stack[++top] = i;
                if(top > max)
                    max = top;
            }else{
                merge(a, i, i, i+1);
                stack[++top] = i;
                stack[++top] = i+1;
                if(top > max)
                    max = top;
            }
            while(top > 1){
                if(stack[top] == stack[top-1]){
                    merge(a, stack[top-3], stack[top-2], stack[top]);
                    stack[top-2] = stack[top];
                    top = top - 2;
                }else{
                    int different = stack[top] - stack[top-1] - stack[top-2] + stack[top-3];
                    if(stack[top-1] -1 == stack[top-2] && different == 0){
                        merge(a, stack[top-3], stack[top-2],stack[top]);
                        stack[top-2] = stack[top];
                        top = top-2;
                    }else if(i+2 >= N){
                        merge(a, stack[top-3], stack[top-2],stack[top]);
                        stack[top-2] = stack[top];
                        top = top-2;
                    }else
                        break;
                }
            }
        }
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo)
            return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        //������mid�±�Ϊ�磬�����ߵ����һ�����ұߵĵ�һ��С������鲢�����ǣ�����������������㷨������ʱ���Ϊ����
        if(less(a[mid], a[mid+1]))
            return;
        merge(a, lo, mid, hi);
    }
}
