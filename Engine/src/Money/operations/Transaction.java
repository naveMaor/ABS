package Money.operations;

import time.Timeline;

import java.util.Objects;

public class Transaction {

    private Timeline timeOfMovement;// time of the movemonet was occured
    private double sum;// schum tnua
    private String to_from;
    private  char sign;

    public Transaction(Timeline timeOfMovement, double sum, String to_from) {
        this.timeOfMovement = timeOfMovement;
        this.sum = sum;
        this.to_from=to_from;
        if(this.sum>0)
            this.sign ='+';
        else
            this.sign ='-';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
       boolean shai = (this.sign == that.sign && timeOfMovement.getTimeStamp()==that.timeOfMovement.getTimeStamp() && to_from.equals(that.to_from));

        return shai ;
    }           // same "Sign" of transaction +/-

    @Override
    public int hashCode() {
        return Objects.hash(timeOfMovement, to_from);
    }

    public String getTo_from() {
        return to_from;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "timeOfMovement=" + timeOfMovement +
                ", sum=" + sum +
                ", to_from='" + to_from + '\'' +
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
