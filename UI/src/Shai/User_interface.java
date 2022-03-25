package Shai;

import nave.*;

import java.util.List;


public class User_interface {


    public void func2 (){
        List<Lenders> lendersList;
        for(Loan itr:Database.getLoanList()) {
            System.out.println(itr.toString());
            lendersList = itr.getLendersList();
            for (Lenders lender:lendersList)
            {
                System.out.println(lender);
            }

            switch (itr.getStatus())
            {
                case ACTIVE:
                {

                }
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

    }




    public static void main(String[] args)  {

    }




    }
