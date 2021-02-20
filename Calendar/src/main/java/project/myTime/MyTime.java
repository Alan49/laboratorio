package project.myTime;

/**
 * Created by alan on 05/12/16.
 */
public class MyTime {

    private int hours = 0;
    private int minuts = 0;
    private int seconds = 0;

    public boolean isValidTime(int hours, int minuts, int seconds){
        if (hours >= 0 && hours <= 23){
            if (minuts >= 0 && minuts <= 59){
                if(seconds >= 0 && seconds <= 59){
                    return true;
                }
            }
        }

        return false;
    }

    public MyTime(int hours, int minuts, int seconds) throws MyTimeException {
        if (isValidTime(hours, minuts, seconds)){
            this.hours = hours;
            this.minuts = minuts;
            this.seconds = seconds;
        }
    }

    public void setMyTime(int hours, int minuts, int seconds) throws MyTimeException {
        if (isValidTime(hours, minuts, seconds)){
            this.hours = hours;
            this.minuts = minuts;
            this.seconds = seconds;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(hours) + ":" + String.valueOf(minuts) + ":" + String.valueOf(seconds);
    }
}
