package test;

import myuitl.Stopwatch;

/**
 * Created by ruanqx on 2015/6/29.
 */
public class Main {
    public static void main(String[] args){
        Stopwatch stopWatch = new Stopwatch();
        stopWatch.start();
        try {
            Thread.currentThread().sleep(1500);
        }catch (InterruptedException e){

        }
        System.out.println(stopWatch.getTimeString());
    }
}
