package test;

import sort.Merge;

import java.util.Random;

/**
 * Created by ruanqx on 2015/6/29.
 */
public class Main {
    public static void main(String[] args){
        Random rand = new Random();
//        Integer[] Ints = {54, 29, 89, 33, 18, 70, 42, 3, 46, 1, 90, 7, 86, 56, 94,};
        int count = 55;
        Integer[] Ints = new Integer[count];
        for(int i = 0; i < count; i++){
            Ints[i] = (Integer)(rand.nextInt(5000));
        }
        Merge.sortByLoop(Ints);
        for(int i = 0; i < count - 1; i++){
            if(Ints[i] > Ints[i+1])
                System.out.println("false");
        }
        Merge.show(Ints);
    }
}
