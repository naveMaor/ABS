package utills;

import customes.Account;
import customes.Client;
import customes.Lenders;
import data.Database;
import data.schema.generated.AbsCustomer;
import data.schema.generated.AbsDescriptor;
import data.schema.generated.AbsLoan;
//
import loan.Loan;
import Money.operations.Transaction;
import loan.enums.eDeviationPortion;
import time.Timeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static loan.enums.eLoanStatus.ACTIVE;
import static loan.enums.eLoanStatus.RISK;

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
    //SHAI: in what context this function is used? check if a certain category is in sent Arraylist ?
    public static boolean checkCategoryList(ArrayList<String> loanCategoryArrayList, String category) {
        return loanCategoryArrayList.contains(category);
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

    /**
     * this fun get loan list and order it by two parameters:
     * getStartLoanYaz and then nextExpectedPaymentAmount
     * @param LoanList
     */
    public static void orderLoanList(List<Loan> LoanList) {

        Collections.sort(LoanList, new Comparator() {

            public int compare(Object o1, Object o2) {

                Integer x1 = ((Loan) o1).getStartLoanYaz().getTimeStamp();
                Integer x2 = ((Loan) o2).getStartLoanYaz().getTimeStamp();
                int sComp = x1.compareTo(x2);

                if (sComp != 0) {
                    return sComp;
                }

                 Double x3 = ((Loan) o1).nextExpectedPaymentAmount(eDeviationPortion.TOTAL);
                 Double x4 = ((Loan) o2).nextExpectedPaymentAmount(eDeviationPortion.TOTAL);
                return x3.compareTo(x4);
            }});
}

    public static void filterAndHandleLoansListAfterPromote(){
        List<Loan> sortedLoanList = Database.getSortedLoanList();
        for (Loan loan:sortedLoanList){
            if((Timeline.getCurrTime()%loan.nextYazToPay() == 0)&&((loan.getStatus()== ACTIVE)|| (loan.getStatus()== RISK))){
                loan.handleLoanAfterTimePromote();
            }
        }
    }

    /**
     *     check if there is a loan category that does not exist
     */
    public static boolean checkValidCategories(AbsDescriptor descriptor){
        List<String> absCategoriesList = descriptor.getAbsCategories().getAbsCategory();
        List<AbsLoan> absLoanList = descriptor.getAbsLoans().getAbsLoan();
        boolean isCategoryExist = false;

        for (AbsLoan absLoan:absLoanList){
            for(String s:absCategoriesList){
                if(absLoan.getAbsCategory().equals(s)) {
                    isCategoryExist=true;
                }
            }
            if(!isCategoryExist)
                return false;
            isCategoryExist = false;
        }
        return true;
    }

    /**
     *     check if there is a loan owner that does not exist
     */
    public static boolean checkValidLoanOwner(AbsDescriptor descriptor){
        List<AbsCustomer> absCustomerList = descriptor.getAbsCustomers().getAbsCustomer();
        List<AbsLoan> absLoanList = descriptor.getAbsLoans().getAbsLoan();
        boolean isCustomerExist = false;

        for (AbsLoan absLoan:absLoanList){
            for(AbsCustomer absCustomer:absCustomerList){
                String customerName = absCustomer.getName();
                if(absLoan.getAbsOwner().equals(customerName))
                {
                    isCustomerExist=true;
                }
            }
            if(!isCustomerExist)
            {
                return false;
            }
            isCustomerExist = false;
        }
        return true;
    }

    /**
     * check if payment frequency is fully divided by the total time of the loan
     * @param descriptor
     * @return
     */
    public static boolean checkValidPaymentFrequency(AbsDescriptor descriptor){
        List<AbsLoan> absLoanList = descriptor.getAbsLoans().getAbsLoan();
        int absTotalYazTime;
        int absPaysEveryYaz;

        for (AbsLoan absLoan:absLoanList){
            absTotalYazTime=absLoan.getAbsTotalYazTime();
            absPaysEveryYaz = absLoan.getAbsTotalYazTime();
            if(absTotalYazTime%absPaysEveryYaz !=0)
                return false;
        }
        return true;
    }

    /**
     *  check if there is two customers with the same name
     * @param descriptor
     * @return
     */
    public static boolean checkValidCustomersList(AbsDescriptor descriptor){
        List<AbsCustomer> absCustomerList = descriptor.getAbsCustomers().getAbsCustomer();
        for (AbsCustomer absCustomer:absCustomerList){
            if(absCustomerList.contains(absCustomer.getName()) )
                return false;
        }
        return true;
    }

    public static void buildDataFromDescriptor(AbsDescriptor descriptor){
        buildCustomersData(descriptor.getAbsCustomers().getAbsCustomer());
        buildCategoriesData(descriptor.getAbsCategories().getAbsCategory());
        buildLoansData(descriptor.getAbsLoans().getAbsLoan());
    }

    public static void buildCustomersData(List<AbsCustomer> absCustomerList){
        for (AbsCustomer absCustomer:absCustomerList){
            Client newClient = new Client(absCustomer.getName(),absCustomer.getAbsBalance());
            Database.addClientToClientMap(newClient);
        }
    }
    public static void buildCategoriesData(List<String> absCategories){
        for (String categoryName:absCategories){
            Database.addCategory(categoryName);
        }
    }
    public static void buildLoansData(List<AbsLoan> absLoanList){
       for (AbsLoan absLoan:absLoanList){
           Loan newLoan = new Loan(absLoan.getAbsOwner(),absLoan.getAbsCategory(),absLoan.getAbsCapital(),absLoan.getAbsTotalYazTime(),absLoan.getAbsPaysEveryYaz(),absLoan.getAbsIntristPerPayment());
           Database.addLoanToLoanMap(newLoan);
       }
    }
}
