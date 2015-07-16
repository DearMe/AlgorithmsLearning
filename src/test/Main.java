package test;

import myuitl.Stopwatch;
import sort.Merge;
import sort.MergeAdvance;
import sort.MergeBU;

import java.util.Random;

/**
 * Created by ruanqx on 2015/6/29.
 */
public class Main {
    public static void main(String[] args){
        Random rand = new Random();
        Integer[] Ints = {54, 29, 89, 33, 18, 70, 42, 3, 46, 1, 90, 7, 86, 56, 94,};
        /*for(int i = 0; i < 15; i++){
            Ints[i] = (Integer)(rand.nextInt(100));
        }*/
        MergeAdvance.sort(Ints);
        MergeAdvance.show(Ints);
    }
}
