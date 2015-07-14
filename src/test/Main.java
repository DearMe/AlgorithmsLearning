package test;

import myuitl.Stopwatch;
import sort.Merge;
import sort.MergeBU;

import java.util.Random;

/**
 * Created by ruanqx on 2015/6/29.
 */
public class Main {
    public static void main(String[] args){
        Random rand = new Random();
        Integer[] Ints = new Integer[15];
        for(int i = 0; i < 15; i++){
            Ints[i] = (Integer)(rand.nextInt(100));
        }
        MergeBU.show(Ints);
        MergeBU.sort(Ints);
        MergeBU.show(Ints);
    }
}
