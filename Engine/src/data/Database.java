package data;

import ClientDTO.ClientObj;
import loan.Loan;
import customes.Client;
import loanDTO.LoanObj;
import time.Timeline;
import utills.Engine;

import java.io.Serializable;
import java.util.*;

public class Database implements Serializable {
    Engine engine = Engine.getInstance();

    private static Database single_instance = null;
    public static Database Database()
    {
        // To ensure only one instance is created
        if (single_instance == null) {
            single_instance = new Database();
        }
        return single_instance;
    }


    //todo: check if need to stay static
    private Map <String, List<Loan>> loanMapByCategory = new HashMap<>();
    private Map<String, Client> clientMap =new HashMap<>();

    public void setLoanMapByCategory(Map<String, List<Loan>> loanMapByCategory) {
        loanMapByCategory = loanMapByCategory;
    }

    public static void setClientMap(Map<String, Client> clientMap) {
        Database.clientMap = clientMap;
    }

    public static Map<String, List<Loan>> getLoanMapByCategory() {
        return loanMapByCategory;
    }

    public static List<LoanObj> getLoanObjList() {
        List<LoanObj> result = new ArrayList<>();
        for (List<Loan> loanList: loanMapByCategory.values()) {
            for(Loan newloan: loanList){
                result.add(new LoanObj(newloan));
            }
            //result.addAll(loanList);
        }
        return result;
    }
    public static List<Loan> getLoanList() {
        List<Loan> result = new ArrayList<>();
        for (List<Loan> loanList: loanMapByCategory.values()) {
            result.addAll(loanList);
        }
        return result;
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
            Client LoanBorrower = clientMap.get(newLoanNode.getBorrowerName());
            LoanBorrower.addLoanAsBorrower(newLoanNode);
    }
    public static List<Client> getClientsList() {
        return new ArrayList<>(clientMap.values());
    }
    public static List<ClientObj> getClientsObjList() {
        List<ClientObj> result = new ArrayList<>();
        for (Client clientToCopy: clientMap.values()) {
                result.add(new ClientObj(clientToCopy));
            }
        return result;
    }
//TO ASK: NOT SUPPOSE TO BE ADD TO MAP ? ADD TO DATABASE ?
    public static void addClientToClientMap(Client newClientNode){
        clientMap.put(newClientNode.getFullName(), newClientNode);
    }
    public List<Loan> getSortedLoanList(){
        List <Loan> result = getLoanList();
        engine.orderLoanList(result);
        return result;
    }
    public static Map<String, Client> getClientMap() {
        return clientMap;
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

    public static Client getClientByname(String name){
        return clientMap.get(name);
    }

    public static void clearAll(){
        loanMapByCategory.clear();
        clientMap.clear();
        Timeline.resetTime();
        //resetFileData();
    }

}
