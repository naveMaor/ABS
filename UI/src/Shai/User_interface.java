package Shai;

import customes.Client;
import data.Database;
import loan.Loan;
import time.Timeline;
import utills.BackgroundFunc;

import java.util.ArrayList;

import static Shai.PrintFuncs.*;


public class User_interface {


    public static void func2AllLoansData() {
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

    public static void func5(){
        //printing to UI all clients in database, letting user choose wanted client and getting the wanted withdraw amount
        printAllClientsFromDatabase();
        Client wantedClient = ChooseClientFromDatabase();
        String clientFullName =wantedClient.getFullName();
        int withdrawal =  PrintFuncs.getWithdrawalAmount(clientFullName);

        //making the wire
        BackgroundFunc.AccountTransaction(withdrawal,wantedClient.getMyAccount());
        System.out.println("Withdraw of: "+withdrawal+" from "+clientFullName+"'s account, has been confirmed.\n have a lovely day!");
        System.out.println(wantedClient.getMyAccount().getTnuaList().toString()+wantedClient.getMyAccount().getCurrBalance());
    }

    public void func6() {
        Client client = customersMenu();
        ArrayList<Loan> loanslistToInvest = ChooseLoans(client);
        for (Loan loan : loanslistToInvest) {
            ClientToLoan(loan, client, loanslistToInvest.size());
        }
    }

    public void func7(){
        Timeline.promoteStaticCurrTime();
        PrintFuncs.printYazAfterPromote();
        BackgroundFunc.filterAndHandleLoansListAfterPromote();
    }



}





