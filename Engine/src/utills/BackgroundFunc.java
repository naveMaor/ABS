package utills;

import customes.Account;
import customes.Client;
import customes.Lenders;
import data.Database;
import loan.Loan;
import loan.enums.eLoanCategory;
import operations.Transaction;
import time.Timeline;

import java.util.ArrayList;
import java.util.List;

public class BackgroundFunc {
/*
This func gets lenders list and return thus sum of their deposit
 */
    //NIKOL: what is the purpose of this class?
    //Answer: this class is the engine class where all the background functions are.
    //NIKOL: than why is it called BackgroundFunc? The name of the class should be a noun
    public  final static double calculateDeposit(List<Lenders> lendersList)
    {
        double sum=0;
        for (Lenders lenders:lendersList)
            sum+=lenders.getDeposit();

        return sum;
    }

    /**
     * func creates a transaction as needed (withdraw/deposit) , updates account's balance & transactions list
     * @param money
     * @param accDest
     */
    public static void AccountTransaction(double money, Account accDest)
    {
        //create a timestamp
        Timeline timeStamp = new Timeline(Timeline.getCurrTime());
        //update dest account
        Transaction transaction = new Transaction(timeStamp,money);
        accDest.getTnuaList().add(transaction);
        accDest.setCurrBalance(accDest.getCurrBalance()+money);
    }
    //NIKOL: everything is references in java"!!!!!!!!!!!"
    public static void TransferMoneyBetweenAccounts(Account accSource, double money, Account accDest)
    {
        //create a timestamp
        Timeline timeStamp = new Timeline(Timeline.getCurrTime());
        //update source account
        accSource.setCurrBalance(accSource.getCurrBalance()-money);
        Transaction transactionMinus = new Transaction(timeStamp,(-money));
        accSource.getTnuaList().add(transactionMinus);
        //update dest account
        Transaction transactionPlus = new Transaction(timeStamp,money);
        accDest.getTnuaList().add(transactionPlus);//SHAI: CHECK IF SUPPOSE TO BE AccDest ??
        accDest.setCurrBalance(accDest.getCurrBalance()+money);

    }

    /**
     * THIS FUNCTION BUILD NEW LOAN ARRAY FROM THE CORRESPONDING INDEXES IN THE NUMBERS ARRAY
     * @param loanArrayList
     * @param numbersArrayList
     * @return
     */
    public static ArrayList<Loan> getResultedArray(ArrayList<Loan> loanArrayList, ArrayList<Integer> numbersArrayList){
        ArrayList<Loan> result = new ArrayList<>();
        for (Integer integer:numbersArrayList)
        {
            result.add(loanArrayList.get(integer));
        }
        return result;
    }

    //NIKOL: this should probably be part of one of the classes.
    //NIKOL: what are you doing here? why do you need a list where all the values are the same?
    public static boolean checkCategoryList(ArrayList<eLoanCategory> loanCategoryArrayList, eLoanCategory category) {
        //NIKOL: try using this instead
        //loanCategoryArrayList.removeAll(Collections.singleton(category));
        //return loanCategoryArrayList.size() == 0;
        for(eLoanCategory loanCategory:loanCategoryArrayList)
        {
            if(loanCategory==category){
                return true;
            }
        }
        return false;
    }
    public static void addLenderToLoanList(Client client, Loan loan, double amountOfMoney) {
        Lenders lender = new Lenders(client.getFullName(),amountOfMoney);
        loan.getLendersList().add(lender);

    }
    public static Client returnClientByName(String name) throws IllegalArgumentException{
        Client client= Database.getClientMap().get(name);
        if (client == null)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            return  client;
        }

    }
}
