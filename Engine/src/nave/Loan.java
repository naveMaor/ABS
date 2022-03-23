package nave;

import java.util.ArrayList;
import java.util.List;

public class Loan {
    LoanStatus status;
    int LoanID;
    String LoanOwnerName;
    List<String> borrowList = new ArrayList<>();
    String loanCategory;
    int loanOriginalDepth;
    int currentDepth;//TODO ASK if supposed to be two different param or the one suppose to define the other
    int originalLoanTimeFrame;
    int loanInterest;

}
