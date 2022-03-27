package nave;

public class Timeline {

    private static int currTime = 0;
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

    public static void setCurrTime(int currTime) {
        Timeline.currTime = currTime;
    }
}
