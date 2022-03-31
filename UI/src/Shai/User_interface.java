package Shai;

import customes.Client;
import data.Database;
import loan.Loan;

import java.util.ArrayList;

import static Shai.PrintFuncs.*;


public class User_interface {


    public static void allLoansData() {
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

    public void func6(){
        Client client = customersMenu();
        ArrayList<Loan> loanslistToInvest = ChooseLoans(client);
        for (Loan loan:loanslistToInvest)
        {
            ClientToLoan(loan,client,loanslistToInvest.size());
        }
    }
}





