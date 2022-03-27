package Shai;

import nave.*;


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
}





