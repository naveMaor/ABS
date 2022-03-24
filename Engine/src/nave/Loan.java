package nave;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;

public class Loan {
    private LoanStatus status;//++++++++++++++
    private int loanID;//shem mezha
    private String borrowerName;// mi shlekah et haalvaa
    private List<String> lendersList = new ArrayList<>();//
    private loanCategory loanCategory;//
    private int originalInterest;//ribit mekorit
    private Timeline originalLoanTimeFrame;// misgeret zman halvaa
    private Timeline startLoanYaz;
    private Timeline paymentFrequency;
    private int  interestPercentagePerTimeUnit;//
    private int payedInterest;//ribit shulma
    private int payedFund;//keren shulma
    private int currInterestDepth;//schum ribit nochechit
    private int loanOriginalDepth;//Schum halvaa mekori
    private int currFundDepth;//schum keren nochchit
    private int totalRemainingPayment;//fund+interest


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

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }
}
