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

    @Override
    public String toString() {
        String payed = isPayed ? "" : "Not Payed!";
        return "{" +
                "Fund Portion: " + fundPortion +
                ", interest Portion: " + interestPortion +
                ", payment Yaz: " + paymentYaz +
                ", total payment: " + fundPlusInterest +
                 payed +
                '}';
    }
}
