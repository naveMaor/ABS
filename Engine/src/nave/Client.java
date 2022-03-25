package nave;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String fullName;
    private Account myAccount;
    private List<Lenders> loanList = new ArrayList<>();//

    public List<Lenders> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Lenders> loanList) {
        this.loanList = loanList;
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
