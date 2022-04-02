package Shai;
import customes.Account;
import customes.Client;
import customes.Lenders;
import data.Database;
import loan.Loan;
import loan.enums.eLoanCategory;
import loan.enums.eLoanStatus;
import operations.Payment;
import time.Timeline;
import utills.BackgroundFunc;
import Shai.User_interface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main (String[] args){

        //1ST TEST OBJ
        Loan test1 = new Loan(eLoanCategory.DEFICIT, eLoanStatus.ACTIVE,"Shai Shillo",new Timeline(10),new Timeline(1),new Timeline(1),10,100000);
        test1.generateLoanID();

       //creates&sets lenders list:
        Lenders lender1=new Lenders("Idan",20000);
        Lenders lender2=new Lenders("Shai", 40000);
        Lenders lender3=new Lenders("Nave",40000);
        List<Lenders> lendersList1 = new ArrayList<>(3);
        lendersList1.add(lender1);
        lendersList1.add(lender2);
        lendersList1.add(lender3);
        test1.setLendersList(lendersList1);

        //creates&sets payment list:
        Payment payment1 = new Payment(new Timeline(2),11000,true);
        Payment payment2 = new Payment(new Timeline(2),11000,true);
        Payment payment3 = new Payment(new Timeline(2),11000,false);
        List<Payment> paymentsList1 = new ArrayList<>(3);
        paymentsList1.add(payment1);
        paymentsList1.add(payment2);
        paymentsList1.add(payment3);
        test1.setPaymentsList(paymentsList1);

        //set remaining Loan fields:


        //2ST TEST OBJ
        Loan test2 = new Loan(eLoanCategory.EVENT, eLoanStatus.RISK,"Oded Menashe",new Timeline(5),new Timeline(1),new Timeline(1),5,200000);
        test1.generateLoanID();

        //creates&sets lenders list:
        Lenders lender4=new Lenders("shlomi",20000);
        Lenders lender5=new Lenders("eran", 40000);
        Lenders lender6=new Lenders("gadi",40000);
        List<Lenders> lendersList2 = new ArrayList<>(3);
        lendersList2.add(lender4);
        lendersList2.add(lender5);
        lendersList2.add(lender6);
        test2.setLendersList(lendersList2);

        //creates&sets payment list:
        Payment payment4 = new Payment(new Timeline(2),11000,true);
        Payment payment5 = new Payment(new Timeline(2),11000,true);
        Payment payment6 = new Payment(new Timeline(2),11000,false);
        List<Payment> paymentsList2 = new ArrayList<>(3);
        paymentsList2.add(payment4);
        paymentsList2.add(payment5);
        paymentsList2.add(payment6);
        test2.setPaymentsList(paymentsList2);

        Database.addLoanToLoanList(test1);
        Database.addLoanToLoanList(test2);

        //User_interface.allLoansData();
        //set remaining Loan fields:

        //creating clients for test
        Client idan = new Client("Idan",new Account(204684914, 5000));
        Client shai = new Client("Shai",new Account(204684914, 5000));
        Client nave = new Client("Nave",new Account(204684914, 5000));
        // adding new test clients to map
        Database.addClientToClientList(idan);
        Database.addClientToClientList(shai);
        Database.addClientToClientList(nave);
        // User_interface.func4();
        // User_interface.func5();
    //testing func payLoanDividendsToLenders
        test1.payLoanDividendsToLenders();
        System.out.println(idan.getMyAccount().toString()+"\n"+shai.getMyAccount().toString()+"\n"+nave.getMyAccount().toString());
    }
}
