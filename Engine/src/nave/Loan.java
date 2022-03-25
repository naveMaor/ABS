package nave;

import java.util.ArrayList;
import java.util.List;

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
    private Timeline endLoanyaz;
    private int  interestPercentagePerTimeUnit;//

    //Original Loan info:
    private int originalInterest;//ribit mekorit
    private int loanOriginalDepth;//Schum halvaa mekori

    //Dynamic data members:
    private int payedInterest;//ribit shulma
    private int payedFund;//keren shulma

    //remaining Loan data:
    private int currInterestDepth = originalInterest - payedInterest;//schum ribit nochechit
    private int currFundDepth = loanOriginalDepth - payedFund;//schum keren nochchit
    private int totalRemainingLoan = currInterestDepth + currFundDepth;//fund+interest


/*

    @Override
    public String toString()
    {
        System.out.println("Loan ID: " + loanID);
        System.out.println("borrower's Name :" + borrowerName);
        System.out.println("loan Category: " +loanCategory );

        System.out.println("Requested loan: " + loanOriginalDepth );
        System.out.println("Requested Time Frame For Loan: " + originalLoanTimeFrame);

        System.out.println("Loan interest: " + interestPercentagePerTimeUnit );
        System.out.println("Frequency of loan repayment requested: " + paymentFrequency);

        System.out.println("Loan status: " + status);
        return null;
    }
*/

    @Override
    public String toString() {
        return "Loan{" +
                "status=" + status +
                ", Loan ID:" + loanID +
                ", borrower's Name :" + borrowerName + '\'' +
                ", loan Category: " + loanCategory +
                ", Requested Time Frame For Loan: " + originalLoanTimeFrame +
                ", Frequency of loan repayment requested: " + paymentFrequency +
                ", Loan interest: " + interestPercentagePerTimeUnit +
                ", Requested loan: " + loanOriginalDepth +
                '}';
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

    public final void printACTIVEstatus()
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
    }
    public final void printLenderList()
    {
        for (Lenders lender:lendersList)
        {
            System.out.println(lender);
        }
    }

    public final void printRISKstatus(){
        printACTIVEstatus();
        int sumNotPayed = 0;
        int numNotPayed=0;
        for(Payment pays:paymentsList)
        {
            if(pays.isPayed() == false)
            {
                sumNotPayed+=pays.getFundPlusInterest();
                ++numNotPayed;
            }

        }
        System.out.println("num of delayed payments: " + numNotPayed);
        System.out.println("sum of delayed: " + sumNotPayed);
    }

    public final void printFINISHEDstatus(){
        printLenderList();
        System.out.println("start loan yaz: "+startLoanYaz);
        System.out.println("end loan yaz" + endLoanyaz);
        for(Payment pay:paymentsList)
        {
            System.out.println(pay.toString());
        }
    }

}
