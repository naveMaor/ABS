package Shai;

import nave.Account;
import nave.Client;
import nave.Tnua;

import java.util.List;

public class PrintFuncs {
    public final void printAccountInfo(Account account)
    {
        List<Tnua> tnuaList = account.getTnuaList();
        int beforeBalance=account.getCurrBalance();
        int afterBalance=account.getCurrBalance();;
        for (Tnua tnua:tnuaList) {
            System.out.println("yaz of tnua: " + tnua.getTimeOfMovement() + "yazes");
            if (tnua.getSum() > 0) {
                System.out.println("schum tnua: +" + tnua.getTimeOfMovement());
            }
            else {
                System.out.println("schum tnua: " + tnua.getTimeOfMovement());
            }

            afterBalance +=tnua.getSum();
            System.out.println("balance before the tnua: " + beforeBalance);
            System.out.println("balance after the tnua: " + afterBalance);
            beforeBalance=afterBalance;
        }
    }
    public final void printConnectedLoans()
    {

    }

}
