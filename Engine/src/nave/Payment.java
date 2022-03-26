package nave;

public class Payment {
    private int fundPortion;
    private int interestPortion;
    private Timeline paymentYaz;
    private int fundPlusInterest;
    private boolean isPayed;

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public int getFundPlusInterest() {
        return fundPlusInterest;
    }

    public void setFundPlusInterest(int fundPlusInterest) {
        this.fundPlusInterest = fundPlusInterest;
    }

    public int getFundPortion() {
        return fundPortion;
    }

    public Payment() {
    }

    public Payment(int fundPortion, int interestPortion, Timeline paymentYaz, int fundPlusInterest, boolean isPayed) {
        this.fundPortion = fundPortion;
        this.interestPortion = interestPortion;
        this.paymentYaz = paymentYaz;
        this.fundPlusInterest = fundPlusInterest;
        this.isPayed = isPayed;
    }

    public void setFundPortion(int fundPortion) {
        this.fundPortion = fundPortion;
    }

    public int getInterestPortion() {
        return interestPortion;
    }

    public void setInterestPortion(int interestPortion) {
        this.interestPortion = interestPortion;
    }

    public Timeline getPaymentYaz() {
        return paymentYaz;
    }

    public void setPaymentYaz(Timeline paymentYaz) {
        this.paymentYaz = paymentYaz;
    }

    @Override
    public String toString() {
        String payed = isPayed ? "" : ", Not Payed!";
        return "{" +
                "Fund Portion: " + fundPortion +
                ", interest Portion: " + interestPortion +
                ", payment Yaz: " + paymentYaz +
                ", total payment: " + fundPlusInterest +
                 payed +
                '}';
    }
}
