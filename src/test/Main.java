package test;

import sort.Merge;
import sort.Quick;

import java.util.Random;

/**
 * Created by ruanqx on 2015/6/29.
 */
public class Main {
    public static void main(String[] args){
//        Random rand = new Random();
//        int count = 55;
//        Integer[] ints = {54, 29, 89, 33, 18, 70, 42, 3, 46, 1, 90, 7, 86, 56, 94,};
//        count = ints.length;
//        Integer[] ints = new Integer[count];
//        for(int i = 0; i < count; i++){
//            ints[i] = (Integer)(rand.nextInt(5000));
//        }
//        Quick.sort(ints);
//        for(int i = 0; i < count-1; i++){
//            if(ints[i] > ints[i+1]) {
//                System.out.println("false");
//                break;
//            }
//        }
        int[] prices = new int[3];
        prices[0] = 1;
        prices[1] = 4;
        prices[2] = 2;
        int min = 0, result = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[min] > prices[i])
                min = i;
            else {

            }
        }

    }
}
