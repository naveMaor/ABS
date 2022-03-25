package nave;

public class Payment {
    private int fundPortion;
    private int interestPortion;
    private Timeline paymentYaz;
    private int fundPlusInterest;
    private boolean isPayed;

    @Override
    public String toString() {
        return "{" +
                "Fund Portion: " + fundPortion +
                ", interest Portion: " + interestPortion +
                ", payment Yaz: " + paymentYaz +
                ", total payment: " + fundPlusInterest +
                '}';
    }
}
