package Shai;

import nave.Database;
import nave.Loan;
import nave.LoanStatus;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;



public class User_interface {


    public void func2 (){

        for(Loan itr:Database.getLoanList())
        {
            itr.toString();

            if(itr.getStatus() == LoanStatus.PENDING)
            {

            }
        }

    }





    public static void main(String[] args)  {

    }




    }
