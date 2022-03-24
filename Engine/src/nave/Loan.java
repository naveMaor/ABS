package nave;

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


}
