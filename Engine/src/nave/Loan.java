package nave;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Loan {
    //Identification data members:
    private LoanCategory loanCategory;//
    private LoanStatus status;//
    private int loanID;//shem mezha
    private String borrowerName;// mi shlekah et haalvaa

    //List data members
    private List<Lenders> lendersList = new ArrayList<>();//
    private List<Payment> paymentsList = new ArrayList<>();//

    //Time settings data members:
    private Timeline originalLoanTimeFrame;// misgeret zman halvaa
    private Timeline startLoanYaz;
    private Timeline paymentFrequency;
    private Timeline endLoanYaz;
    private int  interestPercentagePerTimeUnit;//

    //Original Loan info:
    private double originalInterest;//ribit mekorit
    private int loanOriginalDepth;//Schum halvaa mekori
    private double totalLoanCostInterestPlusOriginalDepth = originalInterest + loanOriginalDepth;

    //Dynamic data members:
    private int payedInterest;//ribit shulma
    private int payedFund;//keren shulma

    //remaining Loan data:
    private double currInterestDepth;//schum ribit nochechit
    private double currFundDepth;//schum keren nochchit
    private double totalRemainingLoan;//fund+interest


    //constractor
    public Loan(LoanCategory loanCategory, LoanStatus status, String borrowerName, Timeline originalLoanTimeFrame, Timeline startLoanYaz, Timeline paymentFrequency, int interestPercentagePerTimeUnit, int loanOriginalDepth) {
        this.loanCategory = loanCategory;
        this.status = status;
        this.borrowerName = borrowerName;
        this.originalLoanTimeFrame = originalLoanTimeFrame;
        this.startLoanYaz = startLoanYaz;
        this.paymentFrequency = paymentFrequency;
        this.interestPercentagePerTimeUnit = interestPercentagePerTimeUnit;
        this.loanOriginalDepth = loanOriginalDepth;
        this.currInterestDepth = originalInterest - payedInterest;//schum ribit nochechit
        this.currFundDepth = loanOriginalDepth - payedFund;//schum keren nochchit
        this.totalRemainingLoan = currInterestDepth + currFundDepth;//fund+interest
        calculateInterest();
    }


    //getter and setters:
    public void generateLoanID() {
         this.loanID = Objects.hash(loanCategory, originalLoanTimeFrame, startLoanYaz);
    }
    public int getLoanID() {
        return loanID;
    }
    public String getBorrowerName() {
        return borrowerName;
    }
    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }
    public List<Payment> getPaymentsList() {
        return paymentsList;
    }
    public void setPaymentsList(List<Payment> paymentsList) {
        this.paymentsList = paymentsList;
    }
    public Timeline getOriginalLoanTimeFrame() {
        return originalLoanTimeFrame;
    }
    public void setOriginalLoanTimeFrame(Timeline originalLoanTimeFrame) {
        this.originalLoanTimeFrame = originalLoanTimeFrame;
    }
    public Timeline getPaymentFrequency() {
        return paymentFrequency;
    }
    public void setPaymentFrequency(Timeline paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }
    public Timeline getEndLoanYaz() {
        return endLoanYaz;
    }
    public void setEndLoanYaz(Timeline endLoanYaz) {
        this.endLoanYaz = endLoanYaz;
    }
    public int getInterestPercentagePerTimeUnit() {
        return interestPercentagePerTimeUnit;
    }
    public void setInterestPercentagePerTimeUnit(int interestPercentagePerTimeUnit) {
        this.interestPercentagePerTimeUnit = interestPercentagePerTimeUnit;
    }
    public double getOriginalInterest() {
        return originalInterest;
    }
    public void calculateInterest() {
        this.originalInterest = this.loanOriginalDepth * (this.interestPercentagePerTimeUnit/100.0);
    }
    public int getLoanOriginalDepth() {
        return loanOriginalDepth;
    }
    public void setLoanOriginalDepth(int loanOriginalDepth) {
        this.loanOriginalDepth = loanOriginalDepth;
    }
    public int getPayedInterest() {
        return payedInterest;
    }
    public void setPayedInterest(int payedInterest) {
        this.payedInterest = payedInterest;
    }
    public int getPayedFund() {
        return payedFund;
    }
    public void setPayedFund(int payedFund) {
        this.payedFund = payedFund;
    }
    public double getCurrInterestDepth() {
        return currInterestDepth;
    }
    public void setCurrInterestDepth(int currInterestDepth) {
        this.currInterestDepth = currInterestDepth;
    }
    public double getCurrFundDepth() {
        return currFundDepth;
    }
    public void setCurrFundDepth(int currFundDepth) {
        this.currFundDepth = currFundDepth;
    }
    public double getTotalRemainingLoan() {
        return totalRemainingLoan;
    }
    public void setTotalRemainingLoan(int totalRemainingLoan) {
        this.totalRemainingLoan = totalRemainingLoan;
    }
    public double getTotalLoanCostInterestPlusOriginalDepth() {
        return totalLoanCostInterestPlusOriginalDepth;
    }
    public void setTotalLoanCostInterestPlusOriginalDepth(double totalLoanCostInterestPlusOriginalDepth) {
        this.totalLoanCostInterestPlusOriginalDepth = totalLoanCostInterestPlusOriginalDepth;
    }
    public LoanCategory getLoanCategory() {
        return loanCategory;
    }
    public void setLoanCategory(LoanCategory loanCategory) {
        this.loanCategory = loanCategory;
    }
    public LoanStatus getStatus() {
        return status;
    }
    public void setStatus(LoanStatus status) {
        this.status = status;
    }
    public List<Lenders> getLendersList() {
        return lendersList;
    }
    public Timeline getStartLoanYaz() {
        return startLoanYaz;
    }
    public void setStartLoanYaz(Timeline startLoanYaz) {
        this.startLoanYaz = startLoanYaz;
    }
    public void setLendersList(List<Lenders> lendersList) {
        this.lendersList = lendersList;
    }

    @Override
    public String toString() {
        return "Loan: " +
                "status; " + status +
                ", Loan ID:" + loanID +
                ", borrower's Name: " + borrowerName + '\'' +
                ", loan Category: " + loanCategory +
                ", Requested Time Frame For Loan: " + originalLoanTimeFrame +
                ", Frequency of loan repayment requested: " + paymentFrequency +
                ", Loan interest: " + interestPercentagePerTimeUnit +
                ", Requested loan: " + loanOriginalDepth;
    }


/*    public final void printACTIVEstatus()
    {
        System.out.println("Loan start time" + startLoanYaz + "Yazes");
        int T = (Timeline.getCurrTime() - startLoanYaz.getTime()) % paymentFrequency.getTime();
        System.out.println("next payment: " + T);
        for(Payment pay:paymentsList)
        {
            System.out.println(pay.toString());
        }
        System.out.println("total payed fund: " + payedFund);
        System.out.println("total payed interest: " + payedInterest);
        System.out.println("remaining fund: " + currFundDepth);
        System.out.println("remaining interest: " + currInterestDepth);
    }*/

    public int nextYazToPay() {return(Timeline.getCurrTime() - startLoanYaz.getTime()) % paymentFrequency.getTime();}
    public double nextExpectedPayment(){ return (totalLoanCostInterestPlusOriginalDepth / originalLoanTimeFrame.getTime());
    }
    public double InterestperYaz()    {
        return (originalInterest/originalInterest);
    }


}
