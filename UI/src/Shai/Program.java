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
        Lenders lender1=new Lenders("utills",20000);
        Lenders lender2=new Lenders("nikol", 40000);
        Lenders lender3=new Lenders("david",40000);
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
        //creating index i , and printing all existing clients in database
        int i=1;
        for(Client client: Database.getClientMap().values()) {
            System.out.println(i + ". " + client.getFullName());
            i++;
            }
        //asking user to choose a client from database ,and getting input value of wanted client index
        System.out.println("Please choose a client (by index a integer number between: 1 to"+Database.getClientMap().size()+")");
        Scanner input = new Scanner(System.in);
        String userClientIndexChoice = input.nextLine();
        //getting client
        Client wantedClient = Database.getClientMap().get(userClientIndexChoice);
        //asking user and getting wanted deposit amount
        System.out.println("How much would you like to to deposit into chosen client:"+wantedClient.getFullName()+" account's ?");
        System.out.println("(please enter a positive integer number)");
        int deposit = input.nextInt();
        //making the wire
        BackgroundFunc.DepositMoneyToAccount(deposit,wantedClient.getMyAccount());
        System.out.println(wantedClient.getMyAccount().toString());



    }
}
