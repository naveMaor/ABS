package nave;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String fullName;
    private Account myAccount;
    private List<Loan> cleintAsLenderLoanList = new ArrayList<>();//
    private List<Loan> cleintAsBorrowLoanList = new ArrayList<>();//

    public List<Loan> getCleintAsLenderLoanList() {
        return cleintAsLenderLoanList;
    }

    public void setCleintAsLenderLoanList(List<Loan> cleintAsLenderLoanList) {
        this.cleintAsLenderLoanList = cleintAsLenderLoanList;
    }

    public List<Loan> getCleintAsBorrowLoanList() {
        return cleintAsBorrowLoanList;
    }

    public void setCleintAsBorrowLoanList(List<Loan> cleintAsBorrowLoanList) {
        this.cleintAsBorrowLoanList = cleintAsBorrowLoanList;
    }

    public String getFullName() {
        return fullName;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Account getMyAccount() {
        return myAccount;
    }

    public void setMyAccount(Account myAccount) {
        this.myAccount = myAccount;
    }
}
