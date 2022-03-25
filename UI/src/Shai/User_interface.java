package Shai;

import nave.*;


public class User_interface {


    public void func2 (){

        for(Loan itr:Database.getLoanList()) {
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



        }

    }





    public static void main(String[] args)  {

    }




    }
