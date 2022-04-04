package Money;

public class Deviation {
    double interestDeviation=0;
    double fundDeviation=0;
    //double sumOfDeviation=0;
    int numberOfYazNotPayed=0;

/*    public double getSumOfDeviation() {
        return sumOfDeviation;
    }*/
    public int getNumberOfYazNotPayed() {
        return numberOfYazNotPayed;
    }
    public final double getSumOfDeviation(){
        return interestDeviation+fundDeviation;
    }

    public void incrementTheNumberOfYazNotPayed(){this.numberOfYazNotPayed++;}
    public void increaseDeviationBy(double interest,double fund){
        interestDeviation+=interest;
        fundDeviation+=fund;
        //sumOfDeviation +=Amount;
        incrementTheNumberOfYazNotPayed();
    }

    public void resetDeviation(){
        numberOfYazNotPayed=0;
        interestDeviation=0;
        fundDeviation=0;
    }
}
