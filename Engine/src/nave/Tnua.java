package nave;

public class Tnua {

    private Timeline timeOfMovement;// time of the movemonet was occured
    private double sum;// schum tnua

    public Tnua(Timeline timeOfMovement, double sum) {
        this.timeOfMovement = timeOfMovement;
        this.sum = sum;
    }

    public Timeline getTimeOfMovement() {
        return timeOfMovement;
    }

    public void setTimeOfMovement(Timeline timeOfMovement) {
        this.timeOfMovement = timeOfMovement;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
