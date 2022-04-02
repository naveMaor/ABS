package loan;

import customes.Account;
import customes.Client;
import customes.Lenders;
import data.Database;
import loan.enums.eLoanCategory;
import loan.enums.eLoanStatus;
import operations.Payment;
import operations.Transaction;
import time.Timeline;
import utills.BackgroundFunc;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Loan {

    //Identification data members:
    private eLoanCategory loanCategory;//
    private eLoanStatus status;//
    private int loanID;//shem mezha
    private String borrowerName;// mi shlekah et haalvaa

    //List data members
    private List<Lenders> lendersList = new ArrayList<>();//
    private List<Payment> paymentsList = new ArrayList<>();// borrower paying every yaz list

    //Time settings data members:
    private Timeline originalLoanTimeFrame;// misgeret zman halvaa
    private Timeline startLoanYaz;
    private Timeline paymentFrequency;
    private Timeline endLoanYaz;
    private double interestPercentagePerTimeUnit;//

    //Original Loan info:
    private double originalInterest;//ribit mekorit
    private double loanOriginalDepth;//Schum halvaa mekori
    private double totalLoanCostInterestPlusOriginalDepth = originalInterest + loanOriginalDepth;

    //Dynamic growing data members:
    private double payedInterest;//ribit shulma
    private double payedFund;//keren shulma
    private double deviation=0;

    //remaining Loan data:
    private double currInterestDepth;//schum ribit nochechit
    private double currFundDepth;//schum keren nochchit
    private double totalRemainingLoan = totalLoanCostInterestPlusOriginalDepth;//fund+interest

    private Account loanAccount;
    //constructor
    public Loan(eLoanCategory loanCategory, eLoanStatus status, String borrowerName, Timeline originalLoanTimeFrame, Timeline startLoanYaz, Timeline paymentFrequency, int interestPercentagePerTimeUnit, double loanOriginalDepth) {
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
    public double getInterestPercentagePerTimeUnit() {
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
    public double getLoanOriginalDepth() {
        return loanOriginalDepth;
    }
    public void setLoanOriginalDepth(double loanOriginalDepth) {
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
    public double nextExpectedPaymentAmount() {
        if(deviation>0)
        {
            return deviation;
        }
        else
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

    /**
     * update the status of the loan from new or from pending or from activate. if changed to activate it starts up the loan
     * todo:add option for changing in risk and finished status
     */
    public void UpdateLoanStatusIfNeeded() {
        if ((!getLendersList().isEmpty()) && (status == eLoanStatus.NEW)) {
            setStatus(eLoanStatus.PENDING);
        }
        else if(getLoanAccount().getCurrBalance()==getLoanOriginalDepth()) {
            setStatus(eLoanStatus.ACTIVE);
            activateLoan();
        }

    }

    /**
     * starts up the loan to activate
     */
    public void activateLoan() {

        Client borrower = BackgroundFunc.returnClientByName(getBorrowerName());
        BackgroundFunc.TransferMoneyBetweenAccounts(getLoanAccount(),getLoanOriginalDepth(),borrower.getMyAccount());
        Timeline startingLoanTimeStamp = new Timeline (Timeline.getCurrTime());
        setStartLoanYaz(startingLoanTimeStamp);
    }

    public void updateDynamicDataMembersAfterYazPromotion(){
        totalRemainingLoan -=nextExpectedPaymentAmount();
        //todo: complete do dynamic data members and remaining loan data update

    }

    /**
     * this func checks if the borrower can pay the next Expected Payment Amount and update the loan accordinly
     */
    public void handleLoanAfterTimePromote(){
        Client borrowerAsClient = Database.getClientMap().get(borrowerName);
        Account borrowerAccount = borrowerAsClient.getMyAccount();
        Timeline currTimeStamp = new Timeline(Timeline.getCurrTime());
        //if the borrower have the money for paying this loan at the time of the yaz
        if(borrowerAccount.getCurrBalance()>=nextExpectedPaymentAmount()){
                //add new payment to the loan payment list
                Payment BorrowPayment = new Payment(currTimeStamp,nextExpectedPaymentAmount(),true);
                paymentsList.add(BorrowPayment);
                //add the transaction stamp to the borrower transaction list
                Transaction transaction = new Transaction(currTimeStamp,nextExpectedPaymentAmount());
                borrowerAccount.addTnuaToAccount(transaction);
                //update loan money info
                updateDynamicDataMembersAfterYazPromotion();
                //update loan status
                if(totalRemainingLoan == 0) {
                    status=eLoanStatus.FINISHED;
                    handleFinishedLoan();
                }
                else if(status == eLoanStatus.RISK) {
                    status=eLoanStatus.ACTIVE;
                }
        }
        //if the borrower does not have the money for paying this loan at the time of the yaz
        else {
            status = eLoanStatus.RISK;
            //add new payment to the loan payment list with false
            Payment BorrowPayment = new Payment(currTimeStamp,nextExpectedPaymentAmount(),false);
            paymentsList.add(BorrowPayment);
            //enlarge the deviation
            deviation +=nextExpectedPaymentAmount();
        }
    }

    /**
     * this func assumes that the loan it works on is a finished loan pays the money from the loan savings account to the loaners
     */
    public void handleFinishedLoan(){
        //todo: need to complete it and pay for all the lenders from the loan savings account
    };

    /**
     * function in charge of paying each lender is partial share of his investment in the loan.
     * DONT FORGET TO CHECK IF LOAN IS IN FINISHED STATUS BEFORE ENTERING FUNC
     */
    public void payLoanDividendsToLenders(){
        double amountToPayLender;
        //need to docu this variable -//DOCU calc the multiplier for getting the  amount of interest Slender should be payed
        double coefficientOfMultiplicationInterest = this.interestPercentagePerTimeUnit/100;
        System.out.println(coefficientOfMultiplicationInterest);
        for(Lenders itr: this.lendersList){
            //calc amount of money specific lender suppose to get after loan is in "FINISHED" status
            amountToPayLender = itr.getDeposit() + itr.getDeposit()*coefficientOfMultiplicationInterest;
            //getting curr lender to pay name
        String lendersNameToPay = itr.getFullName();
        //getting clients account
        Account accToPay = Database.getClientMap().get(lendersNameToPay).getMyAccount();
        //getting current timeStamp for transaction.
        Timeline currTimeStamp = new Timeline(Timeline.getCurrTime());
        //creating a transaction
        Transaction lenderPaymentTransAction = new Transaction(currTimeStamp,amountToPayLender);
        //adding transaction to lenders account transactioList
            accToPay.getTnuaList().add(lenderPaymentTransAction);
        //updating lenders balance
            double updatedLenderBalance = accToPay.getCurrBalance()+amountToPayLender;
            accToPay.setCurrBalance(updatedLenderBalance);

    }
}
}
