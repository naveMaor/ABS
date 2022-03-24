package nave;

import java.util.ArrayList;
import java.util.List;

public class Loan {
    //NIKOL: you may want to create more classes in order to separate this one.
    private LoanStatus status;//++++++++++++++
    private int loanID;//shem mezha
    private String borrowerName;// mi shlekah et haalvaa
    private List<String> lendersList = new ArrayList<>();//
    private LoanCategory loanCategory;//
    private int originalInterest;//ribit mekorit
    private Timeline originalLoanTimeFrame;// misgeret zman halvaa
    private Timeline startLoanYaz;
    private Timeline paymentFrequency;
    private int interestPercentagePerTimeUnit;//
    private int payedInterest;//ribit shulma
    private int payedFund;//keren shulma
    private int currInterestDepth;//schum ribit nochechit
    private int loanOriginalDepth;//Schum halvaa mekori
    private int currFundDepth;//schum keren nochchit
    private int totalRemainingPayment;//fund+interest


    @Override
    public String toString()
    {
        String str = "Loan ID: " + loanID + System.lineSeparator();
        str += "borrower's Name :" + borrowerName + System.lineSeparator();
        str += "loan Category: " +loanCategory + System.lineSeparator();

        str += "Requested loan: " + loanOriginalDepth + System.lineSeparator();
        str += "Requested Time Frame For Loan: " + originalLoanTimeFrame + System.lineSeparator();

        str += "Loan interest: " + interestPercentagePerTimeUnit + System.lineSeparator();
        str += "Frequency of loan repayment requested: " + paymentFrequency + System.lineSeparator();

        str += "Loan status: " + status + System.lineSeparator();

        return str;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }
}
