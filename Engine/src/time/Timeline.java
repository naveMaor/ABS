package time;

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
    public static void promoteStaticCurrTime(){
        currTime++;
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
}
