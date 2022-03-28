package loan;

import customes.Account;
import customes.Lenders;
import loan.enums.eLoanCategory;
import loan.enums.eLoanStatus;
import operations.Payment;
import time.Timeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Loan {
    //NIKOL: must be seperated to objects
    //Identification data members:
    private eLoanCategory loanCategory;//
    private eLoanStatus status;//
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
    private int interestPercentagePerTimeUnit;//

    //Original Loan info:
    private double originalInterest;//ribit mekorit
    private int loanOriginalDepth;//Schum halvaa mekori
    private double totalLoanCostInterestPlusOriginalDepth = originalInterest + loanOriginalDepth;

    //Dynamic data members:
    private double payedInterest;//ribit shulma
    private double payedFund;//keren shulma

    private Account loanAccount;

    //remaining Loan data:
    private double currInterestDepth;//schum ribit nochechit
    private double currFundDepth;//schum keren nochchit
    private double totalRemainingLoan;//fund+interest


    //constructor
    public Loan(eLoanCategory loanCategory, eLoanStatus status, String borrowerName, Timeline originalLoanTimeFrame, Timeline startLoanYaz, Timeline paymentFrequency, int interestPercentagePerTimeUnit, int loanOriginalDepth) {
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
        this.originalInterest = this.loanOriginalDepth * (this.interestPercentagePerTimeUnit / 100.0);
    }

    public int getLoanOriginalDepth() {
        return loanOriginalDepth;
    }

    public void setLoanOriginalDepth(int loanOriginalDepth) {
        this.loanOriginalDepth = loanOriginalDepth;
    }

    public double getPayedInterest() {
        return payedInterest;
    }

    public void setPayedInterest(double payedInterest) {
        this.payedInterest = payedInterest;
    }

    public double getPayedFund() {
        return payedFund;
    }

    public void setPayedFund(double payedFund) {
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

    public eLoanCategory getLoanCategory() {
        return loanCategory;
    }

    public void setLoanCategory(eLoanCategory loanCategory) {
        this.loanCategory = loanCategory;
    }

    public eLoanStatus getStatus() {
        return status;
    }

    public void setStatus(eLoanStatus status) {
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

    public Account getLoanAccount() {
        return loanAccount;
    }

    public void setLoanAccount(Account loanAccount) {
        this.loanAccount = loanAccount;
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

    /**
     * this func calculates how much yaz needs to pass for the next payment to be paid
     *
     * @return
     */
    public int nextYazToPay() {
        return (Timeline.getCurrTime() - startLoanYaz.getTimeStamp()) % paymentFrequency.getTimeStamp();
    }

    /**
     * this func returns the amount of money that is expected to be paid in the next yaz
     *
     * @return
     */
    public double nextExpectedPayment() {
        return (totalLoanCostInterestPlusOriginalDepth / originalLoanTimeFrame.getTimeStamp());
    }

    public double InterestPerYaz() {
        return (originalInterest / originalLoanTimeFrame.getTimeStamp());
    }

    /**
     * this func sums up the total amount of money that all the lenders invested
     *
     * @return
     */
    public double calculateLendersTotalAmount() {
        double result = 0;
        for (Lenders lenders : lendersList) {
            result += lenders.getDeposit();
        }
        return result;
    }

    /**
     * this func calculate the Amount that Left For Loan to change from being Pending or New
     *
     * @return
     */
    public double calculateLoanAmountLeftForPendingAndNew() {
        return (loanOriginalDepth - calculateLendersTotalAmount());
    }

}
