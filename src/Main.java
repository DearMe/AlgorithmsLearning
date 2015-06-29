/**
 * Created by ruanqx on 2015/6/29.
 */
public class Main {
    public static void main(String[] args){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            Thread.currentThread().sleep(1500);
        }catch (InterruptedException e){

        }
        System.out.println(stopWatch.getTimeString());
    }
}
