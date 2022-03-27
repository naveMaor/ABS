package nave;

import java.util.List;

public class BackroundFunc {
/*
This func gets lenders list and return thus sum of their deposit
 */
    //NIKOL: what is the purpose of this class?
    public  final static double calculateDeposit(List<Lenders> lendersList)
    {
        double sum=0;
        for (Lenders lenders:lendersList)
            sum+=lenders.getDeposit();

        return sum;
    }


    //TODO: CHECK IF NEEDED BY REFERENCE!!!!!!!!!!!
    public static void TransferMoneyBetweenAccounts(Account accSource,double money,Account accDest)
    {
        //create a timestamp
        Timeline timeStamp = new Timeline(Timeline.getCurrTime());
        //update source account
        accSource.setCurrBalance(accSource.getCurrBalance()-money);
        Tnua tnuaMinus = new Tnua(timeStamp,(-money));
        accSource.getTnuaList().add(tnuaMinus);
        //update dest account
        Tnua tnuaPlus = new Tnua(timeStamp,money);
        accSource.getTnuaList().add(tnuaPlus);
        accDest.setCurrBalance(accDest.getCurrBalance()+money);

    }
}
