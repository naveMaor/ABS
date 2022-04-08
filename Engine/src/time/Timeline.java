package time;

import java.util.Objects;

public class Timeline {

    private static int currTime = 1;
    private int timeStamp;

    @Override
    public String toString() {
        return String.valueOf(timeStamp);
    }

    public Timeline(int timeStamp) {
        this.timeStamp = timeStamp;
    }
    public int getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }
    public static int getCurrTime() {
        return currTime;
    }
    public static void promoteStaticCurrTime(){
        currTime++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timeline timeline = (Timeline) o;
        return timeStamp == timeline.timeStamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeStamp);
    }

    public static void printStaticCurrTime(){
        System.out.println(currTime);
    }
    public static void printPreviousCurrTime(){
        if (currTime==0)
        {
            System.out.println(currTime);
        }
        else {
            System.out.println(--currTime);
        }
    }
    public static void resetTime(){
        currTime =1;
    }
}
