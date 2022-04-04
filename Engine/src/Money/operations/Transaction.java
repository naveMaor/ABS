package Money.operations;

import time.Timeline;

public class Transaction {

    private Timeline timeOfMovement;// time of the movemonet was occured
    private double sum;// schum tnua


    public Transaction(Timeline timeOfMovement, double sum) {
        this.timeOfMovement = timeOfMovement;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "timeOfMovement=" + timeOfMovement +
                ", sum=" + sum +
                '}';
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
