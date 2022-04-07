package data;

import loan.Loan;
import customes.Client;
import utills.BackgroundFunc;

import java.util.*;

public class Database {
    private static Map <String, List<Loan>> loanMapByCategory = new HashMap<>();
    //private static Map<Integer, Loan> loanMap = new HashMap<>();

    private static Map<String, Client> clientMap =new HashMap<>();
    public static Map<String, Client> getClientMap() {
        return clientMap;
    }


    public static List<Loan> getLoanList() {
        List<Loan> result = new ArrayList<>();
        for (List<Loan> loanList: loanMapByCategory.values()) {
            result.addAll(loanList);
        }
        return result;
        //return new ArrayList<>(loanMap.values());
    }
    public static void addLoanToLoanMap(Loan newLoanNode){
            String category= newLoanNode.getLoanCategory();
            if(loanMapByCategory.containsKey(category))
            {
                loanMapByCategory.get(category).add(newLoanNode);
            }
            else
            {
                List<Loan> newLoanlist = new ArrayList<>();
                newLoanlist.add(newLoanNode);
                loanMapByCategory.put(category,newLoanlist);
            }
            //loanMap.put(newLoanNode.getLoanID(), newLoanNode);
    }
    public static void addNewClient(Client client) {
        clientMap.put(client.getFullName(), client);
    }
    public static List<Client> getClientsList() {
        return new ArrayList<>(clientMap.values());
    }
//TO ASK: NOT SUPPOSE TO BE ADD TO MAP ? ADD TO DATABASE ?
    public static void addClientToClientList(Client newClientNode){
        clientMap.put(newClientNode.getFullName(), newClientNode);
    }
    public static List<Loan> getSortedLoanList(){
        List <Loan> result = getLoanList();
        BackgroundFunc.orderLoanList(result);
        return result;
    }

    public static void addCategory (String category){
        if (!loanMapByCategory.containsKey(category))
        {
            loanMapByCategory.put(category,new ArrayList<Loan>());
        }
    }

    public static List<String> getAllCategories() {
        List<String> result = new ArrayList<>();
        for (String category:loanMapByCategory.keySet()) {
            result.add(category);
        }
        return result;
    }
}
