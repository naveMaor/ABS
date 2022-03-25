package nave;

public class Timeline {
    private static int currTime = 0;
    private int time;

    @Override
    public String toString() {
        return String.valueOf(time);
    }

    public Timeline(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public static int getCurrTime() {
        return currTime;
    }

    public static void setCurrTime(int currTime) {
        Timeline.currTime = currTime;
    }
}
