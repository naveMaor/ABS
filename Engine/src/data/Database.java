package data;

import loan.Loan;
import customes.Client;

import java.util.*;

public class Database {

    private static Map<Integer, Loan> loanMap = new HashMap<>();
    private static Map<String, Client> clientMap =new HashMap<>();

    public static Map<String, Client> getClientMap() {
        return clientMap;
    }

    public static List<Loan> getLoanList() {
        return new ArrayList<>(loanMap.values());
    }

    public static void addLoanToLoanList(Loan newLoanNode){
            loanMap.put(newLoanNode.getLoanID(), newLoanNode);
    }

    public static void addNewClient(Client client) {
        clientMap.put(client.getFullName(), client);
    }

    public static List<Client> getClientsList() {
        return new ArrayList<>(clientMap.values());
    }
}
