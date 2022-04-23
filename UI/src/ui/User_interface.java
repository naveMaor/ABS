package ui;

import ClientDTO.ClientObj;
import Money.operations.Transaction;
import customes.Client;
import data.Database;
import data.File.XmlFile;
import loan.Loan;
import loan.enums.eLoanStatus;
import loanDTO.LoanObj;
import time.Timeline;
import utills.BackgroundFunc;

import java.util.List;

import static ui.PrintFuncs.*;


public class User_interface {


    public static void func2AllLoansData() {
        int index = 1;
        for (LoanObj loan : Database.getLoanObjList()) {
            System.out.println("\n------------------------\n");
            System.out.println(index + ". ");
            printLoanInfo2(loan);
            index ++;
        }
        System.out.println("\n------------------------\n");
    }

    public static void func3(){

       List<ClientObj> printList =Database.getClientsObjList();
        for(ClientObj client:printList ){
            System.out.println("Presenting " + client.getFullName() + ":");
            PrintFuncs.printAccountInfo(client);
            PrintFuncs.printConnectedLoans(client);
        }
    }



    /**
     * func 4 is in charge of depositing money to a selected account from
     * a list of existing customers in the database
     */
    public static void func4() {
        //printing to UI all clients in database, letting user choose wanted client and getting the wanted deposit amount
        printAllClientsFromDatabase();
        String clientFullName = ChooseClientFromDatabase();
        int deposit =  getDepositAmount(clientFullName);

        //making the wire
        BackgroundFunc.AccountTransaction(deposit,clientFullName);
        System.out.println("Wire of: "+deposit+" to "+clientFullName+"'s account, has been confirmed.\n ");
        System.out.println(clientFullName+"'s new account balance is: "+ BackgroundFunc.getBalanceFromClientName(clientFullName));
    }

    public static void func5(){
        //printing to UI all clients in database, letting user choose wanted client and getting the wanted withdraw amount
        printAllClientsFromDatabase();
        String clientFullName =ChooseClientFromDatabase();
        int withdrawal =  PrintFuncs.getWithdrawalAmount(clientFullName);
        //making the wire
        BackgroundFunc.AccountTransaction(withdrawal,clientFullName);
        System.out.println("Withdraw of: "+withdrawal+" from "+clientFullName+"'s account, has been confirmed.\n ");
        System.out.println(clientFullName + "'s current balance: " +BackgroundFunc.getBalanceFromClientName(clientFullName));
    }

    public static void func6() {
        //double amountOfMoneyPerLoan,minNeededInvestment,investment;
        int loanListSize;
        //getting wanted investor
        Client client = customersMenu();
        //creating wanted loans to invest list by investor wanted parameters
        List<Loan> loanslistToInvest = ChooseLoans(client);
        if(loanslistToInvest.isEmpty()){
            return;
        }
        //getting wanted overall investment for current yaz from client
        double wantedInvestment = PrintFuncs.getWantedInvestment(client);
/*       // investing according to agreed risk management methodology
        do {

            //getting updated list size
            loanListSize = loanslistToInvest.size();
            //getting the amount of money wanted to invest equally for each loan from loan list
            amountOfMoneyPerLoan = BackgroundFunc.amountOfMoneyPerLoan(loanListSize, wantedInvestment);
            //getting minimal investment needed
            minNeededInvestment = BackgroundFunc.getMinInvestment(loanslistToInvest);
            //chosen way of payment
            investment = Math.min(amountOfMoneyPerLoan, minNeededInvestment);
            //reducing upcoming investments from wantedInvestment
            wantedInvestment -= investment * loanListSize;
            //TO DO: MAYBE TAKE LINES 111-119 TO A FUNC
            //initializing index for removal

            for (int index=0;index<loanslistToInvest.size();) {
                Loan loan = loanslistToInvest.get(index);
                BackgroundFunc.ClientToLoan(loan, client, investment);
                if(loan.getStatus() == eLoanStatus.ACTIVE)
                    loanslistToInvest.remove(index);
                else //should move foward nothing was removed
                    ++index;
            }
            loanListSize=loanslistToInvest.size();//NEWLY ADDED
            // as long as there is money left to invest , or list of optional investments is not empty
        } while (wantedInvestment != 0 && loanListSize != 0);*/
        loanListSize = BackgroundFunc.investing_according_to_agreed_risk_management_methodology(loanslistToInvest,wantedInvestment,client);
        if (loanListSize==0){
            PrintFuncs.printEmptyListNotification(wantedInvestment);    }
    }

/*    static void printEmptyListNotification(double remainingInvestment){
        System.out.println("Invested in all chosen loans the maximum optional investment.\n there are no loans left to invest from selected loans");
        //System.out.println("remaining money left from original sum of investment is: "+remainingInvestment);
        System.out.println("you can choose to re-filter to continue investing");
    }*/
/*    static double getMinInvestment(List<Loan> loanslistToInvest){
       //initialize  minimal with first loan details
        double minimalInvest = (loanslistToInvest.get(0).getLoanOriginalDepth()-loanslistToInvest.get(0).getLoanAccount().getCurrBalance());
        double leftForInvestment;
       for (Loan loan : loanslistToInvest) {
           //checks how much money is needed for loan to become active
           leftForInvestment = loan.getLoanOriginalDepth() - loan.getLoanAccount().getCurrBalance();
            //getting minimal
           if (leftForInvestment < minimalInvest)
               minimalInvest = leftForInvestment;
       }
        return minimalInvest;
    }*/
/*    static double getWantedInvestment(Client client) {
        double amountOfMoney = 0, balance = client.getMyAccount().getCurrBalance();
        System.out.println("Please enter the amount you would like the client to invest,\n (must a number between 1 and " + balance+")");
        amountOfMoney = readDoubleFromUser(1, balance);
        return amountOfMoney;
    }*/

    public static void func7(){
        Timeline.promoteStaticCurrTime();
        PrintFuncs.printYazAfterPromote();
        BackgroundFunc.filterAndHandleLoansListAfterPromote();
    }

    public static void func1(){
        XmlFile.getDetailsForFile();
        try {
            if(CheckAndPrintInvalidFile(XmlFile.getInputObject())){
                Database.clearAll();
                BackgroundFunc.buildDataFromDescriptor(XmlFile.getInputObject());
                System.out.println("file loaded successfully");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}





