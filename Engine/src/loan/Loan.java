package loan;

import customes.Account;
import customes.Client;
import customes.Lenders;
import data.Database;
import loan.enums.eDeviationPortion;
import loan.enums.eLoanStatus;
import Money.operations.Payment;
import Money.operations.Transaction;
import time.Timeline;
import utills.Engine;
import Money.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Loan implements Serializable {
    Engine engine = Engine.getInstance();

    //Identification data members:

    private String loanCategory;//
    private eLoanStatus status;//
    private String loanID;//shem mezha
    private String borrowerName;// mi shlekah et haalvaa

    //List data members
    private List<Lenders> lendersList = new ArrayList<>();//
    private List<Payment> paymentsList = new ArrayList<>();// borrower paying every yaz list

    //Time settings data members:
    private Timeline originalLoanTimeFrame = null;// misgeret zman halvaa
    private Timeline startLoanYaz = new Timeline();
    private Timeline paymentFrequency = new Timeline();
    private Timeline endLoanYaz = new Timeline();
    private double interestPercentagePerTimeUnit ;//

   private double intristPerPayment;
    private double fundPerPayment;

    //Original Loan info:
    private double originalInterest;//ribit mekorit
    private double loanOriginalDepth;//Schum halvaa mekori
    private double totalLoanCostInterestPlusOriginalDepth = originalInterest + loanOriginalDepth;

    //Dynamic growing data members:
    private double payedInterest=0;//ribit shulma
    private double payedFund=0;//keren shulma
    private Deviation deviation;

    //remaining Loan data:
    private double totalRemainingLoan = totalLoanCostInterestPlusOriginalDepth;//fund+interest

    private Account loanAccount;
    //constructors
/*
    public Loan(String loanCategory, eLoanStatus status, String borrowerName, Timeline originalLoanTimeFrame, Timeline startLoanYaz, Timeline paymentFrequency, double interestPercentagePerTimeUnit, double loanOriginalDepth) {
        this.loanCategory = loanCategory;
        this.status = status;
        this.borrowerName = borrowerName;
        this.originalLoanTimeFrame = originalLoanTimeFrame;
        this.startLoanYaz = startLoanYaz;
        this.paymentFrequency = paymentFrequency;
        this.interestPercentagePerTimeUnit = interestPercentagePerTimeUnit;
        this.loanOriginalDepth = loanOriginalDepth;
        //this.currInterestDepth = originalInterest - payedInterest;//schum ribit nochechit
        //this.currFundDepth = loanOriginalDepth - payedFund;//schum keren nochchit
        //this.totalRemainingLoan = currInterestDepth + currFundDepth;//fund+interest
        calculateInterest();
    }
*/

    public Loan(String LoanId,String borrowerName, String loanCategory,double loanOriginalDepth,int originalLoanTimeFrame,int paymentFrequency, int intristPerPayment){
        this.borrowerName =borrowerName;
        this.loanCategory =loanCategory;
        this.loanOriginalDepth =loanOriginalDepth;
        Timeline newOriginalLoanTimeFrame = new Timeline(originalLoanTimeFrame);
        this.originalLoanTimeFrame =newOriginalLoanTimeFrame;
        Timeline newPaymentFrequency = new Timeline(paymentFrequency);
        this.paymentFrequency = newPaymentFrequency;
        this.fundPerPayment = this.loanOriginalDepth/(this.originalLoanTimeFrame.getTimeStamp()/this.paymentFrequency.getTimeStamp());
        this.status = eLoanStatus.NEW;
        this.loanID = LoanId;
        //this.loanID = Objects.hash(this.loanCategory, this.originalLoanTimeFrame, startLoanYaz) & 0xfffffff;
        this.interestPercentagePerTimeUnit = intristPerPayment;  //(100*this.originalInterest)/this.loanOriginalDepth;
        this.originalInterest = calculateInterest();
        this.totalLoanCostInterestPlusOriginalDepth = this.originalInterest + this.loanOriginalDepth;
        this.totalRemainingLoan = this.totalLoanCostInterestPlusOriginalDepth;
        this.loanAccount = new Account(Objects.hash(this.loanID) & 0xfffffff,0);
        this.intristPerPayment = calculateInristPerPayment();
        this.deviation= new Deviation();
    }


    public final double calculateCurrInterestDepth(){
        return originalInterest-payedInterest;
    }
    public final double calculateFundDepth(){
        return loanOriginalDepth-payedFund;
    }


    //getter and setters:
/*    public void generateLoanID() {
        this.loanID = Objects.hash(loanCategory, originalLoanTimeFrame, startLoanYaz) & 0xfffffff;
    }*/
    public String getLoanID() {
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
    public Timeline getPaymentFrequency() {
        return paymentFrequency;
    }
    public Timeline getEndLoanYaz() {
        return endLoanYaz;
    }
    public double getInterestPercentagePerTimeUnit() {
        return interestPercentagePerTimeUnit;
    }
    public double getOriginalInterest() {
        return originalInterest;
    }
    public double calculateInterest() {
        return this.loanOriginalDepth * (this.interestPercentagePerTimeUnit / 100.0);
    }
    public double getLoanOriginalDepth() {
        return loanOriginalDepth;
    }
    public double getPayedInterest() {
        return payedInterest;
    }
    public double getPayedFund() {
        return payedFund;
    }
    public double getTotalLoanCostInterestPlusOriginalDepth() {
        return totalLoanCostInterestPlusOriginalDepth;
    }
    public String getLoanCategory() {
        return loanCategory;
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

    public double getFundPerPayment() {
        return fundPerPayment;
    }

    public double getTotalRemainingLoan() {
        return totalRemainingLoan;
    }

    public double getIntristPerPayment() {
        return intristPerPayment;
    }

    public double calculateInristPerPayment(){
        return this.originalInterest/(originalLoanTimeFrame.getTimeStamp()/paymentFrequency.getTimeStamp());
    }

    public Deviation getDeviation() {
        return deviation;
    }

    @Override
    public String toString() {
        return
                "Loan ID:" + loanID + "\n" +
                "status: " + status + "\n" +
                "borrower's Name: " + borrowerName + "\n" +
                "loan Category: " + loanCategory + "\n" +
                "Requested Time Frame For Loan: " + originalLoanTimeFrame + "\n" +
                "Frequency of loan repayment requested: " + paymentFrequency + "\n" +
                "Loan interest Percentage: " + interestPercentagePerTimeUnit + " %"+ "\n" +
                "Requested loan amount: " + loanOriginalDepth + "\n" + "\n";
    }

    /**
     * this func calculates how much yaz needs to pass for the next payment to be paid
     *
     * @return
     */
    public int nextYazToPay() {
        int currTime = Timeline.getCurrTime();
        int startLoanYaz = this.startLoanYaz.getTimeStamp();
        int paymentFrequency = this.paymentFrequency.getTimeStamp();

            return ((currTime-startLoanYaz) % paymentFrequency );
    }

    /**
     * this func returns the amount of money that is expected to be paid in the next yaz
     *
     * @return
     */


    public double nextExpectedPaymentAmount(eDeviationPortion DeviationPortion) {
        //double intristPerPayment = this.originalInterest/this.originalLoanTimeFrame.getTimeStamp();
        switch (DeviationPortion)
        {
            case INTEREST:{
                if(deviation.getInterestDeviation()>0)
                    return deviation.getInterestDeviation();
                else
                    return (this.intristPerPayment);
            }
            case FUND:{
                if(deviation.getFundDeviation()>0)
                    return deviation.getFundDeviation();
                else
                    return (fundPerPayment);
            }
            case TOTAL:{
                if(deviation.getSumOfDeviation()>0)
                {
                    return deviation.getSumOfDeviation();
                }
                else
                    return (totalLoanCostInterestPlusOriginalDepth / (originalLoanTimeFrame.getTimeStamp()/paymentFrequency.getTimeStamp()));
            }
        }

        return -1000000000000.0;
    }




    /**
     * update the status of the loan from new or from pending or from activate. if changed to activate it starts up the loan
     */
    public void UpdateLoanStatusIfNeeded() {
        if ((!lendersList.isEmpty()) && (status == eLoanStatus.NEW)) {
            setStatus(eLoanStatus.PENDING);
        }
        if(loanAccount.getCurrBalance()==getLoanOriginalDepth()) {
            setStatus(eLoanStatus.ACTIVE);
            activateLoan();
        }
    }

    /**
     * starts up the loan to activate
     */
    public void activateLoan() {

        Client borrower = engine.returnClientByName(this.getBorrowerName());
        engine.TransferMoneyBetweenAccounts(loanAccount,loanOriginalDepth,borrower.getMyAccount());
        loanAccount.setCurrBalance(0);
        Timeline startingLoanTimeStamp = new Timeline (Timeline.getCurrTime());
        startLoanYaz=startingLoanTimeStamp;
    }

    public void updateDynamicDataMembersAfterYazPromotion(double interest, double fund){
        totalRemainingLoan-= (interest+fund);
        payedInterest += interest;
        payedFund += fund;
    }

    /**
     * this func checks if the borrower can pay the next Expected Payment Amount and update the loan accordinly
     */
    public void handleLoanAfterTimePromote(){
        Client borrowerAsClient = engine.getDatabase().getClientMap().get(borrowerName);
        Account borrowerAccount = borrowerAsClient.getMyAccount();
        Timeline currTimeStamp = new Timeline(Timeline.getCurrTime());
        Double nextExpectedPaymentAmount = nextExpectedPaymentAmount(eDeviationPortion.TOTAL);
        Double nextExpectedInterest = nextExpectedPaymentAmount(eDeviationPortion.INTEREST);
        Double nextExpectedFund = nextExpectedPaymentAmount(eDeviationPortion.FUND);
        //if the borrower have the money for paying this loan at the time of the yaz
        if(borrowerAccount.getCurrBalance()>=nextExpectedPaymentAmount){
                //add new payment to the loan payment list
                Payment BorrowPayment = new Payment(currTimeStamp,true,nextExpectedFund,nextExpectedInterest);
                paymentsList.add(BorrowPayment);
                //add the transaction stamp to the borrower transaction list
                Transaction transaction = new Transaction(currTimeStamp,-nextExpectedPaymentAmount,String.valueOf(this.loanID),borrowerAccount.getCurrBalance(),borrowerAccount.getCurrBalance()-nextExpectedPaymentAmount);
                borrowerAccount.addTnuaToAccount(transaction);
                //update loan money info
                loanAccount.setCurrBalance(loanAccount.getCurrBalance()+nextExpectedPaymentAmount);
                borrowerAccount.setCurrBalance(borrowerAccount.getCurrBalance()-nextExpectedPaymentAmount);

                updateDynamicDataMembersAfterYazPromotion(nextExpectedInterest,nextExpectedFund);
                deviation.resetDeviation();
                //update loan status
                if(totalRemainingLoan == 0) {
                    status=eLoanStatus.FINISHED;
                    endLoanYaz = currTimeStamp;
                    payLoanDividendsToLenders();
                }
                else if(status == eLoanStatus.RISK) {
                    status=eLoanStatus.ACTIVE;
                }
        }
        //if the borrower does not have the money for paying this loan at the time of the yaz
        else {
            status = eLoanStatus.RISK;
            //add new payment to the loan payment list with false
            Payment BorrowPayment = new Payment(currTimeStamp,false,nextExpectedFund,nextExpectedInterest);
            paymentsList.add(BorrowPayment);
            //enlarge the deviation
            deviation.increaseDeviationBy(intristPerPayment,fundPerPayment);
        }
    }



    /**
     * function in charge of paying each lender is partial share of his investment in the loan.
     * DONT FORGET TO CHECK IF LOAN IS IN FINISHED STATUS BEFORE ENTERING FUNC
     */
    public void payLoanDividendsToLenders(){
        double amountToPayLender;
        //need to docu this variable -//DOCU calc the multiplier for getting the  amount of interest Slender should be payed
        double coefficientOfMultiplicationInterest = this.interestPercentagePerTimeUnit/100.0;
        for(Lenders itr: this.lendersList){
            //calc amount of money specific lender suppose to get after loan is in "FINISHED" status
            amountToPayLender = itr.getDeposit() + itr.getDeposit()*coefficientOfMultiplicationInterest;
            //getting curr lender to pay name
        String lendersNameToPay = itr.getFullName();
        //getting clients account
        Account accToPay = engine.getDatabase().getClientMap().get(lendersNameToPay).getMyAccount();
        //getting current timeStamp for transaction.
        Timeline currTimeStamp = new Timeline(Timeline.getCurrTime());
            //updating lenders balance
            double updatedLenderBalance = accToPay.getCurrBalance()+amountToPayLender;
            //creating a transaction
        Transaction lenderPaymentTransAction = new Transaction(currTimeStamp,amountToPayLender,String.valueOf(this.loanID),accToPay.getCurrBalance(),updatedLenderBalance);
        //adding transaction to lenders account transactioList
            accToPay.getTnuaList().add(lenderPaymentTransAction);

            accToPay.setCurrBalance(updatedLenderBalance);

    }
}


    public void uniformsNeededBlocksInLenderList(){
        int listSize=this.lendersList.size();
        //checks if their at least two blocks to compare in list
        if(listSize>=2){

            int index= listSize-1;//last block
            while(this.lendersList.get(index).getFullName()==this.lendersList.get(index-1).getFullName())//compares if two last blocks have the same name
            {
                //updates index-1 block deposit to be the unified sum of investment
                this.lendersList.get(index-1).setDeposit( this.lendersList.get(index-1).getDeposit()+ this.lendersList.get(index).getDeposit());
                //removing unneeded block after updating prev block to new sum of inves
                this.lendersList.remove(index);
                //updating index to check pre compare
                index -= 1;
            }
        }
    }//MAYBE TO DELETE NOT YET




}
