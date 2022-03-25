package Shai;

import nave.*;

import java.util.List;


public class User_interface {


    public void func2 (){
       for(Loan itr:Database.getLoanList())
        {
            System.out.println(itr.toString());//showing loan
            PrintFuncs.printLenderList(itr.getLendersList());//showing lenders list PENDING
            switch (itr.getStatus())
            {
                case ACTIVE: {PrintFuncs.printACTIVEstatus(itr);}break;
                case RISK: {PrintFuncs.printACTIVEstatus(itr);PrintFuncs.printRISKstatus(itr);}break;
                case FINISHED:{PrintFuncs.printFINISHEDstatus(itr);}break;
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
        for(Client client:Database.getClientMap().values()){
            PrintFuncs.printAccountInfo(client.getMyAccount());
            PrintFuncs.printConnectedLoans(client);
        }
    }




    public static void main(String[] args)  {

    }




    }
