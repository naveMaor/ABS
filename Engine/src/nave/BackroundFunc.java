package nave;

import java.util.List;

public class BackroundFunc {
/*
This func gets lenders list and return thus sum of their deposit
 */
    public  final static double calculateDeposit(List<Lenders> lendersList)
    {
        double sum=0;
        for (Lenders lenders:lendersList)
        {
            sum+=lenders.getDeposit();
        }
        return sum;
    }
}
