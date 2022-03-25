package Shai;

import nave.*;


public class User_interface {


    public void func2 (){

        for(Loan itr:Database.getLoanList())
        {
            itr.toString();

            itr.printLenderList();

            if(itr.getStatus() == LoanStatus.ACTIVE)
            {
                itr.printACTIVEstatus();
            }
            //else if()
        }

    }





    public static void main(String[] args)  {

    }




    }
