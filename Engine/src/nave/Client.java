package nave;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String fullName;
    private Account myAccount;
    private List<Loan> clientAsLenderLoanList = new ArrayList<>();//
    private List<Loan> clientAsBorrowLoanList = new ArrayList<>();//



    public List<Loan> getClientAsLenderLoanList() {
        return clientAsLenderLoanList;
    }
    public void setClientAsLenderLoanList(List<Loan> clientAsLenderLoanList) {
        this.clientAsLenderLoanList = clientAsLenderLoanList;
    }
    public List<Loan> getClientAsBorrowLoanList() {
        return clientAsBorrowLoanList;
    }
    public void setClientAsBorrowLoanList(List<Loan> clientAsBorrowLoanList) {
        this.clientAsBorrowLoanList = clientAsBorrowLoanList;
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
