import java.util.List;

/**
 * Created by ruanqx on 2015/6/29.
 */
public class StopWatch {
    static public int AN_HOUR = 60 * 60 * 1000;
    static public int A_MINUTE = 60 * 1000;
    private long startTime = -1;
    private long stopTime = -1;

    public void start(){
        this.startTime = System.currentTimeMillis();
    }

    public void stop(){
        this.stopTime = System.currentTimeMillis();
    }

    public void reset(){
        this.startTime = -1;
        this.stopTime = -1;
    }

    public void split(){
        this.stopTime = System.currentTimeMillis();
    }

    public void unSplit(){
        this.stopTime = -1;
    }

    public long getTime(){
        if(this.stopTime == -1){
            return (System.currentTimeMillis() - this.startTime);
        }else{
            return this.stopTime - this.startTime;
        }
    }

    public String getTimeString(){
        int hours, minutes, seconds, milliseconds;
        long time = getTime();
        hours = (int)(time / this.AN_HOUR);
        time = time - hours * this.AN_HOUR;
        minutes = (int)(time / this.A_MINUTE);
        time = time - minutes * this.A_MINUTE;
        seconds = (int)(time / 1000);
        time -= 1000 * seconds;
        milliseconds = (int)time;
        return hours + "h:" + minutes + "m:" + seconds + "s:" + milliseconds;
    }

    public String toString(){
        return null;
    }
}
