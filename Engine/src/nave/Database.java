package nave;

import java.util.ArrayList;
import java.util.List;

public class Database {


    private static List<Loan> loanList = new ArrayList<>();


    public static List<Loan> getLoanList() {
        return loanList;
    }

    public static void setLoanList(List<Loan> loanList) {
        Database.loanList = loanList;
    }


}
