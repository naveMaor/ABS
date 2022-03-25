package nave;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {


    private static List<Loan> loanList = new ArrayList<>();
    private static Map<String, Client> clientMap =new HashMap<>();

    public static Map<String, Client> getClientMap() {
        return clientMap;
    }

    public static void setClientMap(Map<String, Client> clientMap) {
        Database.clientMap = clientMap;
    }

    public static List<Loan> getLoanList() {
        return loanList;
    }
    public static void setLoanList(List<Loan> loanList) {
        Database.loanList = loanList;
    }

public static void addLoanToLoanList(Loan newLoanNode){
        loanList.add(newLoanNode);
}
}
