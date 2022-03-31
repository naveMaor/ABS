package Shai;

import customes.Client;
import data.Database;
import loan.Loan;
import utills.BackgroundFunc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Shai.PrintFuncs.*;


public class User_interface {


    public static void allLoansData() {
        //NIKOL: is there an option to print the loan without lenders list? or without status? if not, why not do this logic as part of Loan.toString?
        for (Loan loan : Database.getLoanList()) {
            System.out.println(loan.toString());//showing loan
            PrintFuncs.printLenderList(loan.getLendersList());//showing lenders list PENDING
            switch (loan.getStatus()) {
                case ACTIVE: {
                    PrintFuncs.printACTIVEstatus(loan);
                }
                break;
                case RISK: {
                    PrintFuncs.printACTIVEstatus(loan);
                    PrintFuncs.printRISKstatus(loan);
                }
                break;
                case FINISHED: {
                    PrintFuncs.printFINISHEDstatus(loan);
                }
                break;
                default:
                    break;
            }
        }
        /*
                        itr.toString();
            itr.printLenderList();

            if (itr.getStatus() == LoanStatus.ACTIVE) {
                itr.printACTIVEstatus();
            }
            else if (itr.getStatus() == LoanStatus.RISK)
            {
                itr.printRISKstatus();
            }
            else if (itr.getStatus() == LoanStatus.FINISHED)
            {
                itr.printFINISHEDstatus();
            }

             */
    }

    public void func3(){
        for(Client client:Database.getClientsList()){
            PrintFuncs.printAccountInfo(client.getMyAccount());
            PrintFuncs.printConnectedLoans(client);
        }
    }

    public void func6() {
        Client client = customersMenu();
        ArrayList<Loan> loanslistToInvest = ChooseLoans(client);
        for (Loan loan : loanslistToInvest) {
            ClientToLoan(loan, client, loanslistToInvest.size());
        }
    }

    /**
     * func 4 is in charge of depositing money to a selected account from
     * a list of existing customers in the database
     */
    public static void func4()
    {
        //printing to UI all clients in database, letting user choose wanted client and getting the wanted deposit amount
        printAllClientsFromDatabase();
        Client wantedClient = ChooseClientFromDatabase();
       String clientFullName =wantedClient.getFullName();
        int deposit =  getDepositAmount(clientFullName);

        //making the wire
        BackgroundFunc.AccountTransaction(deposit,wantedClient.getMyAccount());
        System.out.println("Wire of: "+deposit+" to "+clientFullName+"'s account, has been confirmed.\n have a lovely day!");
    }

    /**
     * prints all clients in database to UI with index attached
     */
    public static void printAllClientsFromDatabase() {
        //creating index i , and printing all existing clients in database
        int i = 1;
        for (Client client : Database.getClientMap().values()) {
            System.out.println(i + ". " + client.getFullName());
            i++;
        }
    }

    /**
     * asking user and getting wanted deposit amount
     * @param full_name
     * @return
     */
    public  static int getDepositAmount(String full_name){

        System.out.println("How much would you like to to deposit into"+full_name+"'s account ?");
        System.out.println("(please enter a positive integer number)");
        int deposit = readIntFromUser(0,Integer.MAX_VALUE);
        return deposit;
    }
    public static Client ChooseClientFromDatabase () {
        //asking user to choose a client from database ,and getting input value of wanted client index
        List<Client> clientsList = Database.getClientsList();
        int clientListSize =clientsList.size();
        System.out.println("Please enter wanted client index for deposit\n(index must be an integer number between 0 - "+clientListSize+" )");


        int userClientIndexChoice = PrintFuncs.readIntFromUser(0,clientListSize);
        //getting client
        Client wantedClient =clientsList.get(userClientIndexChoice-1);
        return wantedClient;
    }

    public static void func5(){
        //printing to UI all clients in database, letting user choose wanted client and getting the wanted withdraw amount
        printAllClientsFromDatabase();
        Client wantedClient = ChooseClientFromDatabase();
        String clientFullName =wantedClient.getFullName();
        int withdrawal =  getWithdrawalAmount(clientFullName);

        //making the wire
        BackgroundFunc.AccountTransaction(withdrawal,wantedClient.getMyAccount());
        System.out.println("Withdraw of: "+withdrawal+" from "+clientFullName+"'s account, has been confirmed.\n have a lovely day!");
        System.out.println(wantedClient.getMyAccount().getTnuaList().toString()+wantedClient.getMyAccount().getCurrBalance());
    }
    public  static int getWithdrawalAmount(String full_name){
        //asking user and getting wanted deposit amount // S
        System.out.println("How much would you like to withdraw from "+full_name+"'s account ?");
        System.out.println("(please enter a positive integer number)");
        int withdraw = -(readIntFromUser(0,(int)Database.getClientMap().get(full_name).getMyAccount().getCurrBalance()));
        return withdraw;
    }





}





